package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.AthleteDAO;
import org.jytek.leaguemanager.database.ResultDAO;
import org.jytek.leaguemanager.database.TeamDAO;

import java.util.ArrayList;
import java.util.List;


public class Athlete {
    private AthleteDAO athlete;

    public Integer getTeam() {
        return this.team.getTeam();
    }

    private TeamDAO team;

    public Integer getAthlete() {
        return this.athlete.getAthlete();
    }

    public AthleteDAO getAthleteJ() {
        return this.athlete;
    }

    public List<ResultDAO> getResults() {
        return this.results;
    }

    private final List<ResultDAO> results;

    public Athlete(final AthleteDAO athlete, final TeamDAO team) {
        this.athlete = athlete;
        this.team = team;
        results = new ArrayList<ResultDAO>();
    }

    public void add(ResultDAO r) {
        results.add(r);
    }
}
