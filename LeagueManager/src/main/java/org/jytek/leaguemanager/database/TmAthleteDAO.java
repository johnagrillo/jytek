package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmAthlete;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmAthleteDAO extends DAOStream<Integer, TmAthlete>{

    public TmAthleteDAO(Database db) throws IOException {
        db.getTable(TmAthlete.NAME).forEach(row -> {
            final var obj = TmAthlete.create(row);
            map.put(obj.getAthlete(), obj);
        });
    }
}

