// Link: https://leetcode.com/problems/validate-binary-search-tree/

// SOLUTION: In-Order traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        //if no nodes exists it is said to be a BST
        if(root == null){
            return true;
        }
        
        //PROCESSING IS DONE IN-ORDER
        //check if left subtree is valid BST
        boolean left = isValidBST(root.left);
        
        //if prev value exists and is higher that root then it is not a BST 
        //as in a BST the inorder is in increasing order
        if(prev!=null && root.val<=prev){
            return false;//return false as it is not a BST
        }else{
            //set prev to curr node
            prev = root.val;
        }
        
        //check if the right subtree is BST
        boolean right = isValidBST(root.right);
        
        //check if both left and right are BST
        return left && right;
    }
}

// Morris Inorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer prev = null;
        
        while(root!=null) {
            if(root.left==null) {
                //print
                if(prev!=null && prev>=root.val) {
                    return false;
                }
                prev=root.val;
                //go to right
                root=root.right;
            } else {
                //find inorder predecessor
                TreeNode iop = root.left;
                while(iop.right!=null && iop.right!=root) {
                    iop=iop.right;
                }
                //if left is unprocessed
                if(iop.right==null) {
                    //make thread
                    iop.right=root;
                    root=root.left;//go to left
                } else {
                    //break thread
                    iop.right=null;
                    //print
                    if(prev!=null && prev>=root.val) {
                        return false;
                    }
                    prev=root.val;
                    //go to right
                    root=root.right;
                }
            }
        }
        
        return true;
    }
}