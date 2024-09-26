package org.jytek.leaguemanager.view;

public class MeetResult {
    // Members
    private String athlete;
    private Integer points;
    private Integer place;
    private Integer score;

    public MeetResult() {

        this.athlete = "";
        this.points = Integer.valueOf(0);
        this.place = Integer.valueOf(0);
        this.score = Integer.valueOf(0);
    
    }
    public MeetResult(
            String athlete,
            Integer points,
            Integer place,
            Integer score
    ) {

        this.athlete = athlete;
        this.points = points;
        this.place = place;
        this.score = score;

    }

    // Getters/Setters

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPlace() {
        return place;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

}
