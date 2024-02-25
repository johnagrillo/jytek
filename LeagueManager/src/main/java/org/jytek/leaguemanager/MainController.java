package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.jytek.leaguemanager.database.AthleteException;
import org.jytek.leaguemanager.database.MtEventException;
import org.jytek.leaguemanager.database.TeamException;
import org.jytek.leaguemanager.database.TmMdbDAO;
import org.jytek.leaguemanager.view.*;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.*;


public class MainController extends Application implements Initializable {

    private final FileChooser fileChooser = new FileChooser();
    TmMdbDAO tm;
    @FXML
    private TreeView<String> trvWeeks;
    @FXML
    private Button btRunWeeklysMock;
    @FXML
    private Tab tbLoad;
    @FXML
    private Tab tbTeams;
    @FXML
    private Tab tbAthletes;
    @FXML
    private Tab tbMeets;
    @FXML
    private Tab tbMockMeets;
    @FXML
    private Tab tbWeeklyMockMeets;
    @FXML
    private Label lbMockMeets;
    @FXML
    private Button btRunMock;
    @FXML
    private Button btRunWeeklyMockMeets;
    @FXML
    private Label lbMeets;
    @FXML
    private Label lbTeams;
    @FXML
    private Label lbAthletes;
    @FXML
    private Label lbResults;
    @FXML
    private Label lbRelays;
    @FXML
    private Button btLoad;
    @FXML
    private Label lbFile;
    @FXML
    private TableColumn<DualMockResult, Integer> tcDiff;
    @FXML
    private TableColumn<DualMockResult, Integer> tcScore1;
    @FXML
    private TableColumn<DualMockResult, Integer> tcScore2;
    @FXML
    private TableColumn<DualMockResult, String> tcTeam1;
    @FXML
    private TableColumn<DualMockResult, String> tcTeam2;
    @FXML
    private TableView<DualMockResult> tvMockResults;
    @FXML
    private TableColumn<MockWins, Integer> tcLosses;
    @FXML
    private TableColumn<MockWins, Integer> tcTies;
    @FXML
    private TableColumn<MockWins, Integer> tcWins;
    @FXML
    private TableColumn<MockWins, String> tcTeam;
    @FXML
    private TableView<MockWins> tvMockWins;
    @FXML
    private TableView<TmTeam> tvTmTeams;
    @FXML
    private TableColumn<TmTeam, Integer> tcTeamTeam;
    @FXML
    private TableColumn<TmTeam, String> tcTCode;
    @FXML
    private TableColumn<TmTeam, String> tcTName;
    @FXML
    private TableColumn<TmTeam, String> tcShort;
    @FXML
    private TableView<TmAthlete> tvTmAthletes;
    @FXML
    private TableColumn<TmAthlete, Integer> tcAthlete;
    @FXML
    private TableColumn<TmAthlete, Integer> tcAthTeam1;
    @FXML
    private TableColumn<TmAthlete, String> tcLast;
    @FXML
    private TableColumn<TmAthlete, String> tcFirst;
    @FXML
    private TableColumn<TmAthlete, String> tcInitial;
    @FXML
    private TableColumn<TmAthlete, String> tcSex;
    @FXML
    private TableColumn<TmAthlete, java.time.LocalDateTime> tcBirth;
    //    @FXML
    //private TableColumn<TmAthlete,String> tcID_NO;
    @FXML
    private TableColumn<TmAthlete, Short> tcAge;
    @FXML
    private TableView<TmMeet> tvTmMeets;
    @FXML
    private TableColumn<TmMeet, Integer> tcMeet;
    @FXML
    private TableColumn<TmMeet, String> tcMName;
    @FXML
    private TableColumn<TmMeet, java.time.LocalDateTime> tcStart;
    @FXML
    private TableColumn<TmMeet, java.time.LocalDateTime> tcEnd;
    @FXML
    private TableColumn<TmMeet, java.time.LocalDateTime> tcAgeUp;
    @FXML
    private TableColumn<TmMeet, java.time.LocalDateTime> tcSince;
    @FXML
    private TableColumn<TmMeet, String> tcCourse;
    @FXML
    private TableColumn<TmMeet, String> tcLocation;
    @FXML
    private TableColumn<TmMeet, Short> tcMaxIndEnt;
    @FXML
    private TableColumn<TmMeet, Short> tcMaxRelEnt;
    @FXML
    private TableColumn<TmMeet, Short> tcMaxEnt;
    private Stage stage;
    private File mockFile = null;

