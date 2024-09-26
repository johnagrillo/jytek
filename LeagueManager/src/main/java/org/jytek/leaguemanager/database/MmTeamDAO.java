package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmTeam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmTeamDAO extends MdbDAOStream<Integer, MmTeam> {

    public static MmTeamDAO load(final Database db) throws IOException {
        return new MmTeamDAO(db);
    }

    private MmTeamDAO(final Database db) throws IOException {
        super(db, MmTeam.NAME);
    }


    @Override
    KeyValue<Integer, MmTeam> read(final Row r) {
        return MmTeam.read(r);
    }
}

