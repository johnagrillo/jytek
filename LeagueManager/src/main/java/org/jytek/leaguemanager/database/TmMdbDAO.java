package org.jytek.leaguemanager.database;

import org.jytek.leaguemanager.view.TmMtevent;
import org.jytek.leaguemanager.view.TmResult;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * TmMdbDAO
 * Read tables from a Team Manager MDB(Access DataBase).
 */

public class TmMdbDAO {
    private Map<Integer, ArrayList<TmResult>> athleteResults;
    private Map<Integer, HashSet<Integer>> teamAthletes;
    private Map<Integer, HashSet<TmResult>> meetResults;
    private Map<Integer, ArrayList<TmResult>> athleteBestResults;
    private Map<Integer, ArrayList<TmResult>> teamRelayResults;
    private Map<Integer, ArrayList<TmResult>> teamRelayBestResults;
    /*
        Views of the tables
     */
    private TmTeamDAO teams;
    private TmMeetDAO meets;
    private TmMteventeDAO mtevente;
    private TmMteventDAO mtevents;
    private TmAthleteDAO athletes;
    private TmResultDAO results;
    private TmRelayDAO relays;

    private TmMdbDAO() {

    }


    /*
      Private Methods
     */


    public TmMdbDAO(File input) {
        try {
            var db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);
    	    /*
	          Read all tables in constructor.
	          Could be lazy initialized.
	         */

            teams = new TmTeamDAO(db);
            meets = new TmMeetDAO(db);
            mtevente = new TmMteventeDAO(db);
            mtevents = new TmMteventDAO(db);
            athletes = new TmAthleteDAO(db);
            results = new TmResultDAO(db) ;
            relays = new TmRelayDAO(db);

            //
            // Load results by athlete, team relay results and teamAthletes
            // Could be done lazily.
            //

            athleteResults = new HashMap<>();
            teamRelayResults = new HashMap<>();
            teamAthletes = new HashMap<>();

            results.forEach(result -> {
                var r = result.getValue();
                //
                // Individual event
                //
                if (r.getIr().equals("I")) {

                    var athlist = athleteResults.computeIfAbsent(r.getAthlete(), k -> new ArrayList<>());
                    athlist.add(r);

                    var teamlist = teamAthletes.computeIfAbsent(r.getTeam(), k -> new HashSet<>());
                    teamlist.add(r.getAthlete());
                }
                //
                // Relay
                //
                else if (r.getIr().equals("R")) {
                    var athlist = teamRelayResults.computeIfAbsent(r.getTeam(), k -> new ArrayList<>());
                    athlist.add(r);
                }
            });

            //
            // Best swims by athlete.
            // Could be done lazily.
            //

            athleteBestResults = findBestResults();


            //
            // Best relays by team
            // Could be done lazily.
            //


            teamRelayBestResults = findBestTeamRelays();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<TmResult> getAthleteResults(Integer ath) {
        return athleteResults.get(ath);
    }


    public TmTeamDAO getTeams() {
        return this.teams;
    }

    public TmMeetDAO getMeets() {
        return this.meets;
    }

    public TmMteventeDAO getMtevente() {
        return this.mtevente;
    }

    public TmMteventDAO getMtevents() {
        return this.mtevents;
    }

    public TmAthleteDAO getAthletes() {
        return this.athletes;
    }

    public TmResultDAO getResults() {
        return this.results;
    }

    public TmRelayDAO getRelays() {
        return this.relays;
    }

    public Set<Integer> getTeamAthletes(Integer team) throws AthleteException {
        if (teamAthletes.containsKey(team)) {
            return teamAthletes.get(team);
        }
        throw new AthleteException("No Athletes for team " + team);
    }

    public ArrayList<TmResult> getAthleteBestResults(Integer athlete) {

        if (athleteBestResults.containsKey(athlete)) {
            return athleteBestResults.get(athlete);
        }
        return new ArrayList<>();
    }

    public ArrayList<TmResult> getATeamBestRelays(Integer team) {

        if (teamRelayBestResults.containsKey(team)) {
            return teamRelayBestResults.get(team);
        }
        return new ArrayList<>();
    }


    private Map<Integer, ArrayList<TmResult>> findBestTeamRelays() {

        final Map<Integer, ArrayList<TmResult>> bestTeamRelays = new HashMap<>();

        for (final var team : teamRelayResults.keySet()) {
            final Map<Short, TmResult> bestRelay = new HashMap<>();

            for (var r : teamRelayResults.get(team)) {
                try {
                    var mtevent = getMtevents().get(r.getMtevent());

                    var best = bestRelay.computeIfAbsent(mtevent.getMtev(), k -> r);

                    var bestScore = best.getScore();
                    if (best.getCourse().equals("Y")) {
                        bestScore = (int) (bestScore * 1.11);
                    }
                    var currentScore = r.getScore();
                    if (r.getCourse().equals("Y")) {
                        currentScore = (int) (currentScore * 1.11);
                    }
                    if (currentScore < bestScore) {
                        bestRelay.put(mtevent.getMtev(), r);
                    }

                } catch (MteventException e) {
                    // database inconsistency
                    // just ignore
                }
            }

            // best relays per team
            // now add to team relays

            for (var r : bestRelay.values()) {
                var results = bestTeamRelays.computeIfAbsent(team, k -> new ArrayList<>());
                results.add(r);
            }
        }
        return bestTeamRelays;
    }

    private Map<Integer, ArrayList<TmResult>> findBestResults() {

        Map<Integer, ArrayList<TmResult>> best = new HashMap<>();

        // all athletes fastest times are entered are entered
        for (final var ath : athleteResults.keySet()) {
            final Map<Short, TmResult> bestSwimsY = new TreeMap<>();
            final Map<Short, TmResult> bestSwimsS = new TreeMap<>();
            final Set<Short> events = new TreeSet<>();

            // get the lowest score for each event
            for (final TmResult r : athleteResults.get(ath)) {
                try {
                    if (r.getScore() == 0) {
                        continue;
                    }

                    var dqcode = "";

                    if (r.getDqcode() != null) {
                        dqcode = r.getDqcode().trim();
                    }

                    if (!dqcode.isEmpty()) {
                        continue;
                    }
                    //var ev = getMtevent(r.getMtevent());
                    //if (ev == 11 && ath.getAthlete() == 1224) {
                    //    writer.write(r + "\n");
                    //}
                    //if (ev == 36 && (ath.getAthlete() == 1202 || ath.getAthlete() == 1249)) {
                    //    writer.write(r + "\n");
                    //}

                    TmMtevent mtev = getMtevents().get(r.getMtevent());
                    var ev = mtev.getMtev();
                    var lo_hi = mtev.getLohi();

                    var lo = 0;
                    var hi = 99;
                    if (lo_hi < 100) {
                        hi = lo_hi;
                    }
                    lo = lo_hi / 100;
                    hi = lo_hi - lo * 100;

                    //if (ath.getAge() < lo || ath.getAge() > hi) {
                    //    System.out.println("skip " + lo_hi + " " + r);
                    //  continue;
                    //}

                    if (r.getCourse().equals("Y") || r.getCourse().equals("YS")) {
                        var bestY = bestSwimsY.computeIfAbsent(ev, aShort -> r);
                        if (r.getScore() < bestY.getScore()) {
                            bestSwimsY.put(ev, r);
                        }
                    }
                    if (r.getCourse().equals("S")) {
                        var bestS = bestSwimsS.computeIfAbsent(ev, aShort -> r);
                        if (r.getScore() < bestS.getScore()) {
                            bestSwimsS.put(ev, r);
                        }
                    }
                    events.add(ev);
                } catch (MteventException e) {

                }
            }

            for (final var ev : events) {
                TmResult bestResult = null;

                // if no yards times, use fastest meters times
                if (!bestSwimsY.containsKey(ev)) {
                    bestResult = bestSwimsS.get(ev);

                }
                // if no meters time, use fastest yards times

                else if (!bestSwimsS.containsKey(ev)) {
                    bestResult = bestSwimsY.get(ev);

                }
                // get best of meters and yards
                else {

                    var bestY = bestSwimsY.get(ev);
                    var bestS = bestSwimsS.get(ev);

                    if ((bestY.getScore() * 1.11) < bestS.getScore()) {
                        bestResult = bestSwimsY.get(ev);
                    } else {
                        bestResult = bestSwimsS.get(ev);
                    }
                }


                if (bestResult == null) {
                    System.out.println(ath);
                    System.out.println("Y " + ev + " " + bestSwimsY.get(ev));
                    System.out.println("S " + ev + " " + bestSwimsS.get(ev));
                } else {
                    var results = best.computeIfAbsent(ath, k -> new ArrayList<>());
                    results.add(bestResult);
                }
            }
        }

        return best;
    }

    public TreeMap<Short, ArrayList<TmResult>> getBestTeamEntries(Integer team) {

        //
        // get a best swim for each athlete on this team
        //
        TreeMap<Short, ArrayList<TmResult>> teamEntries = new TreeMap<>();
        try {
            for (var ath : getTeamAthletes(team)) {
                for (var r : getAthleteBestResults(ath)) {
                    try {
                        var events = teamEntries.computeIfAbsent(getMtevents().get(r.getMtevent()).getMtev(),
                                k -> new ArrayList<>());
                        events.add(r);
                    } catch (MteventException e) {

                    }
                }
            }
        } catch (AthleteException e) {
            // continue
            System.out.println("getBestTeamEntries " + e + " " + team);
        }

        //
        // get the best relays for this team
        //
        try {
            var tmteam = teams.get(team);
            for (var r : getATeamBestRelays(team)) {
                var results = teamEntries.computeIfAbsent(getMtevents().get(r.getMtevent()).getMtev(), k -> new ArrayList<>());
            }
        } catch (TeamException | MteventException e) {


        }
        return teamEntries;
    }
}

