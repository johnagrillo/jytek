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
public class Mtevent {

    public static String NAME = "Mtevent";
    private Mtevent() {
    }

    public Mtevent(final com.healthmarketscience.jackcess.Row row){

        meet = (Integer) row.get(Mtevent.MEET);
        mtev = (Short) row.get(Mtevent.MTEV);
        mtevx = (String) row.get(Mtevent.MTEVX);
        lo_hi = (Short) row.get(Mtevent.LO_HI);
        course = (String) row.get(Mtevent.COURSE);
        mtevent = (Integer) row.get(Mtevent.MTEVENT);
        distance = (Short) row.get(Mtevent.DISTANCE);
        stroke = (Short) row.get(Mtevent.STROKE);
        sex = (String) row.get(Mtevent.SEX);
        i_r = (String) row.get(Mtevent.I_R);
        session = (Byte) row.get(Mtevent.SESSION);
        division = (String) row.get(Mtevent.DIVISION);
        eventtype = (String) row.get(Mtevent.EVENTTYPE);
        sessx = (String) row.get(Mtevent.SESSX);
    }


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

    @Override
    public String toString() {
        return "Mtevent{" +
                "meet=" + meet +
                ", mtev=" + mtev +
                ", mtevx='" + mtevx + '\'' +
                ", lo_hi=" + lo_hi +
                ", course='" + course + '\'' +
                ", mtevent=" + mtevent +
                ", distance=" + distance +
                ", stroke=" + stroke +
                ", sex='" + sex + '\'' +
                ", i_r='" + i_r + '\'' +
                ", session=" + session +
                ", division='" + division + '\'' +
                ", eventtype='" + eventtype + '\'' +
                ", sessx='" + sessx + '\'' +
                '}';
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
