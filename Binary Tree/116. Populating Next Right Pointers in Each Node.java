// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Solution

// DFS-> Processing right node first

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

// Alternate DFS Approach

class Solution {
    public Node connect(Node root) {
        //for leaf nodes and nodes that don't exist
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        //if both sides exists
        if(root.left!=null && root.right!=null) {
            root.left.next = root.right;
        }
        
        //if right child exists
        if(root.right!=null) {
            //if root.next has a node connected to it, join right's next to root.next's left
            if(root.next!=null)
                root.right.next = root.next.left;
            //otherwise leave it null
            else 
                root.right.next = null;
        }
        
        //go to left and right children and do the same
        connect(root.left);
        connect(root.right);
        
        //return our root
        return root;
    }
}

// Iterative

class Solution {
    public Node connect(Node root) {
        Node p1=root;
        
        while(p1!=null) {
            Node p2=p1;
            
            while(p2!=null) {
                if(p2.left!=null) {
                    p2.left.next = p2.right;
                }
                if(p2.right!=null && p2.next!=null) {
                    p2.right.next = p2.next.left;
                }
                p2 = p2.next;
            }
            
            p1=p1.left;
        }
        
        return root;
    }
}