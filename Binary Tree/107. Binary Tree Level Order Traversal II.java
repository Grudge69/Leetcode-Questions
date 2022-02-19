                         //QUESTION DESCRIPTION

// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).


// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]

// Example 2:

// Input: root = [1]
// Output: [[1]]

// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

                          //SOLUTION(SIZE OF QUEUE METHOD)

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //no tree exist
        if(root == null) return new ArrayList<>();
        
        //store all level nodes as different arraylists
        List<List<Integer>> ans = new ArrayList<>();
        
        //helper queue 
        Queue<TreeNode> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        while(q.size()>0){
            //q size can vary when we are removing inside the loop so we don't know how many times the for loop runs which is why we store it in a variable count
            int count = q.size();
            //list storing nodes at a particular level
            List<Integer> levels = new ArrayList<>();
            
            //all count(size of queue after pushing nodes) no. of nodes are nodes at a particular level
            for(int i=0; i<count; i++){
                //take curr node from queue
                TreeNode curr = q.remove();
                //add its value in levels list which contains contains values at a particular level and pop its value from queue
                levels.add(curr.val);
                //add left and right nodes in queue if they exist
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            //add this level to ans list
            ans.add(levels);
        }
        
        //reverse the entire list to get the final ans in reverse order as asked
        Collections.reverse(ans);
        //return list
        return ans;
    }
}