package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.IOException;


public class TmTeamDAO extends DAOStream<Integer, TmTeam> {
    public TmTeamDAO(Database db) throws IOException {
        super(db, TmTeam.NAME);
    }

    @Override
    KeyValue<Integer, TmTeam> create(Row r) {
        return TmTeam.create(r);
    }
}

