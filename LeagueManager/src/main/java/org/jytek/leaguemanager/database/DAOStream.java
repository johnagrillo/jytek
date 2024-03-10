/**
 *  Stream Wrapper implementation for TM Table
 */

package org.jytek.leaguemanager.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;





public class DAOStream<K, V> {
    protected Map<K,V> map = new HashMap<>();
    String name = "";


    public V get(K key) throws KeyNotFoundException{
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new KeyNotFoundException(name + " " + key);
    }


    /**
     * Shortcut to the entrySteam.stream.forEach method
     *
     * @param <K> the type
     * @param <V> The class
     * @param action
     */
    Collection<K> keys() {
        return map.keySet();
    }

    public void forEach(final Consumer<Map.Entry<K, V>> action){
        map.entrySet().stream().forEach((Consumer<Map.Entry<K, V>>) action);
    }

    /**
     * Shortcut to the emtryStrem/stream.filter method
     *
     * @param <T> the type
     * @param <C> The class
     * @param predicate
     * @return filter
     */

    public Stream<Map.Entry<K, V>> filter(final Predicate<Map.Entry<K,V>> predicate) {
        return map.entrySet().stream().filter(predicate);
    }

    /**
     * Get the entrySet stream
     *
     * @param <K> the type
     * @param <V> The class
     *
     * @return stream
     */
    public Stream<Map.Entry<K, V>> stream(){
        return map.entrySet().stream();
    }

    /**
     * Get values using stream
     *
     * @param <C> The class
     *
     * @return Collection of C
     */

    public Collection<V> values() {
        List<V> list = map.entrySet()
                .stream()
                .map(x -> x.getValue())
                .toList();
        return list;
    }

    /**
     * Alias for stream.count
     *
     * @return int
     */

    public int count() {
        return map.size();
    }
}