    public static void main(String[] args) {
        launch();
    }

    @FXML
    protected void onLoad() {
        tbTeams.setDisable(true);
        tbAthletes.setDisable(true);
        tbMeets.setDisable(true);
        tbMockMeets.setDisable(true);
        tbWeeklyMockMeets.setDisable(true);


        mockFile = fileChooser.showOpenDialog(this.stage);
        if (mockFile != null) {

            lbFile.setText(mockFile.getPath());
            tm = new TmMdbDAO(mockFile);
            lbTeams.setText("" + tm.getTeams().size());
            lbAthletes.setText("" + tm.getAthletes().size());
            lbResults.setText("" + tm.getResults().size());
            lbRelays.setText("" + tm.getRelays().size());
            lbMeets.setText("" + tm.getMeets().size());

            tbTeams.setDisable(false);
            tbAthletes.setDisable(false);
            tbMeets.setDisable(false);
            tbMockMeets.setDisable(false);
            tbWeeklyMockMeets.setDisable(false);


            ObservableList<TmTeam> teams = FXCollections.observableArrayList();
            teams.addAll(tm.getTeams().values());
            tvTmTeams.setItems(teams);

            ObservableList<TmAthlete> athletes = FXCollections.observableArrayList();
            athletes.addAll(tm.getAthletes().values());
            tvTmAthletes.setItems(athletes);

            ObservableList<TmMeet> meets = FXCollections.observableArrayList();
            meets.addAll(tm.getMeets().values());

            tvTmMeets.setItems(meets);
        }
    }

    private TreeMap<Short, ArrayList<TmResult>> getBestTeamEntries(Integer team) {

        //
        // get a best swim for each athlete on this team
        //
        TreeMap<Short, ArrayList<TmResult>> teamEntries = new TreeMap<>();
        try {
            for (var ath : tm.getTeamAthletes(tm.getTeam(team))) {
                for (var r : tm.getAthleteBestResults(tm.getAthlete(ath.getAthlete()))) {
                    try {
                        var events = teamEntries.computeIfAbsent(tm.getMtevent(r.getMtevent()).getMtev(), k -> new ArrayList<>());
                        events.add(r);
                    } catch (MtEventException e) {

                    }
                }
            }
        } catch (TeamException | AthleteException e) {
            // continue
            System.out.println("getBestTeamEntries " + e +  " " + team) ;
        }

        //
        // get the best relays for this team
        //
        try {
            var tmteam = tm.getTeam(team);
            for( var r : tm.getATeamBestRelays(tmteam)) {
               var results = teamEntries.computeIfAbsent( tm.getMtevent(r.getMtevent()).getMtev(), k -> new ArrayList<>() );

            }
        } catch (TeamException | MtEventException e) {


        }
        System.out.println("Getting Team " + team + " " + teamEntries.size());
        return teamEntries;
    }


    protected Map<Short, Short>  getAgeUp(Scoring scoring) {
        Map<Short, Short> ageUp = new HashMap<>();
        if (scoring == Scoring.CMSL) {
	    //6 & U ageup to 7-8
	    ageUp.put((short)9,  (short)11);
	    ageUp.put((short)10, (short)12);
	    ageUp.put((short)21, (short)23);
	    ageUp.put((short)22, (short)24);
	}
	return ageUp;
    }

