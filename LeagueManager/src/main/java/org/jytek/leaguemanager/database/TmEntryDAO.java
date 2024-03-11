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

    public static TmEntryDAO load(final Database db) throws IOException {
        return new TmEntryDAO(db);
    }

    private TmEntryDAO(final Database db) throws IOException {
        super(db, TmEntry.NAME);
    }


    @Override
    KeyValue<Integer, TmEntry> read(final Row r) {
        return TmEntry.read(r);
    }
}

