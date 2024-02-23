package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmTeam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


  public class TmTeamDAO {


    private TmTeamDAO()
    {

    }

    public static Map<Integer,TmTeam> getTeams(Database db) throws IOException {

        var map = new HashMap<Integer, TmTeam>();
        for (final Row row : db.getTable(TmTeam.NAME)) {
            final var obj = TmTeam.create(row);
            map.put(obj.getTeam(), obj);
        }
        return map;
    }
}

  
