package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmRelay;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmRelayDAO {


    private TmRelayDAO()
    {

    }

    public static Map<Integer,TmRelay> getRelays(Database db) throws IOException {

        var map = new HashMap<Integer, TmRelay>();
        for (final Row row : db.getTable(TmRelay.NAME)) {
            final var obj = TmRelay.create(row);
            map.put(obj.getRelay(), obj);
        }
        return map;
    }
}

  
