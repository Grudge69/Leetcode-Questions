// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

// Solution : Recursive

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        //node
        ans.add(root.val);
        //left
        if(root.left!=null){
            List<Integer> left = preorderTraversal(root.left);
            ans.addAll(left);
        } 
        //right
        if(root.right!=null){
            List<Integer> right = preorderTraversal(root.right);
            ans.addAll(right);
        } 
        
        return ans;
    }
}

// Morris Traversal

class Solution {
    public List<Integer> preorderTraversal(TreeNode curr) {
        List<Integer> ans = new ArrayList<>();
        if(curr == null)
            return ans;
        
        //work till curr exists
        while(curr != null) {
            //if left child doesn't exist
            if(curr.left==null) {
                //print curr and go to right
                ans.add(curr.val);
                curr = curr.right;
            } 
            //if left child exists
            else {
                //find inOrder predecessor -> left's rightMost
                TreeNode iop = curr.left;
                //till iop's right points to curr or null
                while(iop.right!=null && iop.right!=curr) {
                    iop = iop.right;
                }
                //left is unprocessed
                if(iop.right == null) {
                    //print, make thread and go to left
                    ans.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                } 
                //left is processed
                else {
                    //break thread and go to right
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}