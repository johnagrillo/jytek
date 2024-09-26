package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmRelay;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmRelayDAO extends MdbDAOStream<Integer, MmRelay> {

    public static MmRelayDAO load(final Database db) throws IOException {
        return new MmRelayDAO(db);
    }

    private MmRelayDAO(final Database db) throws IOException {
        super(db, MmRelay.NAME);
    }


    @Override
    KeyValue<Integer, MmRelay> read(final Row r) {
        return MmRelay.read(r);
    }
}

