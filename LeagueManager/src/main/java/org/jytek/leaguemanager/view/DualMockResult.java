package org.jytek.leaguemanager.view;

import java.util.Objects;

public class DualMockResult {

    private String team1 = "";
    private String team1Score = "";
    private String team2 = "";
    private String team2Score = "";
    private String diff = "";

    private MockMeetResults results;

    public DualMockResult()
    {

    }


    public DualMockResult(final String team1, final String team1Score,
                          final String team2, final String team2Score,
                          final String diff, final MockMeetResults results) {
        this.team1 = team1;
        this.team1Score = team1Score;
        this.team2 = team2;
        this.team2Score = team2Score;
        this.diff = diff;
        this.results = results;

    }





    public String getTeam1() {
        return team1;
    }

    public void setTeam1(final String team1) {
        this.team1 = team1;
    }

    public String getTeam1Score() {
        return team1Score;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTeam2Score() {
        return team2Score;
    }

    public String getDiff() {
        return diff;
    }


    public MockMeetResults getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DualMockResult that = (DualMockResult) o;
        return Objects.equals(team1, that.team1) && Objects.equals(team1Score, that.team1Score) && Objects.equals(team2, that.team2) && Objects.equals(team2Score, that.team2Score) && Objects.equals(diff, that.diff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team1, team1Score, team2, team2Score, diff);
    }

    @Override
    public String toString() {
        return "DualMockResult{" +
                "team1='" + team1 + '\'' +
                ", team1Score=" + team1Score +
                ", team2='" + team2 + '\'' +
                ", team2Score=" + team2Score +
                ", diff=" + diff +
                '}';
    }
}
