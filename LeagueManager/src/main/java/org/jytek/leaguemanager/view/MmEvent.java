package org.jytek.leaguemanager.view;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.database.KeyValue;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Event]
 * (
 * [Event_no]			Integer,
 * [Event_ltr]			Text (2),
 * [Event_ptr]			Long Integer,
 * [Ind_rel]			Text (2),
 * [Event_sex]			Text (2),
 * [Event_gender]			Text (2),
 * [Event_dist]			Single,
 * [Event_stroke]			Text (2),
 * [Low_age]			Integer,
 * [High_Age]			Integer,
 * );
 */
public class MmEvent implements KeyValue<Integer, MmEvent>, Comparable<MmEvent> {

    @Override
    public int compareTo(MmEvent o) {
        return Integer.compare(eventNo, o.eventNo);
    }


    /**
     * Name of Table
     **/
    public static final String NAME = "Event";

    /**
     * Private Constructor
     **/
    private MmEvent() {
    }

    /**
     * Read MmEvent object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmEvent
     **/
    public static MmEvent read(final Row row){
        final var obj = new MmEvent();
        obj.eventNo = (Short) row.get(MmEvent.EVENT_NO);
        obj.eventLtr = (String) row.get(MmEvent.EVENT_LTR);
        obj.eventPtr = (Integer) row.get(MmEvent.EVENT_PTR);
        obj.indRel = (String) row.get(MmEvent.IND_REL);
        obj.eventSex = (String) row.get(MmEvent.EVENT_SEX);
        obj.eventGender = (String) row.get(MmEvent.EVENT_GENDER);
        obj.eventDist = (Float) row.get(MmEvent.EVENT_DIST);
        obj.eventStroke = (String) row.get(MmEvent.EVENT_STROKE);
        obj.lowAge = (Short) row.get(MmEvent.LOW_AGE);
        obj.highAge = (Short) row.get(MmEvent.HIGH_AGE);
        return obj;
    }

    public MmEvent getValue(){
        return this;
    }

    public Integer getKey(){
        return eventNo.intValue();
    }


    // 
    // Column names
    //
    public static final String EVENT_NO = "Event_no";
    public static final String EVENT_LTR = "Event_ltr";
    public static final String EVENT_PTR = "Event_ptr";
    public static final String IND_REL = "Ind_rel";
    public static final String EVENT_SEX = "Event_sex";
    public static final String EVENT_GENDER = "Event_gender";
    public static final String EVENT_DIST = "Event_dist";
    public static final String EVENT_STROKE = "Event_stroke";
    public static final String LOW_AGE = "Low_age";
    public static final String HIGH_AGE = "High_Age";
    // 
    // members
    //
    private Short eventNo = null;
    private String eventLtr = null;
    private Integer eventPtr = null;
    private String indRel = null;
    private String eventSex = null;
    private String eventGender = null;
    private Float eventDist = null;
    private String eventStroke = null;
    private Short lowAge = null;
    private Short highAge = null;

    //
    // getters
    //

    /**
     * Getter for EventNo
     * @return Short
     */
    public Short getEventNo() {
        return eventNo;
    }

    /**
     * Getter for EventLtr
     * @return String
     */
    public String getEventLtr() {
        return eventLtr;
    }

    /**
     * Getter for EventPtr
     * @return Integer
     */
    public Integer getEventPtr() {
        return eventPtr;
    }

    /**
     * Getter for IndRel
     * @return String
     */
    public String getIndRel() {
        return indRel;
    }

    /**
     * Getter for EventSex
     * @return String
     */
    public String getEventSex() {
        return eventSex;
    }

    /**
     * Getter for EventGender
     * @return String
     */
    public String getEventGender() {
        return eventGender;
    }

    /**
     * Getter for EventDist
     * @return Float
     */
    public Float getEventDist() {
        return eventDist;
    }

    /**
     * Getter for EventStroke
     * @return String
     */
    public String getEventStroke() {
        return eventStroke;
    }

    /**
     * Getter for LowAge
     * @return Short
     */
    public Short getLowAge() {
        return lowAge;
    }

    /**
     * Getter for HighAge
     * @return Short
     */
    public Short getHighAge() {
        return highAge;
    }
}
/* FXML 
<TableView fx:id=tvMmEvent" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmEventEvent_no" prefWidth="150.0" sortable="true" text="Event_no" />
    <TableColumn fx:id="tcMmEventEvent_ltr" prefWidth="150.0" sortable="true" text="Event_ltr" />
    <TableColumn fx:id="tcMmEventEvent_ptr" prefWidth="150.0" sortable="true" text="Event_ptr" />
    <TableColumn fx:id="tcMmEventInd_rel" prefWidth="150.0" sortable="true" text="Ind_rel" />
    <TableColumn fx:id="tcMmEventEvent_sex" prefWidth="150.0" sortable="true" text="Event_sex" />
    <TableColumn fx:id="tcMmEventEvent_gender" prefWidth="150.0" sortable="true" text="Event_gender" />
    <TableColumn fx:id="tcMmEventEvent_dist" prefWidth="150.0" sortable="true" text="Event_dist" />
    <TableColumn fx:id="tcMmEventEvent_stroke" prefWidth="150.0" sortable="true" text="Event_stroke" />
    <TableColumn fx:id="tcMmEventLow_age" prefWidth="150.0" sortable="true" text="Low_age" />
    <TableColumn fx:id="tcMmEventHigh_Age" prefWidth="150.0" sortable="true" text="High_Age" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmEvent> tvMmEvent;
@FXML
private TableColumn<MmEvent,Short> tcMmEventEvent_no;
@FXML
private TableColumn<MmEvent,String> tcMmEventEvent_ltr;
@FXML
private TableColumn<MmEvent,Integer> tcMmEventEvent_ptr;
@FXML
private TableColumn<MmEvent,String> tcMmEventInd_rel;
@FXML
private TableColumn<MmEvent,String> tcMmEventEvent_sex;
@FXML
private TableColumn<MmEvent,String> tcMmEventEvent_gender;
@FXML
private TableColumn<MmEvent,Float> tcMmEventEvent_dist;
@FXML
private TableColumn<MmEvent,String> tcMmEventEvent_stroke;
@FXML
private TableColumn<MmEvent,Short> tcMmEventLow_age;
@FXML
private TableColumn<MmEvent,Short> tcMmEventHigh_Age;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcEvent_no,"Event_no"),
    new Pair(tcEvent_ltr,"Event_ltr"),
    new Pair(tcEvent_ptr,"Event_ptr"),
    new Pair(tcInd_rel,"Ind_rel"),
    new Pair(tcEvent_sex,"Event_sex"),
    new Pair(tcEvent_gender,"Event_gender"),
    new Pair(tcEvent_dist,"Event_dist"),
    new Pair(tcEvent_stroke,"Event_stroke"),
    new Pair(tcLow_age,"Low_age"),
    new Pair(tcHigh_Age,"High_Age")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