    protected Map<Short, Integer[]> getEventPoints(Scoring scoring) {
        Map<Short, Integer[]> eventPoints = new HashMap<>();
        if (scoring == Scoring.FSSL) {
            Integer[] ind = {50, 30, 10};
            Integer[] relay = {80, 40, 0};

            // set all events to ind
            for (short e = 1; e <= 68; e++) {
                eventPoints.put(e, ind);
            }
            // set relay events
            final Short[] relayE = {31, 32, 33, 34, 67, 68};
            for (Short r : relayE) {
                eventPoints.put(r, relay);
            }
        }
        else if (scoring == Scoring.CMSL) {
            Integer[] ind = {50, 30, 10};
            Integer[] relay = {50, 20};
            // set all events to ind
            for (short e = 1; e <= 61; e++) {
                eventPoints.put(e, ind);
            }
            // set relay events
            final Short[] relayE = {53,54,55,56,57,58,59,60,61};
            for (Short r : relayE) {
                eventPoints.put(r, relay);
            }
        }
        return eventPoints;
    }



    @FXML
    protected void onRunMock() {

        ////
        ///   beast time mock for all teams
        ///
        var dualResults = new ArrayList<DualMockResult>();
        for (var team1 : tm.getTeams().keySet()) {
            var team1Entries = getBestTeamEntries(team1);
            for (var team2 : tm.getTeams().keySet()) {
                if (!Objects.equals(team1, team2)) {
                    var in = new HashSet<Integer>();
                    in.add(team1);
                    in.add(team2);
                    var team2Entries = getBestTeamEntries(team2);
                    // add team and team 2
                    var teamEntries = new TreeMap<Short, ArrayList<TmResult>>();

                    var teams = new HashSet<String>();

                    for (var entries : Arrays.asList(team1Entries, team2Entries)) {

                        for (var ev : entries.keySet()) {
                            for (var r : entries.get(ev)) {
                                teamEntries.computeIfAbsent(ev, k -> new ArrayList<>()).add(r);
                                try {
                                    if (in.contains(r.getTeam())) {
                                        teams.add(tm.getTeam(r.getTeam()).getTcode());
                                    } else {
                                        System.out.println("Wrong Team in "  + " " + tm.getTeam(r.getTeam()).getTcode() + " " + r);
                                    }
                                } catch (TeamException e) {
                                    System.out.println("No Team " + e);

                                }
                            }
                        }
                    }


                    // only run if we have two teams


                    var r = MockMeet.runMockMeet(teamEntries,
						 getEventPoints(scoring),
						 getAgeUp(scoring)
						 );

                    var teamScores = r.getTeamScores();
                    System.out.println("scored " + teamScores);

                    if (teamScores.size() == 2) {

                        var t1 = teamScores.get(team1);
                        var t2 = teamScores.get(team2);
                        var diff = (int) ((int) (t1 - t2) / 10.0);

                        try {
                            dualResults.add(new DualMockResult(
                                    tm.getTeam(team1).getTcode(),
                                    t1,
                                    tm.getTeam(team2).getTcode(),
                                    t2,
                                    diff));
                        } catch (TeamException e) {

                        }
                    }

                }
            }
        }


        ObservableList<DualMockResult> results = FXCollections.observableArrayList();
        results.addAll(dualResults);
        tvMockResults.setItems(results);
        lbMockMeets.setText("" + results.size());
        // count wins mby team

        Map<String, Integer> wins = new TreeMap<>();
        Map<String, Integer> losses = new TreeMap<>();
        Map<String, Integer> ties = new TreeMap<>();


        for (var r : results) {
            wins.computeIfAbsent(r.team1, k -> 0);
            wins.computeIfAbsent(r.team2, k -> 0);
            losses.computeIfAbsent(r.team1, k -> 0);
            losses.computeIfAbsent(r.team2, k -> 0);
            ties.computeIfAbsent(r.team1, k -> 0);
            ties.computeIfAbsent(r.team2, k -> 0);

            if (r.team1Score > r.team2Score) {
                wins.put(r.team1, wins.get(r.team1) + 1);
            }
            if (r.team1Score.intValue() == r.team2Score.intValue()) {
                ties.put(r.team1, ties.get(r.team1) + 1);
            }
            if (r.team1Score < r.team2Score) {
                losses.put(r.team1, losses.get(r.team1) + 1);
            }


        }

        // sort by wins

        Map<Integer, ArrayList<String>> byScore = new TreeMap<>();
        for (var team : wins.keySet()) {
            var list = byScore.computeIfAbsent(wins.get(team), k -> new ArrayList<>());
            list.add(team);
        }

        ObservableList<MockWins> places = FXCollections.observableArrayList();

        for (var w : byScore.keySet()) {
            for (var team : byScore.get(w)) {
                places.add(new MockWins(team, w, losses.get(team), ties.get(team)));
            }
        }

        // reverse sort places

        Collections.reverse(places);

        tvMockWins.setItems(places);

    }


