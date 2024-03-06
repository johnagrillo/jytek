package org.jytek.leaguemanager.view;
import java.util.*;

public class AthleteResult {
    // Members
    private Integer score = 0;
    private Short place = 0;
    private Short points = 0;
    private Short age = 0;
    private String stroke = "";
    private String distance = "";
    private String event = "";
    private String mf = "";
    private String ir = "";
    private String meet = "";
    private java.util.Date date = new Date();
    private String team = "";

    public AthleteResult() {

        this.score = 0;
        this.place = 0;
        this.points = 0;
        this.age = 0;
        this.stroke = "";
        this.distance = "";
        this.event = "";
        this.mf = "";
        this.ir = "";
        this.meet = "";
        this.date = new Date();
        this.team = "";
    
    }
    public AthleteResult(
            Integer score,
            Short place,
            Short points,
            Short age,
            String stroke,
            String distance,
            String event,
            String mf,
            String ir,
            String meet,
            java.util.Date date,
            String team
    ) {

        this.score = score;
        this.place = place;
        this.points = points;
        this.age = age;
        this.stroke = stroke;
        this.distance = distance;
        this.event = event;
        this.mf = mf;
        this.ir = ir;
        this.meet = meet;
        this.date = date;
        this.team = team;

    }

    // Getters/Setters

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setPlace(Short place) {
        this.place = place;
    }

    public Short getPlace() {
        return place;
    }

    public void setPoints(Short points) {
        this.points = points;
    }

    public Short getPoints() {
        return points;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getAge() {
        return age;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStroke() {
        return stroke;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setMf(String mf) {
        this.mf = mf;
    }

    public String getMf() {
        return mf;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getIr() {
        return ir;
    }

    public void setMeet(String meet) {
        this.meet = meet;
    }

    public String getMeet() {
        return meet;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

}
