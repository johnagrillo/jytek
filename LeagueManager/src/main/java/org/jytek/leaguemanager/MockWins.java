package org.jytek.leaguemanager;

public class MockWins {

    private String team ="";
    private Integer wins = 0;
    private Integer losses = 0;
    private  Integer ties = 0;

    public Integer getLosses() {
        return losses;
    }

    public Integer getTies() {
        return ties;
    }
    private MockWins() {

    }
    public MockWins(String team, Integer wins, Integer losses, Integer ties) {
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }
    public Integer getWins() {
        return wins;
    }
    public String getTeam() {
        return team;
    }
}
