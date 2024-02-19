package org.jytek.leaguemanager.view;

import java.util.*;

/**
 * -- ----------------------------------------------------------
 * -- MDB Tools - A library for reading MS Access database files
 * -- Copyright (C) 2000-2011 Brian Bruns and others.
 * -- Files in libmdb are licensed under LGPL and the utilities under
 * -- the GPL, see COPYING.LIB and COPYING files respectively.
 * -- Check out http://mdbtools.sourceforge.net
 * -- ----------------------------------------------------------
 * 
 * -- That file uses encoding UTF-8
 * 
 * CREATE TABLE [TEAM]
 * (
 * [Team]			Long Integer,
 * [TCode]			Text (10),
 * [TName]			Text (60),
 * [Short]			Text (32),
 * #	[LSC]			Text (6),
 * #	[MailTo]			Text (80),
 * #	[TAddr]			Text (60),
 * #	[TCity]			Text (60),
 * #	[TState]			Text (6),
 * #	[TZip]			Text (20),
 * #	[TCntry]			Text (6),
 * #	[Day]			Text (40),
 * #	[Eve]			Text (40),
 * #	[Fax]			Text (40),
 * #	[TType]			Text (6),
 * #	[Regn]			Text (2),
 * #	[Reg]			Text (8),
 * #	[MinAge]			Integer,
 * #	[NumAth]			Long Integer,
 * #	[EMail]			Text (72),
 * #	[TM50]			Boolean NOT NULL,
 * #	[TDivision]			Text (6)
 * );
 */
public class TmTeam {

    public static String NAME = "Team";
    private TmTeam() {
    }

    public static TmTeam create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmTeam();
        obj.team = (Integer) row.get(TmTeam.TEAM);
        obj.tcode = (String) row.get(TmTeam.TCODE);
        obj.tname = (String) row.get(TmTeam.TNAME);
        obj.shortn = (String) row.get(TmTeam.SHORTN);
    return obj;
    }


    // 
    // Column names
    //
    public static final String TEAM = "Team";
    public static final String TCODE = "TCode";
    public static final String TNAME = "TName";
    public static final String SHORTN = "shortN";
    // 
    // members
    //
    private Integer team = null;
    private String tcode = null;
    private String tname = null;
    private String shortn = null;
    //
    // getters
    //
    public Integer getTeam() {
        return team;
    }
    public String getTcode() {
        return tcode;
    }
    public String getTname() {
        return tname;
    }
    public String getShortn() {
        return shortn;
    }


    private List<TmAthlete> athletes = new ArrayList<>();

    private List<TmRelay> relays = new ArrayList<>();

    public List<TmAthlete> getAthletes() {
        return this.athletes;
    }
    public void add(TmAthlete ath){
        athletes.add(ath);
    }
    public void add(TmRelay relay){
        relays.add(relay);
    }

    public List<TmRelay> getRelays() {
        return this.relays;
    }

}
/* FXML 
<TableView fx:id=tvTmTeams" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcTeam" prefWidth="150.0" sortable="false" text="Team" />
    <TableColumn fx:id="tcTCode" prefWidth="150.0" sortable="false" text="TCode" />
    <TableColumn fx:id="tcTName" prefWidth="150.0" sortable="false" text="TName" />
    <TableColumn fx:id="tcshortN" prefWidth="150.0" sortable="false" text="shortN" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<TmTeam> tcTmTeam
@FXML
private TableColumn<TmTeam,Integer> tcTeam;
@FXML
private TableColumn<TmTeam,String> tcTCode;
@FXML
private TableColumn<TmTeam,String> tcTName;
@FXML
private TableColumn<TmTeam,String> tcshortN;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcTeam,"Team"),
    new Pair(tcTCode,"TCode"),
    new Pair(tcTName,"TName"),
    new Pair(tcshortN,"shortN")
)) {
 pair.getKey().setCellValueFactory(new PropertyValaueFactory<>(pair.getValue()));  }
*/
