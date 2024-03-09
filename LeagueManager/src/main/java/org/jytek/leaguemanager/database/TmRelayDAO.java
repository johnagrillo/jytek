package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmRelay;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmRelayDAO {

    private Map<Integer, TmRelay> map = new HashMap<>();

    public TmRelayDAO(Database db) throws IOException {
        db.getTable(TmRelay.NAME).forEach(row -> {
            final var obj = TmRelay.create(row);
            map.put(obj.getRelay(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmRelay>> stream(){
        return map.entrySet().stream();
    }

    public TmRelay get(Integer key) throws RelayException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new RelayException("No Relay " + key);
    }

    public Collection<TmRelay> values(){
        return map.values();
    }

}

