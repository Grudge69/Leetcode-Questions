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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        //POST ORDER -> Left Right Node
        
        //add left subtree call
        if(root.left!=null) ans.addAll(postorderTraversal(root.left));
        
        //add right subtree call
        if(root.right!=null) ans.addAll(postorderTraversal(root.right));
        
        //add current node val
        ans.add(root.val);
        
        //return final answer
        return ans;
    }
}