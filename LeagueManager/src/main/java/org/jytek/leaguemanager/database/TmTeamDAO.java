package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.IOException;


public class TmTeamDAO extends DAOStream<Integer,TmTeam> {

    public TmTeamDAO(Database db) throws IOException {
        db.getTable(TmTeam.NAME).forEach(row -> {
            final var obj = TmTeam.create(row);
            map.put(obj.getTeam(), obj);
        });
    }

    public TmTeam get(Integer key) throws TeamException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new TeamException("No Team " + key);
    }
}