    public void populateData() {


        for (Pair<TableColumn, String> pair : Arrays.asList(new Pair(tcDiff, "Diff"), new Pair(tcScore1, "Team1Score"), new Pair(tcScore2, "Team2Score"), new Pair(tcTeam1, "Team1"), new Pair(tcTeam2, "Team2"),

                new Pair(tcTeam, "Team"), new Pair(tcWins, "Wins"), new Pair(tcLosses, "Losses"), new Pair(tcTies, "Ties")

        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

        for (Pair<TableColumn, String> pair : Arrays.asList(new Pair(tcTeamTeam, "Team"), new Pair(tcTCode, "Tcode"), new Pair(tcTName, "Tname")
                //new Pair(tcShort,"shortN")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

        for (Pair<TableColumn, String> pair : Arrays.asList(new Pair(tcAthlete, "Athlete"), new Pair(tcAthTeam1, "Team1"), new Pair(tcLast, "Last"), new Pair(tcFirst, "First"), new Pair(tcInitial, "Initial"), new Pair(tcSex, "Sex"), new Pair(tcBirth, "Birth"), new Pair(tcAge, "Age")
                //new Pair(tcID_NO,"ID_NO")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }


        for (Pair<TableColumn, String> pair : Arrays.asList(new Pair(tcMeet, "Meet"), new Pair(tcMName, "Mname"), new Pair(tcStart, "Start"), new Pair(tcCourse, "Course"), new Pair(tcLocation, "Location"), new Pair(tcMaxIndEnt, "Maxindent"), new Pair(tcMaxRelEnt, "Maxrelent"), new Pair(tcMaxEnt, "Maxent"))) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 1000);
        var controller = loader.<MainController>getController();
        controller.populateData();
        stage.setTitle("League Manager");
        stage.setScene(scene);
        stage.show();
    }

    private void openFile(File file) {

        //Mock mock = new Mock(file);
        //mock.run();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var filt = new FileChooser.ExtensionFilter("MDB", "*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);

    }

    @FXML
    protected void onRunWeeklyMock(ActionEvent actionEvent) {

        //  Year,    Mname,  Cweek
        Map<Integer, HashMap<String, Integer>> corrections = new HashMap<>();

        corrections.put(2023, new HashMap<>());
        var year2023 = corrections.get(2023);

        //63, 2023-07-01, FSSL 2023 Week 1 - SR-RMR
        year2023.put("FSSL 2023 Week 1 - SR-RMR", 1);


        corrections.put(2022, new HashMap<>());
        var year2022 = corrections.get(2022);

        //19 2022-07-02T00:00 FSSL 2022 Week 3 - LDL@DB
        year2022.put("FSSL 2022 Week 3 - LDL@DB", 3);


        //20 2022-07-02T00:00 FSSL 2022 Week 3 - BH@RMR
        year2022.put("FSSL 2022 Week 3", 3);

        //20 2018-07-07T00:00 FSSL Week 3: Holly Hills @ Spring Ridge


        corrections.put(2018, new HashMap<>());
        var year2018 = corrections.get(2018);

        year2018.put("FSSL Week 3: Holly Hills @ Spring Ridge", 5);


        //39 2017-07-01T00:00 FSSL Week 3: Windsor Knolls @ Hood College
        //40 2017-07-01T00:00 FSSL Week 3: Whittier @ Braddock Heights


        corrections.put(2017, new HashMap<>());
        var year2017 = corrections.get(2017);
        year2017.put("FSSL Week 3: Windsor Knolls @ Hood College", 4);
        year2017.put("FSSL Week 3: Whittier @ Braddock Heights", 4);


        corrections.put(2016, new HashMap<>());
        var year2016 = corrections.get(2016);
        //14 2016-06-30T00:00 FSSL Week 2: Clover Hill @ Frederick YMCA  -> 2
        year2017.put("FSSL Week 2: Clover Hill @ Frederick YMCA", 2);


        //21 2012-07-07T00:00 Week 3: Dearbought @ Brunswick - 3
        corrections.put(2012, new HashMap<>());
        var year2012 = corrections.get(2012);
        year2012.put("Week 3: Dearbought @ Brunswick", 3);


        // correction data
        // 2023 Meet 63 week 1

        var first = 50;
        for (var m : tm.getMeets().values()) {
            var week = m.getStart().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            first = Math.min(first, week);
        }

        System.out.println(first);
        // get mmets by week
        var weekMeets = new TreeMap<Integer, HashSet<TmMeet>>();
        var meetResults = new TreeMap<Integer, HashSet<TmResult>>();

        for (var m : tm.getMeets().values()) {
            var week = m.getStart().get(ChronoField.ALIGNED_WEEK_OF_YEAR);

            ZonedDateTime zdt = m.getStart().atZone(ZoneId.systemDefault());
            Date output = Date.from(zdt.toInstant());
            LocalDate date = m.getStart().toLocalDate();
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            week = date.get(weekFields.weekOfWeekBasedYear()) - first + 1;

            // check for corrected cweek

            if (corrections.containsKey(m.getStart().getYear())) {
                if (corrections.get(m.getStart().getYear()).containsKey(m.getMname())) {
                    week = corrections.get(m.getStart().getYear()).get(m.getMname());
                }
            }


            var meets = weekMeets.computeIfAbsent(week, k -> new HashSet<>());
            meets.add(m);
        }

        for (var result : tm.getResults().values()) {
            var meet = meetResults.computeIfAbsent(result.getMeet(), k -> new HashSet<>());
            meet.add(result);
        }

        var iter = weekMeets.keySet().iterator();
        // find the first entry, first week of season

        ///
        ///
        ///
        TreeItem<String> rootNode = new TreeItem<String>("Meets By Week");

        trvWeeks.setRoot(rootNode);
        for (var week : weekMeets.keySet()) {
            var weekNode = new TreeItem<String>("Week " + week);
            System.out.println(week);
            rootNode.getChildren().add(weekNode);
            for (var m : weekMeets.get(week)) {
                System.out.println(m.getMeet() + " " + m.getStart() + " " + m.getMname());
                var node = new TreeItem<String>(m.getMeet() + " " + m.getStart() + " " + m.getMname());
                weekNode.getChildren().add(node);
            }
        }
    }
    enum Scoring {
        CMSL,
        FSSL
    };

    private Scoring scoring = Scoring.CMSL;
    public void onCMSL(ActionEvent actionEvent) {
        scoring = Scoring.CMSL;
    }
    public void onFSSL(ActionEvent actionEvent) {
        scoring = Scoring.FSSL;
    }
        }
