package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Relay]
 * (
 * [Event_ptr]			Long Integer,
 * [Team_no]			Long Integer,
 * [Team_ltr]			Text (2),
 * [Rel_age]			Integer,
 * [Rel_sex]			Text (2),
 * [ActSeed_course]			Text (2),
 * [ActualSeed_time]			Single,
 * [ConvSeed_course]			Text (2),
 * [ConvSeed_time]			Single,
 * [Scr_stat]			Boolean NOT NULL,
 * [Spec_stat]			Text (2),
 * [Dec_stat]			Text (2),
 * [Alt_stat]			Boolean NOT NULL,
 * [Bonus_event]			Boolean NOT NULL,
 * [Div_no]			Long Integer,
 * [Ev_score]			Single,
 * [dq_type]			Text (2),
 * [Pre_heat]			Integer,
 * [Pre_lane]			Integer,
 * [Pre_stat]			Text (2),
 * [Pre_Time]			Single,
 * [Pre_course]			Text (2),
 * [Pre_heatplace]			Integer,
 * [Pre_place]			Integer,
 * [Pre_jdplace]			Integer,
 * [Pre_exh]			Text (2),
 * [Pre_points]			Integer,
 * [Pre_back1]			Single,
 * [Pre_back2]			Single,
 * [Pre_back3]			Single,
 * [Fin_heat]			Integer,
 * [Fin_lane]			Integer,
 * [Fin_group]			Integer,
 * [Fin_stat]			Text (2),
 * [Fin_Time]			Single,
 * [Fin_course]			Text (2),
 * [Fin_heatplace]			Integer,
 * [Fin_jdheatplace]			Integer,
 * [Fin_place]			Integer,
 * [Fin_jdplace]			Integer,
 * [Fin_ptsplace]			Integer,
 * [Fin_exh]			Text (2),
 * [Fin_points]			Integer,
 * [Fin_back1]			Single,
 * [Fin_back2]			Single,
 * [Fin_back3]			Single,
 * [Sem_heat]			Integer,
 * [Sem_lane]			Integer,
 * [Sem_stat]			Text (2),
 * [Sem_Time]			Single,
 * [Sem_course]			Text (2),
 * [Sem_heatplace]			Integer,
 * [Sem_place]			Integer,
 * [Sem_jdplace]			Integer,
 * [Sem_exh]			Text (2),
 * [Sem_points]			Integer,
 * [Sem_back1]			Single,
 * [Sem_back2]			Single,
 * [Sem_back3]			Single,
 * [Swimoff_heat]			Integer,
 * [Swimoff_lane]			Integer,
 * [Swimoff_stat]			Text (2),
 * [Swimoff_Time]			Single,
 * [Swimoff_course]			Text (2),
 * [Swimoff_heatplace]			Integer,
 * [Swimoff_place]			Integer,
 * [Swimoff_jdplace]			Integer,
 * [Swimoff_points]			Integer,
 * [Swimoff_back1]			Single,
 * [Swimoff_back2]			Single,
 * [Swimoff_back3]			Single,
 * [JDEv_score]			Single,
 * [Relay_no]			Long Integer,
 * [Seed_place]			Integer,
 * [fin_heatltr]			Text (2),
 * [Pre_watch1]			Single,
 * [Pre_pad]			Single,
 * [Sem_watch1]			Single,
 * [Sem_pad]			Single,
 * [Fin_watch1]			Single,
 * [Fin_pad]			Single,
 * [Fin_reactiontime1]			Text (10),
 * [Pre_reactiontime1]			Text (10),
 * [Sem_reactiontime1]			Text (10),
 * [Fin_dqcode]			Text (4),
 * [Pre_dqcode]			Text (4),
 * [Sem_dqcode]			Text (4),
 * [Fin_dqcodeSecond]			Text (4),
 * [Pre_dqcodeSecond]			Text (4),
 * [Sem_dqcodeSecond]			Text (4),
 * [Fin_reactiontime2]			Text (10),
 * [Pre_reactiontime2]			Text (10),
 * [Sem_reactiontime2]			Text (10),
 * [Fin_reactiontime3]			Text (10),
 * [Pre_reactiontime3]			Text (10),
 * [Sem_reactiontime3]			Text (10),
 * [Fin_reactiontime4]			Text (10),
 * [Pre_reactiontime4]			Text (10),
 * [Sem_reactiontime4]			Text (10),
 * [Fin_TimeType]			Text (2),
 * [Pre_TimeType]			Text (2),
 * [Sem_TimeType]			Text (2),
 * [Fin_dolphin1]			Single,
 * [Fin_dolphin2]			Single,
 * [Fin_dolphin3]			Single,
 * [Pre_dolphin1]			Single,
 * [Pre_dolphin2]			Single,
 * [Pre_dolphin3]			Single,
 * [Sem_dolphin1]			Single,
 * [Sem_dolphin2]			Single,
 * [Sem_dolphin3]			Single,
 * [early_seed]			Boolean NOT NULL,
 * [fin_adjuststat]			Text (2),
 * [pre_adjuststat]			Text (2),
 * [sem_adjuststat]			Text (2),
 * [entry_method]			Text (2),
 * [fin_dqofficial]			Long Integer,
 * [pre_dqofficial]			Long Integer,
 * [sem_dqofficial]			Long Integer,
 * [pre_contacted]			Boolean NOT NULL
 * );
 */
