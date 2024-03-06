package org.jytek.leaguemanager.view;
import java.util.*;

public class MeetResult {
    // Members
    private Integer score = 0;
    private Integer place = 0;
    private Integer points = 0;
    private String athlete = "";
    private String team = "";
    private Integer converted = 0;

    public MeetResult() {

        this.score = 0;
        this.place = 0;
        this.points = 0;
        this.athlete = "";
        this.team = "";
        this.converted = 0;
    
    }
    public MeetResult(
            Integer score,
            Integer place,
            Integer points,
            String athlete,
            String team,
            Integer converted
    ) {

        this.score = score;
        this.place = place;
        this.points = points;
        this.athlete = athlete;
        this.team = team;
        this.converted = converted;

    }

    // Getters/Setters

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setConverted(Integer converted) {
        this.converted = converted;
    }

    public Integer getConverted() {
        return converted;
    }

}
