// Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

// SOLUTION

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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        
        // if(k==size-k+1){
        //     return head;
        // }
        temp=head;
        for(int i=0; i<size; i++){
            if(i==k-1){
                left = temp;
            }
            if(i==size-k){
                right = temp;
            }
            temp=temp.next;
        }
      
        int tempVal =left.val;
        left.val = right.val;
        right.val = tempVal;
        
        return head;
    }
}

// ALTERNATIVE APPROACH

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode prev = head, nxt = head;
        
        //move nxt to kth node(1 based indexing)
        for(int i = 1; i <= k - 1; i++)
            nxt = nxt.next;
        ListNode marker1 = nxt;
        
        //keep a gap of k nodes and move prev(at head) and nxt(at k node) till next reaches last node
        while(nxt.next!=null)
        {
            prev = prev.next;
            nxt = nxt.next;
        }
        
        // swap(prev.val, marker1.val);
        int temp = prev.val;
        prev.val = marker1.val;
        marker1.val = temp;
        
        return head;
    }
}