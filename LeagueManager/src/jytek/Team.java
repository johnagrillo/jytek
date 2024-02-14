package jytek;


import hytek.tm.Athlete;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private hytek.tm.Team team;

    private List<hytek.tm.Athlete> athletes;

    private List<hytek.tm.Relay> relays;



    public List<Athlete> getAthletes() {
        return this.athletes;
    }
    public List<hytek.tm.Relay> getRelays() {
        return this.relays;
    }

    public hytek.tm.Team getTeam() {
        return this.team;
    }

    @Override
    public String toString() {
        return team.toString();
    }

    private Team() {

    }

    public Team(hytek.tm.Team team) {
        this.team = team;
        athletes = new ArrayList<>();
        relays = new ArrayList<>();

    }

    public void addAthlete(hytek.tm.Athlete athlete) {
        athletes.add(athlete);
    }

    public void addARelay(hytek.tm.Relay relay) {
        relays.add(relay);
    }

}



