package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class FsslMain extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(FsslMain.class.getResource("fssl.fxml"));
        final Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        primaryStage.setTitle("League Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch();
    }
}
