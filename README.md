# Documentation 

Here you can find explanations of all functions that I used to solve this assignment.

## MyHashTable

### hash

**Description:** This method takes a key as input, converting it to a string, and calculateing a hash code by summing the values of its characters. It returns remainder of hascode, where M is the size of the hash table

**Solution:** 

```java
private int hash(K key) {
   int hashCode = 0;
   String strKey = key.toString();
   for (int i = 0; i < strKey.length(); i++) {
        hashCode += strKey.charAt(i);
   }
   return hashCode % M;
   }
```

### put

**Description:** This method adds key value pair to the hash table or updates it. It first calculates the index of the bucket using the hash method, then iterates over the linked list at that index to check if the key already exists. If it does, the method updates the value and returns. Otherwise, it creates a new HashNode object.

**Solution:** 

```java
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
```

### get

**Description:** This method extracts the value with a given key from the hash table by iterating over the linked list at the index corresponding to the key's hash code. If the key is found, its associated value is returned. If not, it returns null.

**Solution:** 

```java
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
```

### remove

**Description:** This method removes a key value from the hash table by looking for the keys corresponding node in the linked list at its index and then removing it. If the key is not found, it returns null.

**Solution:** 

```java
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
```

### contains

**Description:** 

**Solution:** 

```java
 
```

### getKey

**Description:** 

**Solution:** 

```java
 
```

