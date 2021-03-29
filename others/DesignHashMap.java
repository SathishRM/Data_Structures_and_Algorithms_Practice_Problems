/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap.
If the value already exists in the HashMap, update the value.

get(key): Returns the value to which the specified key is mapped, or
-1 if this map contains no mapping for the key.

remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Note:
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)
 */
package others;

import java.util.LinkedList;

public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,65);
        System.out.println(map.get(10));
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
//user was disconnect from remote machine Reason[error connecting to remote machine]
//Using array
/*
class MyHashMap {
    int[] arr;

    public MyHashMap() {
        //Arrays.fill(arr,-1);
        arr= new int[1000000];
    }

    public void put(int key, int value) {
        this.arr[key]=value+1;
    }

    public int get(int key) {
        return this.arr[key]-1;
    }

    public void remove(int key) {
        this.arr[key]=0;
    }
}
*/

class MyHashMap {
    LinkedList<MappingPairs>[] map;
    public static int SIZE = 769;
    /** Initialize your data structure here. */
    public MyHashMap() {
        //Arrays.fill(arr,-1);
        map= new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<MappingPairs>();
            map[bucket].add(new MappingPairs(key, value));
        }
        else {
            for (MappingPairs pair: map[bucket]) {
                if (pair.key == key) {
                    pair.value = value;
                    return;
                }
            }
            map[bucket].add(new MappingPairs(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;

        LinkedList<MappingPairs> pairs = map[bucket];
        if (pairs == null) return -1;
        for (MappingPairs pair: pairs) {
            if (pair.key == key) return pair.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;
        MappingPairs toRemove = null;
        LinkedList<MappingPairs> pairs = map[bucket];
        if (pairs == null) return;
        for (MappingPairs pair: pairs) {
            if (pair.key == key) toRemove = pair;
        }
        if (toRemove == null) return;
        pairs.remove(toRemove);
    }
}

class MappingPairs {
    int key;
    int value;

    public MappingPairs(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

