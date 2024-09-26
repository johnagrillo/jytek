package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmEntry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmEntryDAO extends MdbDAOStream<Integer, MmEntry> {

    public static MmEntryDAO load(final Database db) throws IOException {
        return new MmEntryDAO(db);
    }

    private MmEntryDAO(final Database db) throws IOException {
        super(db, MmEntry.NAME);
    }


    @Override
    KeyValue<Integer, MmEntry> read(final Row r) {
        return MmEntry.read(r);
    }
}

