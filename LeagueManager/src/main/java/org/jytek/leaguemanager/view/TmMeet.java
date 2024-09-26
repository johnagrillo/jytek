package org.jytek.leaguemanager.view;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.database.KeyValue;

/**
 * parsed from mdb-schema
 * CREATE TABLE [MEET]
 * (
 * [Meet]                  Long Integer,
 * [MName]                 Text (90),
 * [Start]                 DateTime,
 * [Course]                        Text (4),
 * [Location]                      Text (90), 3
 * [MaxIndEnt]                     Integer,
 * [MaxRelEnt]                     Integer,
 * [MaxEnt]                        Integer,
 * );
 */
public class TmMeet implements KeyValue<Integer, TmMeet> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Meet";

    /**
     * Private Constructor
     **/
    private TmMeet() {
    }

    /**
     * Read TmMeet object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return TmMeet
     **/
    public static TmMeet read(final Row row){
        final var obj = new TmMeet();
        obj.meet = (Integer) row.get(TmMeet.MEET);
        obj.mname = (String) row.get(TmMeet.MNAME);
        obj.start = (java.time.LocalDateTime) row.get(TmMeet.START);
        obj.course = (String) row.get(TmMeet.COURSE);
        obj.location = (String) row.get(TmMeet.LOCATION);
        obj.maxindent = (Short) row.get(TmMeet.MAXINDENT);
        obj.maxrelent = (Short) row.get(TmMeet.MAXRELENT);
        obj.maxent = (Short) row.get(TmMeet.MAXENT);
        return obj;
    }

    public TmMeet getValue(){
        return this;
    }

    public Integer getKey(){
        return meet;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String MNAME = "MName";
    public static final String START = "Start";
    public static final String COURSE = "Course";
    public static final String LOCATION = "Location";
    public static final String MAXINDENT = "MaxIndEnt";
    public static final String MAXRELENT = "MaxRelEnt";
    public static final String MAXENT = "MaxEnt";
    // 
    // members
    //
    private Integer meet = null;
    private String mname = null;
    private java.time.LocalDateTime start = null;
    private String course = null;
    private String location = null;
    private Short maxindent = null;
    private Short maxrelent = null;
    private Short maxent = null;

    //
    // getters
    //

    /**
     * Getter for Meet
     * @return Integer
     */
    public Integer getMeet() {
        return meet;
    }

    /**
     * Getter for MName
     * @return String
     */
    public String getMname() {
        return mname;
    }

    @Override
    public String toString() {
        return mname;
    }
    /**
     * Getter for Start
     * @return java.time.LocalDateTime
     */
    public java.time.LocalDateTime getStart() {
        return start;
    }

    /**
     * Getter for Course
     * @return String
     */
    public String getCourse() {
        return course;
    }

    /**
     * Getter for Location
     * @return String
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for MaxIndEnt
     * @return Short
     */
    public Short getMaxindent() {
        return maxindent;
    }

    /**
     * Getter for MaxRelEnt
     * @return Short
     */
    public Short getMaxrelent() {
        return maxrelent;
    }

    /**
     * Getter for MaxEnt
     * @return Short
     */
    public Short getMaxent() {
        return maxent;
    }
}
/* FXML 
<TableView fx:id=tvTmMeet" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmMeetMeet" prefWidth="150.0" sortable="true" text="Meet" />
    <TableColumn fx:id="tcTmMeetMName" prefWidth="150.0" sortable="true" text="MName" />
    <TableColumn fx:id="tcTmMeetStart" prefWidth="150.0" sortable="true" text="Start" />
    <TableColumn fx:id="tcTmMeetCourse" prefWidth="150.0" sortable="true" text="Course" />
    <TableColumn fx:id="tcTmMeetLocation" prefWidth="150.0" sortable="true" text="Location" />
    <TableColumn fx:id="tcTmMeetMaxIndEnt" prefWidth="150.0" sortable="true" text="MaxIndEnt" />
    <TableColumn fx:id="tcTmMeetMaxRelEnt" prefWidth="150.0" sortable="true" text="MaxRelEnt" />
    <TableColumn fx:id="tcTmMeetMaxEnt" prefWidth="150.0" sortable="true" text="MaxEnt" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmMeet> tvTmMeet;
@FXML
private TableColumn<TmMeet,Integer> tcTmMeetMeet;
@FXML
private TableColumn<TmMeet,String> tcTmMeetMName;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcTmMeetStart;
@FXML
private TableColumn<TmMeet,String> tcTmMeetCourse;
@FXML
private TableColumn<TmMeet,String> tcTmMeetLocation;
@FXML
private TableColumn<TmMeet,Short> tcTmMeetMaxIndEnt;
@FXML
private TableColumn<TmMeet,Short> tcTmMeetMaxRelEnt;
@FXML
private TableColumn<TmMeet,Short> tcTmMeetMaxEnt;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMeet,"Meet"),
    new Pair(tcMName,"MName"),
    new Pair(tcStart,"Start"),
    new Pair(tcCourse,"Course"),
    new Pair(tcLocation,"Location"),
    new Pair(tcMaxIndEnt,"MaxIndEnt"),
    new Pair(tcMaxRelEnt,"MaxRelEnt"),
    new Pair(tcMaxEnt,"MaxEnt")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
