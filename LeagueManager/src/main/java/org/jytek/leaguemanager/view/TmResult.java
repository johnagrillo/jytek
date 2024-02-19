package org.jytek.leaguemanager.view;

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
 * CREATE TABLE [RESULT]
 * (
 * [MEET]			Long Integer,
 * [ATHLETE]			Long Integer,
 * [I_R]			Text (2),
 * [TEAM]			Long Integer,
 * [SCORE]			Long Integer,
 * [F_P]			Text (2),
 * [SPLIT]			Long Integer,
 * [EX]			Text (2),
 * [ORIGIN]			Text (8),
 * [NT]			Byte,
 * [RESULT]			Long Integer,
 * [MISC]			Text (2),
 * [AGE]			Integer,
 * [DISTANCE]			Integer,
 * [STROKE]			Integer,
 * [MTEVENT]			Long Integer,
 * [POINTS]			Integer,
 * [PLACE]			Integer,
 * [RANK]			Integer,
 * [TRANK]			Integer,
 * [COURSE]			Text (2),
 * [REACTION]			Text (10),
 * [DQCODE]			Text (4),
 * [DQDESCRIPT]			Text (180),
 * [DQCODESecondary]			Text (4),
 * [DQDESCRIPTSecondary]			Text (180)
 * );
 */
public class TmResult {

    public static String NAME = "Result";
    private TmResult() {
    }

    public static TmResult create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmResult();
        obj.meet = (Integer) row.get(TmResult.MEET);
        obj.athlete = (Integer) row.get(TmResult.ATHLETE);
        obj.i_r = (String) row.get(TmResult.I_R);
        obj.team = (Integer) row.get(TmResult.TEAM);
        obj.score = (Integer) row.get(TmResult.SCORE);
        obj.f_p = (String) row.get(TmResult.F_P);
        obj.split = (Integer) row.get(TmResult.SPLIT);
        obj.ex = (String) row.get(TmResult.EX);
        obj.origin = (String) row.get(TmResult.ORIGIN);
        obj.nt = (Byte) row.get(TmResult.NT);
        obj.result = (Integer) row.get(TmResult.RESULT);
        obj.misc = (String) row.get(TmResult.MISC);
        obj.age = (Short) row.get(TmResult.AGE);
        obj.distance = (Short) row.get(TmResult.DISTANCE);
        obj.stroke = (Short) row.get(TmResult.STROKE);
        obj.mtevent = (Integer) row.get(TmResult.MTEVENT);
        obj.points = (Short) row.get(TmResult.POINTS);
        obj.place = (Short) row.get(TmResult.PLACE);
        obj.rank = (Short) row.get(TmResult.RANK);
        obj.trank = (Short) row.get(TmResult.TRANK);
        obj.course = (String) row.get(TmResult.COURSE);
        obj.reaction = (String) row.get(TmResult.REACTION);
        obj.dqcode = (String) row.get(TmResult.DQCODE);
        obj.dqdescript = (String) row.get(TmResult.DQDESCRIPT);
        obj.dqcodesecondary = (String) row.get(TmResult.DQCODESECONDARY);
        obj.dqdescriptsecondary = (String) row.get(TmResult.DQDESCRIPTSECONDARY);
    return obj;
    }


    // 
    // Column names
    //
    public static final String MEET = "MEET";
    public static final String ATHLETE = "ATHLETE";
    public static final String I_R = "I_R";
    public static final String TEAM = "TEAM";
    public static final String SCORE = "SCORE";
    public static final String F_P = "F_P";
    public static final String SPLIT = "SPLIT";
    public static final String EX = "EX";
    public static final String ORIGIN = "ORIGIN";
    public static final String NT = "NT";
    public static final String RESULT = "RESULT";
    public static final String MISC = "MISC";
    public static final String AGE = "AGE";
    public static final String DISTANCE = "DISTANCE";
    public static final String STROKE = "STROKE";
    public static final String MTEVENT = "MTEVENT";
    public static final String POINTS = "POINTS";
    public static final String PLACE = "PLACE";
    public static final String RANK = "RANK";
    public static final String TRANK = "TRANK";
    public static final String COURSE = "COURSE";
    public static final String REACTION = "REACTION";
    public static final String DQCODE = "DQCODE";
    public static final String DQDESCRIPT = "DQDESCRIPT";
    public static final String DQCODESECONDARY = "DQCODESecondary";
    public static final String DQDESCRIPTSECONDARY = "DQDESCRIPTSecondary";
    // 
    // members
    //
    private Integer meet = null;
    private Integer athlete = null;
    private String i_r = null;
    private Integer team = null;
    private Integer score = null;
    private String f_p = null;
    private Integer split = null;
    private String ex = null;
    private String origin = null;
    private Byte nt = null;
    private Integer result = null;
    private String misc = null;
    private Short age = null;
    private Short distance = null;
    private Short stroke = null;
    private Integer mtevent = null;
    private Short points = null;
    private Short place = null;
    private Short rank = null;
    private Short trank = null;
    private String course = null;
    private String reaction = null;
    private String dqcode = null;
    private String dqdescript = null;
    private String dqcodesecondary = null;
    private String dqdescriptsecondary = null;
    //
    // getters
    //
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
    public Integer getScore() {
        return score;
    }
    public String getF_p() {
        return f_p;
    }
    public Integer getSplit() {
        return split;
    }
    public String getEx() {
        return ex;
    }
    public String getOrigin() {
        return origin;
    }
    public Byte getNt() {
        return nt;
    }
    public Integer getResult() {
        return result;
    }
    public String getMisc() {
        return misc;
    }
    public Short getAge() {
        return age;
    }
    public Short getDistance() {
        return distance;
    }
    public Short getStroke() {
        return stroke;
    }
    public Integer getMtevent() {
        return mtevent;
    }
    public Short getPoints() {
        return points;
    }
    public Short getPlace() {
        return place;
    }
    public Short getRank() {
        return rank;
    }
    public Short getTrank() {
        return trank;
    }
    public String getCourse() {
        return course;
    }
    public String getReaction() {
        return reaction;
    }
    public String getDqcode() {
        return dqcode;
    }
    public String getDqdescript() {
        return dqdescript;
    }
    public String getDqcodesecondary() {
        return dqcodesecondary;
    }
    public String getDqdescriptsecondary() {
        return dqdescriptsecondary;
    }
}
