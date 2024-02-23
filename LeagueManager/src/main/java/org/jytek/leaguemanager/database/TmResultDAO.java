package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmResultDAO {


    private TmResultDAO()
    {

    }

    public static Map<Integer,TmResult> getResults(Database db) throws IOException {

        var map = new HashMap<Integer, TmResult>();
        for (final Row row : db.getTable(TmResult.NAME)) {
            final var obj = TmResult.create(row);
            map.put(obj.getResult(), obj);
        }
        return map;
    }
}

  
