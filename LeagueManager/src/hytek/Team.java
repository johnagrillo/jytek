package hytek;

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
 * [MailTo]			Text (80),
 * [TAddr]			Text (60),
 * [TCity]			Text (60),
 * [TState]			Text (6),
 * [TZip]			Text (20),
 * [TCntry]			Text (6),
 * [Day]			Text (40),
 * [Eve]			Text (40),
 * [Fax]			Text (40),
 * [TType]			Text (6),
 * [Regn]			Text (2),
 * [Reg]			Text (8),
 * [MinAge]			Integer,
 * [NumAth]			Long Integer,
 * [EMail]			Text (72),
 * [TM50]			Boolean NOT NULL,
 * [TDivision]			Text (6)
 * );
 */
public class Team {

    public static String NAME = "Team";
    private Team() {
    }

    public Team(final com.healthmarketscience.jackcess.Row row){

        team = (Integer) row.get(Team.TEAM);
        tcode = (String) row.get(Team.TCODE);
        tname = (String) row.get(Team.TNAME);
        shortn = (String) row.get(Team.SHORTN);
        lsc = (String) row.get(Team.LSC);
        mailto = (String) row.get(Team.MAILTO);
        taddr = (String) row.get(Team.TADDR);
        tcity = (String) row.get(Team.TCITY);
        tstate = (String) row.get(Team.TSTATE);
        tzip = (String) row.get(Team.TZIP);
        tcntry = (String) row.get(Team.TCNTRY);
        day = (String) row.get(Team.DAY);
        eve = (String) row.get(Team.EVE);
        fax = (String) row.get(Team.FAX);
        ttype = (String) row.get(Team.TTYPE);
        regn = (String) row.get(Team.REGN);
        reg = (String) row.get(Team.REG);
        minage = (Short) row.get(Team.MINAGE);
        numath = (Integer) row.get(Team.NUMATH);
        email = (String) row.get(Team.EMAIL);
        tm50 = (Boolean) row.get(Team.TM50);
        tdivision = (String) row.get(Team.TDIVISION);
    }


    public static final String TEAM = "Team";
    public static final String TCODE = "TCode";
    public static final String TNAME = "TName";
    public static final String SHORTN = "shortN";
    public static final String LSC = "LSC";
    public static final String MAILTO = "MailTo";
    public static final String TADDR = "TAddr";
    public static final String TCITY = "TCity";
    public static final String TSTATE = "TState";
    public static final String TZIP = "TZip";
    public static final String TCNTRY = "TCntry";
    public static final String DAY = "Day";
    public static final String EVE = "Eve";
    public static final String FAX = "Fax";
    public static final String TTYPE = "TType";
    public static final String REGN = "Regn";
    public static final String REG = "Reg";
    public static final String MINAGE = "MinAge";
    public static final String NUMATH = "NumAth";
    public static final String EMAIL = "EMail";
    public static final String TM50 = "TM50";
    public static final String TDIVISION = "TDivision";
    private Integer team = null;
    private String tcode = null;
    private String tname = null;
    private String shortn = null;
    private String lsc = null;
    private String mailto = null;
    private String taddr = null;
    private String tcity = null;
    private String tstate = null;
    private String tzip = null;
    private String tcntry = null;
    private String day = null;
    private String eve = null;
    private String fax = null;
    private String ttype = null;
    private String regn = null;
    private String reg = null;
    private Short minage = null;
    private Integer numath = null;
    private String email = null;
    private Boolean tm50 = null;
    private String tdivision = null;
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
    public String getMailto() {
        return mailto;
    }
    public String getTaddr() {
        return taddr;
    }
    public String getTcity() {
        return tcity;
    }
    public String getTstate() {
        return tstate;
    }
    public String getTzip() {
        return tzip;
    }
    public String getTcntry() {
        return tcntry;
    }
    public String getDay() {
        return day;
    }
    public String getEve() {
        return eve;
    }
    public String getFax() {
        return fax;
    }
    public String getTtype() {
        return ttype;
    }
    public String getRegn() {
        return regn;
    }
    public String getReg() {
        return reg;
    }
    public Short getMinage() {
        return minage;
    }
    public Integer getNumath() {
        return numath;
    }
    public String getEmail() {
        return email;
    }
    public Boolean getTm50() {
        return tm50;
    }
    public String getTdivision() {
        return tdivision;
    }
}
