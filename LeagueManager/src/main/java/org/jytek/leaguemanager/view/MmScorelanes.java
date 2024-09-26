package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [ScoreLanes]
 * (
 * [lane_00]			Boolean NOT NULL,
 * [lane_01]			Boolean NOT NULL,
 * [lane_02]			Boolean NOT NULL,
 * [lane_03]			Boolean NOT NULL,
 * [lane_04]			Boolean NOT NULL,
 * [lane_05]			Boolean NOT NULL,
 * [lane_06]			Boolean NOT NULL,
 * [lane_07]			Boolean NOT NULL,
 * [lane_08]			Boolean NOT NULL,
 * [lane_09]			Boolean NOT NULL,
 * [lane_10]			Boolean NOT NULL,
 * [lane_11]			Boolean NOT NULL,
 * [lane_12]			Boolean NOT NULL
 * );
 */
public class MmScorelanes implements KeyValue<Integer, MmScorelanes> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Scorelanes";

    /**
     * Private Constructor
     **/
    private MmScorelanes() {
    }

    /**
     * Read MmScorelanes object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmScorelanes
     **/
    public static MmScorelanes read(final Row row){
        final var obj = new MmScorelanes();
        obj.lane_00 = (Boolean) row.get(MmScorelanes.LANE_00);
        obj.lane_01 = (Boolean) row.get(MmScorelanes.LANE_01);
        obj.lane_02 = (Boolean) row.get(MmScorelanes.LANE_02);
        obj.lane_03 = (Boolean) row.get(MmScorelanes.LANE_03);
        obj.lane_04 = (Boolean) row.get(MmScorelanes.LANE_04);
        obj.lane_05 = (Boolean) row.get(MmScorelanes.LANE_05);
        obj.lane_06 = (Boolean) row.get(MmScorelanes.LANE_06);
        obj.lane_07 = (Boolean) row.get(MmScorelanes.LANE_07);
        obj.lane_08 = (Boolean) row.get(MmScorelanes.LANE_08);
        obj.lane_09 = (Boolean) row.get(MmScorelanes.LANE_09);
        obj.lane_10 = (Boolean) row.get(MmScorelanes.LANE_10);
        obj.lane_11 = (Boolean) row.get(MmScorelanes.LANE_11);
        obj.lane_12 = (Boolean) row.get(MmScorelanes.LANE_12);
        return obj;
    }

    public MmScorelanes getValue(){
        return this;
    }

    public Integer getKey(){
        return lane_00.hashCode();
    }


    // 
    // Column names
    //
    public static final String LANE_00 = "lane_00";
    public static final String LANE_01 = "lane_01";
    public static final String LANE_02 = "lane_02";
    public static final String LANE_03 = "lane_03";
    public static final String LANE_04 = "lane_04";
    public static final String LANE_05 = "lane_05";
    public static final String LANE_06 = "lane_06";
    public static final String LANE_07 = "lane_07";
    public static final String LANE_08 = "lane_08";
    public static final String LANE_09 = "lane_09";
    public static final String LANE_10 = "lane_10";
    public static final String LANE_11 = "lane_11";
    public static final String LANE_12 = "lane_12";
    // 
    // members
    //
    private Boolean lane_00 = null;
    private Boolean lane_01 = null;
    private Boolean lane_02 = null;
    private Boolean lane_03 = null;
    private Boolean lane_04 = null;
    private Boolean lane_05 = null;
    private Boolean lane_06 = null;
    private Boolean lane_07 = null;
    private Boolean lane_08 = null;
    private Boolean lane_09 = null;
    private Boolean lane_10 = null;
    private Boolean lane_11 = null;
    private Boolean lane_12 = null;

    //
    // getters
    //

    /**
     * Getter for lane_00
     * @return Boolean
     */
    public Boolean getlane_00() {
        return lane_00;
    }

    /**
     * Getter for lane_01
     * @return Boolean
     */
    public Boolean getlane_01() {
        return lane_01;
    }

    /**
     * Getter for lane_02
     * @return Boolean
     */
    public Boolean getlane_02() {
        return lane_02;
    }

    /**
     * Getter for lane_03
     * @return Boolean
     */
    public Boolean getlane_03() {
        return lane_03;
    }

    /**
     * Getter for lane_04
     * @return Boolean
     */
    public Boolean getlane_04() {
        return lane_04;
    }

    /**
     * Getter for lane_05
     * @return Boolean
     */
    public Boolean getlane_05() {
        return lane_05;
    }

    /**
     * Getter for lane_06
     * @return Boolean
     */
    public Boolean getlane_06() {
        return lane_06;
    }

    /**
     * Getter for lane_07
     * @return Boolean
     */
    public Boolean getlane_07() {
        return lane_07;
    }

    /**
     * Getter for lane_08
     * @return Boolean
     */
    public Boolean getlane_08() {
        return lane_08;
    }

    /**
     * Getter for lane_09
     * @return Boolean
     */
    public Boolean getlane_09() {
        return lane_09;
    }

    /**
     * Getter for lane_10
     * @return Boolean
     */
    public Boolean getlane_10() {
        return lane_10;
    }

    /**
     * Getter for lane_11
     * @return Boolean
     */
    public Boolean getlane_11() {
        return lane_11;
    }

    /**
     * Getter for lane_12
     * @return Boolean
     */
    public Boolean getlane_12() {
        return lane_12;
    }
}
/* FXML 
<TableView fx:id=tvMmScorelanes" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmScorelaneslane_00" prefWidth="150.0" sortable="true" text="lane_00" />
    <TableColumn fx:id="tcMmScorelaneslane_01" prefWidth="150.0" sortable="true" text="lane_01" />
    <TableColumn fx:id="tcMmScorelaneslane_02" prefWidth="150.0" sortable="true" text="lane_02" />
    <TableColumn fx:id="tcMmScorelaneslane_03" prefWidth="150.0" sortable="true" text="lane_03" />
    <TableColumn fx:id="tcMmScorelaneslane_04" prefWidth="150.0" sortable="true" text="lane_04" />
    <TableColumn fx:id="tcMmScorelaneslane_05" prefWidth="150.0" sortable="true" text="lane_05" />
    <TableColumn fx:id="tcMmScorelaneslane_06" prefWidth="150.0" sortable="true" text="lane_06" />
    <TableColumn fx:id="tcMmScorelaneslane_07" prefWidth="150.0" sortable="true" text="lane_07" />
    <TableColumn fx:id="tcMmScorelaneslane_08" prefWidth="150.0" sortable="true" text="lane_08" />
    <TableColumn fx:id="tcMmScorelaneslane_09" prefWidth="150.0" sortable="true" text="lane_09" />
    <TableColumn fx:id="tcMmScorelaneslane_10" prefWidth="150.0" sortable="true" text="lane_10" />
    <TableColumn fx:id="tcMmScorelaneslane_11" prefWidth="150.0" sortable="true" text="lane_11" />
    <TableColumn fx:id="tcMmScorelaneslane_12" prefWidth="150.0" sortable="true" text="lane_12" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmScorelanes> tvMmScorelanes;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_00;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_01;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_02;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_03;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_04;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_05;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_06;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_07;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_08;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_09;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_10;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_11;
@FXML
private TableColumn<MmScorelanes,Boolean> tcMmScorelaneslane_12;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tclane_00,"lane_00"),
    new Pair(tclane_01,"lane_01"),
    new Pair(tclane_02,"lane_02"),
    new Pair(tclane_03,"lane_03"),
    new Pair(tclane_04,"lane_04"),
    new Pair(tclane_05,"lane_05"),
    new Pair(tclane_06,"lane_06"),
    new Pair(tclane_07,"lane_07"),
    new Pair(tclane_08,"lane_08"),
    new Pair(tclane_09,"lane_09"),
    new Pair(tclane_10,"lane_10"),
    new Pair(tclane_11,"lane_11"),
    new Pair(tclane_12,"lane_12")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
