package cmsl;

import com.healthmarketscience.jackcess.Row;
import hytek.Athlete;
import hytek.Result;

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
            System.out.println("Teams: " + teams.size());

            //
            // lookup event numnber by age
            //
            final var events = eventsByAge(db);

            // find number of events

            var vals = events.values();
            System.out.println("Events: " + vals.size());

            // get athletes
            final var athletes = new HashMap<Integer, hytek.Athlete>();
            for (final Row row : db.getTable(hytek.Athlete.NAME)) {
                hytek.Athlete a = new Athlete(row);
                athletes.put(a.getAthlete(), a);
            }
            System.out.println("Athletes: " + athletes.size());

            // track swins my athlete by event
            //         Athtlete         Event
            final Map<Integer, HashMap<Integer, Result>> swims = new HashMap<>();

            for (final Row row : db.getTable(Result.NAME)) {
                final Result result = new hytek.Result(row);
                if ("R".equals(result.getI_r())) {
                    continue;
                }
                if (0 == result.getScore()) {
                    continue;
                }
                final var ath = athletes.get(result.getAthlete());

                Event e = new Event(ath.getAge(), result.getStroke(), result.getDistance(), ath.getSex());
                // is this event in the meet

                var ev = events.get(e);

                if (ev != null) {
                    final var t = swims.computeIfAbsent(result.getAthlete(), k -> new HashMap<>());
                    final var current = t.computeIfAbsent(ev, k -> result);
                    if (result.getScore() < current.getScore()) {
                        System.out.println("faster " + result.getScore() + " " + current.getScore());
                        swims.get(result.getAthlete()).put(ev,result);
                    }
                }
            }

            // add only ome time per event

            final Map<Integer, HashMap<Integer, ArrayList<hytek.Result>>> teamAthResults = new HashMap<>();


            for (var a : swims.keySet()) {
                for (var e : swims.get(a).keySet()) {
                    final var ath = athletes.get(a);
                    var t = teamAthResults.computeIfAbsent(ath.getTeam1(), k -> new HashMap<>());
                    var aa = t.computeIfAbsent(ath.getAthlete(), k -> new ArrayList<>());
                    aa.add( swims.get(a).get(e));
                    //System.out.println(" ath " + a + " " + e +  " "  + swims.get(a).get(e).getScore());
                }
            }


            for (var team1 : teams.keySet()) {
                for (var team2 : teams.keySet()) {
                    if (!Objects.equals(team1, team2)) {

                        System.out.println(" " + team1 + " " + team2);
                        Map<Integer, TreeMap<Integer, ArrayList<hytek.Result>>> meet = new java.util.TreeMap<>();

                        List<Integer> tl = new ArrayList<Integer>();
                        tl.add(team1);
                        tl.add(team2);
                        for( var tt : tl) {
                            var ath1 = teamAthResults.get(tt);
                            if (ath1 == null)
                                continue;
                            for (var a : ath1.keySet()) {
                                for (var r : ath1.get(a)) {
                                    var ath = athletes.get(a);
                                    Event e = new Event(ath.getAge(), r.getStroke(), r.getDistance(), ath.getSex());
                                    // is this event in the meet

                                    var ev = events.get(e);
                                    if (ev != null) {
                                        // add event
                                        final var meetEvent = meet.computeIfAbsent(ev, k -> new TreeMap<>());
                                        final var meetEventScore = meetEvent.computeIfAbsent(r.getScore(), k -> new ArrayList<>());
                                        meetEventScore.add(r);
                                    }
                                }
                            }
                        }
                        for (final var event : meet.keySet()) {
                            System.out.print(event + " - ");
                            for (final var score : meet.get(event).keySet()) {
                                System.out.print(score + " ");
                            }
                            System.out.println();
                        }
                    }
                }
            }
        } catch (final IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public static HashMap<Event, Integer> eventsByAge(com.healthmarketscience.jackcess.Database db) throws IOException {

        final var hash = new java.util.HashMap<Event, Integer>();

        for (Row row : db.getTable(hytek.Mtevent.NAME)) {
            // skip relays
            final hytek.Mtevent mtevent = new hytek.Mtevent(row);
            final var meet = mtevent.getMeet();
            if ("R".equals(mtevent.getI_r())) {
                continue;
            }
            Short lo = 0;
            Short hi = 0;
            if (100 > mtevent.getLo_hi()) {
                hi = mtevent.getLo_hi();
            } else {
                lo = (short) (mtevent.getLo_hi() / (short) 100);
                hi = (short) (mtevent.getLo_hi() - (lo * (short) 100));
            }
            for (Short age = lo; age <= hi; age++) {
                final var event = new Event(age, mtevent.getStroke(), mtevent.getDistance(), mtevent.getSex());
                hash.put(event, Integer.valueOf(mtevent.getMtev()));
            }
        }
        return hash;
    }
}

class Event {
    private final Short age;
    private final Short stroke;
    private final Short distance;
    private final String sex;

    Event(Short age,
          final Short stroke,
          final Short distance,
          final String sex) {
        this.age = age;
        this.stroke = stroke;
        this.distance = distance;
        this.sex = sex;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final Event event = (Event) o;
        return Objects.equals(this.age, event.age) && Objects.equals(this.stroke, event.stroke) && Objects.equals(this.distance, event.distance) && Objects.equals(this.sex, event.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.stroke, this.distance, this.sex);
    }

    public Short getAge() {
        return this.age;
    }

    public Short getStroke() {
        return this.stroke;
    }

    public Short getDistance() {
        return this.distance;
    }

    public String getSex() {
        return this.sex;
    }

    public String toString() {
        return String.format("%d %d %3d %s", age, stroke, distance, sex);
        //mtev + " " + lo + " " + hi + "  " + stroke + " " + distance + " " + sex;
    }

}



