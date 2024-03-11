package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Athlete]
 * (
 * [Athlete]               Long Integer,
 * [Team1]                 Long Integer,
 * [Last]                  Text (40),
 * [First]                 Text (40),
 * [Initial]               Text (2),
 * [Sex]                   Text (2),
 * [Birth]                 DateTime,
 * [Age]                   Integer,
 * [ID_NO]                 Text (34),
 * );
 */
public class TmAthlete implements KeyValue<Integer, TmAthlete> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Athlete";

    /**
     * Private Constructor
     **/
    private TmAthlete() {
    }

    /**
     * Read TmAthlete object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return TmAthlete
     **/
    public static TmAthlete read(final Row row){
        final var obj = new TmAthlete();
        obj.athlete = (Integer) row.get(TmAthlete.ATHLETE);
        obj.team1 = (Integer) row.get(TmAthlete.TEAM1);
        obj.last = (String) row.get(TmAthlete.LAST);
        obj.first = (String) row.get(TmAthlete.FIRST);
        obj.initial = (String) row.get(TmAthlete.INITIAL);
        obj.sex = (String) row.get(TmAthlete.SEX);
        obj.birth = (java.time.LocalDateTime) row.get(TmAthlete.BIRTH);
        obj.age = (Short) row.get(TmAthlete.AGE);
        obj.idno = (String) row.get(TmAthlete.ID_NO);
        return obj;
    }

    public TmAthlete getValue(){
        return this;
    }

    public Integer getKey(){
        return athlete;
    }


    // 
    // Column names
    //
    public static final String ATHLETE = "Athlete";
    public static final String TEAM1 = "Team1";
    public static final String LAST = "Last";
    public static final String FIRST = "First";
    public static final String INITIAL = "Initial";
    public static final String SEX = "Sex";
    public static final String BIRTH = "Birth";
    public static final String AGE = "Age";
    public static final String ID_NO = "ID_NO";
    // 
    // members
    //
    private Integer athlete = null;
    private Integer team1 = null;
    private String last = null;
    private String first = null;
    private String initial = null;
    private String sex = null;
    private java.time.LocalDateTime birth = null;
    private Short age = null;
    private String idno = null;

    //
    // getters
    //

    /**
     * Getter for Athlete
     * @return Integer
     */
    public Integer getAthlete() {
        return athlete;
    }

    /**
     * Getter for Team1
     * @return Integer
     */
    public Integer getTeam1() {
        return team1;
    }

    /**
     * Getter for Last
     * @return String
     */
    public String getLast() {
        return last;
    }

    /**
     * Getter for First
     * @return String
     */
    public String getFirst() {
        return first;
    }

    /**
     * Getter for Initial
     * @return String
     */
    public String getInitial() {
        return initial;
    }

    /**
     * Getter for Sex
     * @return String
     */
    public String getSex() {
        return sex;
    }

    /**
     * Getter for Birth
     * @return java.time.LocalDateTime
     */
    public java.time.LocalDateTime getBirth() {
        return birth;
    }

    /**
     * Getter for Age
     * @return Short
     */
    public Short getAge() {
        return age;
    }

    /**
     * Getter for IdNo
     * @return String
     */
    public String getIdno() {
        return idno;
    }
}
/* FXML 
<TableView fx:id=tvTmAthlete" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmAthleteAthlete" prefWidth="150.0" sortable="true" text="Athlete" />
    <TableColumn fx:id="tcTmAthleteTeam1" prefWidth="150.0" sortable="true" text="Team1" />
    <TableColumn fx:id="tcTmAthleteLast" prefWidth="150.0" sortable="true" text="Last" />
    <TableColumn fx:id="tcTmAthleteFirst" prefWidth="150.0" sortable="true" text="First" />
    <TableColumn fx:id="tcTmAthleteInitial" prefWidth="150.0" sortable="true" text="Initial" />
    <TableColumn fx:id="tcTmAthleteSex" prefWidth="150.0" sortable="true" text="Sex" />
    <TableColumn fx:id="tcTmAthleteBirth" prefWidth="150.0" sortable="true" text="Birth" />
    <TableColumn fx:id="tcTmAthleteAge" prefWidth="150.0" sortable="true" text="Age" />
    <TableColumn fx:id="tcTmAthleteID_NO" prefWidth="150.0" sortable="true" text="ID_NO" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmAthlete> tvTmAthlete;
@FXML
private TableColumn<TmAthlete,Integer> tcTmAthleteAthlete;
@FXML
private TableColumn<TmAthlete,Integer> tcTmAthleteTeam1;
@FXML
private TableColumn<TmAthlete,String> tcTmAthleteLast;
@FXML
private TableColumn<TmAthlete,String> tcTmAthleteFirst;
@FXML
private TableColumn<TmAthlete,String> tcTmAthleteInitial;
@FXML
private TableColumn<TmAthlete,String> tcTmAthleteSex;
@FXML
private TableColumn<TmAthlete,java.time.LocalDateTime> tcTmAthleteBirth;
@FXML
private TableColumn<TmAthlete,Short> tcTmAthleteAge;
@FXML
private TableColumn<TmAthlete,String> tcTmAthleteID_NO;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcAthlete,"Athlete"),
    new Pair(tcTeam1,"Team1"),
    new Pair(tcLast,"Last"),
    new Pair(tcFirst,"First"),
    new Pair(tcInitial,"Initial"),
    new Pair(tcSex,"Sex"),
    new Pair(tcBirth,"Birth"),
    new Pair(tcAge,"Age"),
    new Pair(tcID_NO,"ID_NO")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
