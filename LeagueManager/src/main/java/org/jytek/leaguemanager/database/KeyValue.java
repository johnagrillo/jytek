package org.jytek.leaguemanager.database;

public interface KeyValue<K, V> {
    public K getKey();
    public V getValue();

}