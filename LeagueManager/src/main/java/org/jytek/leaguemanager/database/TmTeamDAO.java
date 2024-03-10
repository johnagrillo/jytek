package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmTeam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmTeamDAO extends DAOStream<Integer, TmTeam>{

    public TmTeamDAO(Database db) throws IOException {
        db.getTable(TmTeam.NAME).forEach(row -> {
            final var obj = TmTeam.create(row);
            map.put(obj.getTeam(), obj);
        });
    }
}

