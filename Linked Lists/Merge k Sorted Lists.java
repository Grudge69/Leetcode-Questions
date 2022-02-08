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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(-1);
        ListNode tail = res;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null)
            tail.next = head1;
        else
            tail.next = head2;

        return res.next;
    }

    public ListNode helper(ListNode[] lists, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return lists[left];

        int mid = (right + left) / 2;
        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid + 1, right);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Base case
        if (lists.length == 0) {
            // 0 LL
            return null;
        }

        return helper(lists, 0, lists.length - 1);

    }
}