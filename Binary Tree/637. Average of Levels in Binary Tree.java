// Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/

// Solution: BFS

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
    public List<Double> averageOfLevels(TreeNode root) {
        //no tree exist
        if(root == null) return new ArrayList<>();
        
        //store all level nodes' averages
        List<Double> ans = new ArrayList<>();
        
        //helper queue 
        Queue<TreeNode> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        while(q.size()>0){
            //q size can vary when we are removing inside the loop so we don't know how many times the for loop runs which is why we store it in a variable count
            int count = q.size();
            //adding nodes of that level
            double levels = 0d;
            
            //all count(size of queue after pushing nodes) no. of nodes are nodes at a particular level
            for(int i=0; i<count; i++){
                //take curr node from queue
                TreeNode curr = q.remove();
                //add its value in levels list which contains contains values at a particular level and pop its value from queue
                levels+=(curr.val); //adding nodes of that level
                
                //add left and right nodes in queue if they exist
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            //add this level's average to ans list
            ans.add(levels/count);
        }
        //return list
        return ans;
    }
}