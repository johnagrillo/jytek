package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmScoring;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmScoringDAO extends MdbDAOStream<Integer, MmScoring> {

    public static MmScoringDAO load(final Database db) throws IOException {
        return new MmScoringDAO(db);
    }

    private MmScoringDAO(final Database db) throws IOException {
        super(db, MmScoring.NAME);
    }


    @Override
    KeyValue<Integer, MmScoring> read(final Row r) {
        return MmScoring.read(r);
    }
}

