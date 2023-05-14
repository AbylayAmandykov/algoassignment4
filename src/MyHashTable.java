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
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> list = chain[index];
        for (HashNode<K, V> node : list) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        list.add(new HashNode<K, V>(key, value));
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> list = chain[index];
        for (HashNode<K, V> node : list) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> list = chain[index];
        for (HashNode<K, V> node : list) {
            if (node.getKey().equals(key)) {
                V value = node.getValue();
                list.remove(node);
                size--;
                return value;
            }
        }
        return null;
    }
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> list = chain[i];
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> list = chain[i];
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
            }
        }
        return null;
    }
    public int getSize() {
        return size;
    }
}
