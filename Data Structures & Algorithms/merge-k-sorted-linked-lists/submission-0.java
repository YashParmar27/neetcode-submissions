/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        for (int i = 0; i < lists.length; i++)
        {
            minHeap.offer(lists[i]);
        }

        while (minHeap.size() > 0)
        {
            ListNode smallestElem = minHeap.poll();
            if (smallestElem.next != null)
                minHeap.offer(smallestElem.next);
            curr.next = smallestElem;
            curr = smallestElem;
        }
    
        return dummy.next;
    }
}
