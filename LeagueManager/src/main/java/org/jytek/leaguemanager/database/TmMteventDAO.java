package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMteventDAO extends DAOStream<Integer, TmMtevent> {
    public TmMteventDAO(Database db) throws IOException {
        super(db, TmMtevent.NAME);
    }

    @Override
    KeyValue<Integer, TmMtevent> create(Row r) {
        return TmMtevent.create(r);
    }
}

