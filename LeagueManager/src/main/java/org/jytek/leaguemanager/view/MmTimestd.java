package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [TimeStd]
 * (
 * [tag_ptr]			Long Integer,
 * [tag_gender]			Text (2),
 * [tag_indrel]			Text (2),
 * [tag_dist]			Long Integer,
 * [tag_stroke]			Text (2),
 * [low_age]			Integer,
 * [high_Age]			Integer,
 * [tag_time]			Single,
 * [tag_course]			Text (2),
 * [div_abbr]			Text (20)
 * );
 */
public class MmTimestd implements KeyValue<Integer, MmTimestd> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Timestd";

    /**
     * Private Constructor
     **/
    private MmTimestd() {
    }

    /**
     * Read MmTimestd object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmTimestd
     **/
    public static MmTimestd read(final Row row){
        final var obj = new MmTimestd();
        obj.tagPtr = (Integer) row.get(MmTimestd.TAG_PTR);
        obj.tagGender = (String) row.get(MmTimestd.TAG_GENDER);
        obj.tagIndrel = (String) row.get(MmTimestd.TAG_INDREL);
        obj.tagDist = (Integer) row.get(MmTimestd.TAG_DIST);
        obj.tagStroke = (String) row.get(MmTimestd.TAG_STROKE);
        obj.lowAge = (Short) row.get(MmTimestd.LOW_AGE);
        obj.highAge = (Short) row.get(MmTimestd.HIGH_AGE);
        obj.tagTime = (Float) row.get(MmTimestd.TAG_TIME);
        obj.tagCourse = (String) row.get(MmTimestd.TAG_COURSE);
        obj.divAbbr = (String) row.get(MmTimestd.DIV_ABBR);
        return obj;
    }

    public MmTimestd getValue(){
        return this;
    }

    public Integer getKey(){
        return tagPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String TAG_PTR = "tag_ptr";
    public static final String TAG_GENDER = "tag_gender";
    public static final String TAG_INDREL = "tag_indrel";
    public static final String TAG_DIST = "tag_dist";
    public static final String TAG_STROKE = "tag_stroke";
    public static final String LOW_AGE = "low_age";
    public static final String HIGH_AGE = "high_Age";
    public static final String TAG_TIME = "tag_time";
    public static final String TAG_COURSE = "tag_course";
    public static final String DIV_ABBR = "div_abbr";
    // 
    // members
    //
    private Integer tagPtr = null;
    private String tagGender = null;
    private String tagIndrel = null;
    private Integer tagDist = null;
    private String tagStroke = null;
    private Short lowAge = null;
    private Short highAge = null;
    private Float tagTime = null;
    private String tagCourse = null;
    private String divAbbr = null;

    //
    // getters
    //

    /**
     * Getter for tagPtr
     * @return Integer
     */
    public Integer gettagPtr() {
        return tagPtr;
    }

    /**
     * Getter for tagGender
     * @return String
     */
    public String gettagGender() {
        return tagGender;
    }

    /**
     * Getter for tagIndrel
     * @return String
     */
    public String gettagIndrel() {
        return tagIndrel;
    }

    /**
     * Getter for tagDist
     * @return Integer
     */
    public Integer gettagDist() {
        return tagDist;
    }

    /**
     * Getter for tagStroke
     * @return String
     */
    public String gettagStroke() {
        return tagStroke;
    }

    /**
     * Getter for lowAge
     * @return Short
     */
    public Short getlowAge() {
        return lowAge;
    }

    /**
     * Getter for highAge
     * @return Short
     */
    public Short gethighAge() {
        return highAge;
    }

    /**
     * Getter for tagTime
     * @return Float
     */
    public Float gettagTime() {
        return tagTime;
    }

    /**
     * Getter for tagCourse
     * @return String
     */
    public String gettagCourse() {
        return tagCourse;
    }

    /**
     * Getter for divAbbr
     * @return String
     */
    public String getdivAbbr() {
        return divAbbr;
    }
}
/* FXML 
<TableView fx:id=tvMmTimestd" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmTimestdtag_ptr" prefWidth="150.0" sortable="true" text="tag_ptr" />
    <TableColumn fx:id="tcMmTimestdtag_gender" prefWidth="150.0" sortable="true" text="tag_gender" />
    <TableColumn fx:id="tcMmTimestdtag_indrel" prefWidth="150.0" sortable="true" text="tag_indrel" />
    <TableColumn fx:id="tcMmTimestdtag_dist" prefWidth="150.0" sortable="true" text="tag_dist" />
    <TableColumn fx:id="tcMmTimestdtag_stroke" prefWidth="150.0" sortable="true" text="tag_stroke" />
    <TableColumn fx:id="tcMmTimestdlow_age" prefWidth="150.0" sortable="true" text="low_age" />
    <TableColumn fx:id="tcMmTimestdhigh_Age" prefWidth="150.0" sortable="true" text="high_Age" />
    <TableColumn fx:id="tcMmTimestdtag_time" prefWidth="150.0" sortable="true" text="tag_time" />
    <TableColumn fx:id="tcMmTimestdtag_course" prefWidth="150.0" sortable="true" text="tag_course" />
    <TableColumn fx:id="tcMmTimestddiv_abbr" prefWidth="150.0" sortable="true" text="div_abbr" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmTimestd> tvMmTimestd;
@FXML
private TableColumn<MmTimestd,Integer> tcMmTimestdtag_ptr;
@FXML
private TableColumn<MmTimestd,String> tcMmTimestdtag_gender;
@FXML
private TableColumn<MmTimestd,String> tcMmTimestdtag_indrel;
@FXML
private TableColumn<MmTimestd,Integer> tcMmTimestdtag_dist;
@FXML
private TableColumn<MmTimestd,String> tcMmTimestdtag_stroke;
@FXML
private TableColumn<MmTimestd,Short> tcMmTimestdlow_age;
@FXML
private TableColumn<MmTimestd,Short> tcMmTimestdhigh_Age;
@FXML
private TableColumn<MmTimestd,Float> tcMmTimestdtag_time;
@FXML
private TableColumn<MmTimestd,String> tcMmTimestdtag_course;
@FXML
private TableColumn<MmTimestd,String> tcMmTimestddiv_abbr;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tctag_ptr,"tag_ptr"),
    new Pair(tctag_gender,"tag_gender"),
    new Pair(tctag_indrel,"tag_indrel"),
    new Pair(tctag_dist,"tag_dist"),
    new Pair(tctag_stroke,"tag_stroke"),
    new Pair(tclow_age,"low_age"),
    new Pair(tchigh_Age,"high_Age"),
    new Pair(tctag_time,"tag_time"),
    new Pair(tctag_course,"tag_course"),
    new Pair(tcdiv_abbr,"div_abbr")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
