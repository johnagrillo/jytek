package hytek.tm;

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
 * CREATE TABLE [Athlete]
 * (
 * [Athlete]			Long Integer,
 * [Team1]			Long Integer,
 * [Team2]			Long Integer,
 * [Team3]			Long Integer,
 * [Group]			Text (6),
 * [SubGr]			Text (6),
 * [Last]			Text (40),
 * [First]			Text (40),
 * [Initial]			Text (2),
 * [Sex]			Text (2),
 * [Birth]			DateTime,
 * [Age]			Integer,
 * [Class]			Text (6),
 * [ID_NO]			Text (34),
 * [Citizen]			Text (6),
 * [Inactive]			Boolean NOT NULL,
 * [Pref]			Text (40),
 * [Batch]			Integer,
 * [WMGroup]			Text (6),
 * [WMSubGr]			Text (6),
 * [BCSSASwimmer]			Text (4),
 * [BCSSADiver]			Text (4),
 * [BCSSASyncro]			Text (4),
 * [BCSSAPolo]			Text (4),
 * [TheSort]			Long Integer,
 * [DiveCertified]			Boolean NOT NULL,
 * [DateClubJoined]			DateTime,
 * [DateGroupJoined]			DateTime,
 * [AWRegType]			Text (2),
 * [RegYear]			Integer,
 * [Foreign]			Boolean NOT NULL,
 * [ForeignCitizenOf]			Text (6),
 * [LastUpdated]			DateTime,
 * [PC_Hide]			Boolean NOT NULL
 * );
 */
public class Athlete {

    public static String NAME = "Athlete";
    private Athlete() {
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athlete=" + athlete +
                ", team1=" + team1 +
                ", last='" + last + '\'' +
                ", first='" + first + '\'' +
                ", initial='" + initial + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                '}';
    }

    public Athlete(final com.healthmarketscience.jackcess.Row row){

        athlete = (Integer) row.get(Athlete.ATHLETE);
        team1 = (Integer) row.get(Athlete.TEAM1);
        team2 = (Integer) row.get(Athlete.TEAM2);
        team3 = (Integer) row.get(Athlete.TEAM3);
        group = (String) row.get(Athlete.GROUP);
        subgr = (String) row.get(Athlete.SUBGR);
        last = (String) row.get(Athlete.LAST);
        first = (String) row.get(Athlete.FIRST);
        initial = (String) row.get(Athlete.INITIAL);
        sex = (String) row.get(Athlete.SEX);
        birth = (java.time.LocalDateTime) row.get(Athlete.BIRTH);
        age = (Short) row.get(Athlete.AGE);
        classn = (String) row.get(Athlete.CLASSN);
        id_no = (String) row.get(Athlete.ID_NO);
        citizen = (String) row.get(Athlete.CITIZEN);
        inactive = (Boolean) row.get(Athlete.INACTIVE);
        pref = (String) row.get(Athlete.PREF);
        batch = (Short) row.get(Athlete.BATCH);
        wmgroup = (String) row.get(Athlete.WMGROUP);
        wmsubgr = (String) row.get(Athlete.WMSUBGR);
        bcssaswimmer = (String) row.get(Athlete.BCSSASWIMMER);
        bcssadiver = (String) row.get(Athlete.BCSSADIVER);
        bcssasyncro = (String) row.get(Athlete.BCSSASYNCRO);
        bcssapolo = (String) row.get(Athlete.BCSSAPOLO);
        thesort = (Integer) row.get(Athlete.THESORT);
        divecertified = (Boolean) row.get(Athlete.DIVECERTIFIED);
        dateclubjoined = (java.time.LocalDateTime) row.get(Athlete.DATECLUBJOINED);
        dategroupjoined = (java.time.LocalDateTime) row.get(Athlete.DATEGROUPJOINED);
        awregtype = (String) row.get(Athlete.AWREGTYPE);
        regyear = (Short) row.get(Athlete.REGYEAR);
        foreign = (Boolean) row.get(Athlete.FOREIGN);
        foreigncitizenof = (String) row.get(Athlete.FOREIGNCITIZENOF);
        lastupdated = (java.time.LocalDateTime) row.get(Athlete.LASTUPDATED);
        pc_hide = (Boolean) row.get(Athlete.PC_HIDE);
    }


