package org.jytek.leaguemanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jytek.leaguemanager.database.TmMdbDAO;
import org.jytek.leaguemanager.view.TmResult;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class Mock {

    TmMdbDAO tm;

    public static void main(String[] args) {
        final File input = new File(args[0]);
        final Mock mock = new Mock(input);
        mock.run();
    }

    Mock(File input) {
        tm = new TmMdbDAO(input);
    }


    public ObservableList<MockResult> run() {
        ObservableList<MockResult> results = FXCollections.observableArrayList();


        // sort teams by

        Map<String, TmTeam> teamsByName = new TreeMap<>();
        for (final var team : tm.getTeams().keySet()) {
            var code = tm.getTeams().get(team).getTcode();
            teamsByName.put(code,  tm.getTeams().get(team));
        }
        
        for (final var team1 : teamsByName.keySet()) {
            for (final var team2 : teamsByName.keySet()) {
                if (!team1.equals(team2)) {
                    try {
                        results.add(runDualMockMeet(teamsByName.get(team1), teamsByName.get(team2)));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return results;
    }


    private MockResult runDualMockMeet(TmTeam team1, TmTeam team2) throws IOException {

        Map<Short, ArrayList<TmResult>> mentries = new java.util.TreeMap<>();
        final Map<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();

        final String fileName = "output/" + team1.getTcode() + "-" + team2.getTcode() + ".txt";
        final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(team1.getTcode() + "-" + team2.getTcode() + "\n");

        for (var team : Arrays.asList(team1, team2)) {
            teamScores.put(team.getTeam(), 0);

            // find fastest time for each event for this athlete

            // all athletes fastest times are entered are entered
            for (final var ath : team.getAthletes()) {
                final Map<Short, TmResult> bestSwimsY = new TreeMap<>();
                final Map<Short, TmResult> bestSwimsS = new TreeMap<>();
                final Set<Short> bestSwims = new TreeSet<>();

                // get the lowest score for each event
                for (final TmResult r : tm.getAthletes().get(ath.getAthlete()).getResults()) {
                    var ev = tm.getMtevent().get(r.getMtevent()).getMtev();

                    if (ev == 11 && ath.getAthlete() == 1224) {
                        writer.write(r + "\n");
                    }
                    if (ev == 36 && (ath.getAthlete() == 1202 || ath.getAthlete() == 1249)) {
                        writer.write(r + "\n");
                    }

                    var mtev = tm.getMtevent().get(r.getMtevent());
                    var lo_hi = mtev.getLo_hi();

                    var lo = 0;
                    var hi = 99;
                    if (lo_hi < 100) {
                        hi = lo_hi;
                    }
                    lo = lo_hi / 100;
                    hi = lo_hi - lo * 100;

                    if (ath.getAge() < lo || ath.getAge() > hi) {
                        writer.write("skip " + lo_hi + " " + r);
                        continue;
                    }

                    if (r.getCourse().equals("Y")  || r.getCourse().equals("YS")  )  {
                        var best = bestSwimsY.computeIfAbsent(ev, aShort -> r);
                        if (r.getScore() < best.getScore()) {
                            bestSwimsY.put(ev, r);
                        }
                    }
                    if (r.getCourse().equals("S")) {
                        var best = bestSwimsS.computeIfAbsent(ev, aShort -> r);
                        if (r.getScore() < best.getScore()) {
                            bestSwimsS.put(ev, r);
                        }
                    }

                    bestSwims.add(ev);

                }
                //enter fastest in meet
                for (final var ev : bestSwims) {
                    final var swims = mentries.computeIfAbsent(ev, aShort -> new ArrayList<>());


                    // if no yards times, use fastest meters times
                    if (!bestSwimsY.containsKey(ev)) {
                        swims.add(bestSwimsS.get(ev));
                    }
                    // if no meters time, use fastest yards times

                    else if (!bestSwimsS.containsKey(ev)) {
                        swims.add(bestSwimsY.get(ev));
                    } else {

                        var bestY = bestSwimsY.get(ev);
                        var bestS = bestSwimsS.get(ev);

                        if ((bestY.getScore() * 1.11) < bestS.getScore()) {
                            swims.add(bestSwimsY.get(ev));
                        } else {
                            swims.add(bestSwimsS.get(ev));
                        }
                    }
                }
            }

            final Map<Short, TmResult> bestRelays = new TreeMap<>();

            // only fastest relay time per event
            for (final var relay : team.getRelays()) {
                for (var r : tm.getRelays().get(relay.getRelay()).getResults()) {
                    var ev = tm.getMtevent().get(r.getMtevent()).getMtev();

                    var best = bestRelays.computeIfAbsent(ev, k -> r);

                    var bestScore = best.getScore();
                    if (best.getCourse().equals("Y")) {
                        bestScore = (int) (bestScore * 1.11);
                    }
                    var currentScore = r.getScore();
                    if (r.getCourse().equals("Y")) {
                        currentScore = (int) (currentScore * 1.11);
                    }
                    if (currentScore < bestScore) {
                        bestRelays.put(ev, r);
                    }
                }
            }
            //enter fastest relay in meet
            for (var ev : bestRelays.keySet()) {
                final var swims = mentries.computeIfAbsent(ev, aShort -> new ArrayList<>());
                swims.add(bestRelays.get(ev));
            }
        }

        final Map<Short, Integer[]> eventPoints = new HashMap<>();

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
                    if (result.getI_r().equals("I")) {
                        team = tm.getAthletes().get(result.getAthlete()).getTeam1();
                        //name = tm.getAthletes().get(result.getAthlete()).getAthleteJ().getLast();
                        //name += "," + tm.getAthletes().get(result.getAthlete()).getAthleteJ().getFirst();

                        scored.put(result.getAthlete(), scored.get(result.getAthlete()) + 1);
                    } else if (result.getI_r().equals("R")) {
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

}
