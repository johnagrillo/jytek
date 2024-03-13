package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.jytek.leaguemanager.view.AthleteResult;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteResultController extends Application implements Initializable {
    // ---------------------------
    // Table tvAthleteResult

    @FXML
    private TableView<AthleteResult> tvAthleteResult;
    @FXML
    private TableColumn<AthleteResult, Integer> tcAthleteResultScore;
    @FXML
    private TableColumn<AthleteResult, Short> tcAthleteResultPlace;
    @FXML
    private TableColumn<AthleteResult, Short> tcAthleteResultPoints;
    @FXML
    private TableColumn<AthleteResult, Short> tcAthleteResultAge;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultStroke;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultDistance;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultEvent;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultMf;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultIr;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultMeet;
    @FXML
    private TableColumn<AthleteResult, java.util.Date> tcAthleteResultDate;
    @FXML
    private TableColumn<AthleteResult, String> tcAthleteResultTeam;

    private AthleteResultController() {
    }

    @Override
    public void start(Stage stage) throws Exception {
    }

    public void populateData(ObservableList<AthleteResult> athleteResults) {
        tvAthleteResult.setItems(athleteResults);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPVF(tcAthleteResultScore, "Score");
        Util.setPVF(tcAthleteResultPlace, "Place");
        Util.setPVF(tcAthleteResultPoints, "Points");
        Util.setPVF(tcAthleteResultAge, "Age");
        Util.setPVF(tcAthleteResultStroke, "Stroke");
        Util.setPVF(tcAthleteResultDistance, "Distance");
        Util.setPVF(tcAthleteResultEvent, "Event");
        Util.setPVF(tcAthleteResultMf, "Mf");
        Util.setPVF(tcAthleteResultIr, "Ir");
        Util.setPVF(tcAthleteResultMeet, "Meet");
        Util.setPVF(tcAthleteResultDate, "Date");
        Util.setPVF(tcAthleteResultTeam, "Team");
    }
}
