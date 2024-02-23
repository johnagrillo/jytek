package org.jytek.leaguemanager;

import org.jytek.leaguemanager.view.MockMeetResults;
import org.jytek.leaguemanager.view.TmResult;

import java.util.*;

public final class MockMeet {

    private MockMeet() {

    }

    public static MockMeetResults runMockMeet(Map<Short, ArrayList<TmResult>> entries) {
        final TreeMap<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();
        final Map<Short, Integer[]> eventPoints = new HashMap<>();


        TreeMap<Short, ArrayList<TmResult>> results = new TreeMap<>();

        Integer[] ind = {50, 30, 10};
        Integer[] relay = {80, 40, 0};

        // set all events to ind
        for (short e = 1; e <= 68; e++) {
            eventPoints.put(e, ind);
        }
        // set relay events

        final Short[] relayE = {31, 32, 33, 34, 67, 68};

        for (Short r : relayE) {
            eventPoints.put(r, relay);
        }

        final Map<Integer, Integer> scored = new HashMap<>();
        for (var ev : entries.keySet()) {
            Map<Integer, ArrayList<TmResult>> scores = new TreeMap<>();

            // rUN eVent

            for (var r : entries.get(ev)) {
                if (scored.computeIfAbsent(r.getAthlete(), k -> 0) == 4) {
                    continue;
                }
                Integer time = r.getScore();
                if ("Y".equals(r.getCourse())) {
                    time = (int) (time * 1.11);
                }
                var slot = scores.computeIfAbsent(time, k -> new ArrayList<>());
                slot.add(r);
                //scored.put(r.getAthlete(), scored.get(r.getAthlete()) + 1);
            }

            // score event

            final List<Integer> times = new ArrayList<>(scores.keySet());
            var eventScore = eventPoints.get(ev);
            for (int t = 0; t < times.size(); t++) {

                final var values = scores.get(times.get(t));
                final var result = values.get(0);

                if (t < eventScore.length) {
                    final var points = eventScore[t];
                    Integer team = result.getTeam();
                    teamScores.put(team, teamScores.computeIfAbsent(team, k->0) + points);
                }
            }
        }
        return new MockMeetResults(results, teamScores);
    }


/*


        f
        final Map<Integer, Integer> scored = new HashMap<>();
        for (var ev : mentries.keySet()) {
            writer.write(ev + "\n");
            Map<Integer, ArrayList<TmResult>> scores = new TreeMap<>();
            for (var r : mentries.get(ev)) {
                if (scored.computeIfAbsent(r.getAthlete(), k -> 0) == 4) {
                    continue;
                }
                Integer time = r.getScore();
                if ("Y".equals(r.getCourse())) {
                    time = (int) (time * 1.11);
                }
                var slot = scores.computeIfAbsent(time, k -> new ArrayList<>());
                slot.add(r);
                //scored.put(r.getAthlete(), scored.get(r.getAthlete()) + 1);

            }

            // score slot

            final List<Integer> times = new ArrayList<>(scores.keySet());
            var eventScore = eventPoints.get(ev);
            for (int t = 0; t < times.size(); t++) {

                final var values = scores.get(times.get(t));
                final var result = values.get(0);

                if (t < eventScore.length) {
                    final var points = eventScore[t];
                    // find team
                    Integer team = 0;

                    String name = "";
                    if (result.getIr().equals("I")) {
                        team = tm.getAthletes().get(result.getAthlete()).getTeam1();
                        //name = tm.getAthletes().get(result.getAthlete()).getAthleteJ().getLast();
                        //name += "," + tm.getAthletes().get(result.getAthlete()).getAthleteJ().getFirst();

                        scored.put(result.getAthlete(), scored.get(result.getAthlete()) + 1);
                    } else if (result.getIr().equals("R")) {
                        team = tm.getRelays().get(result.getAthlete()).getTeam();
                    } else {
                        continue;
                    }


                    var totalSecs = result.getScore() / 100.0;
                    var hours = totalSecs / 3600.0;
                    var minutes = (totalSecs % 3600.0) / 60.0;
                    var seconds = totalSecs % 60.0;

                    writer.write("" + points + " " + name + " " + tm.getTeams().get(team).getTcode() + " ");
                    if (result.getCourse().equals("Y")) {
                        writer.write("" + (int) (result.getScore() * 1.11));
                    } else {
                        writer.write("" + result.getScore());
                    }
                    if (result.getCourse().equals("Y")) {
                        writer.write(" " + result.getScore() + "(Y)");
                    }
                    if (result.getCourse().equals("YS")) {
                        System.out.println(result);
                        writer.write(" " + result.getScore() + "(YS)");
                    }
                    writer.write(" " + result.getAthlete() + "\n");

                    teamScores.put(team, teamScores.get(team) + points);
                }
            }
        }

        final List<Integer> points = new ArrayList<>(teamScores.values());

        var team1score = teamScores.get(team1.getTeam());
        var team2score = teamScores.get(team2.getTeam());

        var score = "SCORE:" + team1.getTcode() + "," + team2.getTcode() + ","
                + team1score + "," + team2score + "," + ((team1score - team2score) / 10.0);
        writer.write(score + "\n");
        writer.close();

        return new MockResult(team1.getTcode(),
                team1score,
                team2.getTcode(),
                team2score,
                (int) ((int)(team1score - team2score) / 10.0));

    }
*/
}
