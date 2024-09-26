package org.jytek.leaguemanager.view;

public class MeetResult implements Comparable<MeetResult> {
    // Members
    private String event = "";
    private String points = "";
    private String place = "";
    private String athlete = "";
    private String age = "";
    private String team = "";
    private String time = "";
    private String conv = "";

    public MeetResult() {

        this.event = "";
        this.points = "";
        this.place = "";
        this.athlete = "";
        this.age = "";
        this.team = "";
        this.time = "";
        this.conv = "";
    
    }

    @Override
    public String toString() {
        return "MeetResult{" +
                "event='" + event + '\'' +
                ", points='" + points + '\'' +
                ", place='" + place + '\'' +
                ", athlete='" + athlete + '\'' +
                ", age='" + age + '\'' +
                ", team='" + team + '\'' +
                ", time='" + time + '\'' +
                ", conv='" + conv + '\'' +
                '}';
    }

    public MeetResult(
            String event,
            String points,
            String place,
            String athlete,
            String age,
            String team,
            String time,
            String conv
    ) {

        this.event = event;
        this.points = points;
        this.place = place;
        this.athlete = athlete;
        this.age = age;
        this.team = team;
        this.time = time;
        this.conv = conv;

    }
    @Override
    public int compareTo(MeetResult o) {
        return Integer.compare(Integer.parseInt(place), Integer.parseInt(o.place));
    }
    // Getters/Setters

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setConv(String conv) {
        this.conv = conv;
    }

    public String getConv() {
        return conv;
    }

}
