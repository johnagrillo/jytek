package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmTeam;

import java.io.IOException;


public class TmTeamDAO extends MdbDAOStream<Integer, TmTeam> {

    public static TmTeamDAO load(final Database db) throws IOException {
        return new TmTeamDAO(db);
    }

    private TmTeamDAO(final Database db) throws IOException {
        super(db, TmTeam.NAME);
    }

    @Override
    KeyValue<Integer, TmTeam> read(final Row r) {
        return TmTeam.read(r);
    }
}

