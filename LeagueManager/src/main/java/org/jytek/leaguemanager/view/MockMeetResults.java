package org.jytek.leaguemanager.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class MockMeetResults {

    private MockMeetResults() {

    }

    public TreeMap<Short, TreeMap<Integer, HashSet<TmResult>>> getMeetResults() {
        return meetResults;
    }

    public MockMeetResults(TreeMap<Short, ArrayList<TmResult>> results,
                           TreeMap<Integer, Integer> teamScores,
                           TreeMap<Short, TreeMap<Integer, HashSet<TmResult>>> meetResults ) {
        this.results = results;
        this.teamScores = teamScores;
        this.meetResults = meetResults;
    }

    public TreeMap<Short, ArrayList<TmResult>> getResults() {
        return results;
    }

    private TreeMap<Short, ArrayList<TmResult>> results;

    public TreeMap<Integer, Integer> getTeamScores() {
        return teamScores;
    }
    TreeMap<Integer, Integer> teamScores;


    public TreeMap<Short, TreeMap<Integer, HashSet<TmResult>>> meetResults;


    @Override
    public String toString() {
        return "MockMeetResults{" +
                "teamScores=" + teamScores +
                '}';
    }
}
