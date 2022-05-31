// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

// Solution

// Take head and tail like linked list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null;
        Node tail = null;
        
        while(curr!=null) {
            //curr on lv x and head,tail on lv x+1
            while(curr!=null) {
                if(curr.left!=null) {
                    if(head == null) {
                        head = curr.left;
                        tail = curr.left;
                    } else {
                        tail.next = curr.left;
                        tail = curr.left;
                    }
                }
                
                if(curr.right!=null) {
                    if(head == null) {
                        head = curr.right;
                        tail = curr.right;
                    } else {
                        tail.next = curr.right;
                        tail = curr.right;
                    }
                }
                
                curr = curr.next;
            }
            
            curr = head;
            head = null;
            tail = null;
        }
        
        return root;
    }
}

// DFS-> Processing right node first

class Solution {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null) ) {
            return root;
        }
        
        // connect left child to right child
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        
        // connect right child (or left if right is abasent) to child of next nodes.
        Node lNode = (root.right == null) ? root.left : root.right;
        
        Node next = root.next;
        while (next != null && next.left == null && next.right == null) {
            next = next.next;
        }

        if (next != null) {
            lNode.next = (next.left != null) ? next.left : next.right;
        }
        
        // process right child first
        connect(root.right);
        connect(root.left);
        
        return root;
    }
}

//BFS LEVEL ORDER
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size()!=0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node curr = q.remove();
                if(i == size-1) {
                    curr.next = null;
                }else {
                    curr.next = q.peek();
                }

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);  
            }
            
        }
        
        return root;
    }
}