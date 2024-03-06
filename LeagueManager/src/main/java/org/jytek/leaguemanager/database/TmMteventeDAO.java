package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevente;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmMteventeDAO {


    private TmMteventeDAO()
    {

    }

    public static Map<Integer,TmMtevente> getMteventes(Database db) throws IOException {

        var map = new HashMap<Integer, TmMtevente>();
        for (final Row row : db.getTable(TmMtevente.NAME)) {
            final var obj = TmMtevente.create(row);
            map.put(obj.getMtevent(), obj);
        }
        return map;
    }
}

  