    public static final String ATHLETE = "Athlete";
    public static final String TEAM1 = "Team1";
    public static final String TEAM2 = "Team2";
    public static final String TEAM3 = "Team3";
    public static final String GROUP = "Group";
    public static final String SUBGR = "SubGr";
    public static final String LAST = "Last";
    public static final String FIRST = "First";
    public static final String INITIAL = "Initial";
    public static final String SEX = "Sex";
    public static final String BIRTH = "Birth";
    public static final String AGE = "Age";
    public static final String CLASSN = "classN";
    public static final String ID_NO = "ID_NO";
    public static final String CITIZEN = "Citizen";
    public static final String INACTIVE = "Inactive";
    public static final String PREF = "Pref";
    public static final String BATCH = "Batch";
    public static final String WMGROUP = "WMGroup";
    public static final String WMSUBGR = "WMSubGr";
    public static final String BCSSASWIMMER = "BCSSASwimmer";
    public static final String BCSSADIVER = "BCSSADiver";
    public static final String BCSSASYNCRO = "BCSSASyncro";
    public static final String BCSSAPOLO = "BCSSAPolo";
    public static final String THESORT = "TheSort";
    public static final String DIVECERTIFIED = "DiveCertified";
    public static final String DATECLUBJOINED = "DateClubJoined";
    public static final String DATEGROUPJOINED = "DateGroupJoined";
    public static final String AWREGTYPE = "AWRegType";
    public static final String REGYEAR = "RegYear";
    public static final String FOREIGN = "Foreign";
    public static final String FOREIGNCITIZENOF = "ForeignCitizenOf";
    public static final String LASTUPDATED = "LastUpdated";
    public static final String PC_HIDE = "PC_Hide";
    private Integer athlete = null;
    private Integer team1 = null;
    private Integer team2 = null;
    private Integer team3 = null;
    private String group = null;
    private String subgr = null;
    private String last = null;
    private String first = null;
    private String initial = null;
    private String sex = null;
    private java.time.LocalDateTime birth = null;
    private Short age = null;
    private String classn = null;
    private String id_no = null;
    private String citizen = null;
    private Boolean inactive = null;
    private String pref = null;
    private Short batch = null;
    private String wmgroup = null;
    private String wmsubgr = null;
    private String bcssaswimmer = null;
    private String bcssadiver = null;
    private String bcssasyncro = null;
    private String bcssapolo = null;
    private Integer thesort = null;
    private Boolean divecertified = null;
    private java.time.LocalDateTime dateclubjoined = null;
    private java.time.LocalDateTime dategroupjoined = null;
    private String awregtype = null;
    private Short regyear = null;
    private Boolean foreign = null;
    private String foreigncitizenof = null;
    private java.time.LocalDateTime lastupdated = null;
    private Boolean pc_hide = null;
    public Integer getAthlete() {
        return athlete;
    }
    public Integer getTeam1() {
        return team1;
    }
    public Integer getTeam2() {
        return team2;
    }
    public Integer getTeam3() {
        return team3;
    }
    public String getGroup() {
        return group;
    }
    public String getSubgr() {
        return subgr;
    }
    public String getLast() {
        return last;
    }
    public String getFirst() {
        return first;
    }
    public String getInitial() {
        return initial;
    }
    public String getSex() {
        return sex;
    }
    public java.time.LocalDateTime getBirth() {
        return birth;
    }
    public Short getAge() {
        return age;
    }
    public String getClassn() {
        return classn;
    }
    public String getId_no() {
        return id_no;
    }
    public String getCitizen() {
        return citizen;
    }
    public Boolean getInactive() {
        return inactive;
    }
    public String getPref() {
        return pref;
    }
    public Short getBatch() {
        return batch;
    }
    public String getWmgroup() {
        return wmgroup;
    }
    public String getWmsubgr() {
        return wmsubgr;
    }
    public String getBcssaswimmer() {
        return bcssaswimmer;
    }
    public String getBcssadiver() {
        return bcssadiver;
    }
    public String getBcssasyncro() {
        return bcssasyncro;
    }
    public String getBcssapolo() {
        return bcssapolo;
    }
    public Integer getThesort() {
        return thesort;
    }
    public Boolean getDivecertified() {
        return divecertified;
    }
    public java.time.LocalDateTime getDateclubjoined() {
        return dateclubjoined;
    }
    public java.time.LocalDateTime getDategroupjoined() {
        return dategroupjoined;
    }
    public String getAwregtype() {
        return awregtype;
    }
    public Short getRegyear() {
        return regyear;
    }
    public Boolean getForeign() {
        return foreign;
    }
    public String getForeigncitizenof() {
        return foreigncitizenof;
    }
    public java.time.LocalDateTime getLastupdated() {
        return lastupdated;
    }
    public Boolean getPc_hide() {
        return pc_hide;
    }
}
