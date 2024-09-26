package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [RelayNames]
 * (
 * [Event_ptr]			Long Integer,
 * [Team_no]			Long Integer,
 * [Team_ltr]			Text (510),
 * [Ath_no]			Long Integer,
 * [Pos_no]			Integer,
 * [Event_round]			Text (2),
 * [Relay_no]			Long Integer
 * );
 */
public class MmRelaynames implements KeyValue<Integer, MmRelaynames> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Relaynames";

    /**
     * Private Constructor
     **/
    private MmRelaynames() {
    }

    /**
     * Read MmRelaynames object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmRelaynames
     **/
    public static MmRelaynames read(final Row row){
        final var obj = new MmRelaynames();
        obj.eventPtr = (Integer) row.get(MmRelaynames.EVENT_PTR);
        obj.teamNo = (Integer) row.get(MmRelaynames.TEAM_NO);
        obj.teamLtr = (String) row.get(MmRelaynames.TEAM_LTR);
        obj.athNo = (Integer) row.get(MmRelaynames.ATH_NO);
        obj.posNo = (Short) row.get(MmRelaynames.POS_NO);
        obj.eventRound = (String) row.get(MmRelaynames.EVENT_ROUND);
        obj.relayNo = (Integer) row.get(MmRelaynames.RELAY_NO);
        return obj;
    }

    public MmRelaynames getValue(){
        return this;
    }

    public Integer getKey(){
        return eventPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String EVENT_PTR = "Event_ptr";
    public static final String TEAM_NO = "Team_no";
    public static final String TEAM_LTR = "Team_ltr";
    public static final String ATH_NO = "Ath_no";
    public static final String POS_NO = "Pos_no";
    public static final String EVENT_ROUND = "Event_round";
    public static final String RELAY_NO = "Relay_no";
    // 
    // members
    //
    private Integer eventPtr = null;
    private Integer teamNo = null;
    private String teamLtr = null;
    private Integer athNo = null;
    private Short posNo = null;
    private String eventRound = null;
    private Integer relayNo = null;

    //
    // getters
    //

    /**
     * Getter for EventPtr
     * @return Integer
     */
    public Integer getEventPtr() {
        return eventPtr;
    }

    /**
     * Getter for TeamNo
     * @return Integer
     */
    public Integer getTeamNo() {
        return teamNo;
    }

    /**
     * Getter for TeamLtr
     * @return String
     */
    public String getTeamLtr() {
        return teamLtr;
    }

    /**
     * Getter for AthNo
     * @return Integer
     */
    public Integer getAthNo() {
        return athNo;
    }

    /**
     * Getter for PosNo
     * @return Short
     */
    public Short getPosNo() {
        return posNo;
    }

    /**
     * Getter for EventRound
     * @return String
     */
    public String getEventRound() {
        return eventRound;
    }

    /**
     * Getter for RelayNo
     * @return Integer
     */
    public Integer getRelayNo() {
        return relayNo;
    }
}
/* FXML 
<TableView fx:id=tvMmRelaynames" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmRelaynamesEvent_ptr" prefWidth="150.0" sortable="true" text="Event_ptr" />
    <TableColumn fx:id="tcMmRelaynamesTeam_no" prefWidth="150.0" sortable="true" text="Team_no" />
    <TableColumn fx:id="tcMmRelaynamesTeam_ltr" prefWidth="150.0" sortable="true" text="Team_ltr" />
    <TableColumn fx:id="tcMmRelaynamesAth_no" prefWidth="150.0" sortable="true" text="Ath_no" />
    <TableColumn fx:id="tcMmRelaynamesPos_no" prefWidth="150.0" sortable="true" text="Pos_no" />
    <TableColumn fx:id="tcMmRelaynamesEvent_round" prefWidth="150.0" sortable="true" text="Event_round" />
    <TableColumn fx:id="tcMmRelaynamesRelay_no" prefWidth="150.0" sortable="true" text="Relay_no" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmRelaynames> tvMmRelaynames;
@FXML
private TableColumn<MmRelaynames,Integer> tcMmRelaynamesEvent_ptr;
@FXML
private TableColumn<MmRelaynames,Integer> tcMmRelaynamesTeam_no;
@FXML
private TableColumn<MmRelaynames,String> tcMmRelaynamesTeam_ltr;
@FXML
private TableColumn<MmRelaynames,Integer> tcMmRelaynamesAth_no;
@FXML
private TableColumn<MmRelaynames,Short> tcMmRelaynamesPos_no;
@FXML
private TableColumn<MmRelaynames,String> tcMmRelaynamesEvent_round;
@FXML
private TableColumn<MmRelaynames,Integer> tcMmRelaynamesRelay_no;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcEvent_ptr,"Event_ptr"),
    new Pair(tcTeam_no,"Team_no"),
    new Pair(tcTeam_ltr,"Team_ltr"),
    new Pair(tcAth_no,"Ath_no"),
    new Pair(tcPos_no,"Pos_no"),
    new Pair(tcEvent_round,"Event_round"),
    new Pair(tcRelay_no,"Relay_no")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
