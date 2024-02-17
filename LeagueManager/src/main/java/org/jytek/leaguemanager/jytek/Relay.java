package org.jytek.leaguemanager.jytek;

import org.jytek.leaguemanager.hytek.tm.*;




import java.util.ArrayList;
import java.util.List;

public class Relay {
    private org.jytek.leaguemanager.hytek.tm.Relay relay;


    public Integer getTeam() {
        return this.team.getTeam();
    }

    private org.jytek.leaguemanager.hytek.tm.Team team;

    public List<Result> getResults() {
        return this.results;
    }

    private final List<Result> results;

    public Relay(final org.jytek.leaguemanager.hytek.tm.Relay relay, final org.jytek.leaguemanager.hytek.tm.Team team) {
        this.relay = relay;
        this.team = team;
        this.results = new ArrayList<Result>();
    }

    @Override
    public String toString() {
        return "Relay{" +
                "relay=" + relay +
                ", team=" + team +
                '}';
    }

    public void add(final Result r) {
        results.add(r);
    }

}