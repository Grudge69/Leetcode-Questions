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
    public ListNode sortList(ListNode head) {
        // USING MERGE SORT
        if (head == null || head.next == null) {
            // if 0 or 1 nodes then already sorted
            return head;
        }

        ListNode mid = middle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoSortedLists(left, right);
    }

    ListNode middle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // if(fast==null){
        // //even size list
        // return prev;
        // }
        prev.next = null;
        return slow;
    }

    ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}