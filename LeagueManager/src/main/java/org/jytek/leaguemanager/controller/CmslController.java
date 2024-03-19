package org.jytek.leaguemanager.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jytek.leaguemanager.CmslMain;
import org.jytek.leaguemanager.database.TmMdbDAO;
import org.jytek.leaguemanager.utilities.MockMeet;
import org.jytek.leaguemanager.utilities.MockMeets;
import org.jytek.leaguemanager.view.DualMockResult;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class CmslController implements Initializable {


    private final FileChooser fileChooser = new FileChooser();
    //
    // Week 5
    //
    private final List<MockTable> mockTables = new ArrayList<>();

    private Stage stage;
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
    //
    // Week 1
    //
    @FXML
    private TreeTableView<DualMockResult> tvMockWk1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk1Team1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk1Score1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk1Team2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk1Score2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk1Diff;
    //
    // Week 2
    //
    @FXML
    private TreeTableView<DualMockResult> tvMockWk2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk2Team1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk2Score1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk2Team2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk2Score2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk2Diff;
    //
    // Week 3
    //
    @FXML
    private TreeTableView<DualMockResult> tvMockWk3;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk3Team1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk3Score1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk3Team2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk3Score2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk3Diff;
    //
    // Week 4
    //
    @FXML
    private TreeTableView<DualMockResult> tvMockWk4;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk4Team1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk4Score1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk4Team2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk4Score2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk4Diff;
    
    //
    // Week 5
    //
    @FXML
    public TreeTableView<DualMockResult> tvMockWk5;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk5Team1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk5Score1;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk5Team2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk5Score2;
    @FXML
    private TreeTableColumn<DualMockResult, String> tcMockWk5Diff;

    @FXML
    public void onLoadMdb(final ActionEvent actionEvent) {
        final var mockFile = fileChooser.showOpenMultipleDialog(stage);

        var tms = new ArrayList<TmMdbDAO>();
        mockFile.forEach(f -> {
            tms.add(TmMdbDAO.load(f));
        });

        for (int idx = 0; idx < 5; idx++) {
            if (idx < tms.size()) {
                final var mockTable = mockTables.get(idx);
                final var dual = MockMeets.runDualMockMeets(tms.get(idx), MockMeet.Scoring.CMSL);
                mockTable.tfFile.setText(tms.get(idx).getFile().toString());
                final var root = mockTable.tvMock.getRoot();
                //  collect teams

                var teams = new HashMap<String, ArrayList<DualMockResult>>();


                dual.forEach(
                        r -> {
                            teams.computeIfAbsent(r.getTeam1(), k -> new ArrayList<>()).add(r);
                        }
                );

                teams.entrySet().forEach(t -> {
                    var d = new DualMockResult();
                    d.setTeam1(t.getKey());
                    final TreeItem<DualMockResult> tr = new TreeItem<>(d);
                    root.getChildren().add(tr);

                    t.getValue().forEach(dr -> {
                        var d2 = new DualMockResult(dr.getTeam1(),
                                dr.getTeam1Score(),
                                dr.getTeam2(),
                                dr.getTeam2Score(),
                                dr.getDiff(),
                                null);


                        final TreeItem<DualMockResult> tr2 = new TreeItem<>(d2);
                        tr.getChildren().add(tr2);
                    });


                });


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

    public void onWkLoad(final ActionEvent actionEvent) {
        final var src = actionEvent.getSource();


        var button = (Button) src;
        System.out.println(button);
    }

    public void onWkRun(final ActionEvent actionEvent) {

        System.out.println(actionEvent);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        var filt = new FileChooser.ExtensionFilter("MDB", "*.mdb");
        fileChooser.getExtensionFilters().add(filt);
        fileChooser.setSelectedExtensionFilter(filt);

        mockTables.add(new MockTable(tfWk1File, tvMockWk1, tcMockWk1Team1, tcMockWk1Score1, tcMockWk1Team2, tcMockWk1Score2, tcMockWk1Diff));
        mockTables.add(new MockTable(tfWk2File, tvMockWk2, tcMockWk2Team1, tcMockWk2Score1, tcMockWk2Team2, tcMockWk2Score2, tcMockWk2Diff));
        mockTables.add(new MockTable(tfWk3File, tvMockWk3, tcMockWk3Team1, tcMockWk3Score1, tcMockWk3Team2, tcMockWk3Score2, tcMockWk3Diff));
        mockTables.add(new MockTable(tfWk4File, tvMockWk4, tcMockWk4Team1, tcMockWk4Score1, tcMockWk4Team2, tcMockWk4Score2, tcMockWk4Diff));
        mockTables.add(new MockTable(tfWk5File, tvMockWk5, tcMockWk5Team1, tcMockWk5Score1, tcMockWk5Team2, tcMockWk5Score2, tcMockWk5Diff));


        mockTables.forEach(t -> {
            var d = new DualMockResult();
            d.setTeam1("Teams (Wins)");
            final TreeItem<DualMockResult> root = new TreeItem<>(d);
            t.getTvMock().setRoot(root);

            t.getTcMockTeam1().setCellValueFactory((
                    TreeTableColumn.CellDataFeatures<DualMockResult, String> param) -> new ReadOnlyStringWrapper(
                    param.getValue().getValue().getTeam1()));

            t.getTcMockScore1().setCellValueFactory((
                    TreeTableColumn.CellDataFeatures<DualMockResult, String> param) -> new ReadOnlyStringWrapper(
                    param.getValue().getValue().getTeam1Score()));

            t.getTcMockTeam2().setCellValueFactory((
                    TreeTableColumn.CellDataFeatures<DualMockResult, String> param) -> new ReadOnlyStringWrapper(
                    param.getValue().getValue().getTeam2()));

            t.getTcMockScore2().setCellValueFactory((
                    TreeTableColumn.CellDataFeatures<DualMockResult, String> param) -> new ReadOnlyStringWrapper(
                    param.getValue().getValue().getTeam2Score()));

            t.getTcMockDiff().setCellValueFactory((
                    TreeTableColumn.CellDataFeatures<DualMockResult, String> param) -> new ReadOnlyStringWrapper(
                    param.getValue().getValue().getDiff()));

        });


    }

    public MockTable createMockTable(
            final TextField tfFile,
            final TreeTableView<DualMockResult> tvMock,
            final TreeTableColumn<DualMockResult, String> tcMockTeam1,
            final TreeTableColumn<DualMockResult, String> tcMock5Score1,
            final TreeTableColumn<DualMockResult, String> tcMockTeam2,
            final TreeTableColumn<DualMockResult, String> tcMockScore2,
            final TreeTableColumn<DualMockResult, String> tcMockDiff) {
        return new MockTable(tfFile, tvMock, tcMockTeam1, tcMock5Score1, tcMockTeam2, tcMockScore2, tcMockDiff);
    }

    //
    // Week 5
    //
    class MockTable {


        private final TextField tfFile;
        private TreeTableView<DualMockResult> tvMock;
        private TreeTableColumn<DualMockResult, String> tcMockTeam1;
        private TreeTableColumn<DualMockResult, String> tcMockScore1;
        private TreeTableColumn<DualMockResult, String> tcMockTeam2;
        private TreeTableColumn<DualMockResult, String> tcMockScore2;
        private TreeTableColumn<DualMockResult, String> tcMockDiff;

        private MockTable(final TextField tfFile,
                          final TreeTableView<DualMockResult> tvMock,
                          final TreeTableColumn<DualMockResult, String> tcMockTeam1,
                          final TreeTableColumn<DualMockResult, String> tcMockScore1,
                          final TreeTableColumn<DualMockResult, String> tcMockTeam2,
                          final TreeTableColumn<DualMockResult, String> tcMockScore2,
                          final TreeTableColumn<DualMockResult, String> tcMockDiff) {
            this.tfFile = tfFile;
            this.tvMock = tvMock;
            this.tcMockTeam1 = tcMockTeam1;
            this.tcMockScore1 = tcMockScore1;
            this.tcMockTeam2 = tcMockTeam2;
            this.tcMockScore2 = tcMockScore2;
            this.tcMockDiff = tcMockDiff;
        }

        public TextField getTfFile() {
            return tfFile;
        }

        public TreeTableView<DualMockResult> getTvMock() {
            return tvMock;
        }

        public TreeTableColumn<DualMockResult, String> getTcMockTeam1() {
            return tcMockTeam1;
        }

        public TreeTableColumn<DualMockResult, String> getTcMockScore1() {
            return tcMockScore1;
        }

        public TreeTableColumn<DualMockResult, String> getTcMockTeam2() {
            return tcMockTeam2;
        }

        public TreeTableColumn<DualMockResult, String> getTcMockScore2() {
            return tcMockScore2;
        }

        public TreeTableColumn<DualMockResult, String> getTcMockDiff() {
            return tcMockDiff;
        }
    }


}
