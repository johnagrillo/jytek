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
    private Map<TmAthlete, ArrayList<TmResult>> athleteResults;

    private Map<TmTeam, ArrayList<TmAthlete>> teamAthletes;


    /*
          Getters
         */
    private Map<TmAthlete, ArrayList<TmResult>> athleteBestResults;
    private Map<TmTeam, ArrayList<TmResult>> teamRelayResults;
    private Map<TmTeam, ArrayList<TmResult>> teamRelayBestResults;


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

                    try {
                        var athlist = athleteResults.computeIfAbsent(getAthlete(r.getAthlete()), k -> new ArrayList<>());
                        athlist.add(r);
                    } catch (AthleteException e) {
                        // sometimes there is result athlete that is not in athletes
                        // seems safe to ignore
                    }

                    try {
                        var teamlist = teamAthletes.computeIfAbsent(getTeam(r.getTeam()), k -> new ArrayList<>());
                        teamlist.add(getAthlete(r.getAthlete()));
                    } catch (TeamException e) {
                         // handle tm case
                    } catch (AthleteException e) {
                        // handle tm case
                    }


                }
                //
                // Relay
                //
                else if (r.getIr().equals("R")) {

                    try {
                        var athlist = teamRelayResults.computeIfAbsent(getTeam(r.getTeam()), k -> new ArrayList<>());
                        athlist.add(r);
                    } catch (TeamException e) {
                        // sometimes there is result athlete that is not in relays
                        // seems safe to ignore
                    }
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

    public Map<TmTeam, ArrayList<TmAthlete>> getTeamAthletes() {
        return teamAthletes;
    }
    public ArrayList<TmResult> getAthleteBestResults(TmAthlete athlete) throws AthleteException{

        if (athleteBestResults.containsKey(athlete)) {
            return athleteBestResults.get(athlete);
        }
        throw new AthleteException("No best Results for " + athlete);
    }

    public ArrayList<TmResult> getATeamBestRelays(TmTeam team) throws TeamException{

        if (teamRelayBestResults.containsKey(team)) {
            return teamRelayBestResults.get(team);
        }
        throw new TeamException("No best Relays for " + team);
    }





    private Map<TmTeam, ArrayList<TmResult>> findBestTeamRelays() {

        final Map<TmTeam, ArrayList<TmResult>> bestTeamRelays = new HashMap<>();

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

    private Map<TmAthlete, ArrayList<TmResult>> findBestResults() {

        Map<TmAthlete, ArrayList<TmResult>> best = new HashMap<>();

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

                    if (!r.getDqcode().trim().isEmpty()) {
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

                    if (ath.getAge() < lo || ath.getAge() > hi) {
                        //writer.write("skip " + lo_hi + " " + r);
                        continue;
                    }

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

