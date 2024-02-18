package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("League Manager");
        final Button openButton = getOpenButton(stage);


        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(openButton, inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));



        stage.setScene(scene);




        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Button getOpenButton(Stage stage) {
        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Select TM Database");
        var filt = new FileChooser.ExtensionFilter("MDB","*.mdb");
        fileChooser.getExtensionFilters().add(filt);


        fileChooser.setSelectedExtensionFilter(filt);
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            openFile(file);
                        }
                    }
                });
        return openButton;
    }

    private void openFile(File file) {

        Mock mock = new Mock(file);
        mock.run();

    }
    }