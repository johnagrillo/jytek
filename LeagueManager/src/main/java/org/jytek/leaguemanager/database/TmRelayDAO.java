package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmRelay;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmRelayDAO extends DAOStream<Integer, TmRelay>{

    public TmRelayDAO(Database db) throws IOException {
        db.getTable(TmRelay.NAME).forEach(row -> {
            final var obj = TmRelay.create(row);
            map.put(obj.getRelay(), obj);
        });
    }
}

