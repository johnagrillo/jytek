package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmMteventDAO {


    private TmMteventDAO()
    {

    }

    public static Map<Integer,TmMtevent> getMtevents(Database db) throws IOException {

        var map = new HashMap<Integer, TmMtevent>();
        for (final Row row : db.getTable(TmMtevent.NAME)) {
            final var obj = TmMtevent.create(row);
            map.put(obj.getMtevent(), obj);
        }
        return map;
    }
}

  
