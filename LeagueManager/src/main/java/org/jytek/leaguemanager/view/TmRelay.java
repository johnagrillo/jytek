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
 * CREATE TABLE [RELAY]
 * (
 * [RELAY]                 Long Integer,
 * [MEET]                  Long Integer,
 * [LO_HI]                 Integer,
 * [TEAM]                  Long Integer,
 * [LETTER]                Text (2),
 * [AGE_RANGE]             Integer,
 * [SEX]                   Text (2),
 * [ATH(1)]                Long Integer,
 * [ATH(2)]                Long Integer,
 * [ATH(3)]                Long Integer,
 * [ATH(4)]                Long Integer,
 * [ATH(5)]                Long Integer,
 * [ATH(6)]                Long Integer,
 * [ATH(7)]                Long Integer,
 * [ATH(8)]                Long Integer,
 * [DISTANCE]              Integer,
 * [STROKE]                Integer,
 * [RELAYAGE]              Text (6),
 * #       [REACTION1]             Text (10),
 * #       [REACTION2]             Text (10),
 * #       [REACTION3]             Text (10),
 * #       [REACTION4]             Text (10)
 * );
 */
public class TmRelay {

    public static String NAME = "Relay";
    private TmRelay() {
    }

    public static TmRelay create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmRelay();
        obj.relay = (Integer) row.get(TmRelay.RELAY);
        obj.meet = (Integer) row.get(TmRelay.MEET);
        obj.lo_hi = (Short) row.get(TmRelay.LO_HI);
        obj.team = (Integer) row.get(TmRelay.TEAM);
        obj.letter = (String) row.get(TmRelay.LETTER);
        obj.age_range = (Short) row.get(TmRelay.AGE_RANGE);
        obj.sex = (String) row.get(TmRelay.SEX);
        obj.ath_1 = (Integer) row.get(TmRelay.ATH_1);
        obj.ath_2 = (Integer) row.get(TmRelay.ATH_2);
        obj.ath_3 = (Integer) row.get(TmRelay.ATH_3);
        obj.ath_4 = (Integer) row.get(TmRelay.ATH_4);
        obj.ath_5 = (Integer) row.get(TmRelay.ATH_5);
        obj.ath_6 = (Integer) row.get(TmRelay.ATH_6);
        obj.ath_7 = (Integer) row.get(TmRelay.ATH_7);
        obj.ath_8 = (Integer) row.get(TmRelay.ATH_8);
        obj.distance = (Short) row.get(TmRelay.DISTANCE);
        obj.stroke = (Short) row.get(TmRelay.STROKE);
        obj.relayage = (String) row.get(TmRelay.RELAYAGE);

        obj.results = new ArrayList<>();

    return obj;
    }


    // 
    // Column names
    //
    public static final String RELAY = "RELAY";
    public static final String MEET = "MEET";
    public static final String LO_HI = "LO_HI";
    public static final String TEAM = "TEAM";
    public static final String LETTER = "LETTER";
    public static final String AGE_RANGE = "AGE_RANGE";
    public static final String SEX = "SEX";
    public static final String ATH_1 = "ATH(1)";
    public static final String ATH_2 = "ATH(2)";
    public static final String ATH_3 = "ATH(3)";
    public static final String ATH_4 = "ATH(4)";
    public static final String ATH_5 = "ATH(5)";
    public static final String ATH_6 = "ATH(6)";
    public static final String ATH_7 = "ATH(7)";
    public static final String ATH_8 = "ATH(8)";
    public static final String DISTANCE = "DISTANCE";
    public static final String STROKE = "STROKE";
    public static final String RELAYAGE = "RELAYAGE";
    // 
    // members
    //
    private Integer relay = null;
    private Integer meet = null;
    private Short lo_hi = null;
    private Integer team = null;
    private String letter = null;
    private Short age_range = null;
    private String sex = null;
    private Integer ath_1 = null;
    private Integer ath_2 = null;
    private Integer ath_3 = null;
    private Integer ath_4 = null;
    private Integer ath_5 = null;
    private Integer ath_6 = null;
    private Integer ath_7 = null;
    private Integer ath_8 = null;
    private Short distance = null;
    private Short stroke = null;
    private String relayage = null;
    //
    // getters
    //
    public Integer getRelay() {
        return relay;
    }
    public Integer getMeet() {
        return meet;
    }
    public Short getLo_hi() {
        return lo_hi;
    }
    public Integer getTeam() {
        return team;
    }
    public String getLetter() {
        return letter;
    }
    public Short getAge_range() {
        return age_range;
    }
    public String getSex() {
        return sex;
    }
    public Integer getAth_1() {
        return ath_1;
    }
    public Integer getAth_2() {
        return ath_2;
    }
    public Integer getAth_3() {
        return ath_3;
    }
    public Integer getAth_4() {
        return ath_4;
    }
    public Integer getAth_5() {
        return ath_5;
    }
    public Integer getAth_6() {
        return ath_6;
    }
    public Integer getAth_7() {
        return ath_7;
    }
    public Integer getAth_8() {
        return ath_8;
    }
    public Short getDistance() {
        return distance;
    }
    public Short getStroke() {
        return stroke;
    }
    public String getRelayage() {
        return relayage;
    }




    public List<TmResult> getResults() {
        return results;
    }
    private List<TmResult> results = null;
    public void add(TmResult r) {
        results.add(r);
    }
}

