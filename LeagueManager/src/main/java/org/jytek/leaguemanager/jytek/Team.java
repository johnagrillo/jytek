package org.jytek.leaguemanager.jytek;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private org.jytek.leaguemanager.hytek.tm.Team team;

    private List<org.jytek.leaguemanager.hytek.tm.Athlete> athletes;

    private List<org.jytek.leaguemanager.hytek.tm.Relay> relays;


    public List<org.jytek.leaguemanager.hytek.tm.Athlete> getAthletes() {
        return this.athletes;
    }

    public List<org.jytek.leaguemanager.hytek.tm.Relay> getRelays() {
        return this.relays;
    }

    public org.jytek.leaguemanager.hytek.tm.Team getTeam() {
        return this.team;
    }

    @Override
    public String toString() {
        return team.toString();
    }

    private Team() {

    }

    public Team(org.jytek.leaguemanager.hytek.tm.Team team) {
        this.team = team;
        athletes = new ArrayList<>();
        relays = new ArrayList<>();

    }

    public void addAthlete(org.jytek.leaguemanager.hytek.tm.Athlete athlete) {
        athletes.add(athlete);
    }

    public void addARelay(org.jytek.leaguemanager.hytek.tm.Relay relay) {
        relays.add(relay);
    }

}



