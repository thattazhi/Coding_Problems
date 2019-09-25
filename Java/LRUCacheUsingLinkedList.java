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
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
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