package org.jytek.leaguemanager.view;

import java.util.ArrayList;
import java.util.List;

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
 * [LSC]			Text (6),
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
        obj.lsc = (String) row.get(TmTeam.LSC);


        obj.athletes = new ArrayList<>();
        obj.relays = new ArrayList<>();


        return obj;
    }


    // 
    // Column names
    //
    public static final String TEAM = "Team";
    public static final String TCODE = "TCode";
    public static final String TNAME = "TName";
    public static final String SHORTN = "shortN";
    public static final String LSC = "LSC";
    // 
    // members
    //
    private Integer team = null;
    private String tcode = null;
    private String tname = null;
    private String shortn = null;
    private String lsc = null;
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
    public String getLsc() {
        return lsc;
    }





    private List<TmAthlete> athletes;

    private List<TmRelay> relays;

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
