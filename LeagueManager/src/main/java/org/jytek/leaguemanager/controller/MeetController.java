package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jytek.leaguemanager.database.KeyNotFoundException;
import org.jytek.leaguemanager.database.MmMdbDAO;
import org.jytek.leaguemanager.view.MeetResult;
import org.jytek.leaguemanager.view.MmEvent;
import org.jytek.leaguemanager.view.MmMeet;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MeetController extends Application implements Initializable {
    @FXML
    public Label lbFile = null;

    @FXML
    public TreeTableView<MeetResult> tvResult = null;
    // ---------------------------
    // Table tvMeetResult
    @FXML
    private Button btLoad;


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

    private final FileChooser fileChooser = new FileChooser();

    private Stage stage = null;
    private File mockFile = null;

    MmMdbDAO mm;

    @FXML

    protected void onLoad() {

        mockFile = fileChooser.showOpenDialog(this.stage);

        if (mockFile != null) {


            lbFile.setText(mockFile.getPath());

            mm = MmMdbDAO.load(mockFile);
            // there is onlu one meet

            var meets = mm.getMeets().values();

            var meet = meets.stream().toList().get(0);

            System.out.println(meet.getMeetName1());


            var results = new TreeMap<MmEvent, ArrayList<MeetResult>>();

            mm.getEntrys().forEach(entry -> {
                System.out.println(entry);
                try {
                    final var athlete = mm.getAthletes().get(entry.getAthNo());
                    final var event = mm.getEvents().get(entry.getEventPtr());
                    var list = results.computeIfAbsent(event, k -> new ArrayList<>());
                    ;

                    list.add(new MeetResult("", "" + entry.getEvScore(),
                            "" + entry.getFinPlace(),
                            Util.atheteToString(athlete),

                            "" + event.getHighAge(),
                            mm.getTeams().get(athlete.getTeamNo()).getTeamAbbr(),
                            entry.getFinTime() != null ?  entry.getFinTime().toString() : "",
                            "course"));
                } catch (KeyNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                populateData(meet, results);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        ////disable();
        //reset();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    public void populateData(final MmMeet meet, final TreeMap<? extends MmEvent, ? extends ArrayList<MeetResult>> results) throws Exception {
        tvResult.setRoot(null);

        var m = new MeetResult();
        m.setEvent(meet.getMeetName1());

        final TreeItem<MeetResult> root = new TreeItem<>(m);
        tvResult.setRoot(root);
        root.setExpanded(true);
        results.keySet().forEach(e -> {
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
        });
        root.setExpanded(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final var filt = new FileChooser.ExtensionFilter("MDB", "*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);

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


        //tvResult.getColumns().setAll(tcEvent, tcPoints, tcPlace, tcTime, tcAthlete, tcAge, tcTeam, tcConv);

    }
}
