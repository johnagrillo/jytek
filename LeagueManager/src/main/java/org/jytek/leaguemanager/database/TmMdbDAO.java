package org.jytek.leaguemanager.database;

import org.jytek.leaguemanager.view.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * TmMdbDAO
 * Read tables from a Team Manager MDB(Access DataBase).
 */

public class TmMdbDAO {
    private Map<Integer, ArrayList<TmResult>> athleteResults;

    public ArrayList<TmResult> getAthleteResults(Integer ath) {
        return athleteResults.get(ath);
    }

    private Map<Integer, HashSet<Integer>> teamAthletes;


    /*
          Getters
         */
    private Map<Integer, ArrayList<TmResult>> athleteBestResults;
    private Map<Integer, ArrayList<TmResult>> teamRelayResults;
    private Map<Integer, ArrayList<TmResult>> teamRelayBestResults;


    /*
        Views of the tables
     */
    private Map<Integer, TmTeam> teams;
    private Map<Integer, TmMeet> meets;
    private Map<Integer, TmMtevente> mtevente;
    private Map<Integer, TmMtevent> mtevents;
    private Map<Integer, TmAthlete> athletes;
    private Map<Integer, TmResult> results;
    private Map<Integer, TmRelay> relays;


    /*
      Private Methods
     */


    private TmMdbDAO() {

    }

    public TmMdbDAO(File input) {
        try {
            var db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

    	    /*
	          Read all tables in constructor.
	          Could be lazy initailized.

	         */

            meets = TmMeetDAO.getMeets(db);
            teams = TmTeamDAO.getTeams(db);
            //mtevente = TmMteventeDAO.getMteventes(db);
            mtevents = TmMteventDAO.getMtevents(db);
            athletes = TmAthleteDAO.getAthletes(db);
            relays = TmRelayDAO.getRelays(db);
            results = TmResultDAO.getResults(db);


            //
            // Load results by athlete, team relay results and teamAthletes
            // Could be done lazily.
            //

            athleteResults = new HashMap<>();
            teamRelayResults = new HashMap<>();
            teamAthletes = new HashMap<>();

            for (final var r : results.values()) {

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
            }

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


    /*
      Private Members
     */

    public Map<Integer, TmMeet> getMeets() {
        return this.meets;
    }

    public Map<Integer, TmTeam> getTeams() {
        return this.teams;
    }

    /*
     * Best Results by Athlete
     */

    public TmTeam getTeam(Integer team) throws TeamException {
        var t = teams.get(team);
        if (t == null) {
            throw new TeamException("No Team " + team);
        }
        return t;
    }


    /*
     * Relay Results By Team
     */

    public Map<Integer, TmMtevente> getMteventes() {
        return this.mtevente;
    }

    /*
     * Best Relay Results By Team
     */

    public Map<Integer, TmMtevent> getMtevents() {
        return this.mtevents;
    }

    public TmMtevent getMtevent(Integer mtevent) throws MtEventException {
        var m = mtevents.get(mtevent);
        if (m == null) {
            throw new MtEventException("No Meet Event " + mtevent);
        }
        return m;
    }

    public Map<Integer, TmAthlete> getAthletes() {
        return this.athletes;
    }

    public TmAthlete getAthlete(Integer ath) throws AthleteException {
        var a = athletes.get(ath);
        if (a == null) {
            throw new AthleteException("No Athlete " + ath);
        }
        return a;
    }

    public Map<Integer, TmResult> getResults() {
        return this.results;
    }

    public Map<Integer, TmRelay> getRelays() {
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
                    var mtevent = getMtevent(r.getMtevent());

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

                } catch (MtEventException e) {
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

                    TmMtevent mtev = getMtevent(r.getMtevent());
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
                } catch (MtEventException e) {

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



                if (bestResult == null)  {
                    System.out.println(ath);
                    System.out.println("Y " + ev + " " + bestSwimsY.get(ev));
                    System.out.println("S " + ev + " " + bestSwimsS.get(ev));
                }
                else {
                    var results = best.computeIfAbsent(ath, k -> new ArrayList<>());
                    results.add(bestResult);
                }
            }
        }

        return best;
    }

}

