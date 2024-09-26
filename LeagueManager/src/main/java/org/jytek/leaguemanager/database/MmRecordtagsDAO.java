package org.jytek.leaguemanager.database;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import org.jytek.leaguemanager.view.MmRecordtags;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Collection;


public class MmRecordtagsDAO extends MdbDAOStream<Integer, MmRecordtags> {

    public static MmRecordtagsDAO load(final Database db) throws IOException {
        return new MmRecordtagsDAO(db);
    }

    private MmRecordtagsDAO(final Database db) throws IOException {
        super(db, MmRecordtags.NAME);
    }


    @Override
    KeyValue<Integer, MmRecordtags> read(final Row r) {
        return MmRecordtags.read(r);
    }
}

