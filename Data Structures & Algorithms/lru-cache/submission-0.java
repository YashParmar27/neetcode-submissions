public class Node
{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    
    int capacity;
    Map<Integer, Node> cache;

    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    // Removes the specified node
    void removeNode(Node node)
    {
        Node prev = node.prev;
        Node nxt = node.next;

        prev.next = nxt;
        nxt.prev = prev;
    }

    // Inserts node to the right
    void insertNode(Node node)
    {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key))
        {
            Node node = cache.get(key);
            removeNode(node);
            insertNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))
        {
            removeNode(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertNode(newNode);

        if (cache.size() > capacity)
        {
            Node lru = this.left.next;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }
}
