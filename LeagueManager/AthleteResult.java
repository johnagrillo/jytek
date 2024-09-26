package org.jytek.leaguemanager.view;

public class AthleteResult {
    // Members
    private String meet;
    private String athlete;
    private String ir;
    private Integer score;
    private String event;
    private String stroke;
    private Integer place;
    private Integer points;

    public AthleteResult() {

        this.meet = "";
        this.athlete = "";
        this.ir = "";
        this.score = Integer.valueOf(0);
        this.event = "";
        this.stroke = "";
        this.place = Integer.valueOf(0);
        this.points = Integer.valueOf(0);
    
    }
    public AthleteResult(
            String meet,
            String athlete,
            String ir,
            Integer score,
            String event,
            String stroke,
            Integer place,
            Integer points
    ) {

        this.meet = meet;
        this.athlete = athlete;
        this.ir = ir;
        this.score = score;
        this.event = event;
        this.stroke = stroke;
        this.place = place;
        this.points = points;

    }

    // Getters/Setters

    public void setMeet(String meet) {
        this.meet = meet;
    }

    public String getMeet() {
        return meet;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getIr() {
        return ir;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStroke() {
        return stroke;
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

}
