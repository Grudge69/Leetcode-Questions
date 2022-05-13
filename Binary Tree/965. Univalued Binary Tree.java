// Link: https://leetcode.com/problems/univalued-binary-tree/

// Solution

// DFS

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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        return helper(root, root.val);
    }
    
    private boolean helper(TreeNode root, int val) {
        if(root == null) return true;
        
        return (val == root.val) && helper(root.left, val) && helper(root.right, val);
    }
}

// BFS

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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> q = new ArrayDeque<>();
        int val = root.val;
        q.add(root);
        
        while(q.size()!=0) {
            TreeNode curr = q.remove();
            if(curr.val != val) return false;
            
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
        
        return true;
    }
}