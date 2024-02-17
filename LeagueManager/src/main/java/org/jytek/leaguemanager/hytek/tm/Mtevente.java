package org.jytek.leaguemanager.hytek.tm;

/**
 * -- ----------------------------------------------------------
 * -- MDB Tools - A library for reading MS Access database files
 * -- Copyright (C) 2000-2011 Brian Bruns and others.
 * -- Files in libmdb are licensed under LGPL and the utilities under
 * -- the GPL, see COPYING.LIB and COPYING files respectively.
 * -- Check out http://mdbtools.sourceforge.net
 * -- ----------------------------------------------------------
 * <p>
 * -- That file uses encoding UTF-8
 * <p>
 * CREATE TABLE [MTEVENTE]
 * (
 * [Meet]			Long Integer,
 * [MtEv]			Integer,
 * [MtEvX]			Text (2),
 * [Lo_Hi]			Integer,
 * [FastCut]			Long Integer,
 * [SlowCut]			Long Integer,
 * [Course]			Text (2),
 * [MtEvent]			Long Integer,
 * [Fast_L]			Long Integer,
 * [Slow_L]			Long Integer,
 * [Fast_Y]			Long Integer,
 * [Slow_Y]			Long Integer,
 * [TstdFile]			Text (16),
 * [TstDesig]			Text (8),
 * [Distance]			Integer,
 * [Stroke]			Integer,
 * [Sex]			Text (2),
 * [I_R]			Text (2),
 * [Session]			Byte,
 * [Division]			Text (6),
 * [Fee]			Single,
 * [ExportEvent]			Text (8),
 * [GenderMix]			Byte,
 * [SessX]			Text (2)
 * );
 */
public class Mtevente {

    public static String NAME = "Mtevente";

    private Mtevente() {
    }

    public Mtevente(final com.healthmarketscience.jackcess.Row row) {

        meet = (Integer) row.get(Mtevente.MEET);
        mtev = (Short) row.get(Mtevente.MTEV);
        mtevx = (String) row.get(Mtevente.MTEVX);
        lo_hi = (Short) row.get(Mtevente.LO_HI);
        fastcut = (Integer) row.get(Mtevente.FASTCUT);
        slowcut = (Integer) row.get(Mtevente.SLOWCUT);
        course = (String) row.get(Mtevente.COURSE);
        mtevent = (Integer) row.get(Mtevente.MTEVENT);
        fast_l = (Integer) row.get(Mtevente.FAST_L);
        slow_l = (Integer) row.get(Mtevente.SLOW_L);
        fast_y = (Integer) row.get(Mtevente.FAST_Y);
        slow_y = (Integer) row.get(Mtevente.SLOW_Y);
        tstdfile = (String) row.get(Mtevente.TSTDFILE);
        tstdesig = (String) row.get(Mtevente.TSTDESIG);
        distance = (Short) row.get(Mtevente.DISTANCE);
        stroke = (Short) row.get(Mtevente.STROKE);
        sex = (String) row.get(Mtevente.SEX);
        i_r = (String) row.get(Mtevente.I_R);
        session = (Byte) row.get(Mtevente.SESSION);
        division = (String) row.get(Mtevente.DIVISION);
        fee = (Float) row.get(Mtevente.FEE);
        exportevent = (String) row.get(Mtevente.EXPORTEVENT);
        gendermix = (Byte) row.get(Mtevente.GENDERMIX);
        sessx = (String) row.get(Mtevente.SESSX);
    }


    public static final String MEET = "Meet";
    public static final String MTEV = "MtEv";
    public static final String MTEVX = "MtEvX";
    public static final String LO_HI = "Lo_Hi";
    public static final String FASTCUT = "FastCut";
    public static final String SLOWCUT = "SlowCut";
    public static final String COURSE = "Course";
    public static final String MTEVENT = "MtEvent";
    public static final String FAST_L = "Fast_L";
    public static final String SLOW_L = "Slow_L";
    public static final String FAST_Y = "Fast_Y";
    public static final String SLOW_Y = "Slow_Y";
    public static final String TSTDFILE = "TstdFile";
    public static final String TSTDESIG = "TstDesig";
    public static final String DISTANCE = "Distance";
    public static final String STROKE = "Stroke";
    public static final String SEX = "Sex";
    public static final String I_R = "I_R";
    public static final String SESSION = "Session";
    public static final String DIVISION = "Division";
    public static final String FEE = "Fee";
    public static final String EXPORTEVENT = "ExportEvent";
    public static final String GENDERMIX = "GenderMix";
    public static final String SESSX = "SessX";
    private Integer meet = null;
    private Short mtev = null;
    private String mtevx = null;
    private Short lo_hi = null;
    private Integer fastcut = null;
    private Integer slowcut = null;
    private String course = null;
    private Integer mtevent = null;
    private Integer fast_l = null;
    private Integer slow_l = null;
    private Integer fast_y = null;
    private Integer slow_y = null;
    private String tstdfile = null;
    private String tstdesig = null;
    private Short distance = null;
    private Short stroke = null;
    private String sex = null;
    private String i_r = null;
    private Byte session = null;
    private String division = null;
    private Float fee = null;
    private String exportevent = null;
    private Byte gendermix = null;
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

    public Integer getFastcut() {
        return fastcut;
    }

    public Integer getSlowcut() {
        return slowcut;
    }

    public String getCourse() {
        return course;
    }

    public Integer getMtevent() {
        return mtevent;
    }

    public Integer getFast_l() {
        return fast_l;
    }

    public Integer getSlow_l() {
        return slow_l;
    }

    public Integer getFast_y() {
        return fast_y;
    }

    public Integer getSlow_y() {
        return slow_y;
    }

    public String getTstdfile() {
        return tstdfile;
    }

    public String getTstdesig() {
        return tstdesig;
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

    public Float getFee() {
        return fee;
    }

    public String getExportevent() {
        return exportevent;
    }

    public Byte getGendermix() {
        return gendermix;
    }

    public String getSessx() {
        return sessx;
    }

    @Override
    public String toString() {
        return "Mtevente{" +
                "meet=" + meet +
                ", mtev=" + mtev +
                ", mtevx='" + mtevx + '\'' +
                ", lo_hi=" + lo_hi +
                ", mtevent=" + mtevent +
                ", distance=" + distance +
                ", stroke=" + stroke +
                ", sex='" + sex + '\'' +
                ", i_r='" + i_r + '\'' +
                ", gendermix=" + gendermix +
                '}';
    }
}
