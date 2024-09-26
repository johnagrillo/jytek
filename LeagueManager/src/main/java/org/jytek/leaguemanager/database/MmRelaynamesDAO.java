package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmRelaynames;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmRelaynamesDAO extends MdbDAOStream<Integer, MmRelaynames> {

    public static MmRelaynamesDAO load(final Database db) throws IOException {
        return new MmRelaynamesDAO(db);
    }

    private MmRelaynamesDAO(final Database db) throws IOException {
        super(db, MmRelaynames.NAME);
    }


    @Override
    KeyValue<Integer, MmRelaynames> read(final Row r) {
        return MmRelaynames.read(r);
    }
}

