package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;

import java.io.IOException;


public class TmMeetDAO extends DAOStream<Integer, TmMeet> {
    public TmMeetDAO(Database db) throws IOException {
        super(db, TmMeet.NAME);
    }

    @Override
    KeyValue<Integer, TmMeet> create(Row r) {
        return TmMeet.create(r);
    }
}

