// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

// SOLUTION : DFS

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
    public int maxDepth(TreeNode root) {
        // base condition(at end of leaf node)
        if(root == null) return 0;
        
        // add 1 to the sub answer of whichever is having max depth among left and right sub tree
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
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
    ////// BFS
    public int maxDepth(TreeNode root) {
        // 0 depth for no nodes
        if(root == null){
            return 0;
        }
        //queue for processing
        Queue<TreeNode> q = new LinkedList<>();
        //add root in queue
        q.add(root);
        int depth = 0;//initially depth is 0
        
        //work till queue is empty
        while(q.size()!=0){
            //count = total no. of nodes at a particular level
            int count = q.size();
            depth++;//on encountering each level increment the depth
            //work for only nodes of that level
            while(count-->0){
                //get 1 node of that level
                TreeNode curr = q.remove();
                //Add its left and right child if they exist
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        
        //return the final depth
        return depth;
    }
}