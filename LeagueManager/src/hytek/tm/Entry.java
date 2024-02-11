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
 * CREATE TABLE [ENTRY]
 * (
 * [Meet]			Long Integer,
 * [Athlete]			Long Integer,
 * [I_R]			Text (2),
 * [Team]			Long Integer,
 * [Course]			Text (4),
 * [Score]			Long Integer,
 * [Ex]			Text (2),
 * [MtEvent]			Long Integer,
 * [Misc]			Text (2),
 * [Entry]			Long Integer,
 * [Division]			Text (6),
 * [HEAT]			Byte,
 * [LANE]			Byte,
 * [FromOME]			Boolean NOT NULL
 * );
 */
public class Entry {

    public static String NAME = "Entry";
    private Entry() {
    }

    public Entry(final com.healthmarketscience.jackcess.Row row){

        meet = (Integer) row.get(Entry.MEET);
        athlete = (Integer) row.get(Entry.ATHLETE);
        i_r = (String) row.get(Entry.I_R);
        team = (Integer) row.get(Entry.TEAM);
        course = (String) row.get(Entry.COURSE);
        score = (Integer) row.get(Entry.SCORE);
        ex = (String) row.get(Entry.EX);
        mtevent = (Integer) row.get(Entry.MTEVENT);
        misc = (String) row.get(Entry.MISC);
        entry = (Integer) row.get(Entry.ENTRY);
        division = (String) row.get(Entry.DIVISION);
        heat = (Byte) row.get(Entry.HEAT);
        lane = (Byte) row.get(Entry.LANE);
        fromome = (Boolean) row.get(Entry.FROMOME);
    }


    public static final String MEET = "Meet";
    public static final String ATHLETE = "Athlete";
    public static final String I_R = "I_R";
    public static final String TEAM = "Team";
    public static final String COURSE = "Course";
    public static final String SCORE = "Score";
    public static final String EX = "Ex";
    public static final String MTEVENT = "MtEvent";
    public static final String MISC = "Misc";
    public static final String ENTRY = "Entry";
    public static final String DIVISION = "Division";
    public static final String HEAT = "HEAT";
    public static final String LANE = "LANE";
    public static final String FROMOME = "FromOME";
    private Integer meet = null;
    private Integer athlete = null;
    private String i_r = null;
    private Integer team = null;
    private String course = null;
    private Integer score = null;
    private String ex = null;
    private Integer mtevent = null;
    private String misc = null;
    private Integer entry = null;
    private String division = null;
    private Byte heat = null;
    private Byte lane = null;
    private Boolean fromome = null;
    public Integer getMeet() {
        return meet;
    }
    public Integer getAthlete() {
        return athlete;
    }
    public String getI_r() {
        return i_r;
    }
    public Integer getTeam() {
        return team;
    }
    public String getCourse() {
        return course;
    }
    public Integer getScore() {
        return score;
    }
    public String getEx() {
        return ex;
    }
    public Integer getMtevent() {
        return mtevent;
    }
    public String getMisc() {
        return misc;
    }
    public Integer getEntry() {
        return entry;
    }
    public String getDivision() {
        return division;
    }
    public Byte getHeat() {
        return heat;
    }
    public Byte getLane() {
        return lane;
    }
    public Boolean getFromome() {
        return fromome;
    }
}
