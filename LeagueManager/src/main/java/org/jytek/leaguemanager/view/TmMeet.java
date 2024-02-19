package org.jytek.leaguemanager.view;

/**
 * -- ----------------------------------------------------------
 * -- MDB Tools - A library for reading MS Access database files
 * -- Copyright (C) 2000-2011 Brian Bruns and others.
 * -- Files in libmdb are licensed under LGPL and the utilities under
 * -- the GPL, see COPYING.LIB and COPYING files respectively.
 * -- Check out http://mdbtools.sourceforge.net
 * -- ----------------------------------------------------------
 * 
 * -- That file uses encoding UTF-8
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
 * #       [Remarks]                       Text (100),
 * #       [IndCharge]                     Single,
 * #        [RelCharge]                     Single,
 * #        [SurCharge]                     Single,
 * #        [Type]                  Text (6),
 * #        [Sanction]                      Text (30),
 * [MaxIndEnt]                     Integer,
 * [MaxRelEnt]                     Integer,
 * [MaxEnt]                        Integer,
 * #        [RestrictBest]                  Boolean NOT NULL,
 * #        [NonConform]                    Double,
 * #        [EnterAtQTime]                  Boolean NOT NULL,
 * #        [FacilityFee]                   Single,
 * #        [TeamFee]                       Single,
 * #        [Instructions]                  Text (500),
 * #        [MinAge]                        Integer,
 * #        [EnforceQualifying]                     Boolean NOT NULL,
 * #        [Altitude]                      Integer,
 * #        [EnforceSlowQtime]                      Boolean NOT NULL,
 * #       [BanNoTimes]                    Boolean NOT NULL,
 * #       [Lanes]                 Integer,
 * #       [EvenOrOdd]                     Integer,
 * #       [FastToSlow]                    Boolean NOT NULL,
 * #       [Masters]                       Boolean NOT NULL,
 * #       [ActiveFeeXMLSent]                      Boolean NOT NULL,
 * #       [MinAge10AndUnder]                      Integer,
 * #       [SeedLanes]                     Text (32),
 * #       [DeadLine]                      DateTime,
 * #       [ActiveMeetID]                  Long Integer,
 * #       [CustIndCharge]                 Single,
 * #       [CustRelCharge]                 Single,
 * #       [CustSurCharge]                 Single,
 * #       [CustIndAction]                 Byte,
 * #       [CustRelAction]                 Byte,
 * #       [CustSurAction]                 Byte,
 * #       [Addr]                  Text (60),
 * #       [Addr2]                 Text (60),
 * #       [City]                  Text (60),
 * #       [State]                 Text (6),
 * #       [ZIP]                   Text (20),
 * #       [Cntry]                 Text (40),
 * #       [UseCustomFees]                 Boolean NOT NULL,
 * #       [OMEEntryStyle]                 Byte,
 * #       [SwimmerEntryDeadLine]                  DateTime,
 * #       [SwimmerEntryOpen]                      DateTime,
 * #       [AllowCustomTimes]                      Boolean NOT NULL,
 * #       [ExportEntriesDate]                     DateTime,
 * #       [LastSyncDate]                  DateTime,
 * #       [FinalizeEntriesDate]                   DateTime,
 * #       [UseSwimmersTeam]                       Boolean NOT NULL,
 * #       [HonorInviteList]                       Boolean NOT NULL,
 * #       [EntryTeam]                     Long Integer,
 * #       [EMailFrom]                     Text (100),
 * #       [EMailText]                     Text (508),
 * #       [EMailSubject]                  Text (200),
 * #       [OnlyPreEntered]                        Boolean NOT NULL,
 * #       [License]                       Text (240),
 * #       [CollectFeesOnline]                     Boolean NOT NULL,
 * #       [OMEBillDate]                   DateTime,
 * #       [InviteEmailDate]                       DateTime,
 * #       [EntryEMailText]                        Text (508),
 * #       [EntryEMailSubject]                     Text (200),
 * #       [EntryEMailFrom]                        Text (100),
 * #       [OMEValidated]                  Boolean NOT NULL,
 * #       [OMECustomTeam]                 Boolean NOT NULL,
 * #       [OMEFilterTeam]                 Long Integer,
 * #       [OMENeedsSync]                  Boolean NOT NULL,
 * #       [OMENeedSync]                   Boolean NOT NULL,
 * #       [MeetSharingStatus]                     Text (40),
 * #       [FileExportType]                        Integer,
 * #       [MeetRegistrationOpens]                 DateTime,
 * #       [MeetRegistrationCloses]                        DateTime,
 * #       [MeetSharingMeetID]                     Long Integer,
 * #       [MeetSharingPayStatus]                  Text (40),
 * #       [MeetSharingResultDate]                 DateTime,
 * #       [EV3Version]                    Byte
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

}
/* FXML 
<TableView fx:id=tvTmMeets" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMeet" prefWidth="150.0" sortable="false" text="Meet" />
    <TableColumn fx:id="tcMName" prefWidth="150.0" sortable="false" text="MName" />
    <TableColumn fx:id="tcStart" prefWidth="150.0" sortable="false" text="Start" />
    <TableColumn fx:id="tcEnd" prefWidth="150.0" sortable="false" text="End" />
    <TableColumn fx:id="tcAgeUp" prefWidth="150.0" sortable="false" text="AgeUp" />
    <TableColumn fx:id="tcSince" prefWidth="150.0" sortable="false" text="Since" />
    <TableColumn fx:id="tcCourse" prefWidth="150.0" sortable="false" text="Course" />
    <TableColumn fx:id="tcLocation" prefWidth="150.0" sortable="false" text="Location" />
    <TableColumn fx:id="tcMaxIndEnt" prefWidth="150.0" sortable="false" text="MaxIndEnt" />
    <TableColumn fx:id="tcMaxRelEnt" prefWidth="150.0" sortable="false" text="MaxRelEnt" />
    <TableColumn fx:id="tcMaxEnt" prefWidth="150.0" sortable="false" text="MaxEnt" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmMeet> tvTmMeet
@FXML
private TableColumn<TmMeet,Integer> tcMeet;
@FXML
private TableColumn<TmMeet,String> tcMName;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcStart;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcEnd;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcAgeUp;
@FXML
private TableColumn<TmMeet,java.time.LocalDateTime> tcSince;
@FXML
private TableColumn<TmMeet,String> tcCourse;
@FXML
private TableColumn<TmMeet,String> tcLocation;
@FXML
private TableColumn<TmMeet,Short> tcMaxIndEnt;
@FXML
private TableColumn<TmMeet,Short> tcMaxRelEnt;
@FXML
private TableColumn<TmMeet,Short> tcMaxEnt;
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
 pair.getKey().setCellValueFactory(new PropertyValaueFactory<>(pair.getValue()));  }
*/
