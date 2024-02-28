package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.jytek.leaguemanager.utilities.Util;
import org.jytek.leaguemanager.view.Result;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ResultController extends Application implements Initializable {

    // Table tvResult

    @FXML
    private TableView<Result> tvResult;
    @FXML
    private TableColumn<Result, String> tcResultMeet;
    @FXML
    private TableColumn<Result, String> tcResultIr;
    @FXML
    private TableColumn<Result, Integer> tcResultScore;
    @FXML
    private TableColumn<Result, String> tcResultEvent;
    @FXML
    private TableColumn<Result, String> tcResultStroke;
    @FXML
    private TableColumn<Result, String> tcResultDistance;
    @FXML
    private TableColumn<Result, Integer> tcResultPlace;
    @FXML
    private TableColumn<Result, Integer> tcResultPoints;
    @FXML
    private TableColumn<Result, String> tcResultCourse;


    @Override
    public void start(Stage stage) throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPropertyValueFactory(Arrays.asList(
                new Pair<>(tcResultMeet, "Meet"),
                new Pair<>(tcResultIr, "Ir"),
                new Pair<>(tcResultScore, "Score"),
                new Pair<>(tcResultEvent, "Event"),
                new Pair<>(tcResultCourse, "Course"),
                new Pair<>(tcResultDistance, "Distance"),
                new Pair<>(tcResultStroke, "Stroke"),
                new Pair<>(tcResultPlace, "Place"),
                new Pair<>(tcResultPoints, "Points")));
    }

    public void populateData(ObservableList<Result> results) {

        tvResult.setItems(results);
    }
}
