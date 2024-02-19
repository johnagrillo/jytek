package org.jytek.leaguemanager.view;

import java.util.*;

/**
 * 
 * 
 * CREATE TABLE [MTEVENTE]
 * (
 * [Meet]			Long Integer,
 * [MtEv]			Integer,
 * [MtEvX]			Text (2),
 * [Lo_Hi]			Integer,
 * [FastCut]			Long Integer,
 * [SlowCut]			Long Integer,
 * [Course]			Text (2),
 * [MtEvent]			Long Integer,
 * [Fast_L]			Long Integer,
 * [Slow_L]			Long Integer,
 * [Fast_Y]			Long Integer,
 * [Slow_Y]			Long Integer,
 * [TstdFile]			Text (16),
 * [TstDesig]			Text (8),
 * [Distance]			Integer,
 * [Stroke]			Integer,
 * [Sex]			Text (2),
 * [I_R]			Text (2),
 * [Session]			Byte,
 * [Division]			Text (6),
 * [Fee]			Single,
 * [ExportEvent]			Text (8),
 * [GenderMix]			Byte,
 * [SessX]			Text (2)
 * );
 */
public class TmMtevente {

    public static String NAME = "Mtevente";
    private TmMtevente() {
    }

    public static TmMtevente create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmMtevente();
        obj.meet = (Integer) row.get(TmMtevente.MEET);
        obj.mtev = (Short) row.get(TmMtevente.MTEV);
        obj.mtevx = (String) row.get(TmMtevente.MTEVX);
        obj.lohi = (Short) row.get(TmMtevente.LO_HI);
        obj.fastcut = (Integer) row.get(TmMtevente.FASTCUT);
        obj.slowcut = (Integer) row.get(TmMtevente.SLOWCUT);
        obj.course = (String) row.get(TmMtevente.COURSE);
        obj.mtevent = (Integer) row.get(TmMtevente.MTEVENT);
        obj.fastl = (Integer) row.get(TmMtevente.FAST_L);
        obj.slowl = (Integer) row.get(TmMtevente.SLOW_L);
        obj.fasty = (Integer) row.get(TmMtevente.FAST_Y);
        obj.slowy = (Integer) row.get(TmMtevente.SLOW_Y);
        obj.tstdfile = (String) row.get(TmMtevente.TSTDFILE);
        obj.tstdesig = (String) row.get(TmMtevente.TSTDESIG);
        obj.distance = (Short) row.get(TmMtevente.DISTANCE);
        obj.stroke = (Short) row.get(TmMtevente.STROKE);
        obj.sex = (String) row.get(TmMtevente.SEX);
        obj.ir = (String) row.get(TmMtevente.I_R);
        obj.session = (Byte) row.get(TmMtevente.SESSION);
        obj.division = (String) row.get(TmMtevente.DIVISION);
        obj.fee = (Float) row.get(TmMtevente.FEE);
        obj.exportevent = (String) row.get(TmMtevente.EXPORTEVENT);
        obj.gendermix = (Byte) row.get(TmMtevente.GENDERMIX);
        obj.sessx = (String) row.get(TmMtevente.SESSX);
        return obj;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String MTEV = "MtEv";
    public static final String MTEVX = "MtEvX";
    public static final String LO_HI = "Lo_Hi";
    public static final String FASTCUT = "FastCut";
    public static final String SLOWCUT = "SlowCut";
    public static final String COURSE = "Course";
    public static final String MTEVENT = "MtEvent";
    public static final String FAST_L = "Fast_L";
    public static final String SLOW_L = "Slow_L";
    public static final String FAST_Y = "Fast_Y";
    public static final String SLOW_Y = "Slow_Y";
    public static final String TSTDFILE = "TstdFile";
    public static final String TSTDESIG = "TstDesig";
    public static final String DISTANCE = "Distance";
    public static final String STROKE = "Stroke";
    public static final String SEX = "Sex";
    public static final String I_R = "I_R";
    public static final String SESSION = "Session";
    public static final String DIVISION = "Division";
    public static final String FEE = "Fee";
    public static final String EXPORTEVENT = "ExportEvent";
    public static final String GENDERMIX = "GenderMix";
    public static final String SESSX = "SessX";
    // 
    // members
    //
    private Integer meet = null;
    private Short mtev = null;
    private String mtevx = null;
    private Short lohi = null;
    private Integer fastcut = null;
    private Integer slowcut = null;
    private String course = null;
    private Integer mtevent = null;
    private Integer fastl = null;
    private Integer slowl = null;
    private Integer fasty = null;
    private Integer slowy = null;
    private String tstdfile = null;
    private String tstdesig = null;
    private Short distance = null;
    private Short stroke = null;
    private String sex = null;
    private String ir = null;
    private Byte session = null;
    private String division = null;
    private Float fee = null;
    private String exportevent = null;
    private Byte gendermix = null;
    private String sessx = null;
    //
    // getters
    //
    public Integer getMeet() {
        return meet;
    }
    public Short getMtev() {
        return mtev;
    }
    public String getMtevx() {
        return mtevx;
    }
    public Short getLohi() {
        return lohi;
    }
    public Integer getFastcut() {
        return fastcut;
    }
    public Integer getSlowcut() {
        return slowcut;
    }
    public String getCourse() {
        return course;
    }
    public Integer getMtevent() {
        return mtevent;
    }
    public Integer getFastl() {
        return fastl;
    }
    public Integer getSlowl() {
        return slowl;
    }
    public Integer getFasty() {
        return fasty;
    }
    public Integer getSlowy() {
        return slowy;
    }
    public String getTstdfile() {
        return tstdfile;
    }
    public String getTstdesig() {
        return tstdesig;
    }
    public Short getDistance() {
        return distance;
    }
    public Short getStroke() {
        return stroke;
    }
    public String getSex() {
        return sex;
    }
    public String getIr() {
        return ir;
    }
    public Byte getSession() {
        return session;
    }
    public String getDivision() {
        return division;
    }
    public Float getFee() {
        return fee;
    }
    public String getExportevent() {
        return exportevent;
    }
    public Byte getGendermix() {
        return gendermix;
    }
    public String getSessx() {
        return sessx;
    }

}
/* FXML 
<TableView fx:id=tvTmMtevente" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmMteventeMeet" prefWidth="150.0" sortable="true" text="Meet" />
    <TableColumn fx:id="tcTmMteventeMtEv" prefWidth="150.0" sortable="true" text="MtEv" />
    <TableColumn fx:id="tcTmMteventeMtEvX" prefWidth="150.0" sortable="true" text="MtEvX" />
    <TableColumn fx:id="tcTmMteventeLo_Hi" prefWidth="150.0" sortable="true" text="Lo_Hi" />
    <TableColumn fx:id="tcTmMteventeFastCut" prefWidth="150.0" sortable="true" text="FastCut" />
    <TableColumn fx:id="tcTmMteventeSlowCut" prefWidth="150.0" sortable="true" text="SlowCut" />
    <TableColumn fx:id="tcTmMteventeCourse" prefWidth="150.0" sortable="true" text="Course" />
    <TableColumn fx:id="tcTmMteventeMtEvent" prefWidth="150.0" sortable="true" text="MtEvent" />
    <TableColumn fx:id="tcTmMteventeFast_L" prefWidth="150.0" sortable="true" text="Fast_L" />
    <TableColumn fx:id="tcTmMteventeSlow_L" prefWidth="150.0" sortable="true" text="Slow_L" />
    <TableColumn fx:id="tcTmMteventeFast_Y" prefWidth="150.0" sortable="true" text="Fast_Y" />
    <TableColumn fx:id="tcTmMteventeSlow_Y" prefWidth="150.0" sortable="true" text="Slow_Y" />
    <TableColumn fx:id="tcTmMteventeTstdFile" prefWidth="150.0" sortable="true" text="TstdFile" />
    <TableColumn fx:id="tcTmMteventeTstDesig" prefWidth="150.0" sortable="true" text="TstDesig" />
    <TableColumn fx:id="tcTmMteventeDistance" prefWidth="150.0" sortable="true" text="Distance" />
    <TableColumn fx:id="tcTmMteventeStroke" prefWidth="150.0" sortable="true" text="Stroke" />
    <TableColumn fx:id="tcTmMteventeSex" prefWidth="150.0" sortable="true" text="Sex" />
    <TableColumn fx:id="tcTmMteventeI_R" prefWidth="150.0" sortable="true" text="I_R" />
    <TableColumn fx:id="tcTmMteventeSession" prefWidth="150.0" sortable="true" text="Session" />
    <TableColumn fx:id="tcTmMteventeDivision" prefWidth="150.0" sortable="true" text="Division" />
    <TableColumn fx:id="tcTmMteventeFee" prefWidth="150.0" sortable="true" text="Fee" />
    <TableColumn fx:id="tcTmMteventeExportEvent" prefWidth="150.0" sortable="true" text="ExportEvent" />
    <TableColumn fx:id="tcTmMteventeGenderMix" prefWidth="150.0" sortable="true" text="GenderMix" />
    <TableColumn fx:id="tcTmMteventeSessX" prefWidth="150.0" sortable="true" text="SessX" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmMtevente> tvTmMtevente;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeMeet;
@FXML
private TableColumn<TmMtevente,Short> tcTmMteventeMtEv;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeMtEvX;
@FXML
private TableColumn<TmMtevente,Short> tcTmMteventeLo_Hi;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeFastCut;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeSlowCut;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeCourse;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeMtEvent;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeFast_L;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeSlow_L;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeFast_Y;
@FXML
private TableColumn<TmMtevente,Integer> tcTmMteventeSlow_Y;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeTstdFile;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeTstDesig;
@FXML
private TableColumn<TmMtevente,Short> tcTmMteventeDistance;
@FXML
private TableColumn<TmMtevente,Short> tcTmMteventeStroke;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeSex;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeI_R;
@FXML
private TableColumn<TmMtevente,Byte> tcTmMteventeSession;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeDivision;
@FXML
private TableColumn<TmMtevente,Float> tcTmMteventeFee;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeExportEvent;
@FXML
private TableColumn<TmMtevente,Byte> tcTmMteventeGenderMix;
@FXML
private TableColumn<TmMtevente,String> tcTmMteventeSessX;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcMeet,"Meet"),
    new Pair(tcMtEv,"MtEv"),
    new Pair(tcMtEvX,"MtEvX"),
    new Pair(tcLo_Hi,"Lo_Hi"),
    new Pair(tcFastCut,"FastCut"),
    new Pair(tcSlowCut,"SlowCut"),
    new Pair(tcCourse,"Course"),
    new Pair(tcMtEvent,"MtEvent"),
    new Pair(tcFast_L,"Fast_L"),
    new Pair(tcSlow_L,"Slow_L"),
    new Pair(tcFast_Y,"Fast_Y"),
    new Pair(tcSlow_Y,"Slow_Y"),
    new Pair(tcTstdFile,"TstdFile"),
    new Pair(tcTstDesig,"TstDesig"),
    new Pair(tcDistance,"Distance"),
    new Pair(tcStroke,"Stroke"),
    new Pair(tcSex,"Sex"),
    new Pair(tcI_R,"I_R"),
    new Pair(tcSession,"Session"),
    new Pair(tcDivision,"Division"),
    new Pair(tcFee,"Fee"),
    new Pair(tcExportEvent,"ExportEvent"),
    new Pair(tcGenderMix,"GenderMix"),
    new Pair(tcSessX,"SessX")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
