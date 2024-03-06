package org.jytek.leaguemanager.view;

import java.util.*;

/**
 * 
 * 
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
public class TmAthlete {

    public static String NAME = "Athlete";
    private TmAthlete() {
    }

    public static TmAthlete create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmAthlete();
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
    public Integer getAthlete() {
        return athlete;
    }
    public Integer getTeam1() {
        return team1;
    }
    public String getLast() {
        return last;
    }
    public String getFirst() {
        return first;
    }
    public String getInitial() {
        return initial;
    }
    public String getSex() {
        return sex;
    }
    public java.time.LocalDateTime getBirth() {
        return birth;
    }
    public Short getAge() {
        return age;
    }
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
