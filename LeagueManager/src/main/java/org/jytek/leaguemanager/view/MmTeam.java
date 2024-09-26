package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Team]
 * (
 * [Team_no]			Long Integer,
 * [Team_name]			Text (60),
 * [Team_short]			Text (32),
 * [Team_abbr]			Text (10),
 * );
 */
public class MmTeam implements KeyValue<Integer, MmTeam> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Team";

    /**
     * Private Constructor
     **/
    private MmTeam() {
    }

    /**
     * Read MmTeam object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmTeam
     **/
    public static MmTeam read(final Row row){
        final var obj = new MmTeam();
        obj.teamNo = (Integer) row.get(MmTeam.TEAM_NO);
        obj.teamName = (String) row.get(MmTeam.TEAM_NAME);
        obj.teamShort = (String) row.get(MmTeam.TEAM_SHORT);
        obj.teamAbbr = (String) row.get(MmTeam.TEAM_ABBR);
        return obj;
    }

    public MmTeam getValue(){
        return this;
    }

    public Integer getKey(){
        return teamNo.hashCode();
    }


    // 
    // Column names
    //
    public static final String TEAM_NO = "Team_no";
    public static final String TEAM_NAME = "Team_name";
    public static final String TEAM_SHORT = "Team_short";
    public static final String TEAM_ABBR = "Team_abbr";
    // 
    // members
    //
    private Integer teamNo = null;
    private String teamName = null;
    private String teamShort = null;
    private String teamAbbr = null;

    //
    // getters
    //

    /**
     * Getter for TeamNo
     * @return Integer
     */
    public Integer getTeamNo() {
        return teamNo;
    }

    /**
     * Getter for TeamName
     * @return String
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Getter for TeamShort
     * @return String
     */
    public String getTeamShort() {
        return teamShort;
    }

    /**
     * Getter for TeamAbbr
     * @return String
     */
    public String getTeamAbbr() {
        return teamAbbr;
    }
}
/* FXML 
<TableView fx:id=tvMmTeam" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmTeamTeam_no" prefWidth="150.0" sortable="true" text="Team_no" />
    <TableColumn fx:id="tcMmTeamTeam_name" prefWidth="150.0" sortable="true" text="Team_name" />
    <TableColumn fx:id="tcMmTeamTeam_short" prefWidth="150.0" sortable="true" text="Team_short" />
    <TableColumn fx:id="tcMmTeamTeam_abbr" prefWidth="150.0" sortable="true" text="Team_abbr" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmTeam> tvMmTeam;
@FXML
private TableColumn<MmTeam,Integer> tcMmTeamTeam_no;
@FXML
private TableColumn<MmTeam,String> tcMmTeamTeam_name;
@FXML
private TableColumn<MmTeam,String> tcMmTeamTeam_short;
@FXML
private TableColumn<MmTeam,String> tcMmTeamTeam_abbr;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcTeam_no,"Team_no"),
    new Pair(tcTeam_name,"Team_name"),
    new Pair(tcTeam_short,"Team_short"),
    new Pair(tcTeam_abbr,"Team_abbr")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
