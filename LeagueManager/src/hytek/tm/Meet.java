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
 * CREATE TABLE [MEET]
 * (
 * [Meet]			Long Integer,
 * [MName]			Text (90),
 * [Start]			DateTime,
 * [End]			DateTime,
 * [AgeUp]			DateTime,
 * [Since]			DateTime,
 * [Course]			Text (4),
 * [Location]			Text (90),
 * [Remarks]			Text (100),
 * [IndCharge]			Single,
 * [RelCharge]			Single,
 * [SurCharge]			Single,
 * [Type]			Text (6),
 * [Sanction]			Text (30),
 * [MaxIndEnt]			Integer,
 * [MaxRelEnt]			Integer,
 * [MaxEnt]			Integer,
 * [RestrictBest]			Boolean NOT NULL,
 * [NonConform]			Double,
 * [EnterAtQTime]			Boolean NOT NULL,
 * [FacilityFee]			Single,
 * [TeamFee]			Single,
 * [Instructions]			Text (500),
 * [MinAge]			Integer,
 * [EnforceQualifying]			Boolean NOT NULL,
 * [Altitude]			Integer,
 * [EnforceSlowQtime]			Boolean NOT NULL,
 * [BanNoTimes]			Boolean NOT NULL,
 * [Lanes]			Integer,
 * [EvenOrOdd]			Integer,
 * [FastToSlow]			Boolean NOT NULL,
 * [Masters]			Boolean NOT NULL,
 * [ActiveFeeXMLSent]			Boolean NOT NULL,
 * [MinAge10AndUnder]			Integer,
 * [SeedLanes]			Text (32),
 * [DeadLine]			DateTime,
 * [ActiveMeetID]			Long Integer,
 * [CustIndCharge]			Single,
 * [CustRelCharge]			Single,
 * [CustSurCharge]			Single,
 * [CustIndAction]			Byte,
 * [CustRelAction]			Byte,
 * [CustSurAction]			Byte,
 * [Addr]			Text (60),
 * [Addr2]			Text (60),
 * [City]			Text (60),
 * [State]			Text (6),
 * [ZIP]			Text (20),
 * [Cntry]			Text (40),
 * [UseCustomFees]			Boolean NOT NULL,
 * [OMEEntryStyle]			Byte,
 * [SwimmerEntryDeadLine]			DateTime,
 * [SwimmerEntryOpen]			DateTime,
 * [AllowCustomTimes]			Boolean NOT NULL,
 * [ExportEntriesDate]			DateTime,
 * [LastSyncDate]			DateTime,
 * [FinalizeEntriesDate]			DateTime,
 * [UseSwimmersTeam]			Boolean NOT NULL,
 * [HonorInviteList]			Boolean NOT NULL,
 * [EntryTeam]			Long Integer,
 * [EMailFrom]			Text (100),
 * [EMailText]			Text (508),
 * [EMailSubject]			Text (200),
 * [OnlyPreEntered]			Boolean NOT NULL,
 * [License]			Text (240),
 * [CollectFeesOnline]			Boolean NOT NULL,
 * [OMEBillDate]			DateTime,
 * [InviteEmailDate]			DateTime,
 * [EntryEMailText]			Text (508),
 * [EntryEMailSubject]			Text (200),
 * [EntryEMailFrom]			Text (100),
 * [OMEValidated]			Boolean NOT NULL,
 * [OMECustomTeam]			Boolean NOT NULL,
 * [OMEFilterTeam]			Long Integer,
 * [OMENeedsSync]			Boolean NOT NULL,
 * [OMENeedSync]			Boolean NOT NULL,
 * [MeetSharingStatus]			Text (40),
 * [FileExportType]			Integer,
 * [MeetRegistrationOpens]			DateTime,
 * [MeetRegistrationCloses]			DateTime,
 * [MeetSharingMeetID]			Long Integer,
 * [MeetSharingPayStatus]			Text (40),
 * [MeetSharingResultDate]			DateTime,
 * [EV3Version]			Byte
 * );
 */
public class Meet {

    public static String NAME = "Meet";
    private Meet() {
    }

