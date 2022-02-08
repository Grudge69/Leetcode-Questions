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
    public ListNode partition(ListNode head, int x) {

        // 2 dummy nodes for x < 3 and x >= 3
        ListNode dummyL3 = new ListNode(-1);
        ListNode dummyG3 = new ListNode(-1);
        ListNode tL = dummyL3, tG = dummyG3;

        while (head != null) {
            if (head.val >= x) {
                tG.next = head;
                tG = head;
            } else {
                tL.next = head;
                tL = head;
            }

            head = head.next;
        }

        tL.next = null;
        tG.next = null;

        // joining both separated LL
        tL.next = dummyG3.next;

        return dummyL3.next;
    }
}