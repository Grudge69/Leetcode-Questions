// Link: https://leetcode.com/problems/convert-bst-to-greater-tree/

// Solution: reverse inorder of BST is DECREASING order

class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        
        //traverse reverse inorder(Right Node Left) -> Decreasing order, and store sum in golbal varaible
        reverseInorder(root);
        //return newly changed tree
        return root;
    }
    
    //global var that store sum of all greater value nodes + our value
    int sum = 0;
    void reverseInorder(TreeNode root){
        //no need to check it as we have check it in above function
        if(root == null) return;
        
        //////////////// RIGHT call ////////////////
        reverseInorder(root.right);
        
        //////////////// NODE work ////////////////
        
        //store current root's value in previously calculated sum as sum = previous sum(sum of all greater val nodes) + our sum
        sum += root.val;
        root.val = sum;//set our value as this sum
        
        //////////////// LEFT call ////////////////
        reverseInorder(root.left);
    }
}

// Alternate Approach

class Solution {
    public TreeNode convertBST(TreeNode root) {
        rec(root, 0);
        return root ;
    }
    
    public int rec(TreeNode node , int prevSum){
        //add the value of rightSubTree to node
        //pass this as prevSum to add to leftSubTree
        //return the value of leftSubTree
        if(node == null)
            return prevSum ;
        int rightValue = rec(node.right, prevSum);
        node.val += rightValue ;
        int leftValue = rec(node.left, node.val);
        return leftValue ;
    }
}