public class MmRelay implements KeyValue<Integer, MmRelay> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Relay";

    /**
     * Private Constructor
     **/
    private MmRelay() {
    }

    /**
     * Read MmRelay object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmRelay
     **/
    public static MmRelay read(final Row row){
        final var obj = new MmRelay();
        obj.eventPtr = (Integer) row.get(MmRelay.EVENT_PTR);
        obj.teamNo = (Integer) row.get(MmRelay.TEAM_NO);
        obj.teamLtr = (String) row.get(MmRelay.TEAM_LTR);
        obj.relAge = (Short) row.get(MmRelay.REL_AGE);
        obj.relSex = (String) row.get(MmRelay.REL_SEX);
        obj.actseedCourse = (String) row.get(MmRelay.ACTSEED_COURSE);
        obj.actualseedTime = (Float) row.get(MmRelay.ACTUALSEED_TIME);
        obj.convseedCourse = (String) row.get(MmRelay.CONVSEED_COURSE);
        obj.convseedTime = (Float) row.get(MmRelay.CONVSEED_TIME);
        obj.scrStat = (Boolean) row.get(MmRelay.SCR_STAT);
        obj.specStat = (String) row.get(MmRelay.SPEC_STAT);
        obj.decStat = (String) row.get(MmRelay.DEC_STAT);
        obj.altStat = (Boolean) row.get(MmRelay.ALT_STAT);
        obj.bonusEvent = (Boolean) row.get(MmRelay.BONUS_EVENT);
        obj.divNo = (Integer) row.get(MmRelay.DIV_NO);
        obj.evScore = (Float) row.get(MmRelay.EV_SCORE);
        obj.dqType = (String) row.get(MmRelay.DQ_TYPE);
        obj.preHeat = (Short) row.get(MmRelay.PRE_HEAT);
        obj.preLane = (Short) row.get(MmRelay.PRE_LANE);
        obj.preStat = (String) row.get(MmRelay.PRE_STAT);
        obj.preTime = (Float) row.get(MmRelay.PRE_TIME);
        obj.preCourse = (String) row.get(MmRelay.PRE_COURSE);
        obj.preHeatplace = (Short) row.get(MmRelay.PRE_HEATPLACE);
        obj.prePlace = (Short) row.get(MmRelay.PRE_PLACE);
        obj.preJdplace = (Short) row.get(MmRelay.PRE_JDPLACE);
        obj.preExh = (String) row.get(MmRelay.PRE_EXH);
        obj.prePoints = (Short) row.get(MmRelay.PRE_POINTS);
        obj.preBack1 = (Float) row.get(MmRelay.PRE_BACK1);
        obj.preBack2 = (Float) row.get(MmRelay.PRE_BACK2);
        obj.preBack3 = (Float) row.get(MmRelay.PRE_BACK3);
        obj.finHeat = (Short) row.get(MmRelay.FIN_HEAT);
        obj.finLane = (Short) row.get(MmRelay.FIN_LANE);
        obj.finGroup = (Short) row.get(MmRelay.FIN_GROUP);
        obj.finStat = (String) row.get(MmRelay.FIN_STAT);
        obj.finTime = (Float) row.get(MmRelay.FIN_TIME);
        obj.finCourse = (String) row.get(MmRelay.FIN_COURSE);
        obj.finHeatplace = (Short) row.get(MmRelay.FIN_HEATPLACE);
        obj.finJdheatplace = (Short) row.get(MmRelay.FIN_JDHEATPLACE);
        obj.finPlace = (Short) row.get(MmRelay.FIN_PLACE);
        obj.finJdplace = (Short) row.get(MmRelay.FIN_JDPLACE);
        obj.finPtsplace = (Short) row.get(MmRelay.FIN_PTSPLACE);
        obj.finExh = (String) row.get(MmRelay.FIN_EXH);
        obj.finPoints = (Short) row.get(MmRelay.FIN_POINTS);
        obj.finBack1 = (Float) row.get(MmRelay.FIN_BACK1);
        obj.finBack2 = (Float) row.get(MmRelay.FIN_BACK2);
        obj.finBack3 = (Float) row.get(MmRelay.FIN_BACK3);
        obj.semHeat = (Short) row.get(MmRelay.SEM_HEAT);
        obj.semLane = (Short) row.get(MmRelay.SEM_LANE);
        obj.semStat = (String) row.get(MmRelay.SEM_STAT);
        obj.semTime = (Float) row.get(MmRelay.SEM_TIME);
        obj.semCourse = (String) row.get(MmRelay.SEM_COURSE);
        obj.semHeatplace = (Short) row.get(MmRelay.SEM_HEATPLACE);
        obj.semPlace = (Short) row.get(MmRelay.SEM_PLACE);
        obj.semJdplace = (Short) row.get(MmRelay.SEM_JDPLACE);
        obj.semExh = (String) row.get(MmRelay.SEM_EXH);
        obj.semPoints = (Short) row.get(MmRelay.SEM_POINTS);
        obj.semBack1 = (Float) row.get(MmRelay.SEM_BACK1);
        obj.semBack2 = (Float) row.get(MmRelay.SEM_BACK2);
        obj.semBack3 = (Float) row.get(MmRelay.SEM_BACK3);
        obj.swimoffHeat = (Short) row.get(MmRelay.SWIMOFF_HEAT);
        obj.swimoffLane = (Short) row.get(MmRelay.SWIMOFF_LANE);
        obj.swimoffStat = (String) row.get(MmRelay.SWIMOFF_STAT);
        obj.swimoffTime = (Float) row.get(MmRelay.SWIMOFF_TIME);
        obj.swimoffCourse = (String) row.get(MmRelay.SWIMOFF_COURSE);
        obj.swimoffHeatplace = (Short) row.get(MmRelay.SWIMOFF_HEATPLACE);
        obj.swimoffPlace = (Short) row.get(MmRelay.SWIMOFF_PLACE);
        obj.swimoffJdplace = (Short) row.get(MmRelay.SWIMOFF_JDPLACE);
        obj.swimoffPoints = (Short) row.get(MmRelay.SWIMOFF_POINTS);
        obj.swimoffBack1 = (Float) row.get(MmRelay.SWIMOFF_BACK1);
        obj.swimoffBack2 = (Float) row.get(MmRelay.SWIMOFF_BACK2);
        obj.swimoffBack3 = (Float) row.get(MmRelay.SWIMOFF_BACK3);
        obj.jdevScore = (Float) row.get(MmRelay.JDEV_SCORE);
        obj.relayNo = (Integer) row.get(MmRelay.RELAY_NO);
        obj.seedPlace = (Short) row.get(MmRelay.SEED_PLACE);
        obj.finHeatltr = (String) row.get(MmRelay.FIN_HEATLTR);
        obj.preWatch1 = (Float) row.get(MmRelay.PRE_WATCH1);
        obj.prePad = (Float) row.get(MmRelay.PRE_PAD);
        obj.semWatch1 = (Float) row.get(MmRelay.SEM_WATCH1);
        obj.semPad = (Float) row.get(MmRelay.SEM_PAD);
        obj.finWatch1 = (Float) row.get(MmRelay.FIN_WATCH1);
        obj.finPad = (Float) row.get(MmRelay.FIN_PAD);
        obj.finReactiontime1 = (String) row.get(MmRelay.FIN_REACTIONTIME1);
        obj.preReactiontime1 = (String) row.get(MmRelay.PRE_REACTIONTIME1);
        obj.semReactiontime1 = (String) row.get(MmRelay.SEM_REACTIONTIME1);
        obj.finDqcode = (String) row.get(MmRelay.FIN_DQCODE);
        obj.preDqcode = (String) row.get(MmRelay.PRE_DQCODE);
        obj.semDqcode = (String) row.get(MmRelay.SEM_DQCODE);
        obj.finDqcodesecond = (String) row.get(MmRelay.FIN_DQCODESECOND);
        obj.preDqcodesecond = (String) row.get(MmRelay.PRE_DQCODESECOND);
        obj.semDqcodesecond = (String) row.get(MmRelay.SEM_DQCODESECOND);
        obj.finReactiontime2 = (String) row.get(MmRelay.FIN_REACTIONTIME2);
        obj.preReactiontime2 = (String) row.get(MmRelay.PRE_REACTIONTIME2);
        obj.semReactiontime2 = (String) row.get(MmRelay.SEM_REACTIONTIME2);
        obj.finReactiontime3 = (String) row.get(MmRelay.FIN_REACTIONTIME3);
        obj.preReactiontime3 = (String) row.get(MmRelay.PRE_REACTIONTIME3);
        obj.semReactiontime3 = (String) row.get(MmRelay.SEM_REACTIONTIME3);
        obj.finReactiontime4 = (String) row.get(MmRelay.FIN_REACTIONTIME4);
        obj.preReactiontime4 = (String) row.get(MmRelay.PRE_REACTIONTIME4);
        obj.semReactiontime4 = (String) row.get(MmRelay.SEM_REACTIONTIME4);
        obj.finTimetype = (String) row.get(MmRelay.FIN_TIMETYPE);
        obj.preTimetype = (String) row.get(MmRelay.PRE_TIMETYPE);
        obj.semTimetype = (String) row.get(MmRelay.SEM_TIMETYPE);
        obj.finDolphin1 = (Float) row.get(MmRelay.FIN_DOLPHIN1);
        obj.finDolphin2 = (Float) row.get(MmRelay.FIN_DOLPHIN2);
        obj.finDolphin3 = (Float) row.get(MmRelay.FIN_DOLPHIN3);
        obj.preDolphin1 = (Float) row.get(MmRelay.PRE_DOLPHIN1);
        obj.preDolphin2 = (Float) row.get(MmRelay.PRE_DOLPHIN2);
        obj.preDolphin3 = (Float) row.get(MmRelay.PRE_DOLPHIN3);
        obj.semDolphin1 = (Float) row.get(MmRelay.SEM_DOLPHIN1);
        obj.semDolphin2 = (Float) row.get(MmRelay.SEM_DOLPHIN2);
        obj.semDolphin3 = (Float) row.get(MmRelay.SEM_DOLPHIN3);
        obj.earlySeed = (Boolean) row.get(MmRelay.EARLY_SEED);
        obj.finAdjuststat = (String) row.get(MmRelay.FIN_ADJUSTSTAT);
        obj.preAdjuststat = (String) row.get(MmRelay.PRE_ADJUSTSTAT);
        obj.semAdjuststat = (String) row.get(MmRelay.SEM_ADJUSTSTAT);
        obj.entryMethod = (String) row.get(MmRelay.ENTRY_METHOD);
        obj.finDqofficial = (Integer) row.get(MmRelay.FIN_DQOFFICIAL);
        obj.preDqofficial = (Integer) row.get(MmRelay.PRE_DQOFFICIAL);
        obj.semDqofficial = (Integer) row.get(MmRelay.SEM_DQOFFICIAL);
        obj.preContacted = (Boolean) row.get(MmRelay.PRE_CONTACTED);
        return obj;
    }

    public MmRelay getValue(){
        return this;
    }

    public Integer getKey(){
        return eventPtr.hashCode();
    }


    // 
    // Column names
    //
    public static final String EVENT_PTR = "Event_ptr";
    public static final String TEAM_NO = "Team_no";
    public static final String TEAM_LTR = "Team_ltr";
    public static final String REL_AGE = "Rel_age";
    public static final String REL_SEX = "Rel_sex";
    public static final String ACTSEED_COURSE = "ActSeed_course";
    public static final String ACTUALSEED_TIME = "ActualSeed_time";
    public static final String CONVSEED_COURSE = "ConvSeed_course";
    public static final String CONVSEED_TIME = "ConvSeed_time";
    public static final String SCR_STAT = "Scr_stat";
    public static final String SPEC_STAT = "Spec_stat";
    public static final String DEC_STAT = "Dec_stat";
    public static final String ALT_STAT = "Alt_stat";
    public static final String BONUS_EVENT = "Bonus_event";
    public static final String DIV_NO = "Div_no";
    public static final String EV_SCORE = "Ev_score";
    public static final String DQ_TYPE = "dq_type";
    public static final String PRE_HEAT = "Pre_heat";
    public static final String PRE_LANE = "Pre_lane";
    public static final String PRE_STAT = "Pre_stat";
    public static final String PRE_TIME = "Pre_Time";
    public static final String PRE_COURSE = "Pre_course";
    public static final String PRE_HEATPLACE = "Pre_heatplace";
    public static final String PRE_PLACE = "Pre_place";
    public static final String PRE_JDPLACE = "Pre_jdplace";
    public static final String PRE_EXH = "Pre_exh";
    public static final String PRE_POINTS = "Pre_points";
    public static final String PRE_BACK1 = "Pre_back1";
    public static final String PRE_BACK2 = "Pre_back2";
    public static final String PRE_BACK3 = "Pre_back3";
    public static final String FIN_HEAT = "Fin_heat";
    public static final String FIN_LANE = "Fin_lane";
    public static final String FIN_GROUP = "Fin_group";
    public static final String FIN_STAT = "Fin_stat";
    public static final String FIN_TIME = "Fin_Time";
    public static final String FIN_COURSE = "Fin_course";
    public static final String FIN_HEATPLACE = "Fin_heatplace";
    public static final String FIN_JDHEATPLACE = "Fin_jdheatplace";
    public static final String FIN_PLACE = "Fin_place";
    public static final String FIN_JDPLACE = "Fin_jdplace";
    public static final String FIN_PTSPLACE = "Fin_ptsplace";
    public static final String FIN_EXH = "Fin_exh";
    public static final String FIN_POINTS = "Fin_points";
    public static final String FIN_BACK1 = "Fin_back1";
    public static final String FIN_BACK2 = "Fin_back2";
    public static final String FIN_BACK3 = "Fin_back3";
    public static final String SEM_HEAT = "Sem_heat";
    public static final String SEM_LANE = "Sem_lane";
    public static final String SEM_STAT = "Sem_stat";
    public static final String SEM_TIME = "Sem_Time";
    public static final String SEM_COURSE = "Sem_course";
    public static final String SEM_HEATPLACE = "Sem_heatplace";
    public static final String SEM_PLACE = "Sem_place";
    public static final String SEM_JDPLACE = "Sem_jdplace";
    public static final String SEM_EXH = "Sem_exh";
    public static final String SEM_POINTS = "Sem_points";
    public static final String SEM_BACK1 = "Sem_back1";
    public static final String SEM_BACK2 = "Sem_back2";
    public static final String SEM_BACK3 = "Sem_back3";
    public static final String SWIMOFF_HEAT = "Swimoff_heat";
    public static final String SWIMOFF_LANE = "Swimoff_lane";
    public static final String SWIMOFF_STAT = "Swimoff_stat";
    public static final String SWIMOFF_TIME = "Swimoff_Time";
    public static final String SWIMOFF_COURSE = "Swimoff_course";
    public static final String SWIMOFF_HEATPLACE = "Swimoff_heatplace";
    public static final String SWIMOFF_PLACE = "Swimoff_place";
    public static final String SWIMOFF_JDPLACE = "Swimoff_jdplace";
    public static final String SWIMOFF_POINTS = "Swimoff_points";
    public static final String SWIMOFF_BACK1 = "Swimoff_back1";
    public static final String SWIMOFF_BACK2 = "Swimoff_back2";
    public static final String SWIMOFF_BACK3 = "Swimoff_back3";
    public static final String JDEV_SCORE = "JDEv_score";
    public static final String RELAY_NO = "Relay_no";
    public static final String SEED_PLACE = "Seed_place";
    public static final String FIN_HEATLTR = "fin_heatltr";
    public static final String PRE_WATCH1 = "Pre_watch1";
    public static final String PRE_PAD = "Pre_pad";
    public static final String SEM_WATCH1 = "Sem_watch1";
    public static final String SEM_PAD = "Sem_pad";
    public static final String FIN_WATCH1 = "Fin_watch1";
    public static final String FIN_PAD = "Fin_pad";
    public static final String FIN_REACTIONTIME1 = "Fin_reactiontime1";
    public static final String PRE_REACTIONTIME1 = "Pre_reactiontime1";
    public static final String SEM_REACTIONTIME1 = "Sem_reactiontime1";
    public static final String FIN_DQCODE = "Fin_dqcode";
    public static final String PRE_DQCODE = "Pre_dqcode";
    public static final String SEM_DQCODE = "Sem_dqcode";
    public static final String FIN_DQCODESECOND = "Fin_dqcodeSecond";
    public static final String PRE_DQCODESECOND = "Pre_dqcodeSecond";
    public static final String SEM_DQCODESECOND = "Sem_dqcodeSecond";
    public static final String FIN_REACTIONTIME2 = "Fin_reactiontime2";
    public static final String PRE_REACTIONTIME2 = "Pre_reactiontime2";
    public static final String SEM_REACTIONTIME2 = "Sem_reactiontime2";
    public static final String FIN_REACTIONTIME3 = "Fin_reactiontime3";
    public static final String PRE_REACTIONTIME3 = "Pre_reactiontime3";
    public static final String SEM_REACTIONTIME3 = "Sem_reactiontime3";
    public static final String FIN_REACTIONTIME4 = "Fin_reactiontime4";
    public static final String PRE_REACTIONTIME4 = "Pre_reactiontime4";
    public static final String SEM_REACTIONTIME4 = "Sem_reactiontime4";
    public static final String FIN_TIMETYPE = "Fin_TimeType";
    public static final String PRE_TIMETYPE = "Pre_TimeType";
    public static final String SEM_TIMETYPE = "Sem_TimeType";
    public static final String FIN_DOLPHIN1 = "Fin_dolphin1";
    public static final String FIN_DOLPHIN2 = "Fin_dolphin2";
    public static final String FIN_DOLPHIN3 = "Fin_dolphin3";
    public static final String PRE_DOLPHIN1 = "Pre_dolphin1";
    public static final String PRE_DOLPHIN2 = "Pre_dolphin2";
    public static final String PRE_DOLPHIN3 = "Pre_dolphin3";
    public static final String SEM_DOLPHIN1 = "Sem_dolphin1";
    public static final String SEM_DOLPHIN2 = "Sem_dolphin2";
    public static final String SEM_DOLPHIN3 = "Sem_dolphin3";
    public static final String EARLY_SEED = "early_seed";
    public static final String FIN_ADJUSTSTAT = "fin_adjuststat";
    public static final String PRE_ADJUSTSTAT = "pre_adjuststat";
    public static final String SEM_ADJUSTSTAT = "sem_adjuststat";
    public static final String ENTRY_METHOD = "entry_method";
    public static final String FIN_DQOFFICIAL = "fin_dqofficial";
    public static final String PRE_DQOFFICIAL = "pre_dqofficial";
    public static final String SEM_DQOFFICIAL = "sem_dqofficial";
    public static final String PRE_CONTACTED = "pre_contacted";
    // 
    // members
    //
    private Integer eventPtr = null;
    private Integer teamNo = null;
    private String teamLtr = null;
    private Short relAge = null;
    private String relSex = null;
    private String actseedCourse = null;
    private Float actualseedTime = null;
    private String convseedCourse = null;
    private Float convseedTime = null;
    private Boolean scrStat = null;
    private String specStat = null;
    private String decStat = null;
    private Boolean altStat = null;
    private Boolean bonusEvent = null;
    private Integer divNo = null;
    private Float evScore = null;
    private String dqType = null;
    private Short preHeat = null;
    private Short preLane = null;
    private String preStat = null;
    private Float preTime = null;
    private String preCourse = null;
    private Short preHeatplace = null;
    private Short prePlace = null;
    private Short preJdplace = null;
    private String preExh = null;
    private Short prePoints = null;
    private Float preBack1 = null;
    private Float preBack2 = null;
    private Float preBack3 = null;
    private Short finHeat = null;
    private Short finLane = null;
    private Short finGroup = null;
    private String finStat = null;
    private Float finTime = null;
    private String finCourse = null;
    private Short finHeatplace = null;
    private Short finJdheatplace = null;
    private Short finPlace = null;
    private Short finJdplace = null;
    private Short finPtsplace = null;
    private String finExh = null;
    private Short finPoints = null;
    private Float finBack1 = null;
    private Float finBack2 = null;
    private Float finBack3 = null;
    private Short semHeat = null;
    private Short semLane = null;
    private String semStat = null;
    private Float semTime = null;
    private String semCourse = null;
    private Short semHeatplace = null;
    private Short semPlace = null;
    private Short semJdplace = null;
    private String semExh = null;
    private Short semPoints = null;
    private Float semBack1 = null;
    private Float semBack2 = null;
    private Float semBack3 = null;
    private Short swimoffHeat = null;
    private Short swimoffLane = null;
    private String swimoffStat = null;
    private Float swimoffTime = null;
    private String swimoffCourse = null;
    private Short swimoffHeatplace = null;
    private Short swimoffPlace = null;
    private Short swimoffJdplace = null;
    private Short swimoffPoints = null;
    private Float swimoffBack1 = null;
    private Float swimoffBack2 = null;
    private Float swimoffBack3 = null;
    private Float jdevScore = null;
    private Integer relayNo = null;
    private Short seedPlace = null;
    private String finHeatltr = null;
    private Float preWatch1 = null;
    private Float prePad = null;
    private Float semWatch1 = null;
    private Float semPad = null;
    private Float finWatch1 = null;
    private Float finPad = null;
    private String finReactiontime1 = null;
    private String preReactiontime1 = null;
    private String semReactiontime1 = null;
    private String finDqcode = null;
    private String preDqcode = null;
    private String semDqcode = null;
    private String finDqcodesecond = null;
    private String preDqcodesecond = null;
    private String semDqcodesecond = null;
    private String finReactiontime2 = null;
    private String preReactiontime2 = null;
    private String semReactiontime2 = null;
    private String finReactiontime3 = null;
    private String preReactiontime3 = null;
    private String semReactiontime3 = null;
    private String finReactiontime4 = null;
    private String preReactiontime4 = null;
    private String semReactiontime4 = null;
    private String finTimetype = null;
    private String preTimetype = null;
    private String semTimetype = null;
    private Float finDolphin1 = null;
    private Float finDolphin2 = null;
    private Float finDolphin3 = null;
    private Float preDolphin1 = null;
    private Float preDolphin2 = null;
    private Float preDolphin3 = null;
    private Float semDolphin1 = null;
    private Float semDolphin2 = null;
    private Float semDolphin3 = null;
    private Boolean earlySeed = null;
    private String finAdjuststat = null;
    private String preAdjuststat = null;
    private String semAdjuststat = null;
    private String entryMethod = null;
    private Integer finDqofficial = null;
    private Integer preDqofficial = null;
    private Integer semDqofficial = null;
    private Boolean preContacted = null;

    //
    // getters
    //

    /**
     * Getter for EventPtr
     * @return Integer
     */
    public Integer getEventPtr() {
        return eventPtr;
    }

    /**
     * Getter for TeamNo
     * @return Integer
     */
    public Integer getTeamNo() {
        return teamNo;
    }

    /**
     * Getter for TeamLtr
     * @return String
     */
    public String getTeamLtr() {
        return teamLtr;
    }

    /**
     * Getter for RelAge
     * @return Short
     */
    public Short getRelAge() {
        return relAge;
    }

    /**
     * Getter for RelSex
     * @return String
     */
    public String getRelSex() {
        return relSex;
    }

    /**
     * Getter for ActseedCourse
     * @return String
     */
    public String getActseedCourse() {
        return actseedCourse;
    }

    /**
     * Getter for ActualseedTime
     * @return Float
     */
    public Float getActualseedTime() {
        return actualseedTime;
    }

    /**
     * Getter for ConvseedCourse
     * @return String
     */
    public String getConvseedCourse() {
        return convseedCourse;
    }

    /**
     * Getter for ConvseedTime
     * @return Float
     */
    public Float getConvseedTime() {
        return convseedTime;
    }

    /**
     * Getter for ScrStat
     * @return Boolean
     */
    public Boolean getScrStat() {
        return scrStat;
    }

    /**
     * Getter for SpecStat
     * @return String
     */
    public String getSpecStat() {
        return specStat;
    }

    /**
     * Getter for DecStat
     * @return String
     */
    public String getDecStat() {
        return decStat;
    }

    /**
     * Getter for AltStat
     * @return Boolean
     */
    public Boolean getAltStat() {
        return altStat;
    }

    /**
     * Getter for BonusEvent
     * @return Boolean
     */
    public Boolean getBonusEvent() {
        return bonusEvent;
    }

    /**
     * Getter for DivNo
     * @return Integer
     */
    public Integer getDivNo() {
        return divNo;
    }

    /**
     * Getter for EvScore
     * @return Float
     */
    public Float getEvScore() {
        return evScore;
    }

    /**
     * Getter for dqType
     * @return String
     */
    public String getdqType() {
        return dqType;
    }

    /**
     * Getter for PreHeat
     * @return Short
     */
    public Short getPreHeat() {
        return preHeat;
    }

    /**
     * Getter for PreLane
     * @return Short
     */
    public Short getPreLane() {
        return preLane;
    }

    /**
     * Getter for PreStat
     * @return String
     */
    public String getPreStat() {
        return preStat;
    }

    /**
     * Getter for PreTime
     * @return Float
     */
    public Float getPreTime() {
        return preTime;
    }

    /**
     * Getter for PreCourse
     * @return String
     */
    public String getPreCourse() {
        return preCourse;
    }

    /**
     * Getter for PreHeatplace
     * @return Short
     */
    public Short getPreHeatplace() {
        return preHeatplace;
    }

    /**
     * Getter for PrePlace
     * @return Short
     */
    public Short getPrePlace() {
        return prePlace;
    }

    /**
     * Getter for PreJdplace
     * @return Short
     */
    public Short getPreJdplace() {
        return preJdplace;
    }

    /**
     * Getter for PreExh
     * @return String
     */
    public String getPreExh() {
        return preExh;
    }

    /**
     * Getter for PrePoints
     * @return Short
     */
    public Short getPrePoints() {
        return prePoints;
    }

    /**
     * Getter for PreBack1
     * @return Float
     */
    public Float getPreBack1() {
        return preBack1;
    }

    /**
     * Getter for PreBack2
     * @return Float
     */
    public Float getPreBack2() {
        return preBack2;
    }

    /**
     * Getter for PreBack3
     * @return Float
     */
    public Float getPreBack3() {
        return preBack3;
    }

    /**
     * Getter for FinHeat
     * @return Short
     */
    public Short getFinHeat() {
        return finHeat;
    }

    /**
     * Getter for FinLane
     * @return Short
     */
    public Short getFinLane() {
        return finLane;
    }

    /**
     * Getter for FinGroup
     * @return Short
     */
    public Short getFinGroup() {
        return finGroup;
    }

    /**
     * Getter for FinStat
     * @return String
     */
    public String getFinStat() {
        return finStat;
    }

    /**
     * Getter for FinTime
     * @return Float
     */
    public Float getFinTime() {
        return finTime;
    }

    /**
     * Getter for FinCourse
     * @return String
     */
    public String getFinCourse() {
        return finCourse;
    }

    /**
     * Getter for FinHeatplace
     * @return Short
     */
    public Short getFinHeatplace() {
        return finHeatplace;
    }

    /**
     * Getter for FinJdheatplace
     * @return Short
     */
    public Short getFinJdheatplace() {
        return finJdheatplace;
    }

    /**
     * Getter for FinPlace
     * @return Short
     */
    public Short getFinPlace() {
        return finPlace;
    }

    /**
     * Getter for FinJdplace
     * @return Short
     */
    public Short getFinJdplace() {
        return finJdplace;
    }

    /**
     * Getter for FinPtsplace
     * @return Short
     */
    public Short getFinPtsplace() {
        return finPtsplace;
    }

    /**
     * Getter for FinExh
     * @return String
     */
    public String getFinExh() {
        return finExh;
    }

    /**
     * Getter for FinPoints
     * @return Short
     */
    public Short getFinPoints() {
        return finPoints;
    }

    /**
     * Getter for FinBack1
     * @return Float
     */
    public Float getFinBack1() {
        return finBack1;
    }

    /**
     * Getter for FinBack2
     * @return Float
     */
    public Float getFinBack2() {
        return finBack2;
    }

    /**
     * Getter for FinBack3
     * @return Float
     */
    public Float getFinBack3() {
        return finBack3;
    }

    /**
     * Getter for SemHeat
     * @return Short
     */
    public Short getSemHeat() {
        return semHeat;
    }

    /**
     * Getter for SemLane
     * @return Short
     */
    public Short getSemLane() {
        return semLane;
    }

    /**
     * Getter for SemStat
     * @return String
     */
    public String getSemStat() {
        return semStat;
    }

    /**
     * Getter for SemTime
     * @return Float
     */
    public Float getSemTime() {
        return semTime;
    }

    /**
     * Getter for SemCourse
     * @return String
     */
    public String getSemCourse() {
        return semCourse;
    }

    /**
     * Getter for SemHeatplace
     * @return Short
     */
    public Short getSemHeatplace() {
        return semHeatplace;
    }

    /**
     * Getter for SemPlace
     * @return Short
     */
    public Short getSemPlace() {
        return semPlace;
    }

    /**
     * Getter for SemJdplace
     * @return Short
     */
    public Short getSemJdplace() {
        return semJdplace;
    }

    /**
     * Getter for SemExh
     * @return String
     */
    public String getSemExh() {
        return semExh;
    }

    /**
     * Getter for SemPoints
     * @return Short
     */
    public Short getSemPoints() {
        return semPoints;
    }

    /**
     * Getter for SemBack1
     * @return Float
     */
    public Float getSemBack1() {
        return semBack1;
    }

    /**
     * Getter for SemBack2
     * @return Float
     */
    public Float getSemBack2() {
        return semBack2;
    }

    /**
     * Getter for SemBack3
     * @return Float
     */
    public Float getSemBack3() {
        return semBack3;
    }

    /**
     * Getter for SwimoffHeat
     * @return Short
     */
    public Short getSwimoffHeat() {
        return swimoffHeat;
    }

    /**
     * Getter for SwimoffLane
     * @return Short
     */
    public Short getSwimoffLane() {
        return swimoffLane;
    }

    /**
     * Getter for SwimoffStat
     * @return String
     */
    public String getSwimoffStat() {
        return swimoffStat;
    }

    /**
     * Getter for SwimoffTime
     * @return Float
     */
    public Float getSwimoffTime() {
        return swimoffTime;
    }

    /**
     * Getter for SwimoffCourse
     * @return String
     */
    public String getSwimoffCourse() {
        return swimoffCourse;
    }

    /**
     * Getter for SwimoffHeatplace
     * @return Short
     */
    public Short getSwimoffHeatplace() {
        return swimoffHeatplace;
    }

    /**
     * Getter for SwimoffPlace
     * @return Short
     */
    public Short getSwimoffPlace() {
        return swimoffPlace;
    }

    /**
     * Getter for SwimoffJdplace
     * @return Short
     */
    public Short getSwimoffJdplace() {
        return swimoffJdplace;
    }

    /**
     * Getter for SwimoffPoints
     * @return Short
     */
    public Short getSwimoffPoints() {
        return swimoffPoints;
    }

    /**
     * Getter for SwimoffBack1
     * @return Float
     */
    public Float getSwimoffBack1() {
        return swimoffBack1;
    }

    /**
     * Getter for SwimoffBack2
     * @return Float
     */
    public Float getSwimoffBack2() {
        return swimoffBack2;
    }

    /**
     * Getter for SwimoffBack3
     * @return Float
     */
    public Float getSwimoffBack3() {
        return swimoffBack3;
    }

    /**
     * Getter for JdevScore
     * @return Float
     */
    public Float getJdevScore() {
        return jdevScore;
    }

    /**
     * Getter for RelayNo
     * @return Integer
     */
    public Integer getRelayNo() {
        return relayNo;
    }

    /**
     * Getter for SeedPlace
     * @return Short
     */
    public Short getSeedPlace() {
        return seedPlace;
    }

    /**
     * Getter for finHeatltr
     * @return String
     */
    public String getfinHeatltr() {
        return finHeatltr;
    }

    /**
     * Getter for PreWatch1
     * @return Float
     */
    public Float getPreWatch1() {
        return preWatch1;
    }

    /**
     * Getter for PrePad
     * @return Float
     */
    public Float getPrePad() {
        return prePad;
    }

    /**
     * Getter for SemWatch1
     * @return Float
     */
    public Float getSemWatch1() {
        return semWatch1;
    }

    /**
     * Getter for SemPad
     * @return Float
     */
    public Float getSemPad() {
        return semPad;
    }

    /**
     * Getter for FinWatch1
     * @return Float
     */
    public Float getFinWatch1() {
        return finWatch1;
    }

    /**
     * Getter for FinPad
     * @return Float
     */
    public Float getFinPad() {
        return finPad;
    }

    /**
     * Getter for FinReactiontime1
     * @return String
     */
    public String getFinReactiontime1() {
        return finReactiontime1;
    }

    /**
     * Getter for PreReactiontime1
     * @return String
     */
    public String getPreReactiontime1() {
        return preReactiontime1;
    }

    /**
     * Getter for SemReactiontime1
     * @return String
     */
    public String getSemReactiontime1() {
        return semReactiontime1;
    }

    /**
     * Getter for FinDqcode
     * @return String
     */
    public String getFinDqcode() {
        return finDqcode;
    }

    /**
     * Getter for PreDqcode
     * @return String
     */
    public String getPreDqcode() {
        return preDqcode;
    }

    /**
     * Getter for SemDqcode
     * @return String
     */
    public String getSemDqcode() {
        return semDqcode;
    }

    /**
     * Getter for FinDqcodesecond
     * @return String
     */
    public String getFinDqcodesecond() {
        return finDqcodesecond;
    }

    /**
     * Getter for PreDqcodesecond
     * @return String
     */
    public String getPreDqcodesecond() {
        return preDqcodesecond;
    }

    /**
     * Getter for SemDqcodesecond
     * @return String
     */
    public String getSemDqcodesecond() {
        return semDqcodesecond;
    }

    /**
     * Getter for FinReactiontime2
     * @return String
     */
    public String getFinReactiontime2() {
        return finReactiontime2;
    }

    /**
     * Getter for PreReactiontime2
     * @return String
     */
    public String getPreReactiontime2() {
        return preReactiontime2;
    }

    /**
     * Getter for SemReactiontime2
     * @return String
     */
    public String getSemReactiontime2() {
        return semReactiontime2;
    }

    /**
     * Getter for FinReactiontime3
     * @return String
     */
    public String getFinReactiontime3() {
        return finReactiontime3;
    }

    /**
     * Getter for PreReactiontime3
     * @return String
     */
    public String getPreReactiontime3() {
        return preReactiontime3;
    }

    /**
     * Getter for SemReactiontime3
     * @return String
     */
    public String getSemReactiontime3() {
        return semReactiontime3;
    }

    /**
     * Getter for FinReactiontime4
     * @return String
     */
    public String getFinReactiontime4() {
        return finReactiontime4;
    }

    /**
     * Getter for PreReactiontime4
     * @return String
     */
    public String getPreReactiontime4() {
        return preReactiontime4;
    }

    /**
     * Getter for SemReactiontime4
     * @return String
     */
    public String getSemReactiontime4() {
        return semReactiontime4;
    }

    /**
     * Getter for FinTimetype
     * @return String
     */
    public String getFinTimetype() {
        return finTimetype;
    }

    /**
     * Getter for PreTimetype
     * @return String
     */
    public String getPreTimetype() {
        return preTimetype;
    }

    /**
     * Getter for SemTimetype
     * @return String
     */
    public String getSemTimetype() {
        return semTimetype;
    }

    /**
     * Getter for FinDolphin1
     * @return Float
     */
    public Float getFinDolphin1() {
        return finDolphin1;
    }

    /**
     * Getter for FinDolphin2
     * @return Float
     */
    public Float getFinDolphin2() {
        return finDolphin2;
    }

    /**
     * Getter for FinDolphin3
     * @return Float
     */
    public Float getFinDolphin3() {
        return finDolphin3;
    }

    /**
     * Getter for PreDolphin1
     * @return Float
     */
    public Float getPreDolphin1() {
        return preDolphin1;
    }

    /**
     * Getter for PreDolphin2
     * @return Float
     */
    public Float getPreDolphin2() {
        return preDolphin2;
    }

    /**
     * Getter for PreDolphin3
     * @return Float
     */
    public Float getPreDolphin3() {
        return preDolphin3;
    }

    /**
     * Getter for SemDolphin1
     * @return Float
     */
    public Float getSemDolphin1() {
        return semDolphin1;
    }

    /**
     * Getter for SemDolphin2
     * @return Float
     */
    public Float getSemDolphin2() {
        return semDolphin2;
    }

    /**
     * Getter for SemDolphin3
     * @return Float
     */
    public Float getSemDolphin3() {
        return semDolphin3;
    }

    /**
     * Getter for earlySeed
     * @return Boolean
     */
    public Boolean getearlySeed() {
        return earlySeed;
    }

    /**
     * Getter for finAdjuststat
     * @return String
     */
    public String getfinAdjuststat() {
        return finAdjuststat;
    }

    /**
     * Getter for preAdjuststat
     * @return String
     */
    public String getpreAdjuststat() {
        return preAdjuststat;
    }

    /**
     * Getter for semAdjuststat
     * @return String
     */
    public String getsemAdjuststat() {
        return semAdjuststat;
    }

    /**
     * Getter for entryMethod
     * @return String
     */
    public String getentryMethod() {
        return entryMethod;
    }

    /**
     * Getter for finDqofficial
     * @return Integer
     */
    public Integer getfinDqofficial() {
        return finDqofficial;
    }

    /**
     * Getter for preDqofficial
     * @return Integer
     */
    public Integer getpreDqofficial() {
        return preDqofficial;
    }

    /**
     * Getter for semDqofficial
     * @return Integer
     */
    public Integer getsemDqofficial() {
        return semDqofficial;
    }

    /**
     * Getter for preContacted
     * @return Boolean
     */
    public Boolean getpreContacted() {
        return preContacted;
    }
}
/* FXML 
<TableView fx:id=tvMmRelay" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmRelayEvent_ptr" prefWidth="150.0" sortable="true" text="Event_ptr" />
    <TableColumn fx:id="tcMmRelayTeam_no" prefWidth="150.0" sortable="true" text="Team_no" />
    <TableColumn fx:id="tcMmRelayTeam_ltr" prefWidth="150.0" sortable="true" text="Team_ltr" />
    <TableColumn fx:id="tcMmRelayRel_age" prefWidth="150.0" sortable="true" text="Rel_age" />
    <TableColumn fx:id="tcMmRelayRel_sex" prefWidth="150.0" sortable="true" text="Rel_sex" />
    <TableColumn fx:id="tcMmRelayActSeed_course" prefWidth="150.0" sortable="true" text="ActSeed_course" />
    <TableColumn fx:id="tcMmRelayActualSeed_time" prefWidth="150.0" sortable="true" text="ActualSeed_time" />
    <TableColumn fx:id="tcMmRelayConvSeed_course" prefWidth="150.0" sortable="true" text="ConvSeed_course" />
    <TableColumn fx:id="tcMmRelayConvSeed_time" prefWidth="150.0" sortable="true" text="ConvSeed_time" />
    <TableColumn fx:id="tcMmRelayScr_stat" prefWidth="150.0" sortable="true" text="Scr_stat" />
    <TableColumn fx:id="tcMmRelaySpec_stat" prefWidth="150.0" sortable="true" text="Spec_stat" />
    <TableColumn fx:id="tcMmRelayDec_stat" prefWidth="150.0" sortable="true" text="Dec_stat" />
    <TableColumn fx:id="tcMmRelayAlt_stat" prefWidth="150.0" sortable="true" text="Alt_stat" />
    <TableColumn fx:id="tcMmRelayBonus_event" prefWidth="150.0" sortable="true" text="Bonus_event" />
    <TableColumn fx:id="tcMmRelayDiv_no" prefWidth="150.0" sortable="true" text="Div_no" />
    <TableColumn fx:id="tcMmRelayEv_score" prefWidth="150.0" sortable="true" text="Ev_score" />
    <TableColumn fx:id="tcMmRelaydq_type" prefWidth="150.0" sortable="true" text="dq_type" />
    <TableColumn fx:id="tcMmRelayPre_heat" prefWidth="150.0" sortable="true" text="Pre_heat" />
    <TableColumn fx:id="tcMmRelayPre_lane" prefWidth="150.0" sortable="true" text="Pre_lane" />
    <TableColumn fx:id="tcMmRelayPre_stat" prefWidth="150.0" sortable="true" text="Pre_stat" />
    <TableColumn fx:id="tcMmRelayPre_Time" prefWidth="150.0" sortable="true" text="Pre_Time" />
    <TableColumn fx:id="tcMmRelayPre_course" prefWidth="150.0" sortable="true" text="Pre_course" />
    <TableColumn fx:id="tcMmRelayPre_heatplace" prefWidth="150.0" sortable="true" text="Pre_heatplace" />
    <TableColumn fx:id="tcMmRelayPre_place" prefWidth="150.0" sortable="true" text="Pre_place" />
    <TableColumn fx:id="tcMmRelayPre_jdplace" prefWidth="150.0" sortable="true" text="Pre_jdplace" />
    <TableColumn fx:id="tcMmRelayPre_exh" prefWidth="150.0" sortable="true" text="Pre_exh" />
    <TableColumn fx:id="tcMmRelayPre_points" prefWidth="150.0" sortable="true" text="Pre_points" />
    <TableColumn fx:id="tcMmRelayPre_back1" prefWidth="150.0" sortable="true" text="Pre_back1" />
    <TableColumn fx:id="tcMmRelayPre_back2" prefWidth="150.0" sortable="true" text="Pre_back2" />
    <TableColumn fx:id="tcMmRelayPre_back3" prefWidth="150.0" sortable="true" text="Pre_back3" />
    <TableColumn fx:id="tcMmRelayFin_heat" prefWidth="150.0" sortable="true" text="Fin_heat" />
    <TableColumn fx:id="tcMmRelayFin_lane" prefWidth="150.0" sortable="true" text="Fin_lane" />
    <TableColumn fx:id="tcMmRelayFin_group" prefWidth="150.0" sortable="true" text="Fin_group" />
    <TableColumn fx:id="tcMmRelayFin_stat" prefWidth="150.0" sortable="true" text="Fin_stat" />
    <TableColumn fx:id="tcMmRelayFin_Time" prefWidth="150.0" sortable="true" text="Fin_Time" />
    <TableColumn fx:id="tcMmRelayFin_course" prefWidth="150.0" sortable="true" text="Fin_course" />
    <TableColumn fx:id="tcMmRelayFin_heatplace" prefWidth="150.0" sortable="true" text="Fin_heatplace" />
    <TableColumn fx:id="tcMmRelayFin_jdheatplace" prefWidth="150.0" sortable="true" text="Fin_jdheatplace" />
    <TableColumn fx:id="tcMmRelayFin_place" prefWidth="150.0" sortable="true" text="Fin_place" />
    <TableColumn fx:id="tcMmRelayFin_jdplace" prefWidth="150.0" sortable="true" text="Fin_jdplace" />
    <TableColumn fx:id="tcMmRelayFin_ptsplace" prefWidth="150.0" sortable="true" text="Fin_ptsplace" />
    <TableColumn fx:id="tcMmRelayFin_exh" prefWidth="150.0" sortable="true" text="Fin_exh" />
    <TableColumn fx:id="tcMmRelayFin_points" prefWidth="150.0" sortable="true" text="Fin_points" />
    <TableColumn fx:id="tcMmRelayFin_back1" prefWidth="150.0" sortable="true" text="Fin_back1" />
    <TableColumn fx:id="tcMmRelayFin_back2" prefWidth="150.0" sortable="true" text="Fin_back2" />
    <TableColumn fx:id="tcMmRelayFin_back3" prefWidth="150.0" sortable="true" text="Fin_back3" />
    <TableColumn fx:id="tcMmRelaySem_heat" prefWidth="150.0" sortable="true" text="Sem_heat" />
    <TableColumn fx:id="tcMmRelaySem_lane" prefWidth="150.0" sortable="true" text="Sem_lane" />
    <TableColumn fx:id="tcMmRelaySem_stat" prefWidth="150.0" sortable="true" text="Sem_stat" />
    <TableColumn fx:id="tcMmRelaySem_Time" prefWidth="150.0" sortable="true" text="Sem_Time" />
    <TableColumn fx:id="tcMmRelaySem_course" prefWidth="150.0" sortable="true" text="Sem_course" />
    <TableColumn fx:id="tcMmRelaySem_heatplace" prefWidth="150.0" sortable="true" text="Sem_heatplace" />
    <TableColumn fx:id="tcMmRelaySem_place" prefWidth="150.0" sortable="true" text="Sem_place" />
    <TableColumn fx:id="tcMmRelaySem_jdplace" prefWidth="150.0" sortable="true" text="Sem_jdplace" />
    <TableColumn fx:id="tcMmRelaySem_exh" prefWidth="150.0" sortable="true" text="Sem_exh" />
    <TableColumn fx:id="tcMmRelaySem_points" prefWidth="150.0" sortable="true" text="Sem_points" />
    <TableColumn fx:id="tcMmRelaySem_back1" prefWidth="150.0" sortable="true" text="Sem_back1" />
    <TableColumn fx:id="tcMmRelaySem_back2" prefWidth="150.0" sortable="true" text="Sem_back2" />
    <TableColumn fx:id="tcMmRelaySem_back3" prefWidth="150.0" sortable="true" text="Sem_back3" />
    <TableColumn fx:id="tcMmRelaySwimoff_heat" prefWidth="150.0" sortable="true" text="Swimoff_heat" />
    <TableColumn fx:id="tcMmRelaySwimoff_lane" prefWidth="150.0" sortable="true" text="Swimoff_lane" />
    <TableColumn fx:id="tcMmRelaySwimoff_stat" prefWidth="150.0" sortable="true" text="Swimoff_stat" />
    <TableColumn fx:id="tcMmRelaySwimoff_Time" prefWidth="150.0" sortable="true" text="Swimoff_Time" />
    <TableColumn fx:id="tcMmRelaySwimoff_course" prefWidth="150.0" sortable="true" text="Swimoff_course" />
    <TableColumn fx:id="tcMmRelaySwimoff_heatplace" prefWidth="150.0" sortable="true" text="Swimoff_heatplace" />
    <TableColumn fx:id="tcMmRelaySwimoff_place" prefWidth="150.0" sortable="true" text="Swimoff_place" />
    <TableColumn fx:id="tcMmRelaySwimoff_jdplace" prefWidth="150.0" sortable="true" text="Swimoff_jdplace" />
    <TableColumn fx:id="tcMmRelaySwimoff_points" prefWidth="150.0" sortable="true" text="Swimoff_points" />
    <TableColumn fx:id="tcMmRelaySwimoff_back1" prefWidth="150.0" sortable="true" text="Swimoff_back1" />
    <TableColumn fx:id="tcMmRelaySwimoff_back2" prefWidth="150.0" sortable="true" text="Swimoff_back2" />
    <TableColumn fx:id="tcMmRelaySwimoff_back3" prefWidth="150.0" sortable="true" text="Swimoff_back3" />
    <TableColumn fx:id="tcMmRelayJDEv_score" prefWidth="150.0" sortable="true" text="JDEv_score" />
    <TableColumn fx:id="tcMmRelayRelay_no" prefWidth="150.0" sortable="true" text="Relay_no" />
    <TableColumn fx:id="tcMmRelaySeed_place" prefWidth="150.0" sortable="true" text="Seed_place" />
    <TableColumn fx:id="tcMmRelayfin_heatltr" prefWidth="150.0" sortable="true" text="fin_heatltr" />
    <TableColumn fx:id="tcMmRelayPre_watch1" prefWidth="150.0" sortable="true" text="Pre_watch1" />
    <TableColumn fx:id="tcMmRelayPre_pad" prefWidth="150.0" sortable="true" text="Pre_pad" />
    <TableColumn fx:id="tcMmRelaySem_watch1" prefWidth="150.0" sortable="true" text="Sem_watch1" />
    <TableColumn fx:id="tcMmRelaySem_pad" prefWidth="150.0" sortable="true" text="Sem_pad" />
    <TableColumn fx:id="tcMmRelayFin_watch1" prefWidth="150.0" sortable="true" text="Fin_watch1" />
    <TableColumn fx:id="tcMmRelayFin_pad" prefWidth="150.0" sortable="true" text="Fin_pad" />
    <TableColumn fx:id="tcMmRelayFin_reactiontime1" prefWidth="150.0" sortable="true" text="Fin_reactiontime1" />
    <TableColumn fx:id="tcMmRelayPre_reactiontime1" prefWidth="150.0" sortable="true" text="Pre_reactiontime1" />
    <TableColumn fx:id="tcMmRelaySem_reactiontime1" prefWidth="150.0" sortable="true" text="Sem_reactiontime1" />
    <TableColumn fx:id="tcMmRelayFin_dqcode" prefWidth="150.0" sortable="true" text="Fin_dqcode" />
    <TableColumn fx:id="tcMmRelayPre_dqcode" prefWidth="150.0" sortable="true" text="Pre_dqcode" />
    <TableColumn fx:id="tcMmRelaySem_dqcode" prefWidth="150.0" sortable="true" text="Sem_dqcode" />
    <TableColumn fx:id="tcMmRelayFin_dqcodeSecond" prefWidth="150.0" sortable="true" text="Fin_dqcodeSecond" />
    <TableColumn fx:id="tcMmRelayPre_dqcodeSecond" prefWidth="150.0" sortable="true" text="Pre_dqcodeSecond" />
    <TableColumn fx:id="tcMmRelaySem_dqcodeSecond" prefWidth="150.0" sortable="true" text="Sem_dqcodeSecond" />
    <TableColumn fx:id="tcMmRelayFin_reactiontime2" prefWidth="150.0" sortable="true" text="Fin_reactiontime2" />
    <TableColumn fx:id="tcMmRelayPre_reactiontime2" prefWidth="150.0" sortable="true" text="Pre_reactiontime2" />
    <TableColumn fx:id="tcMmRelaySem_reactiontime2" prefWidth="150.0" sortable="true" text="Sem_reactiontime2" />
    <TableColumn fx:id="tcMmRelayFin_reactiontime3" prefWidth="150.0" sortable="true" text="Fin_reactiontime3" />
    <TableColumn fx:id="tcMmRelayPre_reactiontime3" prefWidth="150.0" sortable="true" text="Pre_reactiontime3" />
    <TableColumn fx:id="tcMmRelaySem_reactiontime3" prefWidth="150.0" sortable="true" text="Sem_reactiontime3" />
    <TableColumn fx:id="tcMmRelayFin_reactiontime4" prefWidth="150.0" sortable="true" text="Fin_reactiontime4" />
    <TableColumn fx:id="tcMmRelayPre_reactiontime4" prefWidth="150.0" sortable="true" text="Pre_reactiontime4" />
    <TableColumn fx:id="tcMmRelaySem_reactiontime4" prefWidth="150.0" sortable="true" text="Sem_reactiontime4" />
    <TableColumn fx:id="tcMmRelayFin_TimeType" prefWidth="150.0" sortable="true" text="Fin_TimeType" />
    <TableColumn fx:id="tcMmRelayPre_TimeType" prefWidth="150.0" sortable="true" text="Pre_TimeType" />
    <TableColumn fx:id="tcMmRelaySem_TimeType" prefWidth="150.0" sortable="true" text="Sem_TimeType" />
    <TableColumn fx:id="tcMmRelayFin_dolphin1" prefWidth="150.0" sortable="true" text="Fin_dolphin1" />
    <TableColumn fx:id="tcMmRelayFin_dolphin2" prefWidth="150.0" sortable="true" text="Fin_dolphin2" />
    <TableColumn fx:id="tcMmRelayFin_dolphin3" prefWidth="150.0" sortable="true" text="Fin_dolphin3" />
    <TableColumn fx:id="tcMmRelayPre_dolphin1" prefWidth="150.0" sortable="true" text="Pre_dolphin1" />
    <TableColumn fx:id="tcMmRelayPre_dolphin2" prefWidth="150.0" sortable="true" text="Pre_dolphin2" />
    <TableColumn fx:id="tcMmRelayPre_dolphin3" prefWidth="150.0" sortable="true" text="Pre_dolphin3" />
    <TableColumn fx:id="tcMmRelaySem_dolphin1" prefWidth="150.0" sortable="true" text="Sem_dolphin1" />
    <TableColumn fx:id="tcMmRelaySem_dolphin2" prefWidth="150.0" sortable="true" text="Sem_dolphin2" />
    <TableColumn fx:id="tcMmRelaySem_dolphin3" prefWidth="150.0" sortable="true" text="Sem_dolphin3" />
    <TableColumn fx:id="tcMmRelayearly_seed" prefWidth="150.0" sortable="true" text="early_seed" />
    <TableColumn fx:id="tcMmRelayfin_adjuststat" prefWidth="150.0" sortable="true" text="fin_adjuststat" />
    <TableColumn fx:id="tcMmRelaypre_adjuststat" prefWidth="150.0" sortable="true" text="pre_adjuststat" />
    <TableColumn fx:id="tcMmRelaysem_adjuststat" prefWidth="150.0" sortable="true" text="sem_adjuststat" />
    <TableColumn fx:id="tcMmRelayentry_method" prefWidth="150.0" sortable="true" text="entry_method" />
    <TableColumn fx:id="tcMmRelayfin_dqofficial" prefWidth="150.0" sortable="true" text="fin_dqofficial" />
    <TableColumn fx:id="tcMmRelaypre_dqofficial" prefWidth="150.0" sortable="true" text="pre_dqofficial" />
    <TableColumn fx:id="tcMmRelaysem_dqofficial" prefWidth="150.0" sortable="true" text="sem_dqofficial" />
    <TableColumn fx:id="tcMmRelaypre_contacted" prefWidth="150.0" sortable="true" text="pre_contacted" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmRelay> tvMmRelay;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelayEvent_ptr;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelayTeam_no;
@FXML
private TableColumn<MmRelay,String> tcMmRelayTeam_ltr;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayRel_age;
@FXML
private TableColumn<MmRelay,String> tcMmRelayRel_sex;
@FXML
private TableColumn<MmRelay,String> tcMmRelayActSeed_course;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayActualSeed_time;
@FXML
private TableColumn<MmRelay,String> tcMmRelayConvSeed_course;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayConvSeed_time;
@FXML
private TableColumn<MmRelay,Boolean> tcMmRelayScr_stat;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySpec_stat;
@FXML
private TableColumn<MmRelay,String> tcMmRelayDec_stat;
@FXML
private TableColumn<MmRelay,Boolean> tcMmRelayAlt_stat;
@FXML
private TableColumn<MmRelay,Boolean> tcMmRelayBonus_event;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelayDiv_no;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayEv_score;
@FXML
private TableColumn<MmRelay,String> tcMmRelaydq_type;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_heat;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_lane;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_stat;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_Time;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_course;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_heatplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_place;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_jdplace;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_exh;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayPre_points;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_back1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_back2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_back3;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_heat;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_lane;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_group;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_stat;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_Time;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_course;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_heatplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_jdheatplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_place;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_jdplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_ptsplace;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_exh;
@FXML
private TableColumn<MmRelay,Short> tcMmRelayFin_points;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_back1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_back2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_back3;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_heat;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_lane;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_stat;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_Time;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_course;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_heatplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_place;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_jdplace;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_exh;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySem_points;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_back1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_back2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_back3;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_heat;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_lane;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySwimoff_stat;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySwimoff_Time;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySwimoff_course;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_heatplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_place;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_jdplace;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySwimoff_points;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySwimoff_back1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySwimoff_back2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySwimoff_back3;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayJDEv_score;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelayRelay_no;
@FXML
private TableColumn<MmRelay,Short> tcMmRelaySeed_place;
@FXML
private TableColumn<MmRelay,String> tcMmRelayfin_heatltr;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_watch1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_pad;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_watch1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_pad;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_watch1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_pad;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_reactiontime1;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_reactiontime1;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_reactiontime1;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_dqcode;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_dqcode;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_dqcode;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_dqcodeSecond;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_dqcodeSecond;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_dqcodeSecond;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_reactiontime2;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_reactiontime2;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_reactiontime2;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_reactiontime3;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_reactiontime3;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_reactiontime3;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_reactiontime4;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_reactiontime4;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_reactiontime4;
@FXML
private TableColumn<MmRelay,String> tcMmRelayFin_TimeType;
@FXML
private TableColumn<MmRelay,String> tcMmRelayPre_TimeType;
@FXML
private TableColumn<MmRelay,String> tcMmRelaySem_TimeType;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_dolphin1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_dolphin2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayFin_dolphin3;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_dolphin1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_dolphin2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelayPre_dolphin3;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_dolphin1;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_dolphin2;
@FXML
private TableColumn<MmRelay,Float> tcMmRelaySem_dolphin3;
@FXML
private TableColumn<MmRelay,Boolean> tcMmRelayearly_seed;
@FXML
private TableColumn<MmRelay,String> tcMmRelayfin_adjuststat;
@FXML
private TableColumn<MmRelay,String> tcMmRelaypre_adjuststat;
@FXML
private TableColumn<MmRelay,String> tcMmRelaysem_adjuststat;
@FXML
private TableColumn<MmRelay,String> tcMmRelayentry_method;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelayfin_dqofficial;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelaypre_dqofficial;
@FXML
private TableColumn<MmRelay,Integer> tcMmRelaysem_dqofficial;
@FXML
private TableColumn<MmRelay,Boolean> tcMmRelaypre_contacted;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcEvent_ptr,"Event_ptr"),
    new Pair(tcTeam_no,"Team_no"),
    new Pair(tcTeam_ltr,"Team_ltr"),
    new Pair(tcRel_age,"Rel_age"),
    new Pair(tcRel_sex,"Rel_sex"),
    new Pair(tcActSeed_course,"ActSeed_course"),
    new Pair(tcActualSeed_time,"ActualSeed_time"),
    new Pair(tcConvSeed_course,"ConvSeed_course"),
    new Pair(tcConvSeed_time,"ConvSeed_time"),
    new Pair(tcScr_stat,"Scr_stat"),
    new Pair(tcSpec_stat,"Spec_stat"),
    new Pair(tcDec_stat,"Dec_stat"),
    new Pair(tcAlt_stat,"Alt_stat"),
    new Pair(tcBonus_event,"Bonus_event"),
    new Pair(tcDiv_no,"Div_no"),
    new Pair(tcEv_score,"Ev_score"),
    new Pair(tcdq_type,"dq_type"),
    new Pair(tcPre_heat,"Pre_heat"),
    new Pair(tcPre_lane,"Pre_lane"),
    new Pair(tcPre_stat,"Pre_stat"),
    new Pair(tcPre_Time,"Pre_Time"),
    new Pair(tcPre_course,"Pre_course"),
    new Pair(tcPre_heatplace,"Pre_heatplace"),
    new Pair(tcPre_place,"Pre_place"),
    new Pair(tcPre_jdplace,"Pre_jdplace"),
    new Pair(tcPre_exh,"Pre_exh"),
    new Pair(tcPre_points,"Pre_points"),
    new Pair(tcPre_back1,"Pre_back1"),
    new Pair(tcPre_back2,"Pre_back2"),
    new Pair(tcPre_back3,"Pre_back3"),
    new Pair(tcFin_heat,"Fin_heat"),
    new Pair(tcFin_lane,"Fin_lane"),
    new Pair(tcFin_group,"Fin_group"),
    new Pair(tcFin_stat,"Fin_stat"),
    new Pair(tcFin_Time,"Fin_Time"),
    new Pair(tcFin_course,"Fin_course"),
    new Pair(tcFin_heatplace,"Fin_heatplace"),
    new Pair(tcFin_jdheatplace,"Fin_jdheatplace"),
    new Pair(tcFin_place,"Fin_place"),
    new Pair(tcFin_jdplace,"Fin_jdplace"),
    new Pair(tcFin_ptsplace,"Fin_ptsplace"),
    new Pair(tcFin_exh,"Fin_exh"),
    new Pair(tcFin_points,"Fin_points"),
    new Pair(tcFin_back1,"Fin_back1"),
    new Pair(tcFin_back2,"Fin_back2"),
    new Pair(tcFin_back3,"Fin_back3"),
    new Pair(tcSem_heat,"Sem_heat"),
    new Pair(tcSem_lane,"Sem_lane"),
    new Pair(tcSem_stat,"Sem_stat"),
    new Pair(tcSem_Time,"Sem_Time"),
    new Pair(tcSem_course,"Sem_course"),
    new Pair(tcSem_heatplace,"Sem_heatplace"),
    new Pair(tcSem_place,"Sem_place"),
    new Pair(tcSem_jdplace,"Sem_jdplace"),
    new Pair(tcSem_exh,"Sem_exh"),
    new Pair(tcSem_points,"Sem_points"),
    new Pair(tcSem_back1,"Sem_back1"),
    new Pair(tcSem_back2,"Sem_back2"),
    new Pair(tcSem_back3,"Sem_back3"),
    new Pair(tcSwimoff_heat,"Swimoff_heat"),
    new Pair(tcSwimoff_lane,"Swimoff_lane"),
    new Pair(tcSwimoff_stat,"Swimoff_stat"),
    new Pair(tcSwimoff_Time,"Swimoff_Time"),
    new Pair(tcSwimoff_course,"Swimoff_course"),
    new Pair(tcSwimoff_heatplace,"Swimoff_heatplace"),
    new Pair(tcSwimoff_place,"Swimoff_place"),
    new Pair(tcSwimoff_jdplace,"Swimoff_jdplace"),
    new Pair(tcSwimoff_points,"Swimoff_points"),
    new Pair(tcSwimoff_back1,"Swimoff_back1"),
    new Pair(tcSwimoff_back2,"Swimoff_back2"),
    new Pair(tcSwimoff_back3,"Swimoff_back3"),
    new Pair(tcJDEv_score,"JDEv_score"),
    new Pair(tcRelay_no,"Relay_no"),
    new Pair(tcSeed_place,"Seed_place"),
    new Pair(tcfin_heatltr,"fin_heatltr"),
    new Pair(tcPre_watch1,"Pre_watch1"),
    new Pair(tcPre_pad,"Pre_pad"),
    new Pair(tcSem_watch1,"Sem_watch1"),
    new Pair(tcSem_pad,"Sem_pad"),
    new Pair(tcFin_watch1,"Fin_watch1"),
    new Pair(tcFin_pad,"Fin_pad"),
    new Pair(tcFin_reactiontime1,"Fin_reactiontime1"),
    new Pair(tcPre_reactiontime1,"Pre_reactiontime1"),
    new Pair(tcSem_reactiontime1,"Sem_reactiontime1"),
    new Pair(tcFin_dqcode,"Fin_dqcode"),
    new Pair(tcPre_dqcode,"Pre_dqcode"),
    new Pair(tcSem_dqcode,"Sem_dqcode"),
    new Pair(tcFin_dqcodeSecond,"Fin_dqcodeSecond"),
    new Pair(tcPre_dqcodeSecond,"Pre_dqcodeSecond"),
    new Pair(tcSem_dqcodeSecond,"Sem_dqcodeSecond"),
    new Pair(tcFin_reactiontime2,"Fin_reactiontime2"),
    new Pair(tcPre_reactiontime2,"Pre_reactiontime2"),
    new Pair(tcSem_reactiontime2,"Sem_reactiontime2"),
    new Pair(tcFin_reactiontime3,"Fin_reactiontime3"),
    new Pair(tcPre_reactiontime3,"Pre_reactiontime3"),
    new Pair(tcSem_reactiontime3,"Sem_reactiontime3"),
    new Pair(tcFin_reactiontime4,"Fin_reactiontime4"),
    new Pair(tcPre_reactiontime4,"Pre_reactiontime4"),
    new Pair(tcSem_reactiontime4,"Sem_reactiontime4"),
    new Pair(tcFin_TimeType,"Fin_TimeType"),
    new Pair(tcPre_TimeType,"Pre_TimeType"),
    new Pair(tcSem_TimeType,"Sem_TimeType"),
    new Pair(tcFin_dolphin1,"Fin_dolphin1"),
    new Pair(tcFin_dolphin2,"Fin_dolphin2"),
    new Pair(tcFin_dolphin3,"Fin_dolphin3"),
    new Pair(tcPre_dolphin1,"Pre_dolphin1"),
    new Pair(tcPre_dolphin2,"Pre_dolphin2"),
    new Pair(tcPre_dolphin3,"Pre_dolphin3"),
    new Pair(tcSem_dolphin1,"Sem_dolphin1"),
    new Pair(tcSem_dolphin2,"Sem_dolphin2"),
    new Pair(tcSem_dolphin3,"Sem_dolphin3"),
    new Pair(tcearly_seed,"early_seed"),
    new Pair(tcfin_adjuststat,"fin_adjuststat"),
    new Pair(tcpre_adjuststat,"pre_adjuststat"),
    new Pair(tcsem_adjuststat,"sem_adjuststat"),
    new Pair(tcentry_method,"entry_method"),
    new Pair(tcfin_dqofficial,"fin_dqofficial"),
    new Pair(tcpre_dqofficial,"pre_dqofficial"),
    new Pair(tcsem_dqofficial,"sem_dqofficial"),
    new Pair(tcpre_contacted,"pre_contacted")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
