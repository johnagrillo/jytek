package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import org.jytek.leaguemanager.view.TmMtevente;

import java.io.IOException;


public class TmMteventeDAO extends DAOStream<Short, TmMtevente>{

    public TmMteventeDAO(Database db) throws IOException {
        db.getTable(TmMtevente.NAME).forEach(row -> {
            final var obj = TmMtevente.create(row);
            map.put(obj.getMtev(), obj);
        });
    }
}

