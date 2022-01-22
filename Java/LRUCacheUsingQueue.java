import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCacheUsingQueue {
    private int capacity;
    private Deque<Integer> q;
    private Map<Integer, Integer> map;

    public LRUCacheUsingQueue(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            q.remove(key);
            q.add(key);
            return map.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            q.remove(key);
            q.add(key);
            map.replace(key, value);
        }
        
        else
        {
            map.put(key, value);
            q.add(key);

            if(map.size() > capacity)
                map.remove(q.poll());
        }
    }
}