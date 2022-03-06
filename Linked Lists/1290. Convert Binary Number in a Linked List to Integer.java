// Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

// SOLUTION: Iterative

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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        
		// for 1->0->1
		// 1. ans = 0*2 + 1 = 1
		// 2. ans = 1*2 + 0 = 2
		// 3. ans = 2*2 + 1 = 5
		
        while(head!=null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        
        return ans;
    }
}