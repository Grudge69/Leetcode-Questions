// Link: https://leetcode.com/problems/binary-tree-paths/

// Solution: DFS

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
    public List<String> binaryTreePaths(TreeNode root) {
        //if tree doesn't exist then return empty list
        if(root == null){
            return new ArrayList<>();
        }
        
        //for leaf node add that value in list and return
        if(root.left == null && root.right == null){
            List<String> ans = new ArrayList<>();
            ans.add(Integer.toString(root.val));
            return ans;
        }
        
        //get left and right subtree answers
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        //stores our final list
        List<String> ans = new ArrayList<>();
        
        //add "root.val->" to all the paths of left subtree and add it to our final list
        for(String val: left){
            ans.add(root.val+"->"+val);
        }
        
        //add "root.val->" to all the paths of right subtree and add it to our final list
        for(String val: right){
            ans.add(root.val+"->"+val);
        }
        
        //return our final list
        return ans;
    }
}