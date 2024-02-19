package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmAthlete;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AthleteDAO {
    public static Map<Integer, TmAthlete> getAthletes(Database db) throws IOException {

        var meets = new HashMap<Integer, TmAthlete>();
        for (final Row row : db.getTable(TmAthlete.NAME)) {
            final var ath = TmAthlete.create(row);
            meets.put(ath.getAthlete(), ath);
        }
        return meets;
    }
}