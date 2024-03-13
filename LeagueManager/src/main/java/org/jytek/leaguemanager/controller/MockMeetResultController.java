package org.jytek.leaguemanager.controller;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.jytek.leaguemanager.view.MockMeetResult;

import java.net.URL;
import java.util.ResourceBundle;
        
public class MockMeetResultController extends Application implements Initializable {
    // ---------------------------
    // Table tvMockMeetResult

    @FXML
    private TableView<MockMeetResult> tvMockMeetResult;
    @FXML
    private TableColumn<MockMeetResult, Integer> tcMockMeetResultScore;
    @FXML
    private TableColumn<MockMeetResult, Integer> tcMockMeetResultPlace;
    @FXML
    private TableColumn<MockMeetResult, Integer> tcMockMeetResultPoints;
    @FXML
    private TableColumn<MockMeetResult, String> tcMockMeetResultAthlete;
    @FXML
    private TableColumn<MockMeetResult, String> tcMockMeetResultTeam;
    @FXML
    private TableColumn<MockMeetResult, String> tcMockMeetResultMeet;
    @FXML
    private TableColumn<MockMeetResult, java.util.Date> tcMockMeetResultDate;
    @FXML
    private TableColumn<MockMeetResult, Integer> tcMockMeetResultConverted;


    @Override
    public void start(Stage stage) throws Exception {
    }

    public void populateData(ObservableList<MockMeetResult> mockMeetResults) {
        tvMockMeetResult.setItems(mockMeetResults);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPVF(tcMockMeetResultScore,"Score");
        Util.setPVF(tcMockMeetResultPlace,"Place");
        Util.setPVF(tcMockMeetResultPoints,"Points");
        Util.setPVF(tcMockMeetResultAthlete,"Athlete");
        Util.setPVF(tcMockMeetResultTeam,"Team");
        Util.setPVF(tcMockMeetResultMeet,"Meet");
        Util.setPVF(tcMockMeetResultDate,"Date");
        Util.setPVF(tcMockMeetResultConverted,"Converted");
   }
}
