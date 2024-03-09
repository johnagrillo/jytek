package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmMtevent;
import java.io.IOException;


public class TmMteventDAO extends DAOStream<Integer,TmMtevent> {

    public TmMteventDAO(Database db) throws IOException {
        db.getTable(TmMtevent.NAME).forEach(row -> {
            final var obj = TmMtevent.create(row);
            map.put(obj.getMtevent(), obj);
        });
    }

    public TmMtevent get(Integer key) throws MteventException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new MteventException("No Mtevent " + key);
    }
}

