package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMeetDAO {

    private Map<Integer, TmMeet> map = new HashMap<>();

    public TmMeetDAO(Database db) throws IOException {
        db.getTable(TmMeet.NAME).forEach(row -> {
            final var obj = TmMeet.create(row);
            map.put(obj.getMeet(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmMeet>> stream(){
        return map.entrySet().stream();
    }

    public TmMeet get(Integer key) throws MeetException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new MeetException("No Meet " + key);
    }

    public Collection<TmMeet> values(){
        return map.values();
    }

}

