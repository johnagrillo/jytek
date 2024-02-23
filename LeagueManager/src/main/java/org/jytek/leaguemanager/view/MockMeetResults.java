package org.jytek.leaguemanager.view;

import java.util.ArrayList;
import java.util.TreeMap;

public class MockMeetResults {

    private MockMeetResults() {

    }
    public MockMeetResults(TreeMap<Short, ArrayList<TmResult>> results) {
        this.results = results;
    }

    public MockMeetResults(TreeMap<Short, ArrayList<TmResult>> results, TreeMap<Integer, Integer> teamScores) {
        this.results = results;
        this.teamScores = teamScores;
    }

    public TreeMap<Short, ArrayList<TmResult>> getResults() {
        return results;
    }

    private TreeMap<Short, ArrayList<TmResult>> results;

    public TreeMap<Integer, Integer> getTeamScores() {
        return teamScores;
    }
    TreeMap<Integer, Integer> teamScores;
}
