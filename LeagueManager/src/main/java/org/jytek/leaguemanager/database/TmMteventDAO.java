package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMteventDAO {

    private Map<Integer, TmMtevent> map = new HashMap<>();

    public TmMteventDAO(Database db) throws IOException {
        db.getTable(TmMtevent.NAME).forEach(row -> {
            final var obj = TmMtevent.create(row);
            map.put(obj.getMtevent(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmMtevent>> stream(){
        return map.entrySet().stream();
    }

    public TmMtevent get(Integer key) throws MteventException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new MteventException("No Mtevent " + key);
    }

    public Collection<TmMtevent> values(){
        return map.values();
    }

}

