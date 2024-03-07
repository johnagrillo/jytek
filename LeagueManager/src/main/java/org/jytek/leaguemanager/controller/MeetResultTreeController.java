package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import org.jytek.leaguemanager.view.MeetResult;
import org.jytek.leaguemanager.view.TmMeet;
import org.jytek.leaguemanager.view.TmResult;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.TreeMap;

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

    public void populateData(TmMeet meet, TreeMap<Short, ArrayList<TmResult>> results) throws Exception {
        tvResult.setRoot(null);
        
        var m = new MeetResult();
        m.setEvent(meet.getMname());

        final TreeItem<MeetResult> root = new TreeItem<>(m);
        tvResult.setRoot(root);

        for (var e : results.keySet()) {
            var em = new MeetResult();
            em.setEvent("" + e);
            final TreeItem<MeetResult> event = new TreeItem<>(em);
            event.setExpanded(true);
            var list = results.get(e);
            Collections.sort(list);
            list.forEach(result ->
                    event.getChildren().add(new TreeItem<>(new MeetResult("",
                            "" + result.getPoints(),
                            "" + result.getPlace(),
                            "" + result.getAthlete(),
                            "" + result.getAge(),
                            "" + result.getTeam(),
                            "time",
                            "conv"))));


            root.getChildren().add(event);
        }
root.setExpanded(true);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tcEvent.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getEvent()));

        tcTeam.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getTeam()));

        tcAthlete.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getAthlete()));

        tcPoints.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getPoints()));

        tcPlace.setCellValueFactory((
                TreeTableColumn.CellDataFeatures<MeetResult, String> param) -> new ReadOnlyStringWrapper(
                param.getValue().getValue().getPlace()));


        //final TreeItem<MeetResult> root = new TreeItem<>(new MeetResult("Meet Name","","","","","",""));
        //event1.getChildren().add(new TreeItem<>(new MeetResult("Event 1","1","10","10","Joe","","")));
        //event1.getChildren().add(new TreeItem<>(new MeetResult("Event 1","2","10","10","Joe","","")));


        //final TreeItem<MeetResult> event2 = new TreeItem<>(new MeetResult("Events","","","","","",""));

        //root.getChildren().add(event1);
        //root.getChildren().add(event2);


        //tvResult.setRoot(root);
        tvResult.getColumns().setAll(tcEvent, tcPoints, tcPlace, tcTime, tcAthlete, tcAge, tcTeam, tcConv);


        //root.setExpanded(true);

    }


}
