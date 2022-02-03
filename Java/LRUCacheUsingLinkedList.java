import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCacheUsingLinkedList {
    
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map <Integer, Node> map;

    public LRUCacheUsingLinkedList(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap <>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        
        if(node != null)
        {
            makeHead(node);
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(head == null) {
            head = new Node(key, value);
            tail = head;
            map.put(key, head);
            size++;
            return;
        }
        
        Node node = map.get(key);
        
        if(node != null) {
            node.value = value;
            makeHead(node);
            return;
        }
        
        node = new Node(key, value);
        node.next = head;
        head.prev = node;
        head = node;
        map.put(key, node);
        
        if(size < capacity)
            size++;
        
        else
            removeTail();
    }
    
    private void makeHead(Node node) {
        if(node == head) return;
        
        if(node == tail)
            tail = tail.prev;
        
        else
            node.next.prev = node.prev;
        
        node.prev.next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private void removeTail() {
        map.remove(tail.key);
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
    }
}

class Main {
  
    int test_case_number = 1;
    
    String getStrFromArrayList(List<Integer> list) {
      String output = new String("[ ");
      for(Integer i : list) {
        output += i + " ";
      }
      return output + "]";
    }
    
    void check(List<Integer> expected, List<Integer> output) {
      boolean result = expected.equals(output);
      final String PASS = "PASSED";
      final String FAIL = "FAILED";
      if (result) {
        System.out.println(PASS + " Test #" + test_case_number);
      }
      else {
        String expectedOutput = getStrFromArrayList(expected); 
        String yourOutput = getStrFromArrayList(output); 
        System.out.format(FAIL + " Test #" + test_case_number + ": Expected %s", expectedOutput);
        System.out.format(" Your output: %s", yourOutput);
        System.out.println();
      }
      test_case_number++;
    }
    
    public void run() {
      List<Integer> expectedOutputOne = Arrays.asList(2);
      LRUCacheUsingLinkedList cacheOne = new LRUCacheUsingLinkedList(2);
      List<Integer> outputOne = new ArrayList<Integer>();  
      cacheOne.put(1, 2);
      outputOne.add(cacheOne.get(1));
      check(expectedOutputOne, outputOne);
      
      List<Integer> expectedOutputTwo = Arrays.asList(5, -1); 
      LRUCacheUsingLinkedList cacheTwo = new LRUCacheUsingLinkedList(2);
      List<Integer> outputTwo = new ArrayList<Integer>();
      cacheTwo.put(1, 2);
      cacheTwo.put(2, 3);
      cacheTwo.put(1, 5);
      cacheTwo.put(4, 5);
      cacheTwo.put(6, 7);
      outputTwo.add(cacheTwo.get(4));
      cacheTwo.put(1, 2);
      outputTwo.add(cacheTwo.get(3));
      check(expectedOutputTwo, outputTwo); 
      
      // Add your own test cases here
      
    }
    
    public static void main(String[] args) {
      new Main().run(); 
    }
  }