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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int size = getSize(head);

        k = k % size;

        ListNode curr = head;
        for (int i = 1; i < size - k; i++) {
            curr = curr.next;
        }

        // Head of part2
        ListNode secondHead = curr.next;

        // separating 2 parts
        curr.next = null;

        // reverse part1
        head = reverseList(head);

        curr = head;

        // . getting tail pointer of first part
        while (curr.next != null) {
            curr = curr.next;
        }

        // reverse part2
        secondHead = reverseList(secondHead);

        // joining 2 parts
        curr.next = secondHead;

        // reversing entire list
        head = reverseList(head);

        return head;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }

        ListNode temp = head;
        head = tail;
        tail = temp;

        return head;
    }
}