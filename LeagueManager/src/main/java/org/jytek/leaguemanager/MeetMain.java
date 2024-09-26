package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class MeetMain extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(MeetMain.class.getResource("meet.fxml"));
        final Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        primaryStage.setTitle("Meet Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch();
    }
}
