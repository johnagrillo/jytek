package org.jytek.leaguemanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jytek.leaguemanager.CmslMain;
import org.jytek.leaguemanager.database.TmMdbDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CmslController implements Initializable {

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        var filt = new FileChooser.ExtensionFilter("MDB", "*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);
    }

    @FXML
    public void onLoadMdb(ActionEvent actionEvent) {
        final var mockFile = fileChooser.showOpenMultipleDialog(stage);

        var tms = new ArrayList<TmMdbDAO>();
        mockFile.forEach( f-> {
            System.out.println(f);
            tms.add( TmMdbDAO.load(f) );
        });

        for(int idx =0; idx <5;  idx++)
        {
             if (idx < tms.size()) {
                 System.out.println(tms.get(idx).getFile());

                 if (idx == 0) {
                    tfWk1File.setText(tms.get(idx).getFile().toString());
                 }
                 else if (idx == 1) {
                    tfWk2File.setText(tms.get(idx).getFile().toString());
                 }
                 else if (idx == 2) {
                    tfWk3File.setText(tms.get(idx).getFile().toString());
                 }
                 else if (idx == 3) {
                    tfWk4File.setText(tms.get(idx).getFile().toString());
                 }
                 else if (idx == 4) {
                    tfWk5File.setText(tms.get(idx).getFile().toString());
                 }
		 
             }
        }
    }

     //@Override
     public void start(final Stage stage) throws IOException {
        this.stage = stage;
        final FXMLLoader loader = new FXMLLoader(CmslMain.class.getResource("cmsl.fxml"));
        final Scene scene = new Scene(loader.load(), 1000, 1000);
        final var controller = loader.<CmslController>getController();
        stage.setTitle("CNSL League Manager");
        stage.setScene(scene);
        stage.show();
    }


    private final FileChooser fileChooser = new FileChooser();

    private Stage stage;

    public void onWk1Load(ActionEvent actionEvent) {
    }

    public void onWk1Run(ActionEvent actionEvent) {
    }


    
    public void onWk2Load(ActionEvent actionEvent) {
    }

    public void onWk2Run(ActionEvent actionEvent) {
    }

    
    public void onWk3Load(ActionEvent actionEvent) {
    }

    public void onWk3Run(ActionEvent actionEvent) {
    }

    
    public void onWk4Load(ActionEvent actionEvent) {
    }
    
    public void onWk4Run(ActionEvent actionEvent) {
    }


    
    public void onWk5Run(ActionEvent actionEvent) {
    }

    public void onWk5Load(ActionEvent actionEvent) {
    }


 @FXML
    private Button btLoad;

    @FXML
    private Button btnWk1Load;

    @FXML
    private Button btnWk1Run;

    @FXML
    private Button btnWk2Load;

    @FXML
    private Button btnWk2Run;

    @FXML
    private Button btnWk3Load;

    @FXML
    private Button btnWk3Run;

    @FXML
    private Button btnWk4Load;

    @FXML
    private Button btnWk4Run;

    @FXML
    private Button btnWk5Load;

    @FXML
    private Button btnWk5Run;

    @FXML
    private TextField tfWk1File;

    @FXML
    private TextField tfWk2File;

    @FXML
    private TextField tfWk3File;

    @FXML
    private TextField tfWk4File;

    @FXML
    private TextField tfWk5File;
    
}
