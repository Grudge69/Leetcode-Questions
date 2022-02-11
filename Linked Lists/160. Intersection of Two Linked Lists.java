/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getSize(ListNode head){
        int size = 0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int sizeA=getSize(headA);
        int sizeB=getSize(headB);

        if(sizeB>sizeA){
            for(int i=0; i<sizeB-sizeA; i++){
                headB = headB.next;
            }
        }else{
            for(int i=0; i<sizeA-sizeB; i++){
                headA = headA.next;
            }
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA; //headA = headB, so return headB is valid too
    }
    
}


// FLOYD CYCLE DETECTION APPROACH
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail = headB;
        while(tail.next!=null){
            tail=tail.next;
        }
        
        tail.next = headB;
        
        ListNode res = detectCycle(headA);
        
        tail.next = null;
        
        return res;
    }
    
    public ListNode detectCycle(ListNode head) {
         if(head == null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow == fast){
                //reset slow to starting
                slow = head;
                while(slow != fast){
                    // move both slow and fast by 1x speed until they meet
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        
        return null;
    }
}