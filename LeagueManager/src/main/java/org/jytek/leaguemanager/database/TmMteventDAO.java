package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevent;
import java.io.IOException;


public class TmMteventDAO extends MdbDAOStream<Integer, TmMtevent> {

    public static TmMteventDAO load(final Database db) throws IOException {
        return new TmMteventDAO(db);
    }

    private TmMteventDAO(final Database db) throws IOException {
        super(db, TmMtevent.NAME);
    }


    @Override
    KeyValue<Integer, TmMtevent> read(final Row r) {
        return TmMtevent.read(r);
    }
}

