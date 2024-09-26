package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmRelay;
import java.io.IOException;


public class TmRelayDAO extends MdbDAOStream<Integer, TmRelay> {

    public static TmRelayDAO load(final Database db) throws IOException {
        return new TmRelayDAO(db);
    }

    private TmRelayDAO(final Database db) throws IOException {
        super(db, TmRelay.NAME);
    }


    @Override
    KeyValue<Integer, TmRelay> read(final Row r) {
        return TmRelay.read(r);
    }
}

