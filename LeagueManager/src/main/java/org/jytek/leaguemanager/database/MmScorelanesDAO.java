package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmScorelanes;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmScorelanesDAO extends MdbDAOStream<Integer, MmScorelanes> {

    public static MmScorelanesDAO load(final Database db) throws IOException {
        return new MmScorelanesDAO(db);
    }

    private MmScorelanesDAO(final Database db) throws IOException {
        super(db, MmScorelanes.NAME);
    }


    @Override
    KeyValue<Integer, MmScorelanes> read(final Row r) {
        return MmScorelanes.read(r);
    }
}

