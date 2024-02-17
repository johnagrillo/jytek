package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.AthleteDAO;
import org.jytek.leaguemanager.database.RelayDAO;
import org.jytek.leaguemanager.database.TeamDAO;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private TeamDAO team;

    private List<AthleteDAO> athletes;

    private List<RelayDAO> relays;


    public List<AthleteDAO> getAthletes() {
        return this.athletes;
    }

    public List<RelayDAO> getRelays() {
        return this.relays;
    }

    public TeamDAO getTeam() {
        return this.team;
    }

    @Override
    public String toString() {
        return team.toString();
    }

    private Team() {

    }

    public Team(TeamDAO team) {
        this.team = team;
        athletes = new ArrayList<>();
        relays = new ArrayList<>();

    }

    public void addAthlete(AthleteDAO athlete) {
        athletes.add(athlete);
    }

    public void addARelay(RelayDAO relay) {
        relays.add(relay);
    }

}



