package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.TmAthlete;
import java.io.IOException;


public class TmAthleteDAO extends MdbDAOStream<Integer, TmAthlete> {

    public static TmAthleteDAO load(final Database db) throws IOException {
        return new TmAthleteDAO(db);
    }

    private TmAthleteDAO(final Database db) throws IOException {
        super(db, TmAthlete.NAME);
    }


    @Override
    KeyValue<Integer, TmAthlete> read(final Row r) {
        return TmAthlete.read(r);
    }
}

