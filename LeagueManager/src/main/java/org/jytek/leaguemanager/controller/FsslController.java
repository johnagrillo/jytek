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
import org.jytek.leaguemanager.FsslMain;
import org.jytek.leaguemanager.database.*;
import org.jytek.leaguemanager.utilities.MockMeet;
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


public class FsslController extends Application implements Initializable {

    private final FileChooser fileChooser = new FileChooser();
    private final Collection<DualMockResult> dualResults = new ArrayList<>();
    private final Collection<MockMeetResults> mockResults = new ArrayList<>();

    TmMdbDAO tm;
    private List<Tab> tabs = null;
    @FXML
    private List<TableView<?>> tables ;
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

    public static void main(final String[] args) {
        Application.launch();
    }

    @FXML
    protected void load(File mockFile) {
        disable();
        lbFile.setText(mockFile.getPath());
        tm = TmMdbDAO.load(mockFile);
        lbTeams.setText("" + tm.getTeams().count());
        lbAthletes.setText("" + tm.getAthletes().count());
        lbResults.setText("" + tm.getResults().count());
        lbRelays.setText("" + tm.getRelays().count());
        lbMeets.setText("" + tm.getMeets().count());
    }

    @FXML
    protected void onLoad() {
        disable();
        reset();

        mockFile = fileChooser.showOpenDialog(this.stage);
        if (mockFile != null) {

            lbFile.setText(mockFile.getPath());
            tm = TmMdbDAO.load(mockFile);

            lbTeams.setText("" + tm.getTeams().count());
            lbAthletes.setText("" + tm.getAthletes().count());
            lbResults.setText("" + tm.getResults().count());
            lbRelays.setText("" + tm.getRelays().count());
            lbMeets.setText("" + tm.getMeets().count());

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
        enable();
    }


    @FXML
    protected void onRunMock() {
        ////
        ///   beast time mock for all teams
        ///
        tm.getTeams().forEach(e1 -> {
            final var team1 = e1.getKey();
            final var team1Entries = tm.getBestTeamEntries(team1);
            tm.getTeams().filter(e2 -> !Objects.equals(team1, e2.getKey())).forEach(e2 -> {
                final var team2 = e2.getKey();
                var in = new HashSet<Integer>();
                in.add(team1);
                in.add(team2);
                var team2Entries = tm.getBestTeamEntries(team2);
                // add team and team 2
                var teamEntries = new TreeMap<Short, ArrayList<TmResult>>();
                Arrays.asList(team1Entries, team2Entries).forEach(entries -> {
                    entries.entrySet().forEach(entry -> {
                        var ev = entry.getKey();
                        entry.getValue().forEach(r -> {
                            teamEntries.computeIfAbsent(ev, k -> new ArrayList<>()).add(r);
                            try {
                                if (!in.contains(r.getTeam())) {
                                    System.out.println("Wrong Team in " + " " + tm.getTeams().get(r.getTeam()).getTcode() + " " + r);
                                }
                            } catch (KeyNotFoundException e) {
                                System.out.println("No Team " + e);

                            }
                        });
                    });
                    // only run if we have two teams

                    var r = MockMeet.runMockMeet(teamEntries, scoring);
                    mockResults.add(r);
                    var teamScores = r.getTeamScores();
                    if (teamScores.size() > 1) {
                        var t1 = teamScores.get(team1);
                        var t2 = teamScores.get(team2);
                        var diff = new Integer((int) ((t1 - t2) / 10.0));
                        try {
                            dualResults.add(new DualMockResult(
                                    tm.getTeams().get(team1).getTcode(),
                                    t1.toString(),
                                    tm.getTeams().get(team2).getTcode(),
                                    t2.toString(),
                                    diff.toString(),
                                    r));
                        } catch (KeyNotFoundException e) {
                            System.out.println(e);
                        }

                    }
                });
            });
        });


        ObservableList<DualMockResult> results = FXCollections.observableArrayList();
        results.addAll(dualResults);
        tvMockResults.setItems(results);
        lbMockMeets.setText("" + results.size());
        // count wins mby team

        final Map<String, Integer> wins = new TreeMap<>();
        final Map<String, Integer> losses = new TreeMap<>();
        final Map<String, Integer> ties = new TreeMap<>();


        results.forEach(r-> {
            wins.computeIfAbsent(r.getTeam1(), s -> 0);
            wins.computeIfAbsent(r.getTeam2(), s -> 0);
            losses.computeIfAbsent(r.getTeam1(), s -> 0);
            losses.computeIfAbsent(r.getTeam2(), s -> 0);
            ties.computeIfAbsent(r.getTeam1(), s -> 0);
            ties.computeIfAbsent(r.getTeam2(), s -> 0);

            if (Integer.valueOf(r.getTeam1Score()) > Integer.valueOf(r.getTeam2Score())) {
                wins.put(r.getTeam1(), wins.get(r.getTeam1()) + 1);
            }
            if (Integer.valueOf(r.getTeam1Score()) == Integer.valueOf(r.getTeam2Score())) {
                ties.put(r.getTeam1(), ties.get(r.getTeam1()) + 1);
            }
            if (Integer.valueOf(r.getTeam1Score())< Integer.valueOf(r.getTeam2Score())) {
                losses.put(r.getTeam1(), losses.get(r.getTeam1()) + 1);
            }
        });

        // sort by wins

        Map<Integer, ArrayList<String>> byScore = new TreeMap<>();
        wins.entrySet().forEach( team -> {
            var list = byScore.computeIfAbsent(team.getValue(), k -> new ArrayList<>());
            list.add(team.getKey());
        });

        ObservableList<MockWins> places = FXCollections.observableArrayList();

        byScore.keySet().forEach(w -> {
            byScore.get(w).forEach(team ->
                    places.add(new MockWins(team, w, losses.get(team), ties.get(team))
                    ));
        });

        // reverse sort places
        Collections.reverse(places);
        tvMockWins.setItems(places);
    }


    private void openFile(File file) {

        //Mock mock = new Mock(file);
        //mock.run();

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
        tm.getMeets().forEach(m -> {
            var week = m.getValue().getStart().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            first.set(Math.min(first.get(), week));
        });

        // get mmets by week
        var weekMeets = new TreeMap<Integer, HashSet<TmMeet>>();
        var meetResults = new TreeMap<Integer, HashSet<TmResult>>();

        tm.getMeets().forEach(e -> {
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
        rootNode.setExpanded(true);

        for (var week : weekMeets.keySet()) {
            var weekNode = new TreeItem<String>("Week " + week);
            rootNode.getChildren().add(weekNode);
            for (var m : weekMeets.get(week)) {
                var node = new TreeItem<String>(m.getMeet() + " " + m.getStart() + " " + m.getMname());
                weekNode.getChildren().add(node);
                weekNode.setExpanded(true);
            }
        }
    }

    public void onClickAthletes(MouseEvent mouseEvent) {

        var ta = tvTmAthletes.getSelectionModel().getSelectedItem();

        ObservableList<Result> results = FXCollections.observableArrayList();

        if (ta != null) {
            // find all results ny this athlete
            var athR = tm.getAthleteResults(ta.getAthlete());
            athR.forEach(r -> {
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
                } catch (KeyNotFoundException e) {
                    throw new RuntimeException(e);
                }
                results.add(res);
            });
        }
        FXMLLoader loader = new FXMLLoader(FsslMain.class.getResource("result.fxml"));
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

        tm.getResults().values().forEach( r -> {
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
                } catch (KeyNotFoundException e) {
                    System.out.println(r);
                    // skip this entry
                }
            }
        });

        FXMLLoader loader = new FXMLLoader(FsslMain.class.getResource("meet-result-tree.fxml"));
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

    public void populateData(File mdbFile) {

        lbFile.setText(mdbFile.getPath());
        tm = TmMdbDAO.load(mdbFile);


        lbTeams.setText("" + tm.getTeams().count());
        lbAthletes.setText("" + tm.getAthletes().count());
        lbResults.setText("" + tm.getResults().count());
        lbRelays.setText("" + tm.getRelays().count());
        lbMeets.setText("" + tm.getMeets().count());

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
    public void start(final Stage stage) throws IOException {
        this.stage = stage;
        final FXMLLoader loader = new FXMLLoader(FsslMain.class.getResource("fssl.fxml"));
        final Scene scene = new Scene(loader.load(), 1000, 1000);
        final var controller = loader.<FsslController>getController();
        controller.populateData(new File("c:/Users/john/sandbox/mdb/fssl/2023.mdb"));
        stage.setTitle("League Manager");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

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

}
