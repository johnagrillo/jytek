
package org.jytek.leaguemanager.view;

import java.util.Objects;

public class DualMockResult {

    String team1;
    Integer team1Score;
    String team2;
    Integer team2Score;
    Integer diff;

    MockMeetResults results;



    public DualMockResult(String team1, Integer team1Score, String team2, Integer team2Score, Integer diff, MockMeetResults results) {
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
