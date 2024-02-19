package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MeetDAO {

    private MeetDAO() {
    }

    public static Map<Integer, TmMeet> getMeets(Database db) throws IOException {

        var meets = new HashMap<Integer,TmMeet>();
        for (final Row row : db.getTable(TmMeet.NAME)) {
            final var meet = TmMeet.create(row);
            meets.put(meet.getMeet(), meet);
        }
        return meets;
    }

}
