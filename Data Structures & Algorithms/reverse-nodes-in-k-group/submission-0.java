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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode groupPrev = null;

        while (curr != null)
        {
            int count = 0;
            ListNode kp = curr;
            while (count < k && kp != null)
            {
                kp = kp.next;
                count++;
            }

            if (count < k)
                break;

            ListNode start = curr;
            ListNode prev = null;

            while (curr != kp)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if (groupPrev == null)
                head = prev;
            else
                groupPrev.next = prev;

            start.next = kp;
            groupPrev = start;
        }

        return head;
    }
}
