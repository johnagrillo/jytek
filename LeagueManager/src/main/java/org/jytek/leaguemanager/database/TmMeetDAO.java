package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmMeetDAO {


    private TmMeetDAO()
    {

    }

    public static Map<Integer,TmMeet> getMeets(Database db) throws IOException {

        var map = new HashMap<Integer, TmMeet>();
        for (final Row row : db.getTable(TmMeet.NAME)) {
            final var obj = TmMeet.create(row);
            map.put(obj.getMeet(), obj);
        }
        return map;
    }



}

  
