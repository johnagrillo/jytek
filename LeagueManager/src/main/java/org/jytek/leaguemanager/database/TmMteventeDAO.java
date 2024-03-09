package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmMtevente;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class TmMteventeDAO {

    private Map<Short, TmMtevente> map = new HashMap<>();

    public TmMteventeDAO(Database db) throws IOException {
        db.getTable(TmMtevente.NAME).forEach(row -> {
            final var obj = TmMtevente.create(row);
            map.put(obj.getMtev(), obj);
        });
    }

    public Stream<Map.Entry<Short, TmMtevente>> stream(){
        return map.entrySet().stream();
    }

    public TmMtevente get(Short key) throws MteventeException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new MteventeException("No Mtevente " + key);
    }

    public Collection<TmMtevente> values(){
        return map.values();
    }

}

