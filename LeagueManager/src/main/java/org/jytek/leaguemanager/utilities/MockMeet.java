package org.jytek.leaguemanager.utilities;

import org.jytek.leaguemanager.view.MockMeetResults;
import org.jytek.leaguemanager.view.TmResult;

import java.util.*;

public final class MockMeet {

    
    
    
    private MockMeet() {

    }

    public static MockMeetResults runMockMeet(Map<Short, ArrayList<TmResult>> entries,
                                              Map<Short, Integer[]> eventPoints,
                                              Map<Short, Short> ageUp
                                              ) {
        final TreeMap<Integer, Integer> teamScores = new TreeMap<Integer, Integer>();
        final TreeMap<Short, TreeMap<Integer, HashSet<TmResult>>> meetResults = new TreeMap<>();

        // ageup

        for(var evFrom: ageUp.keySet()) {
            var evTo = ageUp.get(evFrom);

            if (entries.containsKey(evFrom)) {
                var toResults = entries.computeIfAbsent(evTo, k -> new ArrayList<>());
                //toResults.addAll(entries.get(evFrom));
            }
        }

        TreeMap<Short, ArrayList<TmResult>> results = new TreeMap<>();
        final TreeMap<Integer, Integer> scored = new TreeMap<>();
        for (var ev : entries.keySet()) {
            TreeMap<Integer, HashSet<TmResult>> scores = new TreeMap<>();

            // rUN eVent

            for (var r : entries.get(ev)) {
                if (scored.computeIfAbsent(r.getAthlete(), k -> 0) == 4) {
                    continue;
                }
                Integer time = r.getScore();
                if ("Y".equals(r.getCourse())) {
                    time = (int) (time * 1.11);
                }


                //
                // Use a set to prevent the same result being in the time slot.
                // Should not happen, but it does, so use a set.
                //
                //

                var slot = scores.computeIfAbsent(time, k -> new HashSet<>());
                slot.add(r);
                //scored.put(r.getAthlete(), scored.get(r.getAthlete()) + 1);
            }

            // score event

            final List<Integer> times = new ArrayList<>(scores.keySet());

            if (eventPoints.containsKey(ev)) {
                var eventScore = eventPoints.get(ev);
                for (int t = 0; t < times.size(); t++) {
                    final var values = scores.get(times.get(t));

                    if (values.size() > 1) {
                        System.out.println(ev +  " + " + t + " " + values.size());
                        for(var r : values) {
                            System.out.println(r);
                        }
                    }

                    final var iter = values.iterator();

                    var result = iter.next();
                    if (t < eventScore.length) {
                        final var points = eventScore[t];
                       Integer team = result.getTeam();
                        teamScores.put(team, teamScores.computeIfAbsent(team, k -> 0) + points);
                    }
                }
		
            }
	    meetResults.put(ev, scores);
        }
        return new MockMeetResults(results, teamScores, meetResults);
    }
}
