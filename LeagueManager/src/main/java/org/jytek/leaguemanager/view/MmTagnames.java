package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [TagNames]
 * (
 * [tag_ptr]			Long Integer,
 * [tag_name]			Text (8),
 * [for_scoring]			Boolean NOT NULL,
 * [for_entryqual]			Boolean NOT NULL,
 * [for_timestd]			Boolean NOT NULL,
 * [tag_desc]			Text (40)
 * );
 */
public class MmTagnames implements KeyValue<Integer, MmTagnames> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Tagnames";

    /**
     * Private Constructor
     **/
    private MmTagnames() {
    }

    /**
     * Read MmTagnames object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmTagnames
     **/
    public static MmTagnames read(final Row row){
        final var obj = new MmTagnames();
        obj.tagPtr = (Integer) row.get(MmTagnames.TAG_PTR);
        obj.tagName = (String) row.get(MmTagnames.TAG_NAME);
        obj.forScoring = (Boolean) row.get(MmTagnames.FOR_SCORING);
        obj.forEntryqual = (Boolean) row.get(MmTagnames.FOR_ENTRYQUAL);
        obj.forTimestd = (Boolean) row.get(MmTagnames.FOR_TIMESTD);
        obj.tagDesc = (String) row.get(MmTagnames.TAG_DESC);
        return obj;
    }

    public MmTagnames getValue(){
        return this;
    }

    public Integer getKey(){
        return tagPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String TAG_PTR = "tag_ptr";
    public static final String TAG_NAME = "tag_name";
    public static final String FOR_SCORING = "for_scoring";
    public static final String FOR_ENTRYQUAL = "for_entryqual";
    public static final String FOR_TIMESTD = "for_timestd";
    public static final String TAG_DESC = "tag_desc";
    // 
    // members
    //
    private Integer tagPtr = null;
    private String tagName = null;
    private Boolean forScoring = null;
    private Boolean forEntryqual = null;
    private Boolean forTimestd = null;
    private String tagDesc = null;

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
     * Getter for tagName
     * @return String
     */
    public String gettagName() {
        return tagName;
    }

    /**
     * Getter for forScoring
     * @return Boolean
     */
    public Boolean getforScoring() {
        return forScoring;
    }

    /**
     * Getter for forEntryqual
     * @return Boolean
     */
    public Boolean getforEntryqual() {
        return forEntryqual;
    }

    /**
     * Getter for forTimestd
     * @return Boolean
     */
    public Boolean getforTimestd() {
        return forTimestd;
    }

    /**
     * Getter for tagDesc
     * @return String
     */
    public String gettagDesc() {
        return tagDesc;
    }
}
/* FXML 
<TableView fx:id=tvMmTagnames" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmTagnamestag_ptr" prefWidth="150.0" sortable="true" text="tag_ptr" />
    <TableColumn fx:id="tcMmTagnamestag_name" prefWidth="150.0" sortable="true" text="tag_name" />
    <TableColumn fx:id="tcMmTagnamesfor_scoring" prefWidth="150.0" sortable="true" text="for_scoring" />
    <TableColumn fx:id="tcMmTagnamesfor_entryqual" prefWidth="150.0" sortable="true" text="for_entryqual" />
    <TableColumn fx:id="tcMmTagnamesfor_timestd" prefWidth="150.0" sortable="true" text="for_timestd" />
    <TableColumn fx:id="tcMmTagnamestag_desc" prefWidth="150.0" sortable="true" text="tag_desc" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmTagnames> tvMmTagnames;
@FXML
private TableColumn<MmTagnames,Integer> tcMmTagnamestag_ptr;
@FXML
private TableColumn<MmTagnames,String> tcMmTagnamestag_name;
@FXML
private TableColumn<MmTagnames,Boolean> tcMmTagnamesfor_scoring;
@FXML
private TableColumn<MmTagnames,Boolean> tcMmTagnamesfor_entryqual;
@FXML
private TableColumn<MmTagnames,Boolean> tcMmTagnamesfor_timestd;
@FXML
private TableColumn<MmTagnames,String> tcMmTagnamestag_desc;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tctag_ptr,"tag_ptr"),
    new Pair(tctag_name,"tag_name"),
    new Pair(tcfor_scoring,"for_scoring"),
    new Pair(tcfor_entryqual,"for_entryqual"),
    new Pair(tcfor_timestd,"for_timestd"),
    new Pair(tctag_desc,"tag_desc")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
