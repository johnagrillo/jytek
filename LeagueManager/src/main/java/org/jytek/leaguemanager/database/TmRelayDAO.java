package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmRelay;
import java.io.IOException;


public class TmRelayDAO extends DAOStream<Integer,TmRelay> {

    public TmRelayDAO(Database db) throws IOException {
        db.getTable(TmRelay.NAME).forEach(row -> {
            final var obj = TmRelay.create(row);
            map.put(obj.getRelay(), obj);
        });
    }

    public TmRelay get(Integer key) throws RelayException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new RelayException("No Relay " + key);
    }
}

