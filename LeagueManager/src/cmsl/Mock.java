package cmsl;

import com.healthmarketscience.jackcess.Row;
import hytek.*;

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

            final var teams = new HashMap<Integer, hytek.Team>();
            for (final Row row : db.getTable(hytek.Team.NAME)) {
                hytek.Team team = new hytek.Team(row);
                teams.put(team.getTeam(), team);
            }

            final var mtevente = new HashMap<Integer, hytek.Mtevente>();
            for (final Row row : db.getTable(Mtevente.NAME)) {
                Mtevente eve = new hytek.Mtevente(row);
                mtevente.put(eve.getMtevent(), eve);
                System.out.println(eve);
            }

            final var mtevent = new HashMap<Integer, hytek.Mtevent>();
            for (final Row row : db.getTable(Mtevent.NAME)) {
                Mtevent ev = new hytek.Mtevent(row);
                mtevent.put(ev.getMtevent(), ev);
                //System.out.println(ev);
            }


            System.out.println("Teams: " + teams.size());

            // get athletes
            final var athletes = new HashMap<Integer, hytek.Athlete>();
            for (final Row row : db.getTable(hytek.Athlete.NAME)) {
                hytek.Athlete a = new Athlete(row);
                athletes.put(a.getAthlete(), a);
            }
            System.out.println("Athletes: " + athletes.size());

            // track swins my athlete by event
            //         Athtlete         Event
            final Map<Integer, HashMap<Short, Result>> swims = new HashMap<>();


            // relays are also athletes
            final var relays = new HashMap<Integer, hytek.Relay>();
            for (var row : db.getTable(Relay.NAME)) {
                hytek.Relay a = new Relay(row);
                relays.put(a.getRelay(), a);
            }

            System.out.println("Getting Best Times.");
            for (final Row row : db.getTable(Result.NAME)) {
                final Result result = new hytek.Result(row);

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

            final Map<Integer, HashMap<Integer, ArrayList<hytek.Result>>> teamAthResults = new HashMap<>();


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

                        System.out.print(" " + teams.get(team1).getTcode() + " " + teams.get(team2).getTcode());
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
                                   Map<Integer, HashMap<Integer, ArrayList<hytek.Result>>> teamAthResults,
                                   HashMap<Integer, hytek.Athlete> athletes,
                                   HashMap<Integer, hytek.Relay> relays,
                                   HashMap<Integer, hytek.Mtevent> mtevent
    ) {
        Map<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();


        Map<Short, TreeMap<Integer, ArrayList<hytek.Result>>> meet = new java.util.TreeMap<>();
        for (var tt : teams) {
            teamScores.put(tt, 0);
            var ath1 = teamAthResults.get(tt);
            if (ath1 == null)
                continue;


            //
            // can only enter 4 events
            //

            Map<Integer, Integer> scored= new HashMap<>();



            for (var a : ath1.keySet()) {
                var scored = 0;
                for (var r : ath1.get(a)) {

                    if (scored.get(a) == 4)  {
                        System.out.println(a + " " + scored.get(a));
                        continue;
                    }
                            

                    var ev = mtevent.get(r.getMtevent()).getMtev();

                    // add event
                    final var meetEvent = meet.computeIfAbsent(ev, k -> new TreeMap<>());


                    var time = r.getScore();
                    if ("Y".equals(r.getCourse())) {
                        time = (int) (time * 1.11);
                    }
                    
                    final var meetEventScore = meetEvent.computeIfAbsent(time, k -> new ArrayList<>());
                    meetEventScore.add(r);
                    scored.put(a, scored.get(a) + 1);
                }
            }
        }
        for (final var event : meet.keySet()) {
            // determine points for places
            // take top three times

            final List<Integer> scores = new ArrayList<>(meet.get(event).keySet());

            //System.out.print(event + " - ");


            for (int s = 0; s < Math.min(3, scores.size()); s++) {
                final var values = meet.get(event).get(scores.get(s));
                //System.out.print(scores.get(s) + "(" + values.size() + ") ");

                var result = values.get(0);

                // find team
                Integer team = 0;
                var ath = athletes.get(result.getAthlete());
                final var relay = relays.get(result.getAthlete());

                if (ath != null) {
                    team = ath.getTeam1();
                } else {
                    team = relay.getTeam();
                }
                var points = 0;
                if (s == 0)
                    points = 5;
                else if (s == 1)
                    points = 3;
                else if (s == 3)
                    points = 1;
                teamScores.put(team, teamScores.get(team) + points);
            }
            //System.out.println();
        }
        final List<Integer> points = new ArrayList<>(teamScores.values());

        var team1score = teamScores.get(teams.get(0));
        var team2score = teamScores.get(teams.get(1));


        System.out.println(" {" + team1score + ", " + team2score + "}" + (team1score - team2score));

    }
}
