package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.RelayDAO;
import org.jytek.leaguemanager.database.ResultDAO;
import org.jytek.leaguemanager.database.TeamDAO;


import java.util.ArrayList;
import java.util.List;

public class Relay {
    private RelayDAO relay;


    public Integer getTeam() {
        return this.team.getTeam();
    }

    private TeamDAO team;

    public List<ResultDAO> getResults() {
        return this.results;
    }

    private final List<ResultDAO> results;

    public Relay(final RelayDAO relay, final TeamDAO team) {
        this.relay = relay;
        this.team = team;
        this.results = new ArrayList<ResultDAO>();
    }

    @Override
    public String toString() {
        return "Relay{" +
                "relay=" + relay +
                ", team=" + team +
                '}';
    }

    public void add(final ResultDAO r) {
        results.add(r);
    }

}