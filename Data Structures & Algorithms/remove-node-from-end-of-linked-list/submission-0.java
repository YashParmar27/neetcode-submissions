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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        while (curr != null)
        {
            count++;
            curr = curr.next;
        }

        int index = count - n + 1;
        curr = dummy;
        count = 0;
        while (count < index - 1)
        {
            count++;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
