package jytek;

import com.healthmarketscience.jackcess.Row;
import hytek.tm.Meet;
import hytek.tm.Mtevent;
import hytek.tm.Mtevente;
import hytek.tm.Result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TmMdb {

    private com.healthmarketscience.jackcess.Database db;
    private HashMap<Integer, jytek.Team> teams;

    public HashMap<Integer, Meet> getMeets() {
        return this.meets;
    }

    private HashMap<Integer, hytek.tm.Meet> meets;
    private HashMap<Integer, hytek.tm.Mtevente> mtevente;
    private HashMap<Integer, hytek.tm.Mtevent> mtevent;
    private HashMap<Integer, jytek.Athlete> athletes;
    private HashMap<Integer, hytek.tm.Result> results;
    private HashMap<Integer, jytek.Relay> relays;


    private TmMdb() {

    }


    public TmMdb(File input) {
        try {
            db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

            final String fileName = "output/meets.txt";
            final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            meets = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Meet.NAME)) {
                final var meet = new hytek.tm.Meet(row);
                meets.put(meet.getMeet(), meet);
                writer.write(meet + "\n");
            }
            writer.close();
            System.out.println("Meets: " + meets.size());



            teams = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Team.NAME)) {
                final var team = new hytek.tm.Team(row);
                teams.put(team.getTeam(), new jytek.Team(team));
            }
            System.out.println("Teams: " + teams.size());

            mtevente = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Mtevente.NAME)) {
                final hytek.tm.Mtevente eve = new hytek.tm.Mtevente(row);
                mtevente.put(eve.getMtevent(), eve);
            }

            mtevent = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Mtevent.NAME)) {
                final hytek.tm.Mtevent event = new hytek.tm.Mtevent(row);
                mtevent.put(event.getMtevent(), event);
            }
            System.out.println("Events: " + mtevent.size());

            // get athletes
            athletes = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Athlete.NAME)) {
                final hytek.tm.Athlete a = new hytek.tm.Athlete(row);
                athletes.put(a.getAthlete(), new jytek.Athlete(a, teams.get(a.getTeam1()).getTeam()));

                var team = this.teams.get(a.getTeam1());
                team.addAthlete(a);
                System.out.println(a.getLast());
            }
            System.out.println("Athletes: " + athletes.size());

            // get relays
            // relays are also athletes
            // not all relays have results
            relays = new HashMap<>();
            for (var row : db.getTable(hytek.tm.Relay.NAME)) {
                hytek.tm.Relay tmr = new hytek.tm.Relay(row);
                var team = this.teams.get(tmr.getTeam());
                relays.put(tmr.getRelay(), new jytek.Relay(tmr, team.getTeam()));
                team.addARelay(tmr);
            }
            System.out.println("Relays: " + relays.size());


            // get results
            results = new HashMap<>();
            for (final Row row : db.getTable(hytek.tm.Result.NAME)) {
                final hytek.tm.Result r = new hytek.tm.Result(row);
                results.put(r.getResult(), r);

                if (!r.getDqcode().isBlank()) {
                    continue;
                }
                if (0 == r.getScore()) {
                    continue;
                }
                if ("I".equals(r.getI_r())) {
                    final var ath = athletes.get(r.getAthlete());
                    ath.add(r);
                }
                if ("R".equals(r.getI_r())) {
                    var relay = relays.get(r.getAthlete());
                    relay.add(r);

                }
            }
            System.out.println("Results: " + results.size());

            // break athletes into teams

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<Integer, Team> getTeams() {
        return this.teams;
    }

    public HashMap<Integer, Mtevente> getMtevente() {
        return this.mtevente;
    }

    public HashMap<Integer, Mtevent> getMtevent() {
        return this.mtevent;
    }

    public HashMap<Integer, Athlete> getAthletes() {
        return this.athletes;
    }

    public HashMap<Integer, Result> getResults() {
        return this.results;
    }

    public HashMap<Integer, Relay> getRelays() {
        return this.relays;
    }

}

