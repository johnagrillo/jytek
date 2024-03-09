package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmAthlete;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class TmAthleteDAO {

    private Map<Integer, TmAthlete> map = new HashMap<>();

    public TmAthleteDAO(Database db) throws IOException {
        db.getTable(TmAthlete.NAME).forEach(row -> {
            final var obj = TmAthlete.create(row);
            map.put(obj.getAthlete(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmAthlete>> stream(){
        return map.entrySet().stream();
    }

    public TmAthlete get(Integer key) throws AthleteException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new AthleteException("No Athlete " + key);
    }

    public Collection<TmAthlete> values(){
        return map.values();
    }

}

