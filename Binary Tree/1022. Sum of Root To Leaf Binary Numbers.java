// Link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

// Solution: recursion DFS

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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        
        // sum = sum*2 + root.val; //same as below statement
        sum = (sum << 1) + root.val;
        
        if(root.left == null && root.right == null){
            return sum;
        }
        
        return helper(root.left, sum) + helper(root.right, sum);
    }
}