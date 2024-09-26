package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmTimestd;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmTimestdDAO extends MdbDAOStream<Integer, MmTimestd> {

    public static MmTimestdDAO load(final Database db) throws IOException {
        return new MmTimestdDAO(db);
    }

    private MmTimestdDAO(final Database db) throws IOException {
        super(db, MmTimestd.NAME);
    }


    @Override
    KeyValue<Integer, MmTimestd> read(final Row r) {
        return MmTimestd.read(r);
    }
}

