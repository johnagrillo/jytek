package org.jytek.leaguemanager.view;

import java.util.*;

/**
 * 
 * 
 * CREATE TABLE [MEET]
 * (
 * [Meet]                  Long Integer,
 * [MName]                 Text (90),
 * [Start]                 DateTime,
 * [End]                   DateTime,
 * [AgeUp]                 DateTime,
 * [Since]                 DateTime,
 * [Course]                        Text (4),
 * [Location]                      Text (90),
 * [MaxIndEnt]                     Integer,
 * [MaxRelEnt]                     Integer,
 * [MaxEnt]                        Integer,
 * );
 */
public class TmMeet {

    public static String NAME = "Meet";
    private TmMeet() {
    }

    public static TmMeet create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmMeet();
        obj.meet = (Integer) row.get(TmMeet.MEET);
        obj.mname = (String) row.get(TmMeet.MNAME);
        obj.start = (java.time.LocalDateTime) row.get(TmMeet.START);
        obj.end = (java.time.LocalDateTime) row.get(TmMeet.END);
        obj.ageup = (java.time.LocalDateTime) row.get(TmMeet.AGEUP);
        obj.since = (java.time.LocalDateTime) row.get(TmMeet.SINCE);
        obj.course = (String) row.get(TmMeet.COURSE);
        obj.location = (String) row.get(TmMeet.LOCATION);
        obj.maxindent = (Short) row.get(TmMeet.MAXINDENT);
        obj.maxrelent = (Short) row.get(TmMeet.MAXRELENT);
        obj.maxent = (Short) row.get(TmMeet.MAXENT);
        return obj;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String MNAME = "MName";
    public static final String START = "Start";
    public static final String END = "End";
    public static final String AGEUP = "AgeUp";
    public static final String SINCE = "Since";
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
    private java.time.LocalDateTime end = null;
    private java.time.LocalDateTime ageup = null;
    private java.time.LocalDateTime since = null;
    private String course = null;
    private String location = null;
    private Short maxindent = null;
    private Short maxrelent = null;
    private Short maxent = null;
    //
    // getters
    //
    public Integer getMeet() {
        return meet;
    }
    public String getMname() {
        return mname;
    }
    public java.time.LocalDateTime getStart() {
        return start;
    }
    public java.time.LocalDateTime getEnd() {
        return end;
    }
    public java.time.LocalDateTime getAgeup() {
        return ageup;
    }
    public java.time.LocalDateTime getSince() {
        return since;
    }
    public String getCourse() {
        return course;
    }
    public String getLocation() {
        return location;
    }

    public Short getMaxindent() {
        return maxindent;
    }
    public Short getMaxrelent() {
        return maxrelent;
    }
    public Short getMaxent() {
        return maxent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmMeet tmMeet = (TmMeet) o;
        return Objects.equals(meet, tmMeet.meet) && Objects.equals(mname, tmMeet.mname) && Objects.equals(start, tmMeet.start) && Objects.equals(end, tmMeet.end) && Objects.equals(ageup, tmMeet.ageup) && Objects.equals(since, tmMeet.since) && Objects.equals(course, tmMeet.course) && Objects.equals(location, tmMeet.location) && Objects.equals(maxindent, tmMeet.maxindent) && Objects.equals(maxrelent, tmMeet.maxrelent) && Objects.equals(maxent, tmMeet.maxent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meet, mname, start, end, ageup, since, course, location, maxindent, maxrelent, maxent);
    }

    @Override
    public String toString() {
        return "TmMeet{" +
                "meet=" + meet +
                ", mname='" + mname + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", ageup=" + ageup +
                ", since=" + since +
                ", course='" + course + '\'' +
                ", location='" + location + '\'' +
                ", maxindent=" + maxindent +
                ", maxrelent=" + maxrelent +
                ", maxent=" + maxent +
                '}';
    }
}
/* FXML 
<TableView fx:id=tvTmMeet" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmMeetMeet" prefWidth="150.0" sortable="true" text="Meet" />
    <TableColumn fx:id="tcTmMeetMName" prefWidth="150.0" sortable="true" text="MName" />
    <TableColumn fx:id="tcTmMeetStart" prefWidth="150.0" sortable="true" text="Start" />
    <TableColumn fx:id="tcTmMeetEnd" prefWidth="150.0" sortable="true" text="End" />
    <TableColumn fx:id="tcTmMeetAgeUp" prefWidth="150.0" sortable="true" text="AgeUp" />
    <TableColumn fx:id="tcTmMeetSince" prefWidth="150.0" sortable="true" text="Since" />
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
private TableColumn<TmMeet,java.time.LocalDateTime> tcTmMeetEnd;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcTmMeetAgeUp;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcTmMeetSince;
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
    new Pair(tcEnd,"End"),
    new Pair(tcAgeUp,"AgeUp"),
    new Pair(tcSince,"Since"),
    new Pair(tcCourse,"Course"),
    new Pair(tcLocation,"Location"),
    new Pair(tcMaxIndEnt,"MaxIndEnt"),
    new Pair(tcMaxRelEnt,"MaxRelEnt"),
    new Pair(tcMaxEnt,"MaxEnt")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
