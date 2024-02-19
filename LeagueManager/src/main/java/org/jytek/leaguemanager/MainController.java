package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.jytek.leaguemanager.database.TmMdbDAO;
import org.jytek.leaguemanager.view.TmAthlete;
import org.jytek.leaguemanager.view.TmMeet;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.File;
import java.net.URL;
import java.util.*;


public class MainController extends Application implements Initializable {

    private final FileChooser fileChooser = new FileChooser();
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
    private Label lbMockMeets;
    @FXML
    private Button btRunMock;
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
    private TableColumn<MockResult, Integer> tcDiff;
    @FXML
    private TableColumn<MockResult, Integer> tcScore1;
    @FXML
    private TableColumn<MockResult, Integer> tcScore2;
    @FXML
    private TableColumn<MockResult, String> tcTeam1;
    @FXML
    private TableColumn<MockResult, String> tcTeam2;
    @FXML
    private TableView<MockResult> tvMockResults;
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
    private TableColumn<TmTeam,Integer> tcTeamTeam;
    @FXML
    private TableColumn<TmTeam,String> tcTCode;
    @FXML
    private TableColumn<TmTeam,String> tcTName;
    @FXML
    private TableColumn<TmTeam,String> tcShort;


    @FXML
    private TableView<TmAthlete> tvTmAthletes;
    @FXML
    private TableColumn<TmAthlete,Integer> tcAthlete;
    @FXML
    private TableColumn<TmAthlete,Integer> tcAthTeam1;
    @FXML
    private TableColumn<TmAthlete,String> tcLast;
    @FXML
    private TableColumn<TmAthlete,String> tcFirst;
    @FXML
    private TableColumn<TmAthlete,String> tcInitial;
    @FXML
    private TableColumn<TmAthlete,String> tcSex;
    @FXML
    private TableColumn<TmAthlete,java.time.LocalDateTime> tcBirth;
    @FXML
    private TableColumn<TmAthlete,Short> tcAge;
//    @FXML
    //private TableColumn<TmAthlete,String> tcID_NO;


    @FXML
    private TableView<TmMeet> tvTmMeets;
    @FXML
    private TableColumn<TmMeet,Integer> tcMeet;
    @FXML
    private TableColumn<TmMeet,String> tcMName;
    @FXML
    private TableColumn<TmMeet,java.time.LocalDateTime> tcStart;
    @FXML
    private TableColumn<TmMeet,java.time.LocalDateTime> tcEnd;
    @FXML
    private TableColumn<TmMeet,java.time.LocalDateTime> tcAgeUp;
    @FXML
    private TableColumn<TmMeet,java.time.LocalDateTime> tcSince;
    @FXML
    private TableColumn<TmMeet,String> tcCourse;
    @FXML
    private TableColumn<TmMeet,String> tcLocation;
    @FXML
    private TableColumn<TmMeet,Short> tcMaxIndEnt;
    @FXML
    private TableColumn<TmMeet,Short> tcMaxRelEnt;
    @FXML
    private TableColumn<TmMeet,Short> tcMaxEnt;


    private Stage stage;

    private File mockFile = null;

    public static void main(String[] args) {
        launch();
    }

    @FXML
    protected void onLoad() {

        mockFile = fileChooser.showOpenDialog(this.stage);
        if (mockFile != null) {

            lbFile.setText(mockFile.getPath());
            TmMdbDAO db = new TmMdbDAO(mockFile);
            lbTeams.setText("" + db.getTeams().size());
            lbAthletes.setText("" + db.getAthletes().size());
            lbResults.setText("" + db.getResults().size());
            lbRelays.setText("" + db.getRelays().size());
            lbMeets.setText("" + db.getMeets().size());

            tbTeams.setDisable(false);
            tbAthletes.setDisable(false);;
            tbMeets.setDisable(false);;
            tbMockMeets.setDisable(false);;

            ObservableList<TmTeam> teams = FXCollections.observableArrayList();
            teams.addAll(db.getTeams().values());
            tvTmTeams.setItems(teams);

            ObservableList<TmAthlete> athletes = FXCollections.observableArrayList();
            athletes.addAll(db.getAthletes().values());
            tvTmAthletes.setItems(athletes);

            ObservableList<TmMeet> meets = FXCollections.observableArrayList();
            meets.addAll(db.getMeets().values());
            tvTmMeets.setItems(meets);



        }
    }

    @FXML
    protected void onRunMock() {
        Mock mock = new Mock(mockFile);

        ObservableList<MockResult> results = mock.run();
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


        for (Pair<TableColumn, String> pair : Arrays.asList(
                new Pair(tcDiff, "Diff"),
                new Pair(tcScore1, "Team1Score"),
                new Pair(tcScore2, "Team2Score"),
                new Pair(tcTeam1, "Team1"),
                new Pair(tcTeam2, "Team2"),

                new Pair(tcTeam, "Team"),
                new Pair(tcWins, "Wins"),
                new Pair(tcLosses, "Losses"),
                new Pair(tcTies, "Ties")

        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

        for (Pair<TableColumn, String> pair : Arrays.asList(
                new Pair(tcTeam,"Team"),
                new Pair(tcTCode,"Tcode"),
                new Pair(tcTName,"Tname")
                //new Pair(tcShort,"shortN")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

        for (Pair<TableColumn, String> pair : Arrays.asList(
                new Pair(tcAthlete,"Athlete"),
                new Pair(tcTeam1,"Team1"),
                new Pair(tcLast,"Last"),
                new Pair(tcFirst,"First"),
                new Pair(tcInitial,"Initial"),
                new Pair(tcSex,"Sex"),
                new Pair(tcBirth,"Birth"),
                new Pair(tcAge,"Age")
                //new Pair(tcID_NO,"ID_NO")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }


        for (Pair<TableColumn, String> pair : Arrays.asList(
                new Pair(tcMeet,"Meet"),
                new Pair(tcMName,"Mname"),
                new Pair(tcStart,"Start"),
                new Pair(tcEnd,"End"),
                new Pair(tcAgeUp,"Ageup"),
                new Pair(tcSince,"Since"),
                new Pair(tcCourse,"Course"),
                new Pair(tcLocation,"Location"),
                new Pair(tcMaxIndEnt,"Maxindent"),
                new Pair(tcMaxRelEnt,"Maxrelent"),
                new Pair(tcMaxEnt,"Maxent")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }

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

        Mock mock = new Mock(file);
        mock.run();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var filt = new FileChooser.ExtensionFilter("MDB", "*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);

    }


}
