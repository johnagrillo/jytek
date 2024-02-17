package org.jytek.leaguemanager.jytek;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.hytek.tm.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TmMdb {

    private com.healthmarketscience.jackcess.Database db;
    private HashMap<Integer, org.jytek.leaguemanager.jytek.Team> teams;

    public HashMap<Integer, Meet> getMeets() {
        return this.meets;
    }

    private HashMap<Integer, Meet> meets;
    private HashMap<Integer, Mtevente> mtevente;
    private HashMap<Integer, Mtevent> mtevent;
    private HashMap<Integer, Athlete> athletes;
    private HashMap<Integer, Result> results;
    private HashMap<Integer, org.jytek.leaguemanager.jytek.Relay> relays;


    private TmMdb() {

    }


    public TmMdb(File input) {
        try {
            db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

            final String fileName = "output/meets.txt";
            final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            meets = new HashMap<>();
            for (final Row row : db.getTable(org.jytek.leaguemanager.hytek.tm.Meet.NAME)) {
                final var meet = new Meet(row);
                meets.put(meet.getMeet(), meet);
                writer.write(meet + "\n");
            }
            writer.close();
            System.out.println("Meets: " + meets.size());


            teams = new HashMap<>();
            for (final Row row : db.getTable(org.jytek.leaguemanager.hytek.tm.Team.NAME)) {
                final var team = new org.jytek.leaguemanager.hytek.tm.Team(row);
                teams.put(team.getTeam(), new org.jytek.leaguemanager.jytek.Team(team));
            }
            System.out.println("Teams: " + teams.size());

            mtevente = new HashMap<>();
            for (final Row row : db.getTable(org.jytek.leaguemanager.hytek.tm.Mtevente.NAME)) {
                final Mtevente eve = new Mtevente(row);
                mtevente.put(eve.getMtevent(), eve);
            }

            mtevent = new HashMap<>();
            for (final Row row : db.getTable(org.jytek.leaguemanager.hytek.tm.Mtevent.NAME)) {
                final Mtevent event = new Mtevent(row);
                mtevent.put(event.getMtevent(), event);
            }
            System.out.println("Events: " + mtevent.size());

            // get athletes
            athletes = new HashMap<>();
            for (final Row row : db.getTable(org.jytek.leaguemanager.hytek.tm.Athlete.NAME)) {
                final org.jytek.leaguemanager.hytek.tm.Athlete a = new org.jytek.leaguemanager.hytek.tm.Athlete(row);
                athletes.put(a.getAthlete(), new org.jytek.leaguemanager.jytek.Athlete(a, teams.get(a.getTeam1()).getTeam()));

                var team = this.teams.get(a.getTeam1());
                team.addAthlete(a);
                System.out.println(a.getLast());
            }
            System.out.println("Athletes: " + athletes.size());

            // get relays
            // relays are also athletes
            // not all relays have results
            relays = new HashMap<>();
            for (var row : db.getTable(org.jytek.leaguemanager.hytek.tm.Relay.NAME)) {
                org.jytek.leaguemanager.hytek.tm.Relay tmr = new org.jytek.leaguemanager.hytek.tm.Relay(row);
                var team = this.teams.get(tmr.getTeam());
                relays.put(tmr.getRelay(), new Relay(tmr, team.getTeam()));
                team.addARelay(tmr);
            }
            System.out.println("Relays: " + relays.size());


            // get results
            results = new HashMap<>();
            for (final Row row : db.getTable(Result.NAME)) {
                final Result r = new Result(row);
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

