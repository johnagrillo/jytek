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
public class TmMtevente {

    public static String NAME = "Mtevente";
    private TmMtevente() {
    }

    public static TmMtevente create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmMtevente();
        obj.meet = (Integer) row.get(TmMtevente.MEET);
        obj.mtev = (Short) row.get(TmMtevente.MTEV);
        obj.mtevx = (String) row.get(TmMtevente.MTEVX);
        obj.lo_hi = (Short) row.get(TmMtevente.LO_HI);
        obj.fastcut = (Integer) row.get(TmMtevente.FASTCUT);
        obj.slowcut = (Integer) row.get(TmMtevente.SLOWCUT);
        obj.course = (String) row.get(TmMtevente.COURSE);
        obj.mtevent = (Integer) row.get(TmMtevente.MTEVENT);
        obj.fast_l = (Integer) row.get(TmMtevente.FAST_L);
        obj.slow_l = (Integer) row.get(TmMtevente.SLOW_L);
        obj.fast_y = (Integer) row.get(TmMtevente.FAST_Y);
        obj.slow_y = (Integer) row.get(TmMtevente.SLOW_Y);
        obj.tstdfile = (String) row.get(TmMtevente.TSTDFILE);
        obj.tstdesig = (String) row.get(TmMtevente.TSTDESIG);
        obj.distance = (Short) row.get(TmMtevente.DISTANCE);
        obj.stroke = (Short) row.get(TmMtevente.STROKE);
        obj.sex = (String) row.get(TmMtevente.SEX);
        obj.i_r = (String) row.get(TmMtevente.I_R);
        obj.session = (Byte) row.get(TmMtevente.SESSION);
        obj.division = (String) row.get(TmMtevente.DIVISION);
        obj.fee = (Float) row.get(TmMtevente.FEE);
        obj.exportevent = (String) row.get(TmMtevente.EXPORTEVENT);
        obj.gendermix = (Byte) row.get(TmMtevente.GENDERMIX);
        obj.sessx = (String) row.get(TmMtevente.SESSX);
    return obj;
    }


    // 
    // Column names
    //
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
    // 
    // members
    //
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
}
