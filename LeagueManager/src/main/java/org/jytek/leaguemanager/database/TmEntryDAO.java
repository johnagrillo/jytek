package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmEntry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmEntryDAO extends DAOStream<Integer, TmEntry>{

    public TmEntryDAO(Database db) throws IOException {
        db.getTable(TmEntry.NAME).forEach(row -> {
            final var obj = TmEntry.create(row);
            map.put(obj.getEntry(), obj);
        });
    }
}

