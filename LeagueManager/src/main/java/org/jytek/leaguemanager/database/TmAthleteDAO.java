package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmAthlete;
import java.io.IOException;


public class TmAthleteDAO extends DAOStream<Integer,TmAthlete> {

    public TmAthleteDAO(Database db) throws IOException {
        db.getTable(TmAthlete.NAME).forEach(row -> {
            final var obj = TmAthlete.create(row);
            map.put(obj.getAthlete(), obj);
        });
    }

    public TmAthlete get(Integer key) throws AthleteException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new AthleteException("No Athlete " + key);
    }
}

