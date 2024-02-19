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
 * CREATE TABLE [Athlete]
 * (
 * [Athlete]               Long Integer,
 * [Team1]                 Long Integer,
 * #        [Team2]                 Long Integer,
 * #        [Team3]                 Long Integer,
 * #        [Group]                 Text (6),
 * #        [SubGr]                 Text (6),
 * [Last]                  Text (40),
 * [First]                 Text (40),
 * [Initial]               Text (2),
 * [Sex]                   Text (2),
 * [Birth]                 DateTime,
 * [Age]                   Integer,
 * #        [Class]                 Text (6),
 * [ID_NO]                 Text (34),
 * #        [Citizen]               Text (6),
 * #        [Inactive]              Boolean NOT NULL,
 * #        [Pref]                  Text (40),
 * #        [Batch]                 Integer,
 * #        [WMGroup]               Text (6),
 * #        [WMSubGr]               Text (6),
 * #        [BCSSASwimmer]          Text (4),
 * #        [BCSSADiver]            Text (4),
 * #        [BCSSASyncro]           Text (4),
 * #        [BCSSAPolo]             Text (4),
 * #        [TheSort]               Long Integer,
 * #        [DiveCertified]         Boolean NOT NULL,
 * #        [DateClubJoined]        DateTime,
 * #        [DateGroupJoined]       DateTime,
 * #        [AWRegType]             Text (2),
 * #        [RegYear]               Integer,
 * #        [Foreign]               Boolean NOT NULL,
 * #        [ForeignCitizenOf]      Text (6),
 * #        [LastUpdated]           DateTime,
 * #        [PC_Hide]               Boolean NOT NULL
 * );
 */
public class TmAthlete {

    public static String NAME = "Athlete";
    private TmAthlete() {
    }

    public static TmAthlete create(final com.healthmarketscience.jackcess.Row row){

       var obj = new TmAthlete();
        obj.athlete = (Integer) row.get(TmAthlete.ATHLETE);
        obj.team1 = (Integer) row.get(TmAthlete.TEAM1);
        obj.last = (String) row.get(TmAthlete.LAST);
        obj.first = (String) row.get(TmAthlete.FIRST);
        obj.initial = (String) row.get(TmAthlete.INITIAL);
        obj.sex = (String) row.get(TmAthlete.SEX);
        obj.birth = (java.time.LocalDateTime) row.get(TmAthlete.BIRTH);
        obj.age = (Short) row.get(TmAthlete.AGE);
        obj.id_no = (String) row.get(TmAthlete.ID_NO);


        obj.results = new ArrayList<>();

        return obj;
    }


    // 
    // Column names
    //
    public static final String ATHLETE = "Athlete";
    public static final String TEAM1 = "Team1";
    public static final String LAST = "Last";
    public static final String FIRST = "First";
    public static final String INITIAL = "Initial";
    public static final String SEX = "Sex";
    public static final String BIRTH = "Birth";
    public static final String AGE = "Age";
    public static final String ID_NO = "ID_NO";
    // 
    // members
    //
    private Integer athlete = null;
    private Integer team1 = null;
    private String last = null;
    private String first = null;
    private String initial = null;
    private String sex = null;
    private java.time.LocalDateTime birth = null;
    private Short age = null;
    private String id_no = null;
    //
    // getters
    //
    public Integer getAthlete() {
        return athlete;
    }
    public Integer getTeam1() {
        return team1;
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
    public String getId_no() {
        return id_no;
    }

    public List<TmResult> getResults() {
        return results;
    }
    private List<TmResult> results = null;
    public void add(TmResult r) {
        results.add(r);
    }
}
