import java.util.LinkedList;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    public LinkedList<HashNode<K, V>>[] chain;
    public int M = 11;
    public int size;
    public MyHashTable() {}
    public MyHashTable(int M) {}
    private int hash(K key) {}
    public void put(K key, V value) {}
    public V get(K key) {}
    public V remove(K key) {}
    public boolean contains(V value) {}
    public K getKey(V value) {}

}
