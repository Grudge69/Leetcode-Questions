// Link : https://leetcode.com/problems/binary-tree-right-side-view/

// Solution : BFS

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        //queue for processing
        Queue<TreeNode> q = new ArrayDeque<>();
        
        //add root to queue
        q.add(root);
        
        //work till queue is empty
        while(!q.isEmpty()){
            //currently queue contains nodes of a particular so do this size no. of times
            int count = q.size();
            
            //list for nodes of current level
            List<Integer> levels = new ArrayList<>();
            
            //bfs is from right to left so first value in queue is the rightmost node of that level
            ans.add(q.peek().val);
            while(count-- > 0){
                //remove front node of queue as it contains first node of that level from left -> right
                TreeNode curr = q.remove();
                //add that value to levels list
                levels.add(curr.val);
                
                //get the right child of current tree if it exists
                if(curr.right!=null) q.add(curr.right);
                //get the left child of current tree if it exists
                if(curr.left!=null) q.add(curr.left);
            }
        }
        
        return ans;
    }
}

// DFS(faster)

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
    List<Integer> res = new ArrayList<>();
    int maxDepth = -1;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            res.add(node.val);
        }
        maxDepth = Math.max(maxDepth, depth);
        helper(node.right, depth+1);
        helper(node.left, depth+1);

    }
}

// BFS Alternate

class Solution {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size()!=0){
            int count = q.size();
            
            for(int i=0; i<count; i++){
                TreeNode curr = q.remove();
                
                if(i==count-1) {
                    ans.add(curr.val);
                }
                
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        
        return ans;
    }
}