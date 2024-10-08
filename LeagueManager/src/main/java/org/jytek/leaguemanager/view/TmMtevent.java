package org.jytek.leaguemanager.view;

import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.database.KeyValue;

/**
 * parsed from mdb-schema
 * CREATE TABLE [MTEVENT]
 * (
 * [Meet]			Long Integer,
 * [MtEv]			Integer,
 * [MtEvX]			Text (2),
 * [Lo_Hi]			Integer,
 * [Course]			Text (2),
 * [MtEvent]			Long Integer,
 * [Distance]			Integer,
 * [Stroke]			Integer,
 * [Sex]			Text (2),
 * [I_R]			Text (2),
 * [Session]			Byte,
 * [Division]			Text (6),
 * [EventType]			Text (2),
 * [SessX]			Text (2)
 * );
 */
public class TmMtevent implements KeyValue<Integer, TmMtevent>, Comparable<TmMtevent> {
    @Override
    public int compareTo(TmMtevent o) {
        return Integer.compare(mtev, o.mtev);
    }


    /**
     * Name of Table
     **/
    public static final String NAME = "Mtevent";

    /**
     * Private Constructor
     **/
    private TmMtevent() {
    }

    /**
     * Read TmMtevent object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return TmMtevent
     **/
    public static TmMtevent read(final Row row){
        final var obj = new TmMtevent();
        obj.meet = (Integer) row.get(TmMtevent.MEET);
        obj.mtev = (Short) row.get(TmMtevent.MTEV);
        obj.mtevx = (String) row.get(TmMtevent.MTEVX);
        obj.lohi = (Short) row.get(TmMtevent.LO_HI);
        obj.course = (String) row.get(TmMtevent.COURSE);
        obj.mtevent = (Integer) row.get(TmMtevent.MTEVENT);
        obj.distance = (Short) row.get(TmMtevent.DISTANCE);
        obj.stroke = (Short) row.get(TmMtevent.STROKE);
        obj.sex = (String) row.get(TmMtevent.SEX);
        obj.ir = (String) row.get(TmMtevent.I_R);
        obj.session = (Byte) row.get(TmMtevent.SESSION);
        obj.division = (String) row.get(TmMtevent.DIVISION);
        obj.eventtype = (String) row.get(TmMtevent.EVENTTYPE);
        obj.sessx = (String) row.get(TmMtevent.SESSX);
        return obj;
    }

    public TmMtevent getValue(){
        return this;
    }

