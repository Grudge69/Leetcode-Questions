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
    public ListNode removeFirst(ListNode head){
        head=head.next;
        return head;
    }
    
//     public ListNode removeLast(Node head){
        
//     }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        
        // if(n==1){
        //     head=removeLast(head)
        // }
        
        
        if(n==size){
            head = removeFirst(head);
        }else{
            curr=head;
            for(int i=0; i<size-n-1; i++){
                
                curr=curr.next;
            }
        
            curr.next = curr.next.next;
        }
        return head;
    }
}