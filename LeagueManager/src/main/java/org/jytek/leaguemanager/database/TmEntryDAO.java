package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmEntry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmEntryDAO extends DAOStream<Integer, TmEntry> {
    public TmEntryDAO(Database db) throws IOException {
        super(db, TmEntry.NAME);
    }

    @Override
    KeyValue<Integer, TmEntry> create(Row r) {
        return TmEntry.create(r);
    }
}

