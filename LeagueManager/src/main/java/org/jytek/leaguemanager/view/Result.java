package org.jytek.leaguemanager.view;


public class Result {
    // Members
    private String meet;
    private String ir;
    private Integer score;
    private String event;
    private String stroke;
    private Short distance;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    private String course;


    private Short place;
    private Integer points;


    public Result() {

        this.meet = "";
        this.ir = "";
        this.score = 0;
        this.event = "";
        this.stroke = "";
        this.distance = 0;
        this.place = (short) 0;
        this.points = 0;

    }

    public Result(
            String meet,
            String ir,
            Integer score,
            String event,
            String stroke,
            Short distance,
            Short place,
            Integer points
    ) {

        this.meet = meet;
        this.ir = ir;
        this.score = score;
        this.event = event;
        this.stroke = stroke;
        this.distance = distance;
        this.place = place;
        this.points = points;

    }

    // Getters/Setters

    public String getMeet() {
        return meet;
    }

    public void setMeet(String meet) {
        this.meet = meet;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public Short getPlace() {
        return place;
    }

    public void setPlace(Short place) {
        this.place = place;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Short getDistance() {
        return distance;
    }

    public void setDistance(Short distance) {
        this.distance = distance;
    }

}

