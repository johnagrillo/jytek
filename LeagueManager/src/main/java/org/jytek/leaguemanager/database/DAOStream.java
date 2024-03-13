/**
 * Stream Wrapper implementation for TM Table.
 */

package org.jytek.leaguemanager.database;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @param <K>
 * @param <V>
 */
public abstract class DAOStream<K, V extends KeyValue<K, V>> {
    /**
     *
     */
    private final Map<K, V> daoHashMap = new HashMap<>();

    /**
     *
     */
    private String name = "";

    DAOStream(final Database db, final String name) throws IOException {
        this.name = name;
        db.getTable(name).forEach(row -> {
            final var obj = read(row);
            daoHashMap.put(obj.getKey(), obj.getValue());
        });
    }

    abstract KeyValue<K, V> read(Row r);

    /**
     * get for K
     *
     * @param key
     * @return V
     * @throws KeyNotFoundException key not found
     */

    public V get(final K key) throws KeyNotFoundException {
        if (daoHashMap.containsKey(key)) {
            return daoHashMap.get(key);
        }
        throw new KeyNotFoundException(name + " " + key);
    }

    /**
     * Get all keys K
     * @return Collection of keys
     */
    Collection<K> keys() {
        return daoHashMap.keySet();
    }

    public void forEach(final Consumer<Map.Entry<K, V>> action) {
        daoHashMap.entrySet().forEach((Consumer<Map.Entry<K, V>>) action);
    }

    /**
     * Shortcut to the emtrySet.stream.filter method*
     * @param predicate filtered predicate
     * @return stream
     */

    public Stream<Map.Entry<K, V>> filter(final Predicate<? super Map.Entry<K, V>> predicate) {
        return daoHashMap.entrySet().stream().filter(predicate);
    }

    /**
     * Get the entrySet stream
     *
     * @param <K> the type
     * @param <V> The class
     * @return stream
     */
    public Stream<Map.Entry<K, V>> stream() {
        return daoHashMap.entrySet().stream();
    }

    /**
     * Get values using stream
     *
     * @param <V> The class
     * @return Collection of C
     */

    public Collection<V> values() {
        return daoHashMap.values()
                .stream()
                .toList();
    }

    /**
     * Alias for stream.count
     *
     * @return int
     */

    public int count() {
        return daoHashMap.size();
    }
}
