package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TmMdbDAO {

    private com.healthmarketscience.jackcess.Database db;
    private Map<Integer, TmTeam> teams;

    public Map<Integer, TmMeet> getMeets() {
        return this.meets;
    }

    private Map<Integer, TmMeet> meets;
    private HashMap<Integer, TmMtevente> mtevente;
    private HashMap<Integer, TmMtevent> mtevent;
    private Map<Integer, TmAthlete> athletes;
    private Map<Integer, TmResult> results;
    private Map<Integer, TmRelay> relays;

    private TmMdbDAO() {

    }

    public TmMeet getMeet(Integer meet) throws TeamException {
        var tmMeet = meets.get(meet);
        if (tmMeet == null) {
            throw new TeamException("No Meet " + meet);
        }
        return tmMeet;
    }

    public TmMdbDAO(File input) {
        try {
            db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);
            meets = MeetDAO.getMeets(db);


            teams = new HashMap<>();
            for (final Row row : db.getTable(TmTeam.NAME)) {
                final var team = TmTeam.create(row);
                teams.put(team.getTeam(), team);
            }

            mtevente = new HashMap<>();
            for (final Row row : db.getTable(TmMtevente.NAME)) {
                final TmMtevente eve = TmMtevente.create(row);
                mtevente.put(eve.getMtevent(), eve);
            }

            mtevent = new HashMap<>();
            for (final Row row : db.getTable(TmMtevent.NAME)) {
                final TmMtevent event = TmMtevent.create(row);
                mtevent.put(event.getMtevent(), event);
            }

            // get athletes
            athletes = AthleteDAO.getAthletes(db);

            for (var a : athletes.keySet()) {
                var ath = athletes.get(a);

                teams.get(ath.getTeam1()).add(ath);
            }


            // get relays
            // relays are also athletes
            // not all relays have results
            relays = new HashMap<>();
            for (var row : db.getTable(TmRelay.NAME)) {
                TmRelay tmr = TmRelay.create(row);
                var team = this.teams.get(tmr.getTeam());
                relays.put(tmr.getRelay(), tmr);
                team.add(tmr);
            }

            // get results
            results = new HashMap<>();
            for (final Row row : db.getTable(TmResult.NAME)) {
                final TmResult r = TmResult.create(row);

                if ((r.getDqcode() == null || r.getDqcode().isBlank())) {
                    if (0 == r.getScore()) {
                        continue;
                    }
                    if ("I".equals(r.getIr())) {
                        final var ath = athletes.get(r.getAthlete());

                        if (ath != null) {
                            ath.add(r);
                        } else {
                            System.out.println("Missing Ath " + r.getAthlete());
                        }
                    }
                    if ("R".equals(r.getIr())) {
                        var relay = relays.get(r.getAthlete());
                        relay.add(r);
                    }
                }
                results.put(r.getResult(), r);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, TmTeam> getTeams() {
        return this.teams;
    }

    public HashMap<Integer, TmMtevente> getMtevente() {
        return this.mtevente;
    }

    public HashMap<Integer, TmMtevent> getMtevent() {
        return this.mtevent;
    }

    public Map<Integer, TmAthlete> getAthletes() {
        return this.athletes;
    }

    public Map<Integer, TmResult> getResults() {
        return this.results;
    }

    public Map<Integer, TmRelay> getRelays() {
        return this.relays;
    }

}

