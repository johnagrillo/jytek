package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmMeet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmMeetDAO extends MdbDAOStream<Integer, MmMeet> {

    public static MmMeetDAO load(final Database db) throws IOException {
        return new MmMeetDAO(db);
    }

    private MmMeetDAO(final Database db) throws IOException {
        super(db, MmMeet.NAME);
    }


    @Override
    KeyValue<Integer, MmMeet> read(final Row r) {
        return MmMeet.read(r);
    }
}

