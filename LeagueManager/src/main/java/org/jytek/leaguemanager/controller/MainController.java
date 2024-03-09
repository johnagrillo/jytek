package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.jytek.leaguemanager.MainApplication;
import org.jytek.leaguemanager.database.*;
import org.jytek.leaguemanager.utilities.MockMeet;
import org.jytek.leaguemanager.utilities.Util;
import org.jytek.leaguemanager.view.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class MainController extends Application implements Initializable {

    private final FileChooser fileChooser = new FileChooser();
    private final ArrayList<DualMockResult> dualResults = new ArrayList<>();
    private final ArrayList<MockMeetResults> mockResults = new ArrayList<>();
    TmMdbDAO tm;
    private List<Tab> tabs;
    private List<TableView<?>> tables;
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
    // Mock Meet Best Time
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
    // Mock Meet Summary
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
    private TableColumn<TmAthlete, LocalDateTime> tcBirth;
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
    private TableColumn<TmMeet, LocalDateTime> tcStart;
    @FXML
    private TableColumn<TmMeet, LocalDateTime> tcEnd;
    @FXML
    private TableColumn<TmMeet, LocalDateTime> tcAgeUp;
    @FXML
    private TableColumn<TmMeet, LocalDateTime> tcSince;
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
    private MockMeet.Scoring scoring = MockMeet.Scoring.CMSL;

    public static void main(String[] args) {
        launch();
    }

    @FXML
    protected void load(File mockFile) {
        disable();
        tm = new TmMdbDAO(mockFile);

        lbFile.setText(mockFile.getPath());
        tm = new TmMdbDAO(mockFile);
        lbTeams.setText("" + tm.getTeams().stream().count());
        lbAthletes.setText("" + tm.getAthletes().stream().count());
        lbResults.setText("" + tm.getResults().stream().count());
        lbRelays.setText("" + tm.getRelays().stream().count());
        lbMeets.setText("" + tm.getMeets().stream().count());
    }

    @FXML
    protected void onLoad() {
        disable();
        reset();

        mockFile = fileChooser.showOpenDialog(this.stage);
        if (mockFile != null) {

            lbFile.setText(mockFile.getPath());
            tm = new TmMdbDAO(mockFile);

            lbTeams.setText("" + tm.getTeams().stream().count());
            lbAthletes.setText("" + tm.getAthletes().stream().count());
            lbResults.setText("" + tm.getResults().stream().count());
            lbRelays.setText("" + tm.getRelays().stream().count());
            lbMeets.setText("" + tm.getMeets().stream().count());


            ObservableList<TmTeam> teams = FXCollections.observableArrayList();


            teams.addAll(tm.getTeams().stream().map(Map.Entry::getValue).toList());
            tvTmTeams.setItems(teams);

            ObservableList<TmAthlete> athletes = FXCollections.observableArrayList();
            athletes.addAll(tm.getAthletes().values());

            tvTmAthletes.setItems(athletes);

            ObservableList<TmMeet> meets = FXCollections.observableArrayList();
            meets.addAll(tm.getMeets().values());

            tvTmMeets.setItems(meets);
        }
        enable();
    }


    @FXML
    protected void onRunMock() {

        ////
        ///   beast time mock for all teams
        ///


        tm.getTeams().stream().forEach(e1 -> {
            var team1 = e1.getKey();
            var team1Entries = tm.getBestTeamEntries(team1);
            tm.getTeams().stream().forEach( e2 -> {
                var team2 = e1.getKey();
                if (!Objects.equals(team1, team2)) {
                    var in = new HashSet<Integer>();
                    in.add(team1);
                    in.add(team2);
                    var team2Entries = tm.getBestTeamEntries(team2);
                    // add team and team 2
                    var teamEntries = new TreeMap<Short, ArrayList<TmResult>>();

                    for (var entries : Arrays.asList(team1Entries, team2Entries)) {
                        for (var ev : entries.keySet()) {
                            for (var r : entries.get(ev)) {
                                teamEntries.computeIfAbsent(ev, k -> new ArrayList<>()).add(r);
                                try {
                                    if (!in.contains(r.getTeam())) {
                                        System.out.println("Wrong Team in " + " " + tm.getTeams().get(r.getTeam()).getTcode() + " " + r);
                                    }
                                } catch (TeamException e) {
                                    System.out.println("No Team " + e);

                                }
                            }
                        }
                    }

                    // only run if we have two teams

                    var r = MockMeet.runMockMeet(teamEntries, scoring);
                    mockResults.add(r);
                    var teamScores = r.getTeamScores();
                    System.out.println("scored " + teamScores);
                    if (teamScores.size() > 1) {
                        var t1 = teamScores.get(team1);
                        var t2 = teamScores.get(team2);
                        var diff = (int) ((t1 - t2) / 10.0);
                        try {
                            dualResults.add(new DualMockResult(
                                    tm.getTeams().get(team1).getTcode(),
                                    t1,
                                    tm.getTeams().get(team2).getTcode(),
                                    t2,
                                    diff,
                                    r));
                        } catch (TeamException e) {
                            System.out.println(e);
                        }
                    }

                }
            });
        });


        ObservableList<DualMockResult> results = FXCollections.observableArrayList();
        results.addAll(dualResults);
        tvMockResults.setItems(results);
        lbMockMeets.setText("" + results.size());
        // count wins mby team

        Map<String, Integer> wins = new TreeMap<>();
        Map<String, Integer> losses = new TreeMap<>();
        Map<String, Integer> ties = new TreeMap<>();


        for (var r : results) {
            wins.computeIfAbsent(r.getTeam1(), k -> 0);
            wins.computeIfAbsent(r.getTeam2(), k -> 0);
            losses.computeIfAbsent(r.getTeam1(), k -> 0);
            losses.computeIfAbsent(r.getTeam2(), k -> 0);
            ties.computeIfAbsent(r.getTeam1(), k -> 0);
            ties.computeIfAbsent(r.getTeam2(), k -> 0);

            if (r.getTeam1Score() > r.getTeam2Score()) {
                wins.put(r.getTeam1(), wins.get(r.getTeam1()) + 1);
            }
            if (r.getTeam1Score().intValue() == r.getTeam2Score().intValue()) {
                ties.put(r.getTeam1(), ties.get(r.getTeam1()) + 1);
            }
            if (r.getTeam1Score() < r.getTeam2Score()) {
                losses.put(r.getTeam1(), losses.get(r.getTeam1()) + 1);
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

    public void populateData(File mdbFile) {

        lbFile.setText(mdbFile.getPath());
        tm = new TmMdbDAO(mdbFile);

        lbTeams.setText("" + tm.getTeams().stream().count());
        lbAthletes.setText("" + tm.getAthletes().stream().count());
        lbResults.setText("" + tm.getResults().stream().count());
        lbRelays.setText("" + tm.getRelays().stream().count());
        lbMeets.setText("" + tm.getMeets().stream().count());

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

        onRunMock();

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 1000);
        var controller = loader.<MainController>getController();
        controller.populateData(new File("c:/Users/john/sandbox/mdb/fssl/2023.mdb"));
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

        Util.setPropertyValueFactory(
                Arrays.asList(
                        new Pair<>(tcDiff, "Diff"),
                        new Pair<>(tcScore1, "Team1Score"),
                        new Pair<>(tcScore2, "Team2Score"),
                        new Pair<>(tcTeam1, "Team1"),
                        new Pair<>(tcTeam2, "Team2"),
                        new Pair<>(tcTeam, "Team"),
                        new Pair<>(tcWins, "Wins"),
                        new Pair<>(tcLosses, "Losses"),
                        new Pair<>(tcTies, "Ties")
                ));

        Util.setPropertyValueFactory(Arrays.asList(
                new Pair<>(tcTeamTeam, "Team"),
                new Pair<>(tcTCode, "Tcode"),
                new Pair<>(tcTName, "Tname")
                //new Pair<>(tcShort,"shortN")
        ));

        Util.setPropertyValueFactory(Arrays.asList(
                new Pair<>(tcAthlete, "Athlete"),
                new Pair<>(tcAthTeam1, "Team1"),
                new Pair<>(tcLast, "Last"),
                new Pair<>(tcFirst, "First"),
                new Pair<>(tcInitial, "Initial"),
                new Pair<>(tcSex, "Sex"),
                new Pair<>(tcBirth, "Birth"),
                new Pair<>(tcAge, "Age")));
        //new Pair<>(tcID_NO,"ID_NO")

        Util.setPropertyValueFactory(Arrays.asList(
                new Pair<>(tcMeet, "Meet"),
                new Pair<>(tcMName, "Mname"),
                new Pair<>(tcStart, "Start"),
                new Pair<>(tcCourse, "Course"),
                new Pair<>(tcLocation, "Location"),
                new Pair<>(tcMaxIndEnt, "Maxindent"),
                new Pair<>(tcMaxRelEnt, "Maxrelent"),
                new Pair<>(tcMaxEnt, "Maxent")));

        tabs = Arrays.asList(
                tbTeams,
                tbAthletes, tbMeets,
                tbMockMeets,
                tbWeeklyMockMeets);

        tables = Arrays.asList(
                tvMockResults,
                tvMockWins,
                tvMockResults,
                tvTmMeets,
                tvTmTeams
        );

        disable();

    }

    private void disable() {
        for (final var t : tabs) {
            t.setDisable(true);
        }
    }

    private void enable() {
        for (final var t : tabs) {
            t.setDisable(false);
        }
    }

    private void reset() {
        for (final var t : tables) {
            t.getItems().clear();
        }
        mockResults.clear();
        dualResults.clear();
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

        AtomicInteger first = new AtomicInteger(50);
        tm.getMeets().stream().forEach( m -> {
            var week = m.getValue().getStart().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            first.set(Math.min(first.get(), week));
        });

        // get mmets by week
        var weekMeets = new TreeMap<Integer, HashSet<TmMeet>>();
        var meetResults = new TreeMap<Integer, HashSet<TmResult>>();

        tm.getMeets().stream().forEach( e -> {
            var week = e.getValue().getStart().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            var meet = e.getValue();
            ZonedDateTime zdt = meet.getStart().atZone(ZoneId.systemDefault());
            Date output = Date.from(zdt.toInstant());
            LocalDate date = meet.getStart().toLocalDate();
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            week = date.get(weekFields.weekOfWeekBasedYear()) - first.get() + 1;

            // check for corrected cweek

            if (corrections.containsKey(meet.getStart().getYear())) {
                if (corrections.get(meet.getStart().getYear()).containsKey(meet.getMname())) {
                    week = corrections.get(meet.getStart().getYear()).get(meet.getMname());
                }
            }


            var meets = weekMeets.computeIfAbsent(week, k -> new HashSet<>());
            meets.add(meet);
        });

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
            rootNode.getChildren().add(weekNode);
            for (var m : weekMeets.get(week)) {
                var node = new TreeItem<String>(m.getMeet() + " " + m.getStart() + " " + m.getMname());
                weekNode.getChildren().add(node);
            }
        }
    }

    public void onClickAthletes(MouseEvent mouseEvent) {

        var ta = tvTmAthletes.getSelectionModel().getSelectedItem();

        ObservableList<Result> results = FXCollections.observableArrayList();

        if (ta != null) {
            // find all results ny this athlete
            var athR = tm.getAthleteResults(ta.getAthlete());
            for (var r : athR) {
                Result res = new Result();
                try {
                    res.setMeet(tm.getMeets().get(r.getMeet()).getMname());
                    res.setEvent(tm.getMtevents().get(r.getMtevent()).getMtev().toString());
                    res.setPlace(r.getPoints());
                    res.setScore(r.getScore());
                    res.setDistance(r.getDistance());
                    res.setStroke(Util.strokeToString(r.getStroke()));
                    res.setCourse(r.getCourse());
                    res.setIr(r.getIr());
                } catch (MteventException | MeetException e) {
                    throw new RuntimeException(e);
                }
                results.add(res);
            }
        }
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("result.fxml"));
        try {
            Scene scene = new Scene(loader.load(), 625, 275);
            var controller = loader.<ResultController>getController();
            controller.populateData(results);
            Stage stage = new Stage();
            stage.setTitle("Athlete " + ta.getAthlete().toString());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onCMSL(ActionEvent actionEvent) {
        scoring = MockMeet.Scoring.CMSL;
    }

    public void onFSSL(ActionEvent actionEvent) {
        MockMeet.Scoring Scoring = null;
        scoring = MockMeet.Scoring.FSSL;
    }

    public void onBestTimeClick(MouseEvent mouseEvent) {
        var mock = tvMockResults.getSelectionModel().getSelectedItem();
        var mockResults = mock.getResults().getMeetResults();

    }

    public void onClickMeets(MouseEvent mouseEvent) {
        var meet = tvTmMeets.getSelectionModel().getSelectedItem();

        var results = new TreeMap<TmMtevent, ArrayList<MeetResult>>();

        for (var r : tm.getResults().values()) {
            if (Objects.equals(r.getMeet(), meet.getMeet())) {

                try {
                    var mtevent = tm.getMtevents().get(r.getMtevent());
                    var list = results.computeIfAbsent(mtevent, k -> new ArrayList<>());


                    list.add(new MeetResult("", "" + r.getPoints(),
                            "" + r.getPlace(),
                            Util.atheteToString(tm.getAthletes().get(r.getAthlete())),
                            "" + r.getAge(),
                            tm.getTeams().get(r.getTeam()).getTcode(),
                            r.getScore().toString(), r.getCourse()));
                } catch (TeamException | AthleteException | MteventException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("meet-result-tree.fxml"));
        try {
            Scene scene = new Scene(loader.load(), 1000, 800);
            var controller = loader.<MeetResultTreeController>getController();
            controller.populateData(meet, results);
            Stage stage = new Stage();
            stage.setTitle("Meet " + meet.getMname());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
