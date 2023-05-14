import java.util.LinkedList;
public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        //constructor
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        //returns the key of the hash node
        public K getKey() {
            return key;
        }
        //returns the value of the hash node
        public V getValue() {
            return value;
        }
        //sets the value of the hash node
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
    // constructor with no param
    public MyHashTable() {
        this.chain = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chain[i] = new LinkedList<>();
        }
    }
    // constructor with the size M
    public MyHashTable(int M) {
        this.M = M;
        this.chain = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chain[i] = new LinkedList<>();
        }
    }
    // hash - takes a key and returns an index in the array of linked lists
    private int hash(K key) {
        int hashCode = 0;
        String strKey = key.toString(); // convert the key to a string
        for (int i = 0; i < strKey.length(); i++) {
            hashCode += strKey.charAt(i);
        }
        return hashCode % M; // returning the index of array by taking the hash code modulo
    }
    // put - adds a key value pair to the hash table
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
    // returns the value associated with the given key in the hash table
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
    // removes the key-value pair with the given key from the hash table
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
    // returns whether the hash table contains the given value
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
    // returns the key associated with the given value in the hash table
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
