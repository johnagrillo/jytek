package org.jytek.leaguemanager.jytek;

import org.jytek.leaguemanager.hytek.tm.*;
import java.util.ArrayList;
import java.util.List;


public class Athlete {
    private org.jytek.leaguemanager.hytek.tm.Athlete athlete;

    public Integer getTeam() {
        return this.team.getTeam();
    }

    private org.jytek.leaguemanager.hytek.tm.Team team;

    public Integer getAthlete() {
        return this.athlete.getAthlete();
    }

    public org.jytek.leaguemanager.hytek.tm.Athlete getAthleteJ() {
        return this.athlete;
    }

    public List<Result> getResults() {
        return this.results;
    }

    private final List<Result> results;

    public Athlete(final org.jytek.leaguemanager.hytek.tm.Athlete athlete, final org.jytek.leaguemanager.hytek.tm.Team team) {
        this.athlete = athlete;
        this.team = team;
        results = new ArrayList<Result>();
    }

    public void add(Result r) {
        results.add(r);
    }
}
