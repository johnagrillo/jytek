package org.jytek.leaguemanager.view;

import java.util.*;

/**
 * 
 * 
 * CREATE TABLE [ENTRY]
 * (
 * [Meet]			Long Integer,
 * [Athlete]			Long Integer,
 * [I_R]			Text (2),
 * [Team]			Long Integer,
 * [Course]			Text (4),
 * [Score]			Long Integer,
 * [Ex]			Text (2),
 * [MtEvent]			Long Integer,
 * [Misc]			Text (2),
 * [Entry]			Long Integer,
 * [Division]			Text (6),
 * [HEAT]			Byte,
 * [LANE]			Byte,
 * [FromOME]			Boolean NOT NULL
 * );
 */
public class TmEntry {

    public static String NAME = "Entry";
    private TmEntry() {
    }

    public static TmEntry create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmEntry();
        obj.meet = (Integer) row.get(TmEntry.MEET);
        obj.athlete = (Integer) row.get(TmEntry.ATHLETE);
        obj.ir = (String) row.get(TmEntry.I_R);
        obj.team = (Integer) row.get(TmEntry.TEAM);
        obj.course = (String) row.get(TmEntry.COURSE);
        obj.score = (Integer) row.get(TmEntry.SCORE);
        obj.ex = (String) row.get(TmEntry.EX);
        obj.mtevent = (Integer) row.get(TmEntry.MTEVENT);
        obj.misc = (String) row.get(TmEntry.MISC);
        obj.entry = (Integer) row.get(TmEntry.ENTRY);
        obj.division = (String) row.get(TmEntry.DIVISION);
        obj.heat = (Byte) row.get(TmEntry.HEAT);
        obj.lane = (Byte) row.get(TmEntry.LANE);
        obj.fromome = (Boolean) row.get(TmEntry.FROMOME);
        return obj;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String ATHLETE = "Athlete";
    public static final String I_R = "I_R";
    public static final String TEAM = "Team";
    public static final String COURSE = "Course";
    public static final String SCORE = "Score";
    public static final String EX = "Ex";
    public static final String MTEVENT = "MtEvent";
    public static final String MISC = "Misc";
    public static final String ENTRY = "Entry";
    public static final String DIVISION = "Division";
    public static final String HEAT = "HEAT";
    public static final String LANE = "LANE";
    public static final String FROMOME = "FromOME";
    // 
    // members
    //
    private Integer meet = null;
    private Integer athlete = null;
    private String ir = null;
    private Integer team = null;
    private String course = null;
    private Integer score = null;
    private String ex = null;
    private Integer mtevent = null;
    private String misc = null;
    private Integer entry = null;
    private String division = null;
    private Byte heat = null;
    private Byte lane = null;
    private Boolean fromome = null;
    //
    // getters
    //
    public Integer getMeet() {
        return meet;
    }
    public Integer getAthlete() {
        return athlete;
    }
    public String getIr() {
        return ir;
    }
    public Integer getTeam() {
        return team;
    }
    public String getCourse() {
        return course;
    }
    public Integer getScore() {
        return score;
    }
    public String getEx() {
        return ex;
    }
    public Integer getMtevent() {
        return mtevent;
    }
    public String getMisc() {
        return misc;
    }
    public Integer getEntry() {
        return entry;
    }
    public String getDivision() {
        return division;
    }
    public Byte getHeat() {
        return heat;
    }
    public Byte getLane() {
        return lane;
    }
    public Boolean getFromome() {
        return fromome;
    }

}
/* FXML 
<TableView fx:id=tvTmEntry" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmEntryMeet" prefWidth="150.0" sortable="true" text="Meet" />
    <TableColumn fx:id="tcTmEntryAthlete" prefWidth="150.0" sortable="true" text="Athlete" />
    <TableColumn fx:id="tcTmEntryI_R" prefWidth="150.0" sortable="true" text="I_R" />
    <TableColumn fx:id="tcTmEntryTeam" prefWidth="150.0" sortable="true" text="Team" />
    <TableColumn fx:id="tcTmEntryCourse" prefWidth="150.0" sortable="true" text="Course" />
    <TableColumn fx:id="tcTmEntryScore" prefWidth="150.0" sortable="true" text="Score" />
    <TableColumn fx:id="tcTmEntryEx" prefWidth="150.0" sortable="true" text="Ex" />
    <TableColumn fx:id="tcTmEntryMtEvent" prefWidth="150.0" sortable="true" text="MtEvent" />
    <TableColumn fx:id="tcTmEntryMisc" prefWidth="150.0" sortable="true" text="Misc" />
    <TableColumn fx:id="tcTmEntryEntry" prefWidth="150.0" sortable="true" text="Entry" />
    <TableColumn fx:id="tcTmEntryDivision" prefWidth="150.0" sortable="true" text="Division" />
    <TableColumn fx:id="tcTmEntryHEAT" prefWidth="150.0" sortable="true" text="HEAT" />
    <TableColumn fx:id="tcTmEntryLANE" prefWidth="150.0" sortable="true" text="LANE" />
    <TableColumn fx:id="tcTmEntryFromOME" prefWidth="150.0" sortable="true" text="FromOME" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmEntry> tvTmEntry;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryMeet;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryAthlete;
@FXML
private TableColumn<TmEntry,String> tcTmEntryI_R;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryTeam;
@FXML
private TableColumn<TmEntry,String> tcTmEntryCourse;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryScore;
@FXML
private TableColumn<TmEntry,String> tcTmEntryEx;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryMtEvent;
@FXML
private TableColumn<TmEntry,String> tcTmEntryMisc;
@FXML
private TableColumn<TmEntry,Integer> tcTmEntryEntry;
@FXML
private TableColumn<TmEntry,String> tcTmEntryDivision;
@FXML
private TableColumn<TmEntry,Byte> tcTmEntryHEAT;
@FXML
private TableColumn<TmEntry,Byte> tcTmEntryLANE;
@FXML
private TableColumn<TmEntry,Boolean> tcTmEntryFromOME;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMeet,"Meet"),
    new Pair(tcAthlete,"Athlete"),
    new Pair(tcI_R,"I_R"),
    new Pair(tcTeam,"Team"),
    new Pair(tcCourse,"Course"),
    new Pair(tcScore,"Score"),
    new Pair(tcEx,"Ex"),
    new Pair(tcMtEvent,"MtEvent"),
    new Pair(tcMisc,"Misc"),
    new Pair(tcEntry,"Entry"),
    new Pair(tcDivision,"Division"),
    new Pair(tcHEAT,"HEAT"),
    new Pair(tcLANE,"LANE"),
    new Pair(tcFromOME,"FromOME")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
