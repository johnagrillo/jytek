package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [TEAM]
 * (
 * [Team]			Long Integer,
 * [TCode]			Text (10),
 * [TName]			Text (60),
 * [Short]			Text (32),
 * );
 */
public class TmTeam implements KeyValue<Integer, TmTeam> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Team";

    /**
     * Private Constructor
     **/
    private TmTeam() {
    }

    /**
     * Read TmTeam object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return TmTeam
     **/
    public static TmTeam read(final Row row){
        final var obj = new TmTeam();
        obj.team = (Integer) row.get(TmTeam.TEAM);
        obj.tcode = (String) row.get(TmTeam.TCODE);
        obj.tname = (String) row.get(TmTeam.TNAME);
        obj.short_ = (String) row.get(TmTeam.SHORT);
        return obj;
    }

    public TmTeam getValue(){
        return this;
    }

    public Integer getKey(){
        return team;
    }


    // 
    // Column names
    //
    public static final String TEAM = "Team";
    public static final String TCODE = "TCode";
    public static final String TNAME = "TName";
    public static final String SHORT = "Short";
    // 
    // members
    //
    private Integer team = null;
    private String tcode = null;
    private String tname = null;
    private String short_ = null;

    //
    // getters
    //

    /**
     * Getter for Team
     * @return Integer
     */
    public Integer getTeam() {
        return team;
    }

    /**
     * Getter for TCode
     * @return String
     */
    public String getTcode() {
        return tcode;
    }

    /**
     * Getter for TName
     * @return String
     */
    public String getTname() {
        return tname;
    }

    /**
     * Getter for short_
     * @return String
     */
    public String getShort_() {
        return short_;
    }
}
/* FXML 
<TableView fx:id=tvTmTeam" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTmTeamTeam" prefWidth="150.0" sortable="true" text="Team" />
    <TableColumn fx:id="tcTmTeamTCode" prefWidth="150.0" sortable="true" text="TCode" />
    <TableColumn fx:id="tcTmTeamTName" prefWidth="150.0" sortable="true" text="TName" />
    <TableColumn fx:id="tcTmTeamShort" prefWidth="150.0" sortable="true" text="Short" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmTeam> tvTmTeam;
@FXML
private TableColumn<TmTeam,Integer> tcTmTeamTeam;
@FXML
private TableColumn<TmTeam,String> tcTmTeamTCode;
@FXML
private TableColumn<TmTeam,String> tcTmTeamTName;
@FXML
private TableColumn<TmTeam,String> tcTmTeamShort;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcTeam,"Team"),
    new Pair(tcTCode,"TCode"),
    new Pair(tcTName,"TName"),
    new Pair(tcShort,"Short")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
