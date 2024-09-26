package org.jytek.leaguemanager.utilities;

import org.jytek.leaguemanager.database.KeyNotFoundException;
import org.jytek.leaguemanager.database.TmMdbDAO;
import org.jytek.leaguemanager.view.DualMockResult;
import org.jytek.leaguemanager.view.MockMeetResults;
import org.jytek.leaguemanager.view.TmResult;

import java.util.*;

public class MockMeets {

    static public Collection<DualMockResult> runDualMockMeets(TmMdbDAO tm, final MockMeet.Scoring scoring) {
        final Collection<MockMeetResults> mockResults = new ArrayList<>();
        final Collection<DualMockResult> dualResults = new ArrayList<>();


        tm.getTeams().forEach(e1 -> {
            final var team1 = e1.getKey();
            final var team1Entries = tm.getBestTeamEntries(team1);
            tm.getTeams().filter(e2 -> !Objects.equals(team1, e2.getKey())).forEach(e2 -> {
                final var team2 = e2.getKey();
                var in = new HashSet<Integer>();
                in.add(team1);
                in.add(team2);
                var team2Entries = tm.getBestTeamEntries(team2);
                // add team and team 2
                var teamEntries = new TreeMap<Short, ArrayList<TmResult>>();
                Arrays.asList(team1Entries, team2Entries).forEach(entries -> {
                    entries.entrySet().forEach(entry -> {
                        var ev = entry.getKey();
                        entry.getValue().forEach(r -> {
                            teamEntries.computeIfAbsent(ev, k -> new ArrayList<>()).add(r);
                            try {
                                if (!in.contains(r.getTeam())) {
                                    System.out.println("Wrong Team in " + " " + tm.getTeams().get(r.getTeam()).getTcode() + " " + r);
                                }
                            } catch (KeyNotFoundException e) {
                                System.out.println("No Team " + e);

                            }
                        });
                    });
                    // only run if we have two teams

                    var r = MockMeet.runMockMeet(teamEntries, scoring);
                    mockResults.add(r);
                    var teamScores = r.getTeamScores();
                    if (teamScores.size() > 1) {
                        var t1 = teamScores.get(team1);
                        var t2 = teamScores.get(team2);
                        var diff = (int) ((t1 - t2) / 10.0);
                        try {
                            dualResults.add(new DualMockResult(
                                    tm.getTeams().get(team1).getTcode(),
                                    t1.toString(),
                                    tm.getTeams().get(team2).getTcode(),
                                    t2.toString(),
                                    (Integer.valueOf(diff)).toString(),
                                    r));
                        } catch (KeyNotFoundException e) {
                            System.out.println(e);
                        }

                    }

                });
            });
        });
        return dualResults;
    }
}