    public Meet(final com.healthmarketscience.jackcess.Row row){

        meet = (Integer) row.get(Meet.MEET);
        mname = (String) row.get(Meet.MNAME);
        start = (java.time.LocalDateTime) row.get(Meet.START);
        end = (java.time.LocalDateTime) row.get(Meet.END);
        ageup = (java.time.LocalDateTime) row.get(Meet.AGEUP);
        since = (java.time.LocalDateTime) row.get(Meet.SINCE);
        course = (String) row.get(Meet.COURSE);
        location = (String) row.get(Meet.LOCATION);
        remarks = (String) row.get(Meet.REMARKS);
        indcharge = (Float) row.get(Meet.INDCHARGE);
        relcharge = (Float) row.get(Meet.RELCHARGE);
        surcharge = (Float) row.get(Meet.SURCHARGE);
        type = (String) row.get(Meet.TYPE);
        sanction = (String) row.get(Meet.SANCTION);
        maxindent = (Short) row.get(Meet.MAXINDENT);
        maxrelent = (Short) row.get(Meet.MAXRELENT);
        maxent = (Short) row.get(Meet.MAXENT);
        restrictbest = (Boolean) row.get(Meet.RESTRICTBEST);
        nonconform = (Double) row.get(Meet.NONCONFORM);
        enteratqtime = (Boolean) row.get(Meet.ENTERATQTIME);
        facilityfee = (Float) row.get(Meet.FACILITYFEE);
        teamfee = (Float) row.get(Meet.TEAMFEE);
        instructions = (String) row.get(Meet.INSTRUCTIONS);
        minage = (Short) row.get(Meet.MINAGE);
        enforcequalifying = (Boolean) row.get(Meet.ENFORCEQUALIFYING);
        altitude = (Short) row.get(Meet.ALTITUDE);
        enforceslowqtime = (Boolean) row.get(Meet.ENFORCESLOWQTIME);
        bannotimes = (Boolean) row.get(Meet.BANNOTIMES);
        lanes = (Short) row.get(Meet.LANES);
        evenorodd = (Short) row.get(Meet.EVENORODD);
        fasttoslow = (Boolean) row.get(Meet.FASTTOSLOW);
        masters = (Boolean) row.get(Meet.MASTERS);
        activefeexmlsent = (Boolean) row.get(Meet.ACTIVEFEEXMLSENT);
        minage10andunder = (Short) row.get(Meet.MINAGE10ANDUNDER);
        seedlanes = (String) row.get(Meet.SEEDLANES);
        deadline = (java.time.LocalDateTime) row.get(Meet.DEADLINE);
        activemeetid = (Integer) row.get(Meet.ACTIVEMEETID);
        custindcharge = (Float) row.get(Meet.CUSTINDCHARGE);
        custrelcharge = (Float) row.get(Meet.CUSTRELCHARGE);
        custsurcharge = (Float) row.get(Meet.CUSTSURCHARGE);
        custindaction = (Byte) row.get(Meet.CUSTINDACTION);
        custrelaction = (Byte) row.get(Meet.CUSTRELACTION);
        custsuraction = (Byte) row.get(Meet.CUSTSURACTION);
        addr = (String) row.get(Meet.ADDR);
        addr2 = (String) row.get(Meet.ADDR2);
        city = (String) row.get(Meet.CITY);
        state = (String) row.get(Meet.STATE);
        zip = (String) row.get(Meet.ZIP);
        cntry = (String) row.get(Meet.CNTRY);
        usecustomfees = (Boolean) row.get(Meet.USECUSTOMFEES);
        omeentrystyle = (Byte) row.get(Meet.OMEENTRYSTYLE);
        swimmerentrydeadline = (java.time.LocalDateTime) row.get(Meet.SWIMMERENTRYDEADLINE);
        swimmerentryopen = (java.time.LocalDateTime) row.get(Meet.SWIMMERENTRYOPEN);
        allowcustomtimes = (Boolean) row.get(Meet.ALLOWCUSTOMTIMES);
        exportentriesdate = (java.time.LocalDateTime) row.get(Meet.EXPORTENTRIESDATE);
        lastsyncdate = (java.time.LocalDateTime) row.get(Meet.LASTSYNCDATE);
        finalizeentriesdate = (java.time.LocalDateTime) row.get(Meet.FINALIZEENTRIESDATE);
        useswimmersteam = (Boolean) row.get(Meet.USESWIMMERSTEAM);
        honorinvitelist = (Boolean) row.get(Meet.HONORINVITELIST);
        entryteam = (Integer) row.get(Meet.ENTRYTEAM);
        emailfrom = (String) row.get(Meet.EMAILFROM);
        emailtext = (String) row.get(Meet.EMAILTEXT);
        emailsubject = (String) row.get(Meet.EMAILSUBJECT);
        onlypreentered = (Boolean) row.get(Meet.ONLYPREENTERED);
        license = (String) row.get(Meet.LICENSE);
        collectfeesonline = (Boolean) row.get(Meet.COLLECTFEESONLINE);
        omebilldate = (java.time.LocalDateTime) row.get(Meet.OMEBILLDATE);
        inviteemaildate = (java.time.LocalDateTime) row.get(Meet.INVITEEMAILDATE);
        entryemailtext = (String) row.get(Meet.ENTRYEMAILTEXT);
        entryemailsubject = (String) row.get(Meet.ENTRYEMAILSUBJECT);
        entryemailfrom = (String) row.get(Meet.ENTRYEMAILFROM);
        omevalidated = (Boolean) row.get(Meet.OMEVALIDATED);
        omecustomteam = (Boolean) row.get(Meet.OMECUSTOMTEAM);
        omefilterteam = (Integer) row.get(Meet.OMEFILTERTEAM);
        omeneedssync = (Boolean) row.get(Meet.OMENEEDSSYNC);
        omeneedsync = (Boolean) row.get(Meet.OMENEEDSYNC);
        meetsharingstatus = (String) row.get(Meet.MEETSHARINGSTATUS);
        fileexporttype = (Short) row.get(Meet.FILEEXPORTTYPE);
        meetregistrationopens = (java.time.LocalDateTime) row.get(Meet.MEETREGISTRATIONOPENS);
        meetregistrationcloses = (java.time.LocalDateTime) row.get(Meet.MEETREGISTRATIONCLOSES);
        meetsharingmeetid = (Integer) row.get(Meet.MEETSHARINGMEETID);
        meetsharingpaystatus = (String) row.get(Meet.MEETSHARINGPAYSTATUS);
        meetsharingresultdate = (java.time.LocalDateTime) row.get(Meet.MEETSHARINGRESULTDATE);
        ev3version = (Byte) row.get(Meet.EV3VERSION);
    }


