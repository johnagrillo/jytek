package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmEntry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmEntryDAO {

    private Map<Integer, TmEntry> map = new HashMap<>();

    public TmEntryDAO(Database db) throws IOException {
        db.getTable(TmEntry.NAME).forEach(row -> {
            final var obj = TmEntry.create(row);
            map.put(obj.getEntry(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmEntry>> stream(){
        return map.entrySet().stream();
    }

    public TmEntry get(Integer key) throws EntryException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new EntryException("No Entry " + key);
    }

    public Collection<TmEntry> values(){
        return map.values();
    }

}

