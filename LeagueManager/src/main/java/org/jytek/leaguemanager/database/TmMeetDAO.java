package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmMeet;
import java.io.IOException;


public class TmMeetDAO extends DAOStream<Integer,TmMeet> {

    public TmMeetDAO(Database db) throws IOException {
        db.getTable(TmMeet.NAME).forEach(row -> {
            final var obj = TmMeet.create(row);
            map.put(obj.getMeet(), obj);
        });
    }

    public TmMeet get(Integer key) throws MeetException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new MeetException("No Meet " + key);
    }
}

