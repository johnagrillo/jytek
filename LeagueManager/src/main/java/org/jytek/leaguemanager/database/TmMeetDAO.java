package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmMeet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class TmMeetDAO extends DAOStream<Integer, TmMeet> {

    public static TmMeetDAO load(final Database db) throws IOException {
        return new TmMeetDAO(db);
    }

    private TmMeetDAO(final Database db) throws IOException {
        super(db, TmMeet.NAME);
    }


    @Override
    KeyValue<Integer, TmMeet> read(final Row r) {
        return TmMeet.read(r);
    }
}

