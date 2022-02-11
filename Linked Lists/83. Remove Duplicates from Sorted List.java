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
    public ListNode deleteDuplicates(ListNode head) {
        // 0 or 1 node only
        if (head == null || head.next == null)
            return head;

        // previous node, starting from 0
        ListNode prev = head;
        // current node, starting from 1
        ListNode cur = head.next;
        while (cur != null) {
            // prev and cur node have same data then delete 1 node
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return head;
    }
}