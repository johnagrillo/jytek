package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Entry]
 * (
 * [Event_ptr]			Long Integer,
 * [Ath_no]			Long Integer,
 * [Ev_score]			Single,
 * [Fin_Time]			Single,
 * [Fin_place]			Integer,
 * [Fin_points]			Integer,
 * );
 */
public class MmEntry implements KeyValue<Integer, MmEntry> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Entry";

    /**
     * Private Constructor
     **/
    private MmEntry() {
    }

    /**
     * Read MmEntry object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmEntry
     **/
    public static MmEntry read(final Row row){
        final var obj = new MmEntry();
        obj.eventPtr = (Integer) row.get(MmEntry.EVENT_PTR);
        obj.athNo = (Integer) row.get(MmEntry.ATH_NO);
        obj.evScore = (Float) row.get(MmEntry.EV_SCORE);
        obj.finTime = (Float) row.get(MmEntry.FIN_TIME);
        obj.finPlace = (Short) row.get(MmEntry.FIN_PLACE);
        obj.finPoints = (Short) row.get(MmEntry.FIN_POINTS);
        return obj;
    }

    public MmEntry getValue(){
        return this;
    }

    public Integer getKey(){
        return eventPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String EVENT_PTR = "Event_ptr";
    public static final String ATH_NO = "Ath_no";
    public static final String EV_SCORE = "Ev_score";
    public static final String FIN_TIME = "Fin_Time";
    public static final String FIN_PLACE = "Fin_place";
    public static final String FIN_POINTS = "Fin_points";
    // 
    // members
    //
    private Integer eventPtr = null;
    private Integer athNo = null;
    private Float evScore = null;
    private Float finTime = null;
    private Short finPlace = null;
    private Short finPoints = null;

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
     * Getter for AthNo
     * @return Integer
     */
    public Integer getAthNo() {
        return athNo;
    }

    /**
     * Getter for EvScore
     * @return Float
     */
    public Float getEvScore() {
        return evScore;
    }

    /**
     * Getter for FinTime
     * @return Float
     */
    public Float getFinTime() {
        return finTime;
    }

    /**
     * Getter for FinPlace
     * @return Short
     */
    public Short getFinPlace() {
        return finPlace;
    }

    /**
     * Getter for FinPoints
     * @return Short
     */
    public Short getFinPoints() {
        return finPoints;
    }
}
/* FXML 
<TableView fx:id=tvMmEntry" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmEntryEvent_ptr" prefWidth="150.0" sortable="true" text="Event_ptr" />
    <TableColumn fx:id="tcMmEntryAth_no" prefWidth="150.0" sortable="true" text="Ath_no" />
    <TableColumn fx:id="tcMmEntryEv_score" prefWidth="150.0" sortable="true" text="Ev_score" />
    <TableColumn fx:id="tcMmEntryFin_Time" prefWidth="150.0" sortable="true" text="Fin_Time" />
    <TableColumn fx:id="tcMmEntryFin_place" prefWidth="150.0" sortable="true" text="Fin_place" />
    <TableColumn fx:id="tcMmEntryFin_points" prefWidth="150.0" sortable="true" text="Fin_points" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmEntry> tvMmEntry;
@FXML
private TableColumn<MmEntry,Integer> tcMmEntryEvent_ptr;
@FXML
private TableColumn<MmEntry,Integer> tcMmEntryAth_no;
@FXML
private TableColumn<MmEntry,Float> tcMmEntryEv_score;
@FXML
private TableColumn<MmEntry,Float> tcMmEntryFin_Time;
@FXML
private TableColumn<MmEntry,Short> tcMmEntryFin_place;
@FXML
private TableColumn<MmEntry,Short> tcMmEntryFin_points;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcEvent_ptr,"Event_ptr"),
    new Pair(tcAth_no,"Ath_no"),
    new Pair(tcEv_score,"Ev_score"),
    new Pair(tcFin_Time,"Fin_Time"),
    new Pair(tcFin_place,"Fin_place"),
    new Pair(tcFin_points,"Fin_points")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
