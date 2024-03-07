package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import org.jytek.leaguemanager.utilities.Util;
import org.jytek.leaguemanager.view.MeetResult;
import org.jytek.leaguemanager.view.TmMeet;
import org.jytek.leaguemanager.view.TmMtevent;

import java.net.URL;
import java.util.*;

public class MeetResultTreeController extends Application implements Initializable {

    @FXML
    public TreeTableView<MeetResult> tvResult;

    @FXML
    private TreeTableColumn<MeetResult, String> tcEvent;

    @FXML
    private TreeTableColumn<MeetResult, String> tcPoints;

    @FXML
    private TreeTableColumn<MeetResult, String> tcPlace;

    @FXML
    private TreeTableColumn<MeetResult, String> tcTime;

    @FXML
    private TreeTableColumn<MeetResult, String> tcAthlete;

    @FXML
    private TreeTableColumn<MeetResult, String> tcAge;

    @FXML
    private TreeTableColumn<MeetResult, String> tcTeam;

    @FXML
    private TreeTableColumn<MeetResult, String> tcConv;


    @Override
    public void start(Stage stage) throws Exception {

    }

    public void populateData(TmMeet meet, TreeMap<TmMtevent, ArrayList<MeetResult>> results) throws Exception {
        tvResult.setRoot(null);

        var m = new MeetResult();
        m.setEvent(meet.getMname());

        final TreeItem<MeetResult> root = new TreeItem<>(m);
        tvResult.setRoot(root);
        root.setExpanded(true);
        for (var e : results.keySet()) {
            var em = new MeetResult();
            em.setEvent(Util.eventToString(e));
            final TreeItem<MeetResult> event = new TreeItem<>(em);

            var list = results.get(e);
            Collections.sort(list);
            list.forEach(result -> {
                if (!Objects.equals(result.getPlace(), "0")) {
                    event.getChildren().add(new TreeItem<>(result));
                }
            });
            list.forEach(result -> {
                if (Objects.equals(result.getPlace(), "0")) {
                    event.getChildren().add(new TreeItem<>(result));
                }
            });


            root.getChildren().add(event);
        }
        root.setExpanded(true);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tcEvent.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getEvent()));

        tcPoints.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getPoints()));

        tcPoints.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getPoints()));


        tcTime.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getTime()));

        tcAthlete.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getAthlete()));

        tcPlace.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getPlace()));

        tcAge.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getAge()));

        tcTeam.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getTeam()));



        tvResult.getColumns().setAll(tcEvent, tcPoints, tcPlace, tcTime, tcAthlete, tcAge, tcTeam, tcConv);

    }


}
