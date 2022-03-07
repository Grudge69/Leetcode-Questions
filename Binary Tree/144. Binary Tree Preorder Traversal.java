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