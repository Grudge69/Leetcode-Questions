// Link: https://leetcode.com/problems/copy-list-with-random-pointer/

// Solution: USING HASHMAP

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node nHead = new Node(-1); // dummy node for creating a new copy of the list without random pointers
        Node tail = nHead;

        while (curr != null) {
            Node node = new Node(curr.val); // make a fresh copy of current node from original list
            tail.next = node; // join it to new list's end

            map.put(curr, node); // map curr node address-->new node address : a --> a'

            tail = tail.next;
            curr = curr.next; // go to next node and do the above steps
        }

        nHead = nHead.next; // new list starts from nHead.next
        Node c1 = head; // iterator for list1
        Node c2 = nHead; // iterator for list2

        while (c1 != null) {
            // get random pointer of a current and copy it's corresponding value in new
            // list(only if random exists)
            c2.random = (c1.random != null) ? map.get(c1.random) : null;

            c1 = c1.next; // go to next node and do the same as above
            c2 = c2.next;
        }

        return nHead; // return new list with random pointers attached to it
    }
}