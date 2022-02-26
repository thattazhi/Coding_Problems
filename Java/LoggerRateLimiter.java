/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed at most every 10 seconds (i.e. a message
 * printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 * 
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class LoggerUsingHashMap {
    private Map<String, Integer> messageMap;

    public LoggerUsingHashMap() {
        messageMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int prevTimeStamp = messageMap.getOrDefault(message, -10);
        
        if(timestamp - prevTimeStamp > 9) {
            messageMap.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class LoggerUsingQueue {
    private class Pair<U, V> {
        private U first;
        private V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    private LinkedList<Pair<String, Integer>> messageQ;
    private Set<String> messageSet;
    
    public LoggerUsingQueue() {
        messageQ = new LinkedList<>();
        messageSet = new HashSet<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(messageQ.size() > 0) {
            Pair<String, Integer> head = messageQ.getFirst();

            if(timestamp - head.second > 9) {
                messageQ.removeFirst();
                messageSet.remove(head.first);
            } else break;
        }

        if(!messageSet.contains(message)) {
            Pair<String, Integer> newMessage = new Pair<>(message, timestamp);
            messageQ.addLast(newMessage);
            messageSet.add(message);
            return true;
        }

        return false;
    }
}