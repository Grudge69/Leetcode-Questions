/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;

        // join dummy node at the beginning
        dummy.next = head;

        // swapping only if 2 nodes are available
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;

            // updating the curr and prev pointers
            curr = curr.next;
            prev = prev.next.next;
        }

        return dummy.next;
    }

}