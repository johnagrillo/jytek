package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmEntry;
import java.io.IOException;


public class TmEntryDAO extends DAOStream<Integer,TmEntry> {

    public TmEntryDAO(Database db) throws IOException {
        db.getTable(TmEntry.NAME).forEach(row -> {
            final var obj = TmEntry.create(row);
            map.put(obj.getEntry(), obj);
        });
    }

    public TmEntry get(Integer key) throws EntryException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new EntryException("No Entry " + key);
    }
}

