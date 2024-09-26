package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmTagnames;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmTagnamesDAO extends MdbDAOStream<Integer, MmTagnames> {

    public static MmTagnamesDAO load(final Database db) throws IOException {
        return new MmTagnamesDAO(db);
    }

    private MmTagnamesDAO(final Database db) throws IOException {
        super(db, MmTagnames.NAME);
    }


    @Override
    KeyValue<Integer, MmTagnames> read(final Row r) {
        return MmTagnames.read(r);
    }
}

