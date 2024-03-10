package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMeetDAO extends DAOStream<Integer, TmMeet>{

    public TmMeetDAO(Database db) throws IOException {
        db.getTable(TmMeet.NAME).forEach(row -> {
            final var obj = TmMeet.create(row);
            map.put(obj.getMeet(), obj);
        });
    }
}

