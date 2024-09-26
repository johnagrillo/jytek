package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Athlete]
 * (
 * [Ath_no]			Long Integer,
 * [Last_name]			Text (40),
 * [First_name]			Text (40),
 * [Initial]			Text (2),
 * [Ath_Sex]			Text (2),
 * [Birth_date]			DateTime,
 * [Team_no]			Long Integer,
 * [Ath_age]			Integer,
 * [Reg_no]			Text (28),
 * [Ath_stat]			Text (2),
 * [Ath_Sex_BS]			Text (2)
 * );
 */
public class MmAthlete implements KeyValue<Integer, MmAthlete> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Athlete";

    /**
     * Private Constructor
     **/
    private MmAthlete() {
    }

    /**
     * Read MmAthlete object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmAthlete
     **/
    public static MmAthlete read(final Row row){
        final var obj = new MmAthlete();
        obj.athNo = (Integer) row.get(MmAthlete.ATH_NO);
        obj.lastName = (String) row.get(MmAthlete.LAST_NAME);
        obj.firstName = (String) row.get(MmAthlete.FIRST_NAME);
        obj.initial = (String) row.get(MmAthlete.INITIAL);
        obj.athSex = (String) row.get(MmAthlete.ATH_SEX);
        obj.birthDate = (java.time.LocalDateTime) row.get(MmAthlete.BIRTH_DATE);
        obj.teamNo = (Integer) row.get(MmAthlete.TEAM_NO);
        obj.athAge = (Short) row.get(MmAthlete.ATH_AGE);
        obj.regNo = (String) row.get(MmAthlete.REG_NO);
        obj.athStat = (String) row.get(MmAthlete.ATH_STAT);
        obj.athSexBs = (String) row.get(MmAthlete.ATH_SEX_BS);
        return obj;
    }

    public MmAthlete getValue(){
        return this;
    }

    public Integer getKey(){
        return athNo.hashCode();
    }


    // 
    // Column names
    //
    public static final String ATH_NO = "Ath_no";
    public static final String LAST_NAME = "Last_name";
    public static final String FIRST_NAME = "First_name";
    public static final String INITIAL = "Initial";
    public static final String ATH_SEX = "Ath_Sex";
    public static final String BIRTH_DATE = "Birth_date";
    public static final String TEAM_NO = "Team_no";
    public static final String ATH_AGE = "Ath_age";
    public static final String REG_NO = "Reg_no";
    public static final String ATH_STAT = "Ath_stat";
    public static final String ATH_SEX_BS = "Ath_Sex_BS";
    // 
    // members
    //
    private Integer athNo = null;
    private String lastName = null;
    private String firstName = null;
    private String initial = null;
    private String athSex = null;
    private java.time.LocalDateTime birthDate = null;
    private Integer teamNo = null;
    private Short athAge = null;
    private String regNo = null;
    private String athStat = null;
    private String athSexBs = null;

    //
    // getters
    //

    /**
     * Getter for AthNo
     * @return Integer
     */
    public Integer getAthNo() {
        return athNo;
    }

    /**
     * Getter for LastName
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for FirstName
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for Initial
     * @return String
     */
    public String getInitial() {
        return initial;
    }

    /**
     * Getter for AthSex
     * @return String
     */
    public String getAthSex() {
        return athSex;
    }

    /**
     * Getter for BirthDate
     * @return java.time.LocalDateTime
     */
    public java.time.LocalDateTime getBirthDate() {
        return birthDate;
    }

    /**
     * Getter for TeamNo
     * @return Integer
     */
    public Integer getTeamNo() {
        return teamNo;
    }

    /**
     * Getter for AthAge
     * @return Short
     */
    public Short getAthAge() {
        return athAge;
    }

    /**
     * Getter for RegNo
     * @return String
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * Getter for AthStat
     * @return String
     */
    public String getAthStat() {
        return athStat;
    }

    /**
     * Getter for AthSexBs
     * @return String
     */
    public String getAthSexBs() {
        return athSexBs;
    }
}
/* FXML 
<TableView fx:id=tvMmAthlete" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmAthleteAth_no" prefWidth="150.0" sortable="true" text="Ath_no" />
    <TableColumn fx:id="tcMmAthleteLast_name" prefWidth="150.0" sortable="true" text="Last_name" />
    <TableColumn fx:id="tcMmAthleteFirst_name" prefWidth="150.0" sortable="true" text="First_name" />
    <TableColumn fx:id="tcMmAthleteInitial" prefWidth="150.0" sortable="true" text="Initial" />
    <TableColumn fx:id="tcMmAthleteAth_Sex" prefWidth="150.0" sortable="true" text="Ath_Sex" />
    <TableColumn fx:id="tcMmAthleteBirth_date" prefWidth="150.0" sortable="true" text="Birth_date" />
    <TableColumn fx:id="tcMmAthleteTeam_no" prefWidth="150.0" sortable="true" text="Team_no" />
    <TableColumn fx:id="tcMmAthleteAth_age" prefWidth="150.0" sortable="true" text="Ath_age" />
    <TableColumn fx:id="tcMmAthleteReg_no" prefWidth="150.0" sortable="true" text="Reg_no" />
    <TableColumn fx:id="tcMmAthleteAth_stat" prefWidth="150.0" sortable="true" text="Ath_stat" />
    <TableColumn fx:id="tcMmAthleteAth_Sex_BS" prefWidth="150.0" sortable="true" text="Ath_Sex_BS" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmAthlete> tvMmAthlete;
@FXML
private TableColumn<MmAthlete,Integer> tcMmAthleteAth_no;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteLast_name;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteFirst_name;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteInitial;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteAth_Sex;
@FXML
private TableColumn<MmAthlete,java.time.LocalDateTime> tcMmAthleteBirth_date;
@FXML
private TableColumn<MmAthlete,Integer> tcMmAthleteTeam_no;
@FXML
private TableColumn<MmAthlete,Short> tcMmAthleteAth_age;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteReg_no;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteAth_stat;
@FXML
private TableColumn<MmAthlete,String> tcMmAthleteAth_Sex_BS;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcAth_no,"Ath_no"),
    new Pair(tcLast_name,"Last_name"),
    new Pair(tcFirst_name,"First_name"),
    new Pair(tcInitial,"Initial"),
    new Pair(tcAth_Sex,"Ath_Sex"),
    new Pair(tcBirth_date,"Birth_date"),
    new Pair(tcTeam_no,"Team_no"),
    new Pair(tcAth_age,"Ath_age"),
    new Pair(tcReg_no,"Reg_no"),
    new Pair(tcAth_stat,"Ath_stat"),
    new Pair(tcAth_Sex_BS,"Ath_Sex_BS")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
