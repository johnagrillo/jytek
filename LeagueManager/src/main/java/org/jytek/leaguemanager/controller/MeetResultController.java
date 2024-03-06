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
import org.jytek.leaguemanager.view.MeetResult;
        
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
        
public class MeetResultController extends Application implements Initializable {
    // ---------------------------
    // Table tvMeetResult

    @FXML
    private TableView<MeetResult> tvMeetResult;
    @FXML
    private TableColumn<MeetResult, Integer> tcMeetResultScore;
    @FXML
    private TableColumn<MeetResult, Integer> tcMeetResultPlace;
    @FXML
    private TableColumn<MeetResult, Integer> tcMeetResultPoints;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultAthlete;
    @FXML
    private TableColumn<MeetResult, String> tcMeetResultTeam;
    @FXML
    private TableColumn<MeetResult, Integer> tcMeetResultConverted;



    @Override
    public void start(Stage stage) throws Exception {
    }
    public void populateData(ObservableList<MeetResult> meetResults) {
        tvMeetResult.setItems(meetResults);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPVF(tcMeetResultScore,"Score");
        Util.setPVF(tcMeetResultPlace,"Place");
        Util.setPVF(tcMeetResultPoints,"Points");
        Util.setPVF(tcMeetResultAthlete,"Athlete");
        Util.setPVF(tcMeetResultTeam,"Team");
        Util.setPVF(tcMeetResultConverted,"Converted");
   }
}
