package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("League Manager");
        stage.setScene(scene);
        stage.show();
        MainController mainController =  fxmlLoader.<MainController>getController();
        File file = new File("c:/Users/john/sandbox/mdb/cmsl/2018-Realignment-Wk1.mdb");
        mainController.load(file);




    }

    public static void main(String[] args) {
        launch();
    }


    }
