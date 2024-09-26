package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmAthlete;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmAthleteDAO extends MdbDAOStream<Integer, MmAthlete> {

    public static MmAthleteDAO load(final Database db) throws IOException {
        return new MmAthleteDAO(db);
    }

    private MmAthleteDAO(final Database db) throws IOException {
        super(db, MmAthlete.NAME);
    }


    @Override
    KeyValue<Integer, MmAthlete> read(final Row r) {
        return MmAthlete.read(r);
    }
}

