package org.jytek.leaguemanager.view;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.database.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TmMdb {

    private com.healthmarketscience.jackcess.Database db;
    private HashMap<Integer, org.jytek.leaguemanager.view.Team> teams;

    public HashMap<Integer, MeetDAO> getMeets() {
        return this.meets;
    }

    private HashMap<Integer, MeetDAO> meets;
    private HashMap<Integer, MteventeDAO> mtevente;
    private HashMap<Integer, MteventDAO> mtevent;
    private HashMap<Integer, Athlete> athletes;
    private HashMap<Integer, ResultDAO> results;
    private HashMap<Integer, org.jytek.leaguemanager.view.Relay> relays;


    private TmMdb() {

    }


    public TmMdb(File input) {
        try {
            db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

            final String fileName = "output/meets.txt";
            final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            meets = new HashMap<>();
            for (final Row row : db.getTable(MeetDAO.NAME)) {
                final var meet = new MeetDAO(row);
                meets.put(meet.getMeet(), meet);
                writer.write(meet + "\n");
            }
            writer.close();
            System.out.println("Meets: " + meets.size());


            teams = new HashMap<>();
            for (final Row row : db.getTable(TeamDAO.NAME)) {
                final var team = new TeamDAO(row);
                teams.put(team.getTeam(), new org.jytek.leaguemanager.view.Team(team));
            }
            System.out.println("Teams: " + teams.size());

            mtevente = new HashMap<>();
            for (final Row row : db.getTable(MteventeDAO.NAME)) {
                final MteventeDAO eve = new MteventeDAO(row);
                mtevente.put(eve.getMtevent(), eve);
            }

            mtevent = new HashMap<>();
            for (final Row row : db.getTable(MteventDAO.NAME)) {
                final MteventDAO event = new MteventDAO(row);
                mtevent.put(event.getMtevent(), event);
            }
            System.out.println("Events: " + mtevent.size());

            // get athletes
            athletes = new HashMap<>();
            for (final Row row : db.getTable(AthleteDAO.NAME)) {
                final AthleteDAO a = new AthleteDAO(row);
                athletes.put(a.getAthlete(), new org.jytek.leaguemanager.view.Athlete(a, teams.get(a.getTeam1()).getTeam()));

                var team = this.teams.get(a.getTeam1());
                team.addAthlete(a);
                System.out.println(a.getLast());
            }
            System.out.println("Athletes: " + athletes.size());

            // get relays
            // relays are also athletes
            // not all relays have results
            relays = new HashMap<>();
            for (var row : db.getTable(RelayDAO.NAME)) {
                RelayDAO tmr = new RelayDAO(row);
                var team = this.teams.get(tmr.getTeam());
                relays.put(tmr.getRelay(), new Relay(tmr, team.getTeam()));
                team.addARelay(tmr);
            }
            System.out.println("Relays: " + relays.size());


            // get results
            results = new HashMap<>();
            for (final Row row : db.getTable(ResultDAO.NAME)) {
                final ResultDAO r = new ResultDAO(row);
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

    public HashMap<Integer, MteventeDAO> getMtevente() {
        return this.mtevente;
    }

    public HashMap<Integer, MteventDAO> getMtevent() {
        return this.mtevent;
    }

    public HashMap<Integer, Athlete> getAthletes() {
        return this.athletes;
    }

    public HashMap<Integer, ResultDAO> getResults() {
        return this.results;
    }

    public HashMap<Integer, Relay> getRelays() {
        return this.relays;
    }

}