    public Integer getKey(){
        return mtevent;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String MTEV = "MtEv";
    public static final String MTEVX = "MtEvX";
    public static final String LO_HI = "Lo_Hi";
    public static final String COURSE = "Course";
    public static final String MTEVENT = "MtEvent";
    public static final String DISTANCE = "Distance";
    public static final String STROKE = "Stroke";
    public static final String SEX = "Sex";
    public static final String I_R = "I_R";
    public static final String SESSION = "Session";
    public static final String DIVISION = "Division";
    public static final String EVENTTYPE = "EventType";
    public static final String SESSX = "SessX";
    // 
    // members
    //
    private Integer meet = null;
    private Short mtev = null;
    private String mtevx = null;
    private Short lohi = null;
    private String course = null;
    private Integer mtevent = null;
    private Short distance = null;
    private Short stroke = null;
    private String sex = null;
    private String ir = null;
    private Byte session = null;
    private String division = null;
    private String eventtype = null;
    private String sessx = null;

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
     * Getter for MtEv
     * @return Short
     */
    public Short getMtev() {
        return mtev;
    }

    /**
     * Getter for MtEvX
     * @return String
     */
    public String getMtevx() {
        return mtevx;
    }

    /**
     * Getter for LoHi
     * @return Short
     */
    public Short getLohi() {
        return lohi;
    }

    /**
     * Getter for Course
     * @return String
     */
    public String getCourse() {
        return course;
    }

    /**
     * Getter for MtEvent
     * @return Integer
     */
    public Integer getMtevent() {
        return mtevent;
    }

    /**
     * Getter for Distance
     * @return Short
     */
    public Short getDistance() {
        return distance;
    }

    /**
     * Getter for Stroke
     * @return Short
     */
    public Short getStroke() {
        return stroke;
    }

    /**
     * Getter for Sex
     * @return String
     */
    public String getSex() {
        return sex;
    }

    /**
     * Getter for IR
     * @return String
     */
    public String getIr() {
        return ir;
    }

    /**
     * Getter for Session
     * @return Byte
     */
    public Byte getSession() {
        return session;
    }

    /**
     * Getter for Division
     * @return String
     */
    public String getDivision() {
        return division;
    }

    /**
     * Getter for EventType
     * @return String
     */
    public String getEventtype() {
        return eventtype;
    }

    /**
     * Getter for SessX
     * @return String
     */
    public String getSessx() {
        return sessx;
    }
}
/* FXML 
<TableView fx:id=tvTmMtevent" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmMteventMeet" prefWidth="150.0" sortable="true" text="Meet" />
    <TableColumn fx:id="tcTmMteventMtEv" prefWidth="150.0" sortable="true" text="MtEv" />
    <TableColumn fx:id="tcTmMteventMtEvX" prefWidth="150.0" sortable="true" text="MtEvX" />
    <TableColumn fx:id="tcTmMteventLo_Hi" prefWidth="150.0" sortable="true" text="Lo_Hi" />
    <TableColumn fx:id="tcTmMteventCourse" prefWidth="150.0" sortable="true" text="Course" />
    <TableColumn fx:id="tcTmMteventMtEvent" prefWidth="150.0" sortable="true" text="MtEvent" />
    <TableColumn fx:id="tcTmMteventDistance" prefWidth="150.0" sortable="true" text="Distance" />
    <TableColumn fx:id="tcTmMteventStroke" prefWidth="150.0" sortable="true" text="Stroke" />
    <TableColumn fx:id="tcTmMteventSex" prefWidth="150.0" sortable="true" text="Sex" />
    <TableColumn fx:id="tcTmMteventI_R" prefWidth="150.0" sortable="true" text="I_R" />
    <TableColumn fx:id="tcTmMteventSession" prefWidth="150.0" sortable="true" text="Session" />
    <TableColumn fx:id="tcTmMteventDivision" prefWidth="150.0" sortable="true" text="Division" />
    <TableColumn fx:id="tcTmMteventEventType" prefWidth="150.0" sortable="true" text="EventType" />
    <TableColumn fx:id="tcTmMteventSessX" prefWidth="150.0" sortable="true" text="SessX" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmMtevent> tvTmMtevent;
@FXML
private TableColumn<TmMtevent,Integer> tcTmMteventMeet;
@FXML
private TableColumn<TmMtevent,Short> tcTmMteventMtEv;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventMtEvX;
@FXML
private TableColumn<TmMtevent,Short> tcTmMteventLo_Hi;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventCourse;
@FXML
private TableColumn<TmMtevent,Integer> tcTmMteventMtEvent;
@FXML
private TableColumn<TmMtevent,Short> tcTmMteventDistance;
@FXML
private TableColumn<TmMtevent,Short> tcTmMteventStroke;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventSex;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventI_R;
@FXML
private TableColumn<TmMtevent,Byte> tcTmMteventSession;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventDivision;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventEventType;
@FXML
private TableColumn<TmMtevent,String> tcTmMteventSessX;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMeet,"Meet"),
    new Pair(tcMtEv,"MtEv"),
    new Pair(tcMtEvX,"MtEvX"),
    new Pair(tcLo_Hi,"Lo_Hi"),
    new Pair(tcCourse,"Course"),
    new Pair(tcMtEvent,"MtEvent"),
    new Pair(tcDistance,"Distance"),
    new Pair(tcStroke,"Stroke"),
    new Pair(tcSex,"Sex"),
    new Pair(tcI_R,"I_R"),
    new Pair(tcSession,"Session"),
    new Pair(tcDivision,"Division"),
    new Pair(tcEventType,"EventType"),
    new Pair(tcSessX,"SessX")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
