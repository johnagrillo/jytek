package org.jytek.leaguemanager.utilities;

import org.jytek.leaguemanager.view.MockMeetResults;
import org.jytek.leaguemanager.view.TmResult;

import java.util.*;

public final class MockMeet {
    public enum Scoring {
        CMSL,
        FSSL
    }

    private MockMeet() {

    }

    private static Map<Short, Short> getAgeUp(Scoring scoring) {
        Map<Short, Short> ageUp = new HashMap<>();
        if (scoring == Scoring.CMSL) {
            //6 & U ageup to 7-8
            ageUp.put((short) 9, (short) 11);
            ageUp.put((short) 10, (short) 12);
            ageUp.put((short) 21, (short) 23);
            ageUp.put((short) 22, (short) 24);
        }
        return ageUp;
    }

    private static Map<Short, Integer[]> getEventPoints(Scoring scoring) {
        Map<Short, Integer[]> eventPoints = new HashMap<>();
        if (scoring == Scoring.FSSL) {
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
        } else if (scoring == Scoring.CMSL) {
            Integer[] ind = {50, 30, 10};
            Integer[] relay = {50, 20};
            // set all events to ind
            for (short e = 1; e <= 61; e++) {
                eventPoints.put(e, ind);
            }
            // set relay events
            final Short[] relayE = {53, 54, 55, 56, 57, 58, 59, 60, 61};
            for (Short r : relayE) {
                eventPoints.put(r, relay);
            }
        }
        return eventPoints;
    }

    public static MockMeetResults runMockMeet(Map<Short, ArrayList<TmResult>> entries,
                                              Scoring scoring) {


        var eventPoints = getEventPoints(scoring);
        var ageUp = getAgeUp(scoring);


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
                        //System.out.println(ev +  " + " + t + " " + values.size());
                        for(var r : values) {
                            //System.out.println(r);
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
