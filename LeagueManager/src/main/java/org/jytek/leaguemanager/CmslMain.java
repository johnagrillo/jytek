package org.jytek.leaguemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class CmslMain extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(FsslMain.class.getResource("cmsl.fxml"));
        final Scene scene = new Scene(fxmlLoader.load(), 1100, 850);
        primaryStage.setTitle("CMSL League Alignment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch();
    }
}
