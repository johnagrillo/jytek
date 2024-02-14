package cmsl;

import com.healthmarketscience.jackcess.*;
import hytek.tm.Result;
import jytek.TmMdb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class EventResult {

    HashMap<Short, hytek.tm.Result> eventResult;

    public EventResult() {
        eventResult = new HashMap<>();
    }

    hytek.tm.Result get(Short event) {
        return eventResult.get(event);
    }
}


public final class Mock {

    jytek.TmMdb tm ;


    public static void main(String[] args) {
        final File input = new File(args[0]);
        final Mock mock = new Mock(input);
        mock.run();
    }

    private Mock(File input) {
        tm = new TmMdb(input);
    }



    private void run() {
        for (final var team1 : tm.getTeams().keySet()) {
            for (final var team2 : tm.getTeams().keySet()) {
                if (!Objects.equals(team1, team2)) {
                    try {
                        runDualMockMeet(tm.getTeams().get(team1), tm.getTeams().get(team2));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    private void runDualMockMeet(jytek.Team team1, jytek.Team team2) throws IOException{

        Map<Short, ArrayList<hytek.tm.Result>> mentries = new java.util.TreeMap<>();
        final Map<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();

        final String fileName = "output/" + team1.getTeam().getTcode() + "-" + team2.getTeam().getTcode() + ".txt";
        final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(team1.getTeam().getTcode() + "-" + team2.getTeam().getTcode() + "\n");

        for (var team : Arrays.asList(team1, team2)) {
            teamScores.put(team.getTeam().getTeam(), 0);

            // find fastest time for each event for this athlete

            // all athletes fastest times are entered are entered
            for (final var ath : team.getAthletes()) {
                final Map<Short, hytek.tm.Result> bestSwimsY = new TreeMap<>();
                final Map<Short, hytek.tm.Result> bestSwimsS = new TreeMap<>();
                final Set<Short> bestSwims = new TreeSet<>();                
                
                // get the lowest score for each event
                for (final hytek.tm.Result r : tm.getAthletes().get(ath.getAthlete()).getResults()) {
                    var ev = tm.getMtevent().get(r.getMtevent()).getMtev();


                    
                    var mtev = tm.getMtevent().get(r.getMtevent());
                    var lo_hi = mtev.getLo_hi();
                    
                    var lo = 0;
                    var hi = 99;
                    if (lo_hi < 100) {
                        hi = lo_hi;
                    }
                    lo =  lo_hi/100;
                    hi =  lo_hi - lo * 100;

                    if (ath.getAge() < lo || ath.getAge() > hi)
                    {
                        writer.write("" + lo_hi + " " + r);
                        continue;
                    }

                    if (r.getCourse().equals("Y")) {
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
                    }
                    else {

                        var bestY = bestSwimsY.get(ev);
                        var bestS = bestSwimsS.get(ev);

                        if ( (bestY.getScore() * 1.11) < bestS.getScore()) {
                            swims.add(bestSwimsY.get(ev));
                        }
                        else {
                            swims.add(bestSwimsS.get(ev));
                        }
                    }
                }
            }

            final Map<Short, hytek.tm.Result> bestRelays = new TreeMap<>();

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
            writer.write(ev  + "\n");
            Map<Integer, ArrayList<Result>> scores = new TreeMap<>();
            for (var r : mentries.get(ev)) {
                if (scored.computeIfAbsent(r.getAthlete(), k -> 0 ) == 4) {
                    continue;
                }
                Integer time = r.getScore();
                if ("Y".equals(r.getCourse())) {
                    time = (int) (time * 1.11);
                }
                var slot = scores.computeIfAbsent(time, k -> new ArrayList<>());
                slot.add(r);
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
                        team = tm.getAthletes().get(result.getAthlete()).getTeam();
                        name = tm.getAthletes().get(result.getAthlete()).getAthleteJ().getLast();
                        name += "," + tm.getAthletes().get(result.getAthlete()).getAthleteJ().getFirst();
                        
                        scored.put(result.getAthlete(), scored.get(result.getAthlete())+1);
                    } else if (result.getI_r().equals("R")) {
                        team = tm.getRelays().get(result.getAthlete()).getTeam();
                    } else {
                        continue;
                    }

                    var totalSecs = result.getScore()/100.0;
                    var hours = totalSecs / 3600.0;
                    var minutes = (totalSecs % 3600.0) / 60.0;
                    var seconds = totalSecs % 60.0;

                    writer.write("" + points + " " +name + " " + tm.getTeams().get(team).getTeam().getTcode() + " ");
                    if (result.getCourse().equals("Y")) {
                        writer.write( "" + (int)(result.getScore() * 1.11));
                    }
                    else {
                        writer.write("" + result.getScore());
                    }
                    if (result.getCourse().equals("Y")) {
                        writer.write(" " + result.getScore() + "(Y)");
                    }
                    writer.write("\n");

                    teamScores.put(team, teamScores.get(team) + points);
                }
            }
        }

        final List<Integer> points = new ArrayList<>(teamScores.values());

        var team1score = teamScores.get(team1.getTeam().getTeam());
        var team2score = teamScores.get(team2.getTeam().getTeam());

        var score = "SCORE:" + team1.getTeam().getTcode() + "," + team2.getTeam().getTcode() + ","
                + team1score + "," + team2score + "," + ((team1score - team2score) / 10.0);

        System.out.println(score);
        writer.write(score + "\n");
        writer.close();
    }





}
