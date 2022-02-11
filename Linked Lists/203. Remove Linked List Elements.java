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
    void compute(ListNode node, int val) {
        if (node == null || node.next == null)
            return;
        if (node.next.val == val)
            node.next = node.next.next;
        else
            node = node.next;
        compute(node, val);
    }

    public ListNode removeElements(ListNode head, int val) {
        // Dummy node with garbage value pointing to head,
        // to match the head value
        ListNode node = new ListNode(0, head);

        compute(node, val);
        return node.next;
    }
}