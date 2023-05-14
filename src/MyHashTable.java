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
    public MyHashTable() {
        this.chain = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chain[i] = new LinkedList<>();
        }
    }
    public MyHashTable(int M) {
        this.M = M;
        this.chain = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chain[i] = new LinkedList<>();
        }
    }
    private int hash(K key) {
        int hashCode = 0;
        String strKey = key.toString();
        for (int i = 0; i < strKey.length(); i++) {
            hashCode += strKey.charAt(i);
        }
        return hashCode % M;
    }
    public void put(K key, V value) {}
    public V get(K key) {}
    public V remove(K key) {}
    public boolean contains(V value) {}
    public K getKey(V value) {}
    public int getSize() {
        return size;
    }
}
