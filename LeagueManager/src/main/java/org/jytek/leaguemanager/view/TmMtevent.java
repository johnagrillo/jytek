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
 * CREATE TABLE [MTEVENT]
 * (
 * [Meet]			Long Integer,
 * [MtEv]			Integer,
 * [MtEvX]			Text (2),
 * [Lo_Hi]			Integer,
 * [Course]			Text (2),
 * [MtEvent]			Long Integer,
 * [Distance]			Integer,
 * [Stroke]			Integer,
 * [Sex]			Text (2),
 * [I_R]			Text (2),
 * [Session]			Byte,
 * [Division]			Text (6),
 * [EventType]			Text (2),
 * [SessX]			Text (2)
 * );
 */
public class TmMtevent {

    public static String NAME = "Mtevent";
    private TmMtevent() {
    }

    public static TmMtevent create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmMtevent();
        obj.meet = (Integer) row.get(TmMtevent.MEET);
        obj.mtev = (Short) row.get(TmMtevent.MTEV);
        obj.mtevx = (String) row.get(TmMtevent.MTEVX);
        obj.lo_hi = (Short) row.get(TmMtevent.LO_HI);
        obj.course = (String) row.get(TmMtevent.COURSE);
        obj.mtevent = (Integer) row.get(TmMtevent.MTEVENT);
        obj.distance = (Short) row.get(TmMtevent.DISTANCE);
        obj.stroke = (Short) row.get(TmMtevent.STROKE);
        obj.sex = (String) row.get(TmMtevent.SEX);
        obj.i_r = (String) row.get(TmMtevent.I_R);
        obj.session = (Byte) row.get(TmMtevent.SESSION);
        obj.division = (String) row.get(TmMtevent.DIVISION);
        obj.eventtype = (String) row.get(TmMtevent.EVENTTYPE);
        obj.sessx = (String) row.get(TmMtevent.SESSX);
    return obj;
    }


    // 
    // Column names
    //
    public static final String MEET = "Meet";
    public static final String MTEV = "MtEv";
    public static final String MTEVX = "MtEvX";
    public static final String LO_HI = "Lo_Hi";
    public static final String COURSE = "Course";
    public static final String MTEVENT = "MtEvent";
    public static final String DISTANCE = "Distance";
    public static final String STROKE = "Stroke";
    public static final String SEX = "Sex";
    public static final String I_R = "I_R";
    public static final String SESSION = "Session";
    public static final String DIVISION = "Division";
    public static final String EVENTTYPE = "EventType";
    public static final String SESSX = "SessX";
    // 
    // members
    //
    private Integer meet = null;
    private Short mtev = null;
    private String mtevx = null;
    private Short lo_hi = null;
    private String course = null;
    private Integer mtevent = null;
    private Short distance = null;
    private Short stroke = null;
    private String sex = null;
    private String i_r = null;
    private Byte session = null;
    private String division = null;
    private String eventtype = null;
    private String sessx = null;
    //
    // getters
    //
    public Integer getMeet() {
        return meet;
    }
    public Short getMtev() {
        return mtev;
    }
    public String getMtevx() {
        return mtevx;
    }
    public Short getLo_hi() {
        return lo_hi;
    }
    public String getCourse() {
        return course;
    }
    public Integer getMtevent() {
        return mtevent;
    }
    public Short getDistance() {
        return distance;
    }
    public Short getStroke() {
        return stroke;
    }
    public String getSex() {
        return sex;
    }
    public String getI_r() {
        return i_r;
    }
    public Byte getSession() {
        return session;
    }
    public String getDivision() {
        return division;
    }
    public String getEventtype() {
        return eventtype;
    }
    public String getSessx() {
        return sessx;
    }
}
