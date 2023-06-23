import java.util.*;

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int limit;

    LRUCache(int capacity) {
        map = new HashMap<>();
        limit = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == limit)
            remove(tail.prev);

        insert(new Node(key, value));
    }

    private void remove(Node node) {
        Node prevnode = node.prev;
        Node nextnode = node.next;
        prevnode.next = nextnode;
        nextnode.prev = prevnode;
        map.remove(node.key);
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;

    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    Node(int a, int b) {
        key = a;
        val = b;
    }
}