package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


public class MainController extends Application  implements Initializable {
    @FXML
    private Button btLoad;
    @FXML
    private Label lbFile;
    @FXML
    private TableColumn<MockResult , Integer> tcDiff;

    @FXML
    private TableColumn<MockResult , Integer> tcScore1;

    @FXML
    private TableColumn<MockResult , Integer> tcScore2;

    @FXML
    private TableColumn<MockResult , String> tcTeam1;

    @FXML
    private TableColumn<MockResult , String> tcTeam2;

    @FXML
    private TableView<MockResult > tvMockResults;

    private final FileChooser fileChooser = new FileChooser();


    private Stage stage;
    @FXML
    protected void onLoad() {

        File file = fileChooser.showOpenDialog(this.stage);
        if (file != null) {
            Mock mock = new Mock(file);
            lbFile.setText(file.getPath());
            ObservableList<MockResult> results = mock.run();
            tvMockResults.setItems(results);

        }



    }

    public void populateData() {


        for (Pair<TableColumn, String> pair : Arrays.asList(
                new Pair(tcDiff, "Diff"),
                new Pair(tcScore1, "Team1Score"),
                new Pair(tcScore2, "Team2Score"),
                new Pair(tcTeam1, "Team1"),
                new Pair(tcTeam2, "Team2")
        )) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

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

        var filt = new FileChooser.ExtensionFilter("MDB","*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);

    }

        public static void main(String[] args) {
            launch();
        }



}