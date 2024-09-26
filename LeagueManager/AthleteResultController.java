package org.jytek.leaguemanager.controller;,
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.jytek.leaguemanager.utilities.Util;
import org.jytek.leaguemanager.view.AthleteResult;
        
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
        
public class AthleteResultController extends Application implements Initializable {
    // ---------------------------
    // Table tvAthleteResult

    @FXML
    private TableView<AthleteResult> tvAthleteResult;
    @FXML
    private TableColumn<TcathleteresultmeetDetail, String> athlete result;
    @FXML
    private TableColumn<TcathleteresultathleteDetail, String> athlete result;
    @FXML
    private TableColumn<TcathleteresultirDetail, String> athlete result;
    @FXML
    private TableColumn<TcathleteresultscoreDetail, Integer> athlete result;
    @FXML
    private TableColumn<TcathleteresulteventDetail, String> athlete result;
    @FXML
    private TableColumn<TcathleteresultstrokeDetail, String> athlete result;
    @FXML
    private TableColumn<TcathleteresultplaceDetail, Integer> athlete result;
    @FXML
    private TableColumn<TcathleteresultpointsDetail, Integer> athlete result;



    public void populateData(ObservableList<AthleteResult> athleteResults) {
        tvAthleteResult.setItems(athleteResults);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util.setPVF(tcAthleteResultMeet,"Meet");
        Util.setPVF(tcAthleteResultAthlete,"Athlete");
        Util.setPVF(tcAthleteResultIr,"Ir");
        Util.setPVF(tcAthleteResultScore,"Score");
        Util.setPVF(tcAthleteResultEvent,"Event");
        Util.setPVF(tcAthleteResultStroke,"Stroke");
        Util.setPVF(tcAthleteResultPlace,"Place");
        Util.setPVF(tcAthleteResultPoints,"Points");
   }
