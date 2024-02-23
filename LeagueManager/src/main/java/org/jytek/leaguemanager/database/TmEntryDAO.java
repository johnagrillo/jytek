package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmEntry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmEntryDAO {


    private TmEntryDAO()
    {

    }

    public static Map<Integer,TmEntry> getEntrys(Database db) throws IOException {

        var map = new HashMap<Integer, TmEntry>();
        for (final Row row : db.getTable(TmEntry.NAME)) {
            final var obj = TmEntry.create(row);
            map.put(obj.getEntry(), obj);
        }
        return map;
    }
}

  
