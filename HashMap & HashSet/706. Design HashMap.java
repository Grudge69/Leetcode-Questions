// Link: https://leetcode.com/problems/design-hashmap/

// Solution: Using Array of LinkedList

class MyHashMap {

    /** Initialize your data structure here. */
    LinkedList<Entry>[] map;
    public static int SIZE = 769;//large prime no. to make hashing efficient
    
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;//get the bucket where we want to put our key-val pair
        //if no such bucket exists then create a new one
        if(map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        }
        else {
            //search all the entries in that bucket
            for(Entry entry : map[bucket]){
                //if a key matches given key(the key already exists, just update the value) then set it's value to given value
                if(entry.key == key){
                    entry.val = value;
                    return;
                }
            }
            //no such key exist so add a new entry in the bucket
            map[bucket].add(new Entry(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;//get the bucket first
        LinkedList<Entry> entries = map[bucket];//get the entries from the bucket
        if(entries == null) return -1;//if no such entry exist return -1
        //search each entry
        for(Entry entry : entries) {
            //if any key matches, return it's value
            if(entry.key == key) return entry.val;
        }
        //no such key found
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;//get the bucket first
        Entry toRemove = null;//the entry to be removed
        if(map[bucket] == null) return;//if bucket is empty then do nothing
        else {
            //search each entry in bucket
            for(Entry entry : map[bucket]){
                //if a key matches given key
                if(entry.key == key) {
                    //set toRemove to the entry that matches
                    toRemove = entry;
                }
            }
            //if no such matching entry found, do nothing
            if(toRemove == null) return;
            //remove the entry from bucket
            map[bucket].remove(toRemove);
        }
    }
}

//entry class with our key-value pair
class Entry {
    public int key;
    public int val;

    public Entry(int key, int val){
        this.key = key;
        this.val = val;
    }
}

// Using Integer Array
class MyHashMap {
    int[] map;

    public MyHashMap() {
        map = new int[1000001];//1000000 is limit of map values in constraints
        // filling with -1 takes O(N) time, we don't do it to make it O(1)
        // Arrays.fill(map, -1);//initial values
    }
    
    public void put(int key, int value) {
        // map[key] = value; //this is done when Arrays.fill(map, -1) is used
        map[key] = value+1; //add 1 to our value and store it 
    }
    
    public int get(int key) {
        return map[key]-1; //subtract 1 as we added it in put() operation
    }
    
    public void remove(int key) {
        // map[key] = -1;//this is done when Arrays.fill(map, -1) is used
        map[key] = 0;//just reset to 0
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */