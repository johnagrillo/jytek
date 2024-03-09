package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmResultDAO {

    private Map<Integer, TmResult> map = new HashMap<>();

    public TmResultDAO(Database db) throws IOException {
        db.getTable(TmResult.NAME).forEach(row -> {
            final var obj = TmResult.create(row);
            map.put(obj.getResult(), obj);
        });
    }

    public Stream<Map.Entry<Integer, TmResult>> stream(){
        return map.entrySet().stream();
    }

    public TmResult get(Integer key) throws ResultException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new ResultException("No Result " + key);
    }

    public Collection<TmResult> values(){
        return map.values();
    }

}

