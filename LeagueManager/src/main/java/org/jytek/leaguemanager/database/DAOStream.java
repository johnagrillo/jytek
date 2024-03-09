/**
 *  Stream Wrapper implementation for TM Table
 */

package org.jytek.leaguemanager.database;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

class DAOStream<T, C> {
    protected Map<T, C> map = new HashMap<>();

    /**
     * Shortcut to the stream.forEach method
     *
     * @param <T> the type 
     * @param <C> The class 
     */

    public void forEach(final Consumer<Map.Entry<T, C>> action){
        map.entrySet().stream().forEach((Consumer<Map.Entry<T, C>>) action);
    }

    /**
     * Get the stream access
     *
     * @param <T> the type 
     * @param <C> The class 
     *
     * @return stream
     */

    public Stream<Map.Entry<T,C>> stream(){
        return map.entrySet().stream();
    }


    /**
     * Get values using stream
     *
     * @param <C> The class
     *
     * @return Collection of C
     */

    public Collection<C> values() {
        List<C> list = map.entrySet()
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
