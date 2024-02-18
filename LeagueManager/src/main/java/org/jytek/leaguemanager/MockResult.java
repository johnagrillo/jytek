package org.jytek.leaguemanager;

public class MockResult {

    String team1;
    Integer team1Score;
    String team2;
    Integer team2Score;
    Integer diff;

    public MockResult(String team1, Integer team1Score, String team2, Integer team2Score, Integer diff) {
        this.team1 = team1;
        this.team1Score = team1Score;
        this.team2 = team2;
        this.team2Score = team2Score;
        this.diff = diff;
    }


    public String getTeam1() {
        return team1;
    }

    public Integer getTeam1Score() {
        return team1Score;
    }

    public String getTeam2() {
        return team2;
    }

    public Integer getTeam2Score() {
        return team2Score;
    }

    public Integer getDiff() {
        return diff;
    }
}
