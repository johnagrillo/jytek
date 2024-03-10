package org.jytek.leaguemanager.database;

public interface KeyValue<K, V> {
    public V get();
    public V create();
}