    public static final String MEET = "Meet";
    public static final String MNAME = "MName";
    public static final String START = "Start";
    public static final String END = "End";
    public static final String AGEUP = "AgeUp";
    public static final String SINCE = "Since";
    public static final String COURSE = "Course";
    public static final String LOCATION = "Location";
    public static final String REMARKS = "Remarks";
    public static final String INDCHARGE = "IndCharge";
    public static final String RELCHARGE = "RelCharge";
    public static final String SURCHARGE = "SurCharge";
    public static final String TYPE = "Type";
    public static final String SANCTION = "Sanction";
    public static final String MAXINDENT = "MaxIndEnt";
    public static final String MAXRELENT = "MaxRelEnt";
    public static final String MAXENT = "MaxEnt";
    public static final String RESTRICTBEST = "RestrictBest";
    public static final String NONCONFORM = "NonConform";
    public static final String ENTERATQTIME = "EnterAtQTime";
    public static final String FACILITYFEE = "FacilityFee";
    public static final String TEAMFEE = "TeamFee";
    public static final String INSTRUCTIONS = "Instructions";
    public static final String MINAGE = "MinAge";
    public static final String ENFORCEQUALIFYING = "EnforceQualifying";
    public static final String ALTITUDE = "Altitude";
    public static final String ENFORCESLOWQTIME = "EnforceSlowQtime";
    public static final String BANNOTIMES = "BanNoTimes";
    public static final String LANES = "Lanes";
    public static final String EVENORODD = "EvenOrOdd";
    public static final String FASTTOSLOW = "FastToSlow";
    public static final String MASTERS = "Masters";
    public static final String ACTIVEFEEXMLSENT = "ActiveFeeXMLSent";
    public static final String MINAGE10ANDUNDER = "MinAge10AndUnder";
    public static final String SEEDLANES = "SeedLanes";
    public static final String DEADLINE = "DeadLine";
    public static final String ACTIVEMEETID = "ActiveMeetID";
    public static final String CUSTINDCHARGE = "CustIndCharge";
    public static final String CUSTRELCHARGE = "CustRelCharge";
    public static final String CUSTSURCHARGE = "CustSurCharge";
    public static final String CUSTINDACTION = "CustIndAction";
    public static final String CUSTRELACTION = "CustRelAction";
    public static final String CUSTSURACTION = "CustSurAction";
    public static final String ADDR = "Addr";
    public static final String ADDR2 = "Addr2";
    public static final String CITY = "City";
    public static final String STATE = "State";
    public static final String ZIP = "ZIP";
    public static final String CNTRY = "Cntry";
    public static final String USECUSTOMFEES = "UseCustomFees";
    public static final String OMEENTRYSTYLE = "OMEEntryStyle";
    public static final String SWIMMERENTRYDEADLINE = "SwimmerEntryDeadLine";
    public static final String SWIMMERENTRYOPEN = "SwimmerEntryOpen";
    public static final String ALLOWCUSTOMTIMES = "AllowCustomTimes";
    public static final String EXPORTENTRIESDATE = "ExportEntriesDate";
    public static final String LASTSYNCDATE = "LastSyncDate";
    public static final String FINALIZEENTRIESDATE = "FinalizeEntriesDate";
    public static final String USESWIMMERSTEAM = "UseSwimmersTeam";
    public static final String HONORINVITELIST = "HonorInviteList";
    public static final String ENTRYTEAM = "EntryTeam";
    public static final String EMAILFROM = "EMailFrom";
    public static final String EMAILTEXT = "EMailText";
    public static final String EMAILSUBJECT = "EMailSubject";
    public static final String ONLYPREENTERED = "OnlyPreEntered";
    public static final String LICENSE = "License";
    public static final String COLLECTFEESONLINE = "CollectFeesOnline";
    public static final String OMEBILLDATE = "OMEBillDate";
    public static final String INVITEEMAILDATE = "InviteEmailDate";
    public static final String ENTRYEMAILTEXT = "EntryEMailText";
    public static final String ENTRYEMAILSUBJECT = "EntryEMailSubject";
    public static final String ENTRYEMAILFROM = "EntryEMailFrom";
    public static final String OMEVALIDATED = "OMEValidated";
    public static final String OMECUSTOMTEAM = "OMECustomTeam";
    public static final String OMEFILTERTEAM = "OMEFilterTeam";
    public static final String OMENEEDSSYNC = "OMENeedsSync";
    public static final String OMENEEDSYNC = "OMENeedSync";
    public static final String MEETSHARINGSTATUS = "MeetSharingStatus";
    public static final String FILEEXPORTTYPE = "FileExportType";
    public static final String MEETREGISTRATIONOPENS = "MeetRegistrationOpens";
    public static final String MEETREGISTRATIONCLOSES = "MeetRegistrationCloses";
    public static final String MEETSHARINGMEETID = "MeetSharingMeetID";
    public static final String MEETSHARINGPAYSTATUS = "MeetSharingPayStatus";
    public static final String MEETSHARINGRESULTDATE = "MeetSharingResultDate";
    public static final String EV3VERSION = "EV3Version";
    private Integer meet = null;
    private String mname = null;
    private java.time.LocalDateTime start = null;
    private java.time.LocalDateTime end = null;
    private java.time.LocalDateTime ageup = null;
    private java.time.LocalDateTime since = null;
    private String course = null;
    private String location = null;
    private String remarks = null;
    private Float indcharge = null;
    private Float relcharge = null;
    private Float surcharge = null;
    private String type = null;
    private String sanction = null;
    private Short maxindent = null;
    private Short maxrelent = null;
    private Short maxent = null;
    private Boolean restrictbest = null;
    private Double nonconform = null;
    private Boolean enteratqtime = null;
    private Float facilityfee = null;
    private Float teamfee = null;
    private String instructions = null;
    private Short minage = null;
    private Boolean enforcequalifying = null;
    private Short altitude = null;
    private Boolean enforceslowqtime = null;
    private Boolean bannotimes = null;
    private Short lanes = null;
    private Short evenorodd = null;
    private Boolean fasttoslow = null;
    private Boolean masters = null;
    private Boolean activefeexmlsent = null;
    private Short minage10andunder = null;
    private String seedlanes = null;
    private java.time.LocalDateTime deadline = null;
    private Integer activemeetid = null;
    private Float custindcharge = null;
    private Float custrelcharge = null;
    private Float custsurcharge = null;
    private Byte custindaction = null;
    private Byte custrelaction = null;
    private Byte custsuraction = null;
    private String addr = null;
    private String addr2 = null;
    private String city = null;
    private String state = null;
    private String zip = null;
    private String cntry = null;
    private Boolean usecustomfees = null;
    private Byte omeentrystyle = null;
    private java.time.LocalDateTime swimmerentrydeadline = null;
    private java.time.LocalDateTime swimmerentryopen = null;
    private Boolean allowcustomtimes = null;
    private java.time.LocalDateTime exportentriesdate = null;
    private java.time.LocalDateTime lastsyncdate = null;
    private java.time.LocalDateTime finalizeentriesdate = null;
    private Boolean useswimmersteam = null;
    private Boolean honorinvitelist = null;
    private Integer entryteam = null;
    private String emailfrom = null;
    private String emailtext = null;
    private String emailsubject = null;
    private Boolean onlypreentered = null;
    private String license = null;
    private Boolean collectfeesonline = null;
    private java.time.LocalDateTime omebilldate = null;
    private java.time.LocalDateTime inviteemaildate = null;
    private String entryemailtext = null;
    private String entryemailsubject = null;
    private String entryemailfrom = null;
    private Boolean omevalidated = null;
    private Boolean omecustomteam = null;
    private Integer omefilterteam = null;
    private Boolean omeneedssync = null;
    private Boolean omeneedsync = null;
    private String meetsharingstatus = null;
    private Short fileexporttype = null;
    private java.time.LocalDateTime meetregistrationopens = null;
    private java.time.LocalDateTime meetregistrationcloses = null;
    private Integer meetsharingmeetid = null;
    private String meetsharingpaystatus = null;
    private java.time.LocalDateTime meetsharingresultdate = null;
    private Byte ev3version = null;
    public Integer getMeet() {
        return meet;
    }
    public String getMname() {
        return mname;
    }
    public java.time.LocalDateTime getStart() {
        return start;
    }
    public java.time.LocalDateTime getEnd() {
        return end;
    }
    public java.time.LocalDateTime getAgeup() {
        return ageup;
    }
    public java.time.LocalDateTime getSince() {
        return since;
    }
    public String getCourse() {
        return course;
    }
    public String getLocation() {
        return location;
    }
    public String getRemarks() {
        return remarks;
    }
    public Float getIndcharge() {
        return indcharge;
    }
    public Float getRelcharge() {
        return relcharge;
    }
    public Float getSurcharge() {
        return surcharge;
    }
    public String getType() {
        return type;
    }
    public String getSanction() {
        return sanction;
    }
    public Short getMaxindent() {
        return maxindent;
    }
    public Short getMaxrelent() {
        return maxrelent;
    }
    public Short getMaxent() {
        return maxent;
    }
    public Boolean getRestrictbest() {
        return restrictbest;
    }
    public Double getNonconform() {
        return nonconform;
    }
    public Boolean getEnteratqtime() {
        return enteratqtime;
    }
    public Float getFacilityfee() {
        return facilityfee;
    }
    public Float getTeamfee() {
        return teamfee;
    }
    public String getInstructions() {
        return instructions;
    }
    public Short getMinage() {
        return minage;
    }
    public Boolean getEnforcequalifying() {
        return enforcequalifying;
    }
    public Short getAltitude() {
        return altitude;
    }
    public Boolean getEnforceslowqtime() {
        return enforceslowqtime;
    }
    public Boolean getBannotimes() {
        return bannotimes;
    }
    public Short getLanes() {
        return lanes;
    }
    public Short getEvenorodd() {
        return evenorodd;
    }
    public Boolean getFasttoslow() {
        return fasttoslow;
    }
    public Boolean getMasters() {
        return masters;
    }
    public Boolean getActivefeexmlsent() {
        return activefeexmlsent;
    }
    public Short getMinage10andunder() {
        return minage10andunder;
    }
    public String getSeedlanes() {
        return seedlanes;
    }
    public java.time.LocalDateTime getDeadline() {
        return deadline;
    }
    public Integer getActivemeetid() {
        return activemeetid;
    }
    public Float getCustindcharge() {
        return custindcharge;
    }
    public Float getCustrelcharge() {
        return custrelcharge;
    }
    public Float getCustsurcharge() {
        return custsurcharge;
    }
    public Byte getCustindaction() {
        return custindaction;
    }
    public Byte getCustrelaction() {
        return custrelaction;
    }
    public Byte getCustsuraction() {
        return custsuraction;
    }
    public String getAddr() {
        return addr;
    }
    public String getAddr2() {
        return addr2;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getCntry() {
        return cntry;
    }
    public Boolean getUsecustomfees() {
        return usecustomfees;
    }
    public Byte getOmeentrystyle() {
        return omeentrystyle;
    }
    public java.time.LocalDateTime getSwimmerentrydeadline() {
        return swimmerentrydeadline;
    }
    public java.time.LocalDateTime getSwimmerentryopen() {
        return swimmerentryopen;
    }
    public Boolean getAllowcustomtimes() {
        return allowcustomtimes;
    }
    public java.time.LocalDateTime getExportentriesdate() {
        return exportentriesdate;
    }
    public java.time.LocalDateTime getLastsyncdate() {
        return lastsyncdate;
    }
    public java.time.LocalDateTime getFinalizeentriesdate() {
        return finalizeentriesdate;
    }
    public Boolean getUseswimmersteam() {
        return useswimmersteam;
    }
    public Boolean getHonorinvitelist() {
        return honorinvitelist;
    }
    public Integer getEntryteam() {
        return entryteam;
    }
    public String getEmailfrom() {
        return emailfrom;
    }
    public String getEmailtext() {
        return emailtext;
    }
    public String getEmailsubject() {
        return emailsubject;
    }
    public Boolean getOnlypreentered() {
        return onlypreentered;
    }
    public String getLicense() {
        return license;
    }
    public Boolean getCollectfeesonline() {
        return collectfeesonline;
    }
    public java.time.LocalDateTime getOmebilldate() {
        return omebilldate;
    }
    public java.time.LocalDateTime getInviteemaildate() {
        return inviteemaildate;
    }
    public String getEntryemailtext() {
        return entryemailtext;
    }
    public String getEntryemailsubject() {
        return entryemailsubject;
    }
    public String getEntryemailfrom() {
        return entryemailfrom;
    }
    public Boolean getOmevalidated() {
        return omevalidated;
    }
    public Boolean getOmecustomteam() {
        return omecustomteam;
    }
    public Integer getOmefilterteam() {
        return omefilterteam;
    }
    public Boolean getOmeneedssync() {
        return omeneedssync;
    }
    public Boolean getOmeneedsync() {
        return omeneedsync;
    }
    public String getMeetsharingstatus() {
        return meetsharingstatus;
    }
    public Short getFileexporttype() {
        return fileexporttype;
    }
    public java.time.LocalDateTime getMeetregistrationopens() {
        return meetregistrationopens;
    }
    public java.time.LocalDateTime getMeetregistrationcloses() {
        return meetregistrationcloses;
    }
    public Integer getMeetsharingmeetid() {
        return meetsharingmeetid;
    }
    public String getMeetsharingpaystatus() {
        return meetsharingpaystatus;
    }
    public java.time.LocalDateTime getMeetsharingresultdate() {
        return meetsharingresultdate;
    }
    public Byte getEv3version() {
        return ev3version;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "meet=" + meet +
                ", mname='" + mname + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", ageup=" + ageup +
                ", since=" + since +
                ", course='" + course + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", maxent=" + maxent +
                '}';
    }
}
