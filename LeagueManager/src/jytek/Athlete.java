package jytek;

import hytek.tm.Result;
import hytek.tm.Team;

import java.util.ArrayList;
import java.util.List;


public class Athlete
{
    private hytek.tm.Athlete athlete;

    public Integer getTeam() {
        return this.team.getTeam();
    }

    private hytek.tm.Team team;

    public Integer getAthlete() {
        return this.athlete.getAthlete();
    }
    public hytek.tm.Athlete getAthleteJ() {
        return this.athlete;
    }

    public List<Result> getResults() {
        return this.results;
    }

    private final List<Result> results;

    public Athlete(final hytek.tm.Athlete athlete, final hytek.tm.Team team) {
        this.athlete = athlete;
        this.team = team;
        results = new ArrayList<Result>();
    }

    public void add(hytek.tm.Result r) {
        results.add(r);
    }
}
