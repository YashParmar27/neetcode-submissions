/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        
        Node dummy = new Node(0);
        Node copyCur = dummy;

        Map<Node, Node> map = new HashMap<>();
        while (curr != null)
        {   
            int value = curr.val;
            Node newNode = new Node(value);

            map.put(curr, newNode);
            copyCur.next = newNode;
            copyCur = newNode;

            curr = curr.next;
        }

        curr = dummy.next;
        Node org = head;
        while (org != null)
        {
            curr.random = map.get(org.random);
            org = org.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
