package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmResultDAO extends DAOStream<Integer, TmResult> {

    public static TmResultDAO load(final Database db) throws IOException {
        return new TmResultDAO(db);
    }

    private TmResultDAO(final Database db) throws IOException {
        super(db, TmResult.NAME);
    }


    @Override
    KeyValue<Integer, TmResult> read(final Row r) {
        return TmResult.read(r);
    }
}

