# Documentation 

Here you can find explanations of all functions that I used to solve this assignment.

## MyHashTable

### hash

**Description:** 

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

**Description:** 

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

**Description:** 

**Solution:** 

```java
 
```

### remove

**Description:** 

**Solution:** 

```java
 
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

### getSize

**Description:** 

**Solution:** 

```java
 
```
