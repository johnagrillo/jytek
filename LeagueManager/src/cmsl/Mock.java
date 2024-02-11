package cmsl;

import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


public final class Mock {
    private Mock() {
    }

    public static void main(String[] args) {

        try {
            File input = new File(args[0]);
            var db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

            //
            // hash map of teams
            //

            final var teams = new HashMap<Integer, hytek.tm.Team>();
            for (final Row row : db.getTable(hytek.tm.Team.NAME)) {
                hytek.tm.Team team = new hytek.tm.Team(row);
                teams.put(team.getTeam(), team);
            }

            final var mtevente = new HashMap<Integer, hytek.tm.Mtevente>();
            for (final Row row : db.getTable(hytek.tm.Mtevente.NAME)) {
                hytek.tm.Mtevente eve = new hytek.tm.Mtevente(row);
                mtevente.put(eve.getMtevent(), eve);
            }

            final var mtevent = new HashMap<Integer, hytek.tm.Mtevent>();
            for (final Row row : db.getTable(hytek.tm.Mtevent.NAME)) {
                hytek.tm.Mtevent ev = new hytek.tm.Mtevent(row);
                mtevent.put(ev.getMtevent(), ev);
            }


            System.out.println("Teams: " + teams.size());

            // get athletes
            final var athletes = new HashMap<Integer, hytek.tm.Athlete>();
            for (final Row row : db.getTable(hytek.tm.Athlete.NAME)) {
                hytek.tm.Athlete a = new hytek.tm.Athlete(row);
                athletes.put(a.getAthlete(), a);
            }
            System.out.println("Athletes: " + athletes.size());

            // track swins my athlete by event
            //         Athtlete         Event
            final Map<Integer, HashMap<Short, hytek.tm.Result>> swims = new HashMap<>();


            // relays are also athletes
            final var relays = new HashMap<Integer, hytek.tm.Relay>();
            for (var row : db.getTable(hytek.tm.Relay.NAME)) {
                hytek.tm.Relay a = new hytek.tm.Relay(row);
                relays.put(a.getRelay(), a);
            }

            System.out.println("Getting Best Times.");
            for (final Row row : db.getTable(hytek.tm.Result.NAME)) {
                var result = new hytek.tm.Result(row);

                if (0 == result.getScore()) {
                    continue;
                }
                if (!"".equals(result.getDqcode().trim())) {
                    continue;
                }
                var mtev = mtevent.get(result.getMtevent()).getMtev();
                final var t = swims.computeIfAbsent(result.getAthlete(), k -> new HashMap<>());
                final var current = t.computeIfAbsent(mtev, k -> result);
                if (result.getScore() < current.getScore()) {
                    swims.get(result.getAthlete()).put(mtev, result);
                }
            }


            // add only ome time per event

            final Map<Integer, HashMap<Integer, ArrayList<hytek.tm.Result>>> teamAthResults = new HashMap<>();


            for (var a : swims.keySet()) {
                for (var e : swims.get(a).keySet()) {

                    // find team
                    Integer team = 0;
                    final var ath = athletes.get(a);
                    final var relay = relays.get(a);
                    Integer id = 0;
                    if (ath != null) {
                        team = ath.getTeam1();
                        id = ath.getAthlete();
                    } else {
                        team = relay.getTeam();
                        id = relay.getRelay();
                    }
                    var t = teamAthResults.computeIfAbsent(team, k -> new HashMap<>());
                    var aa = t.computeIfAbsent(id, k -> new ArrayList<>());
                    aa.add(swims.get(a).get(e));
                }
            }


            for (var team1 : teams.keySet()) {
                for (var team2 : teams.keySet()) {
                    if (!Objects.equals(team1, team2)) {

                        System.out.print(teams.get(team1).getTcode() + "," + teams.get(team2).getTcode());
                        List<Integer> mockTeams = new ArrayList<Integer>();
                        mockTeams.add(team1);
                        mockTeams.add(team2);
                        runMockMeet(mockTeams, teamAthResults, athletes, relays, mtevent);
                    }
                }
            }
        } catch (
                final IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public static void runMockMeet(List<Integer> teams,
                                   Map<Integer, HashMap<Integer, ArrayList<hytek.tm.Result>>> teamAthResults,
                                   HashMap<Integer, hytek.tm.Athlete> athletes,
                                   HashMap<Integer, hytek.tm.Relay> relays,
                                   HashMap<Integer, hytek.tm.Mtevent> mtevent
    ) {
        Map<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();


        final Map<Short, Integer[]> eventPoints = new HashMap<>();

        Integer[] ind = {50,30,10};
        Integer[] relay = {80,40,20};

        // set all events to ind
        for (Short e = 1; e <= 68; e++) {
            eventPoints.put(e, ind);
        }
        // set relay events

        Short[] relayE = {31,32,33,34,67,68};

        for( Short r : relayE) {
            eventPoints.put(r, relay);
        }

        //
        //
        //

        Map<Short, TreeMap<Integer, ArrayList<hytek.tm.Result>>> meet = new java.util.TreeMap<>();
        Map<Integer, Integer> scored = new HashMap<>();

        for (var tt : teams) {
            teamScores.put(tt, 0);
            var ath1 = teamAthResults.get(tt);
            if (ath1 == null)
                continue;


            for (var a : ath1.keySet()) {
                scored.put(a, 0);
                for (var r : ath1.get(a)) {
                    var ev = mtevent.get(r.getMtevent()).getMtev();
                    // add event
                    final var meetEvent = meet.computeIfAbsent(ev, k -> new TreeMap<>());
                    var time = r.getScore();
                    if ("Y".equals(r.getCourse())) {
                        time = (int) (time * 1.11);
                    }
                    final var meetEventScore = meetEvent.computeIfAbsent(time, k -> new ArrayList<>());
                    meetEventScore.add(r);
                }
            }
        }
        for (final var event : meet.keySet()) {
            // determine points for places
            //

            var eventScore = eventPoints.get(event);
            final List<Integer> scores = new ArrayList<>(meet.get(event).keySet());




            for (int s = 0; s < scores.size(); s++) {
                final var values = meet.get(event).get(scores.get(s));
                //System.out.print(scores.get(s) + "(" + values.size() + ") ");

                if (s < eventScore.length) {
                    final var points = eventScore[s];
                    final var result = values.get(0);

                    // find team
                    Integer team = 0;
                    var ath = athletes.get(result.getAthlete());
                    final var r = relays.get(result.getAthlete());

                    if (ath != null) {
                        team = ath.getTeam1();
                        scored.put(r, scores.get(r) + 1);
                    } else {
                        team = r.getTeam();
                    }


                    teamScores.put(team, teamScores.get(team) + points);
                }
            }
            //System.out.println();
        }
        final List<Integer> points = new ArrayList<>(teamScores.values());

        var team1score = teamScores.get(teams.get(0));
        var team2score = teamScores.get(teams.get(1));


        System.out.println("," + team1score + "," + team2score + "," + (team1score - team2score)/10.0);

    }
}
