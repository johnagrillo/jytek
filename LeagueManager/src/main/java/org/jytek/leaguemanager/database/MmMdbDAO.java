package org.jytek.leaguemanager.database;

import org.jytek.leaguemanager.view.MmEntry;
import org.jytek.leaguemanager.view.MmTagnames;
import org.jytek.leaguemanager.view.MmTimestd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 * TmMdbDAO
 * Read tables from a Team Manager MDB(Access DataBase).
 */

public class MmMdbDAO {

    private File file = null;
    private Map<Integer, ArrayList<MmEntry>> entryResults;

    public ArrayList<MmEntry> getEntrys() {
        return entrys;
    }

    private ArrayList<MmEntry> entrys = null;

    private MmEventDAO events = null;

    public MmEventDAO getEvents() {
        return events;
    }

    public MmAthleteDAO getAthletes() {
        return athletes;
    }

    private MmAthleteDAO athletes = null;

    public MmTeamDAO getTeams() {
        return teams;
    }
    private MmMeetDAO meets= null;
    public MmMeetDAO getMeets() {
        return meets;
    }
    private MmTeamDAO teams = null;




    private MmMdbDAO() {

    }
    private MmMdbDAO(File input) {
        try {
            final var db = com.healthmarketscience.jackcess.DatabaseBuilder.open(input);

            entrys = new ArrayList<>();
            db.getTable(MmEntry.NAME).forEach(row -> {
                entrys.add(MmEntry.read(row));
            });

            db.getTable(MmTimestd.NAME).forEach(row -> {
                //System.out.println(row);

                //entrys.add(MmEntry.read(row));
            });


            db.getTable(MmTagnames.NAME).forEach(row -> {
                System.out.println(row);

                //entrys.add(MmEntry.read(row));
            });





            events = MmEventDAO.load(db);
            athletes = MmAthleteDAO.load(db);
            teams = MmTeamDAO.load(db);
            meets = MmMeetDAO.load(db);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*
      Private Methods
     */

    public static MmMdbDAO load(File input) {
        return new MmMdbDAO(input);
    }

    public File getFile() {
        return file;
    }
}


