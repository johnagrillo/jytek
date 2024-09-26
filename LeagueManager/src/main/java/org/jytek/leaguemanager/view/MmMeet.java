package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Meet]
 * (
 * [Meet_name1]			Text (90),
 * [Meet_location]			Text (90),
 * [Meet_start]			DateTime,
 * [Meet_end]			DateTime,
 * [Meet_idformat]			Integer,
 * [Meet_class]			Integer,
 * [Meet_meettype]			Integer,
 * [Meet_course]			Integer,
 * [Meet_state]			Text (6),
 * [Meet_country]			Text (6),
 * [Meet_lsc]			Text (6),
 * );
 */
public class MmMeet implements KeyValue<Integer, MmMeet> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Meet";

    /**
     * Private Constructor
     **/
    private MmMeet() {
    }

    /**
     * Read MmMeet object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmMeet
     **/
    public static MmMeet read(final Row row){
        final var obj = new MmMeet();
        obj.meetName1 = (String) row.get(MmMeet.MEET_NAME1);
        obj.meetLocation = (String) row.get(MmMeet.MEET_LOCATION);
        obj.meetStart = (java.time.LocalDateTime) row.get(MmMeet.MEET_START);
        obj.meetEnd = (java.time.LocalDateTime) row.get(MmMeet.MEET_END);
        obj.meetIdformat = (Short) row.get(MmMeet.MEET_IDFORMAT);
        obj.meetClass = (Short) row.get(MmMeet.MEET_CLASS);
        obj.meetMeettype = (Short) row.get(MmMeet.MEET_MEETTYPE);
        obj.meetCourse = (Short) row.get(MmMeet.MEET_COURSE);
        obj.meetState = (String) row.get(MmMeet.MEET_STATE);
        obj.meetCountry = (String) row.get(MmMeet.MEET_COUNTRY);
        obj.meetLsc = (String) row.get(MmMeet.MEET_LSC);
        return obj;
    }

    public MmMeet getValue(){
        return this;
    }

    public Integer getKey(){
        return meetName1.hashCode();
    }


    // 
    // Column names
    //
    public static final String MEET_NAME1 = "Meet_name1";
    public static final String MEET_LOCATION = "Meet_location";
    public static final String MEET_START = "Meet_start";
    public static final String MEET_END = "Meet_end";
    public static final String MEET_IDFORMAT = "Meet_idformat";
    public static final String MEET_CLASS = "Meet_class";
    public static final String MEET_MEETTYPE = "Meet_meettype";
    public static final String MEET_COURSE = "Meet_course";
    public static final String MEET_STATE = "Meet_state";
    public static final String MEET_COUNTRY = "Meet_country";
    public static final String MEET_LSC = "Meet_lsc";
    // 
    // members
    //
    private String meetName1 = null;
    private String meetLocation = null;
    private java.time.LocalDateTime meetStart = null;
    private java.time.LocalDateTime meetEnd = null;
    private Short meetIdformat = null;
    private Short meetClass = null;
    private Short meetMeettype = null;
    private Short meetCourse = null;
    private String meetState = null;
    private String meetCountry = null;
    private String meetLsc = null;

    //
    // getters
    //

    /**
     * Getter for MeetName1
     * @return String
     */
    public String getMeetName1() {
        return meetName1;
    }

    /**
     * Getter for MeetLocation
     * @return String
     */
    public String getMeetLocation() {
        return meetLocation;
    }

    /**
     * Getter for MeetStart
     * @return java.time.LocalDateTime
     */
    public java.time.LocalDateTime getMeetStart() {
        return meetStart;
    }

    /**
     * Getter for MeetEnd
     * @return java.time.LocalDateTime
     */
    public java.time.LocalDateTime getMeetEnd() {
        return meetEnd;
    }

    /**
     * Getter for MeetIdformat
     * @return Short
     */
    public Short getMeetIdformat() {
        return meetIdformat;
    }

    /**
     * Getter for MeetClass
     * @return Short
     */
    public Short getMeetClass() {
        return meetClass;
    }

    /**
     * Getter for MeetMeettype
     * @return Short
     */
    public Short getMeetMeettype() {
        return meetMeettype;
    }

    /**
     * Getter for MeetCourse
     * @return Short
     */
    public Short getMeetCourse() {
        return meetCourse;
    }

    /**
     * Getter for MeetState
     * @return String
     */
    public String getMeetState() {
        return meetState;
    }

    /**
     * Getter for MeetCountry
     * @return String
     */
    public String getMeetCountry() {
        return meetCountry;
    }

    /**
     * Getter for MeetLsc
     * @return String
     */
    public String getMeetLsc() {
        return meetLsc;
    }
}
/* FXML 
<TableView fx:id=tvMmMeet" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmMeetMeet_name1" prefWidth="150.0" sortable="true" text="Meet_name1" />
    <TableColumn fx:id="tcMmMeetMeet_location" prefWidth="150.0" sortable="true" text="Meet_location" />
    <TableColumn fx:id="tcMmMeetMeet_start" prefWidth="150.0" sortable="true" text="Meet_start" />
    <TableColumn fx:id="tcMmMeetMeet_end" prefWidth="150.0" sortable="true" text="Meet_end" />
    <TableColumn fx:id="tcMmMeetMeet_idformat" prefWidth="150.0" sortable="true" text="Meet_idformat" />
    <TableColumn fx:id="tcMmMeetMeet_class" prefWidth="150.0" sortable="true" text="Meet_class" />
    <TableColumn fx:id="tcMmMeetMeet_meettype" prefWidth="150.0" sortable="true" text="Meet_meettype" />
    <TableColumn fx:id="tcMmMeetMeet_course" prefWidth="150.0" sortable="true" text="Meet_course" />
    <TableColumn fx:id="tcMmMeetMeet_state" prefWidth="150.0" sortable="true" text="Meet_state" />
    <TableColumn fx:id="tcMmMeetMeet_country" prefWidth="150.0" sortable="true" text="Meet_country" />
    <TableColumn fx:id="tcMmMeetMeet_lsc" prefWidth="150.0" sortable="true" text="Meet_lsc" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmMeet> tvMmMeet;
@FXML
private TableColumn<MmMeet,String> tcMmMeetMeet_name1;
@FXML
private TableColumn<MmMeet,String> tcMmMeetMeet_location;
@FXML
private TableColumn<MmMeet,java.time.LocalDateTime> tcMmMeetMeet_start;
@FXML
private TableColumn<MmMeet,java.time.LocalDateTime> tcMmMeetMeet_end;
@FXML
private TableColumn<MmMeet,Short> tcMmMeetMeet_idformat;
@FXML
private TableColumn<MmMeet,Short> tcMmMeetMeet_class;
@FXML
private TableColumn<MmMeet,Short> tcMmMeetMeet_meettype;
@FXML
private TableColumn<MmMeet,Short> tcMmMeetMeet_course;
@FXML
private TableColumn<MmMeet,String> tcMmMeetMeet_state;
@FXML
private TableColumn<MmMeet,String> tcMmMeetMeet_country;
@FXML
private TableColumn<MmMeet,String> tcMmMeetMeet_lsc;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMeet_name1,"Meet_name1"),
    new Pair(tcMeet_location,"Meet_location"),
    new Pair(tcMeet_start,"Meet_start"),
    new Pair(tcMeet_end,"Meet_end"),
    new Pair(tcMeet_idformat,"Meet_idformat"),
    new Pair(tcMeet_class,"Meet_class"),
    new Pair(tcMeet_meettype,"Meet_meettype"),
    new Pair(tcMeet_course,"Meet_course"),
    new Pair(tcMeet_state,"Meet_state"),
    new Pair(tcMeet_country,"Meet_country"),
    new Pair(tcMeet_lsc,"Meet_lsc")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
