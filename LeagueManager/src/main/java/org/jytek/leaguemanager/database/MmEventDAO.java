package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmEventDAO extends MdbDAOStream<Integer, MmEvent> {

    public static MmEventDAO load(final Database db) throws IOException {
        return new MmEventDAO(db);
    }

    private MmEventDAO(final Database db) throws IOException {
        super(db, MmEvent.NAME);
    }


    @Override
    KeyValue<Integer, MmEvent> read(final Row r) {
        return MmEvent.read(r);
    }
}

