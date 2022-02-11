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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int size = sizeOfLL(head);

        if (size < k)
            return head;

        int times = size / k;

        ListNode prev = null;
        ListNode curr = head;
        int start = 1, end = start + k - 1;

        while (times-- > 0) {

            ListNode left = head, prevLeft = null, right = head;
            // traverse right pointer gap times
            int gap = end - start;
            for (int i = 0; i < gap; i++) {
                right = right.next;
            }

            // get starting of left & right side
            for (int i = 1; i < start; i++) {
                // get prev of left side
                prevLeft = left;
                // left and right both travelling at the same time
                left = left.next;
                right = right.next;
            }

            // get next of right side
            ListNode nextRight = right.next;

            // 3 pointers prev, curr and ahead
            curr = left.next;
            prev = left;

            // till prev pointer becomes right which means curr goes out of range given
            while (prev != right) {
                // storing next pointer to current
                ListNode ahead = curr.next;
                // changing links backwards
                curr.next = prev;
                // updating prev and curr 1 step forward
                prev = curr;
                curr = ahead;
            }

            // joining first element of range to next of the last element(after LL is
            // reversed)
            left.next = nextRight;

            // if prevLeft is NULL it means left is the first pointer
            if (prevLeft != null) {
                prevLeft.next = right;
            } else {
                head = right;
            }

            start = end + 1;
            end = start + k - 1;

        }

        return head;
    }

    private int sizeOfLL(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}