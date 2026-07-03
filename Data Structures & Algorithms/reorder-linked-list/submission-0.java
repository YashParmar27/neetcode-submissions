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
    public void reorderList(ListNode head) {
        ListNode l = head;
        ListNode r = head;
        
        // Finding the middle:
        while (r != null && r.next != null)
        {
            l = l.next;
            r = r.next.next;
        }

        r = l.next;
        l.next = null;
        
        ListNode prev = null;
        ListNode curr = r;
        // Sorting Right-half:
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Weaving has begun!
        l = head;
        r = prev;
        
        ListNode temp1;
        ListNode temp2;

        while (r != null)
        {
            temp1 = l.next;
            temp2 = r.next;

            l.next = r;
            r.next = temp1;

            l = temp1;
            r = temp2;
        }

        return;
    }
}
