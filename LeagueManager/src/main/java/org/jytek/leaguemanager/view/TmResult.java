package org.jytek.leaguemanager.view;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.database.KeyValue;

/**
 * parsed from mdb-schema
 * CREATE TABLE [RESULT]
 * (
 * [MEET]			Long Integer,
 * [ATHLETE]			Long Integer,
 * [I_R]			Text (2),
 * [TEAM]			Long Integer,
 * [SCORE]			Long Integer,
 * [EX]			Text (2),
 * [ORIGIN]			Text (8),
 * [NT]			Byte,
 * [RESULT]			Long Integer,
 * [AGE]			Integer,
 * [DISTANCE]			Integer,
 * [STROKE]			Integer,
 * [MTEVENT]			Long Integer,
 * [POINTS]			Integer,
 * [PLACE]			Integer,
 * [COURSE]			Text (2),
 * [DQCODE]			Text (4),
 * [DQDESCRIPT]			Text (180),
 * );
 */
public class TmResult implements KeyValue<Integer, TmResult> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Result";

    @Override
    public String toString() {
        return "TmResult{" +
                "athlete=" + athlete +
                ", ir='" + ir + '\'' +
                ", team=" + team +
                ", result=" + result +
                ", age=" + age +
                ", distance=" + distance +
                ", stroke=" + stroke +
                ", points=" + points +
                ", place=" + place +
                ", course='" + course + '\'' +
                ", dqcode='" + dqcode + '\'' +
                ", dqdescript='" + dqdescript + '\'' +
                '}';
    }

    /**
     * Private Constructor
     **/
    private TmResult() {
    }

    /**
     * Read TmResult object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return TmResult
     **/
    public static TmResult read(final Row row){
        final var obj = new TmResult();
        obj.meet = (Integer) row.get(TmResult.MEET);
        obj.athlete = (Integer) row.get(TmResult.ATHLETE);
        obj.ir = (String) row.get(TmResult.I_R);
        obj.team = (Integer) row.get(TmResult.TEAM);
        obj.score = (Integer) row.get(TmResult.SCORE);
        obj.ex = (String) row.get(TmResult.EX);
        obj.origin = (String) row.get(TmResult.ORIGIN);
        obj.nt = (Byte) row.get(TmResult.NT);
        obj.result = (Integer) row.get(TmResult.RESULT);
        obj.age = (Short) row.get(TmResult.AGE);
        obj.distance = (Short) row.get(TmResult.DISTANCE);
        obj.stroke = (Short) row.get(TmResult.STROKE);
        obj.mtevent = (Integer) row.get(TmResult.MTEVENT);
        obj.points = (Short) row.get(TmResult.POINTS);
        obj.place = (Short) row.get(TmResult.PLACE);
        obj.course = (String) row.get(TmResult.COURSE);
        obj.dqcode = (String) row.get(TmResult.DQCODE);
        obj.dqdescript = (String) row.get(TmResult.DQDESCRIPT);
        return obj;
    }

    public TmResult getValue(){
        return this;
    }

    public Integer getKey(){
        return result;
    }


    // 
    // Column names
    //
    public static final String MEET = "MEET";
    public static final String ATHLETE = "ATHLETE";
    public static final String I_R = "I_R";
    public static final String TEAM = "TEAM";
    public static final String SCORE = "SCORE";
    public static final String EX = "EX";
    public static final String ORIGIN = "ORIGIN";
    public static final String NT = "NT";
    public static final String RESULT = "RESULT";
    public static final String AGE = "AGE";
    public static final String DISTANCE = "DISTANCE";
    public static final String STROKE = "STROKE";
    public static final String MTEVENT = "MTEVENT";
    public static final String POINTS = "POINTS";
    public static final String PLACE = "PLACE";
    public static final String COURSE = "COURSE";
    public static final String DQCODE = "DQCODE";
    public static final String DQDESCRIPT = "DQDESCRIPT";
    // 
    // members
    //
    private Integer meet = null;
    private Integer athlete = null;
    private String ir = null;
    private Integer team = null;
    private Integer score = null;
    private String ex = null;
    private String origin = null;
    private Byte nt = null;
    private Integer result = null;
    private Short age = null;
    private Short distance = null;
    private Short stroke = null;
    private Integer mtevent = null;
    private Short points = null;
    private Short place = null;
    private String course = null;
    private String dqcode = null;
    private String dqdescript = null;

    //
    // getters
    //

    /**
     * Getter for MEET
     * @return Integer
     */
    public Integer getMeet() {
        return meet;
    }

    /**
     * Getter for ATHLETE
     * @return Integer
     */
    public Integer getAthlete() {
        return athlete;
    }

    /**
     * Getter for IR
     * @return String
     */
    public String getIr() {
        return ir;
    }

    /**
     * Getter for TEAM
     * @return Integer
     */
    public Integer getTeam() {
        return team;
    }

    /**
     * Getter for SCORE
     * @return Integer
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Getter for EX
     * @return String
     */
    public String getEx() {
        return ex;
    }

    /**
     * Getter for ORIGIN
     * @return String
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Getter for NT
     * @return Byte
     */
    public Byte getNt() {
        return nt;
    }

    /**
     * Getter for RESULT
     * @return Integer
     */
    public Integer getResult() {
        return result;
    }

    /**
     * Getter for AGE
     * @return Short
     */
    public Short getAge() {
        return age;
    }

    /**
     * Getter for DISTANCE
     * @return Short
     */
    public Short getDistance() {
        return distance;
    }

    /**
     * Getter for STROKE
     * @return Short
     */
    public Short getStroke() {
        return stroke;
    }

    /**
     * Getter for MTEVENT
     * @return Integer
     */
    public Integer getMtevent() {
        return mtevent;
    }

    /**
     * Getter for POINTS
     * @return Short
     */
    public Short getPoints() {
        return points;
    }

    /**
     * Getter for PLACE
     * @return Short
     */
    public Short getPlace() {
        return place;
    }

    /**
     * Getter for COURSE
     * @return String
     */
    public String getCourse() {
        return course;
    }

    /**
     * Getter for DQCODE
     * @return String
     */
    public String getDqcode() {
        return dqcode;
    }

    /**
     * Getter for DQDESCRIPT
     * @return String
     */
    public String getDqdescript() {
        return dqdescript;
    }
}
/* FXML 
<TableView fx:id=tvTmResult" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmResultMEET" prefWidth="150.0" sortable="true" text="MEET" />
    <TableColumn fx:id="tcTmResultATHLETE" prefWidth="150.0" sortable="true" text="ATHLETE" />
    <TableColumn fx:id="tcTmResultI_R" prefWidth="150.0" sortable="true" text="I_R" />
    <TableColumn fx:id="tcTmResultTEAM" prefWidth="150.0" sortable="true" text="TEAM" />
    <TableColumn fx:id="tcTmResultSCORE" prefWidth="150.0" sortable="true" text="SCORE" />
    <TableColumn fx:id="tcTmResultEX" prefWidth="150.0" sortable="true" text="EX" />
    <TableColumn fx:id="tcTmResultORIGIN" prefWidth="150.0" sortable="true" text="ORIGIN" />
    <TableColumn fx:id="tcTmResultNT" prefWidth="150.0" sortable="true" text="NT" />
    <TableColumn fx:id="tcTmResultRESULT" prefWidth="150.0" sortable="true" text="RESULT" />
    <TableColumn fx:id="tcTmResultAGE" prefWidth="150.0" sortable="true" text="AGE" />
    <TableColumn fx:id="tcTmResultDISTANCE" prefWidth="150.0" sortable="true" text="DISTANCE" />
    <TableColumn fx:id="tcTmResultSTROKE" prefWidth="150.0" sortable="true" text="STROKE" />
    <TableColumn fx:id="tcTmResultMTEVENT" prefWidth="150.0" sortable="true" text="MTEVENT" />
    <TableColumn fx:id="tcTmResultPOINTS" prefWidth="150.0" sortable="true" text="POINTS" />
    <TableColumn fx:id="tcTmResultPLACE" prefWidth="150.0" sortable="true" text="PLACE" />
    <TableColumn fx:id="tcTmResultCOURSE" prefWidth="150.0" sortable="true" text="COURSE" />
    <TableColumn fx:id="tcTmResultDQCODE" prefWidth="150.0" sortable="true" text="DQCODE" />
    <TableColumn fx:id="tcTmResultDQDESCRIPT" prefWidth="150.0" sortable="true" text="DQDESCRIPT" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmResult> tvTmResult;
@FXML
private TableColumn<TmResult,Integer> tcTmResultMEET;
@FXML
private TableColumn<TmResult,Integer> tcTmResultATHLETE;
@FXML
private TableColumn<TmResult,String> tcTmResultI_R;
@FXML
private TableColumn<TmResult,Integer> tcTmResultTEAM;
@FXML
private TableColumn<TmResult,Integer> tcTmResultSCORE;
@FXML
private TableColumn<TmResult,String> tcTmResultEX;
@FXML
private TableColumn<TmResult,String> tcTmResultORIGIN;
@FXML
private TableColumn<TmResult,Byte> tcTmResultNT;
@FXML
private TableColumn<TmResult,Integer> tcTmResultRESULT;
@FXML
private TableColumn<TmResult,Short> tcTmResultAGE;
@FXML
private TableColumn<TmResult,Short> tcTmResultDISTANCE;
@FXML
private TableColumn<TmResult,Short> tcTmResultSTROKE;
@FXML
private TableColumn<TmResult,Integer> tcTmResultMTEVENT;
@FXML
private TableColumn<TmResult,Short> tcTmResultPOINTS;
@FXML
private TableColumn<TmResult,Short> tcTmResultPLACE;
@FXML
private TableColumn<TmResult,String> tcTmResultCOURSE;
@FXML
private TableColumn<TmResult,String> tcTmResultDQCODE;
@FXML
private TableColumn<TmResult,String> tcTmResultDQDESCRIPT;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMEET,"MEET"),
    new Pair(tcATHLETE,"ATHLETE"),
    new Pair(tcI_R,"I_R"),
    new Pair(tcTEAM,"TEAM"),
    new Pair(tcSCORE,"SCORE"),
    new Pair(tcEX,"EX"),
    new Pair(tcORIGIN,"ORIGIN"),
    new Pair(tcNT,"NT"),
    new Pair(tcRESULT,"RESULT"),
    new Pair(tcAGE,"AGE"),
    new Pair(tcDISTANCE,"DISTANCE"),
    new Pair(tcSTROKE,"STROKE"),
    new Pair(tcMTEVENT,"MTEVENT"),
    new Pair(tcPOINTS,"POINTS"),
    new Pair(tcPLACE,"PLACE"),
    new Pair(tcCOURSE,"COURSE"),
    new Pair(tcDQCODE,"DQCODE"),
    new Pair(tcDQDESCRIPT,"DQDESCRIPT")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
