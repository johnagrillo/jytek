package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmResult;
import java.io.IOException;


public class TmResultDAO extends DAOStream<Integer,TmResult> {

    public TmResultDAO(Database db) throws IOException {
        db.getTable(TmResult.NAME).forEach(row -> {
            final var obj = TmResult.create(row);
            map.put(obj.getResult(), obj);
        });
    }

    public TmResult get(Integer key) throws ResultException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new ResultException("No Result " + key);
    }
}

