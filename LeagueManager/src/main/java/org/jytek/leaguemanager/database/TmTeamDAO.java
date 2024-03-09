package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class TmTeamDAO {

    private Map<Integer, TmTeam> map = new HashMap<>();

    public TmTeamDAO(Database db) throws IOException {
        db.getTable(TmTeam.NAME).forEach(row -> {
            final var obj = TmTeam.create(row);
            map.put(obj.getTeam(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmTeam>> stream(){
        return map.entrySet().stream();
    }

    public TmTeam get(Integer key) throws TeamException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new TeamException("No Team " + key);
    }

    public Collection<TmTeam> values(){
        return map.values();
    }

}

