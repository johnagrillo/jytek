package jytek;


import hytek.tm.Result;
import hytek.tm.Team;

import java.util.ArrayList;
import java.util.List;

public class Relay {
    private hytek.tm.Relay relay;


    public Integer getTeam() {
        return this.team.getTeam();
    }

    private hytek.tm.Team team;

    public List<Result> getResults() {
        return this.results;
    }

    private final List<Result> results;

    public Relay(final hytek.tm.Relay relay, final hytek.tm.Team team) {
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

    public void add(final hytek.tm.Result r) {
        results.add(r);
    }

}