package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMtevente;

import java.io.IOException;


public class TmMteventeDAO extends DAOStream<Short, TmMtevente> {
    public TmMteventeDAO(Database db) throws IOException {
        super(db, TmMtevente.NAME);
    }

    @Override
    KeyValue<Short, TmMtevente> create(Row r) {
        return TmMtevente.create(r);
    }
}

