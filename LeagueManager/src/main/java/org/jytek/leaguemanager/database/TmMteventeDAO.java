package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevente;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMteventeDAO extends DAOStream<Integer, TmMtevente> {

    public static TmMteventeDAO load(final Database db) throws IOException {
        return new TmMteventeDAO(db);
    }

    private TmMteventeDAO(final Database db) throws IOException {
        super(db, TmMtevente.NAME);
    }


    @Override
    KeyValue<Integer, TmMtevente> read(final Row r) {
        return TmMtevente.read(r);
    }
}

