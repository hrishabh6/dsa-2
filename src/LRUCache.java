import java.util.HashMap;
import java.util.Map;

class Node {
    public int key, value;
    Node prev, next;
    Node(int k, int v) {
        key = k;
        value = v;
    }
}

class LRUCache {

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    Map<Integer, Node> map = new HashMap<>();
    int limit;

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int ans = map.get(key).value;

        Node newNode = map.get(key);
        delNode(newNode);
        addNode(newNode);

        return ans;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }

        if(map.size() == limit){
            //delete LRU data
            map.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);

    }

    private void delNode(Node node){
        Node oldPrev = node.prev;
        Node oldNext = node.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    private void addNode(Node node){
        Node tempNode = head.next;
        head.next = node;
        tempNode.prev = node;
        node.next = tempNode;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */