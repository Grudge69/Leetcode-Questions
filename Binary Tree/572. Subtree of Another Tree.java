// Link:

// Solution: Using sameTree logic

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
    public boolean sameTree(TreeNode nodeA, TreeNode nodeB){
        if(nodeA == null && nodeB == null){
            return true;
        }
        
        if(nodeA == null || nodeB == null){
            return false;
        }
        
        if(nodeA.val != nodeB.val){
            return false;
        }
        
        return sameTree(nodeA.right, nodeB.right) && sameTree(nodeA.left, nodeB.left);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        
        if(root == null || subRoot == null){
            return false;
        }
        
        boolean ans = false;
        
        if(root.val == subRoot.val){
            ans = sameTree(root, subRoot);
        }
        
        return ans || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

// 2nd APPROACH
// Strategy: keep doing a dfs until your parent node matches the child node. 
//           If your parent node matches the child node, 
//           simultaneously DFS the parent and the child and check if they're equal

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
    
    public boolean dfs(TreeNode parent, TreeNode child){
        if(parent == null || child == null){
            return false;
        }
        if(parent.val == child.val){
            if(isValidTree(parent, child)){
                return true;
            }
        }
        return dfs(parent.left, child) || dfs(parent.right, child);
        
    }
    
    public boolean isValidTree(TreeNode parent, TreeNode child){
        //both are null
        if(parent == null && child == null){
            return true;
        }
        //only one is null
        if(parent == null || child == null){
            return false;
        }
        
        if(parent.val == child.val){
            if(isValidTree(parent.left, child.left) && isValidTree(parent.right, child.right)){
                return true;
            }
        }
        return false;
    }
}