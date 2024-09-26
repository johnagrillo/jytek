package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [RecordTags]
 * (
 * [tag_ptr]			Long Integer,
 * [tag_order]			Integer,
 * [tag_name]			Text (24),
 * [tag_flag]			Text (2),
 * [team_no]			Long Integer,
 * [allow_exh]			Boolean NOT NULL,
 * [allow_foreigner]			Boolean NOT NULL,
 * [tag_lsc]			Text (6)
 * );
 */
public class MmRecordtags implements KeyValue<Integer, MmRecordtags> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Recordtags";

    /**
     * Private Constructor
     **/
    private MmRecordtags() {
    }

    /**
     * Read MmRecordtags object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmRecordtags
     **/
    public static MmRecordtags read(final Row row){
        final var obj = new MmRecordtags();
        obj.tagPtr = (Integer) row.get(MmRecordtags.TAG_PTR);
        obj.tagOrder = (Short) row.get(MmRecordtags.TAG_ORDER);
        obj.tagName = (String) row.get(MmRecordtags.TAG_NAME);
        obj.tagFlag = (String) row.get(MmRecordtags.TAG_FLAG);
        obj.teamNo = (Integer) row.get(MmRecordtags.TEAM_NO);
        obj.allowExh = (Boolean) row.get(MmRecordtags.ALLOW_EXH);
        obj.allowForeigner = (Boolean) row.get(MmRecordtags.ALLOW_FOREIGNER);
        obj.tagLsc = (String) row.get(MmRecordtags.TAG_LSC);
        return obj;
    }

    public MmRecordtags getValue(){
        return this;
    }

    public Integer getKey(){
        return tagPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String TAG_PTR = "tag_ptr";
    public static final String TAG_ORDER = "tag_order";
    public static final String TAG_NAME = "tag_name";
    public static final String TAG_FLAG = "tag_flag";
    public static final String TEAM_NO = "team_no";
    public static final String ALLOW_EXH = "allow_exh";
    public static final String ALLOW_FOREIGNER = "allow_foreigner";
    public static final String TAG_LSC = "tag_lsc";
    // 
    // members
    //
    private Integer tagPtr = null;
    private Short tagOrder = null;
    private String tagName = null;
    private String tagFlag = null;
    private Integer teamNo = null;
    private Boolean allowExh = null;
    private Boolean allowForeigner = null;
    private String tagLsc = null;

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
     * Getter for tagOrder
     * @return Short
     */
    public Short gettagOrder() {
        return tagOrder;
    }

    /**
     * Getter for tagName
     * @return String
     */
    public String gettagName() {
        return tagName;
    }

    /**
     * Getter for tagFlag
     * @return String
     */
    public String gettagFlag() {
        return tagFlag;
    }

    /**
     * Getter for teamNo
     * @return Integer
     */
    public Integer getteamNo() {
        return teamNo;
    }

    /**
     * Getter for allowExh
     * @return Boolean
     */
    public Boolean getallowExh() {
        return allowExh;
    }

    /**
     * Getter for allowForeigner
     * @return Boolean
     */
    public Boolean getallowForeigner() {
        return allowForeigner;
    }

    /**
     * Getter for tagLsc
     * @return String
     */
    public String gettagLsc() {
        return tagLsc;
    }
}
/* FXML 
<TableView fx:id=tvMmRecordtags" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmRecordtagstag_ptr" prefWidth="150.0" sortable="true" text="tag_ptr" />
    <TableColumn fx:id="tcMmRecordtagstag_order" prefWidth="150.0" sortable="true" text="tag_order" />
    <TableColumn fx:id="tcMmRecordtagstag_name" prefWidth="150.0" sortable="true" text="tag_name" />
    <TableColumn fx:id="tcMmRecordtagstag_flag" prefWidth="150.0" sortable="true" text="tag_flag" />
    <TableColumn fx:id="tcMmRecordtagsteam_no" prefWidth="150.0" sortable="true" text="team_no" />
    <TableColumn fx:id="tcMmRecordtagsallow_exh" prefWidth="150.0" sortable="true" text="allow_exh" />
    <TableColumn fx:id="tcMmRecordtagsallow_foreigner" prefWidth="150.0" sortable="true" text="allow_foreigner" />
    <TableColumn fx:id="tcMmRecordtagstag_lsc" prefWidth="150.0" sortable="true" text="tag_lsc" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmRecordtags> tvMmRecordtags;
@FXML
private TableColumn<MmRecordtags,Integer> tcMmRecordtagstag_ptr;
@FXML
private TableColumn<MmRecordtags,Short> tcMmRecordtagstag_order;
@FXML
private TableColumn<MmRecordtags,String> tcMmRecordtagstag_name;
@FXML
private TableColumn<MmRecordtags,String> tcMmRecordtagstag_flag;
@FXML
private TableColumn<MmRecordtags,Integer> tcMmRecordtagsteam_no;
@FXML
private TableColumn<MmRecordtags,Boolean> tcMmRecordtagsallow_exh;
@FXML
private TableColumn<MmRecordtags,Boolean> tcMmRecordtagsallow_foreigner;
@FXML
private TableColumn<MmRecordtags,String> tcMmRecordtagstag_lsc;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tctag_ptr,"tag_ptr"),
    new Pair(tctag_order,"tag_order"),
    new Pair(tctag_name,"tag_name"),
    new Pair(tctag_flag,"tag_flag"),
    new Pair(tcteam_no,"team_no"),
    new Pair(tcallow_exh,"allow_exh"),
    new Pair(tcallow_foreigner,"allow_foreigner"),
    new Pair(tctag_lsc,"tag_lsc")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
