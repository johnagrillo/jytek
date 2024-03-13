package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.jytek.leaguemanager.view.MeetResult;

import java.net.URL;
import java.util.ResourceBundle;
        
public class MeetResultController extends Application implements Initializable {
    // ---------------------------
    // Table tvMeetResult

    @FXML
    private TableView<MeetResult> tvMeetResult;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultEvent;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultPoints;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultPlace;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultAthlete;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultAge;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultTeam;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultTime;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultConv;



    @Override
    public void start(Stage stage) throws Exception {
    }
    public void populateData(ObservableList<MeetResult> meetResults) {
        tvMeetResult.setItems(meetResults);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPVF(tcMeetResultEvent,"Event");
        Util.setPVF(tcMeetResultPoints,"Points");
        Util.setPVF(tcMeetResultPlace,"Place");
        Util.setPVF(tcMeetResultAthlete,"Athlete");
        Util.setPVF(tcMeetResultAge,"Age");
        Util.setPVF(tcMeetResultTeam,"Team");
        Util.setPVF(tcMeetResultTime,"Time");
        Util.setPVF(tcMeetResultConv,"Conv");
   }
}
