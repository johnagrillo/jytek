package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import java.util.*;

/**
 * 
 * 
 * CREATE TABLE [RELAY]
 * (
 * [RELAY]                 Long Integer,
 * [MEET]                  Long Integer,
 * [LO_HI]                 Integer,
 * [TEAM]                  Long Integer,
 * [LETTER]                Text (2),
 * [AGE_RANGE]             Integer,
 * [SEX]                   Text (2),
 * [ATH(1)]                Long Integer,
 * [ATH(2)]                Long Integer,
 * [ATH(3)]                Long Integer,
 * [ATH(4)]                Long Integer,
 * [ATH(5)]                Long Integer,
 * [ATH(6)]                Long Integer,
 * [ATH(7)]                Long Integer,
 * [ATH(8)]                Long Integer,
 * [DISTANCE]              Integer,
 * [STROKE]                Integer,
 * [RELAYAGE]              Text (6),
 * );
 */
public class TmRelay implements KeyValue<Integer, TmRelay>  {

    public static String NAME = "Relay";
    private TmRelay() {
    }

    public static TmRelay create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmRelay();
        obj.relay = (Integer) row.get(TmRelay.RELAY);
        obj.meet = (Integer) row.get(TmRelay.MEET);
        obj.lohi = (Short) row.get(TmRelay.LO_HI);
        obj.team = (Integer) row.get(TmRelay.TEAM);
        obj.letter = (String) row.get(TmRelay.LETTER);
        obj.agerange = (Short) row.get(TmRelay.AGE_RANGE);
        obj.sex = (String) row.get(TmRelay.SEX);
        obj.ath_1 = (Integer) row.get(TmRelay.ATH_1);
        obj.ath_2 = (Integer) row.get(TmRelay.ATH_2);
        obj.ath_3 = (Integer) row.get(TmRelay.ATH_3);
        obj.ath_4 = (Integer) row.get(TmRelay.ATH_4);
        obj.ath_5 = (Integer) row.get(TmRelay.ATH_5);
        obj.ath_6 = (Integer) row.get(TmRelay.ATH_6);
        obj.ath_7 = (Integer) row.get(TmRelay.ATH_7);
        obj.ath_8 = (Integer) row.get(TmRelay.ATH_8);
        obj.distance = (Short) row.get(TmRelay.DISTANCE);
        obj.stroke = (Short) row.get(TmRelay.STROKE);
        obj.relayage = (String) row.get(TmRelay.RELAYAGE);
        return obj;
    }
    public TmRelay getValue(){
        return this;
   }
    public Integer getKey(){
        return relay;
   }


    // 
    // Column names
    //
    public static final String RELAY = "RELAY";
    public static final String MEET = "MEET";
    public static final String LO_HI = "LO_HI";
    public static final String TEAM = "TEAM";
    public static final String LETTER = "LETTER";
    public static final String AGE_RANGE = "AGE_RANGE";
    public static final String SEX = "SEX";
    public static final String ATH_1 = "ATH(1)";
    public static final String ATH_2 = "ATH(2)";
    public static final String ATH_3 = "ATH(3)";
    public static final String ATH_4 = "ATH(4)";
    public static final String ATH_5 = "ATH(5)";
    public static final String ATH_6 = "ATH(6)";
    public static final String ATH_7 = "ATH(7)";
    public static final String ATH_8 = "ATH(8)";
    public static final String DISTANCE = "DISTANCE";
    public static final String STROKE = "STROKE";
    public static final String RELAYAGE = "RELAYAGE";
    // 
    // members
    //
    private Integer relay = null;
    private Integer meet = null;
    private Short lohi = null;
    private Integer team = null;
    private String letter = null;
    private Short agerange = null;
    private String sex = null;
    private Integer ath_1 = null;
    private Integer ath_2 = null;
    private Integer ath_3 = null;
    private Integer ath_4 = null;
    private Integer ath_5 = null;
    private Integer ath_6 = null;
    private Integer ath_7 = null;
    private Integer ath_8 = null;
    private Short distance = null;
    private Short stroke = null;
    private String relayage = null;
    //
    // getters
    //
    public Integer getRelay() {
        return relay;
    }
    public Integer getMeet() {
        return meet;
    }
    public Short getLohi() {
        return lohi;
    }
    public Integer getTeam() {
        return team;
    }
    public String getLetter() {
        return letter;
    }
    public Short getAgerange() {
        return agerange;
    }
    public String getSex() {
        return sex;
    }
    public Integer getAth_1() {
        return ath_1;
    }
    public Integer getAth_2() {
        return ath_2;
    }
    public Integer getAth_3() {
        return ath_3;
    }
    public Integer getAth_4() {
        return ath_4;
    }
    public Integer getAth_5() {
        return ath_5;
    }
    public Integer getAth_6() {
        return ath_6;
    }
    public Integer getAth_7() {
        return ath_7;
    }
    public Integer getAth_8() {
        return ath_8;
    }
    public Short getDistance() {
        return distance;
    }
    public Short getStroke() {
        return stroke;
    }
    public String getRelayage() {
        return relayage;
    }
}
/* FXML 
<TableView fx:id=tvTmRelay" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmRelayRELAY" prefWidth="150.0" sortable="true" text="RELAY" />
    <TableColumn fx:id="tcTmRelayMEET" prefWidth="150.0" sortable="true" text="MEET" />
    <TableColumn fx:id="tcTmRelayLO_HI" prefWidth="150.0" sortable="true" text="LO_HI" />
    <TableColumn fx:id="tcTmRelayTEAM" prefWidth="150.0" sortable="true" text="TEAM" />
    <TableColumn fx:id="tcTmRelayLETTER" prefWidth="150.0" sortable="true" text="LETTER" />
    <TableColumn fx:id="tcTmRelayAGE_RANGE" prefWidth="150.0" sortable="true" text="AGE_RANGE" />
    <TableColumn fx:id="tcTmRelaySEX" prefWidth="150.0" sortable="true" text="SEX" />
    <TableColumn fx:id="tcTmRelayATH_1" prefWidth="150.0" sortable="true" text="ATH_1" />
    <TableColumn fx:id="tcTmRelayATH_2" prefWidth="150.0" sortable="true" text="ATH_2" />
    <TableColumn fx:id="tcTmRelayATH_3" prefWidth="150.0" sortable="true" text="ATH_3" />
    <TableColumn fx:id="tcTmRelayATH_4" prefWidth="150.0" sortable="true" text="ATH_4" />
    <TableColumn fx:id="tcTmRelayATH_5" prefWidth="150.0" sortable="true" text="ATH_5" />
    <TableColumn fx:id="tcTmRelayATH_6" prefWidth="150.0" sortable="true" text="ATH_6" />
    <TableColumn fx:id="tcTmRelayATH_7" prefWidth="150.0" sortable="true" text="ATH_7" />
    <TableColumn fx:id="tcTmRelayATH_8" prefWidth="150.0" sortable="true" text="ATH_8" />
    <TableColumn fx:id="tcTmRelayDISTANCE" prefWidth="150.0" sortable="true" text="DISTANCE" />
    <TableColumn fx:id="tcTmRelaySTROKE" prefWidth="150.0" sortable="true" text="STROKE" />
    <TableColumn fx:id="tcTmRelayRELAYAGE" prefWidth="150.0" sortable="true" text="RELAYAGE" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmRelay> tvTmRelay;
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayRELAY;
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayMEET;
@FXML
private TableColumn<TmRelay,Short> tcTmRelayLO_HI;
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayTEAM;
@FXML
private TableColumn<TmRelay,String> tcTmRelayLETTER;
@FXML
private TableColumn<TmRelay,Short> tcTmRelayAGE_RANGE;
@FXML
private TableColumn<TmRelay,String> tcTmRelaySEX;
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(1);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(2);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(3);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(4);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(5);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(6);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(7);
@FXML
private TableColumn<TmRelay,Integer> tcTmRelayATH(8);
@FXML
private TableColumn<TmRelay,Short> tcTmRelayDISTANCE;
@FXML
private TableColumn<TmRelay,Short> tcTmRelaySTROKE;
@FXML
private TableColumn<TmRelay,String> tcTmRelayRELAYAGE;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcRELAY,"RELAY"),
    new Pair(tcMEET,"MEET"),
    new Pair(tcLO_HI,"LO_HI"),
    new Pair(tcTEAM,"TEAM"),
    new Pair(tcLETTER,"LETTER"),
    new Pair(tcAGE_RANGE,"AGE_RANGE"),
    new Pair(tcSEX,"SEX"),
    new Pair(tcATH(1),"ATH(1)"),
    new Pair(tcATH(2),"ATH(2)"),
    new Pair(tcATH(3),"ATH(3)"),
    new Pair(tcATH(4),"ATH(4)"),
    new Pair(tcATH(5),"ATH(5)"),
    new Pair(tcATH(6),"ATH(6)"),
    new Pair(tcATH(7),"ATH(7)"),
    new Pair(tcATH(8),"ATH(8)"),
    new Pair(tcDISTANCE,"DISTANCE"),
    new Pair(tcSTROKE,"STROKE"),
    new Pair(tcRELAYAGE,"RELAYAGE")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
