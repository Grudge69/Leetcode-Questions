// Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

// Solution: DFS with extra space O(N)

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
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        //stores the inorder of tree which is in increasing order
        List<Integer> increasingList = new ArrayList<>();
        //do inorder traversal and store elements in the list
        inorder(root, increasingList);
        
        //get the minDiff of all diffs
        int minDiff = Integer.MAX_VALUE;
        //traverse the list and compare adjacent value differences with our minDiff
        for(int i=0; i<increasingList.size()-1; i++){
            int diff = Math.abs(increasingList.get(i) - increasingList.get(i+1));
            minDiff = Math.min(minDiff, diff);
        }
        
        //return calculated minDiff
        return minDiff;
    }
    
    //inorder function
    private void inorder(TreeNode root, List<Integer> list){
        //stop when no node exist
        if(root == null){
            return;
        }
        
        //left call
        inorder(root.left, list);
        
        //node -> add value of node in the list
        list.add(root.val);
        
        //right call
        inorder(root.right, list);
    }
}


// DFS Without EXTRA SPACE

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
    //stores the answer we need
    int minDiff = Integer.MAX_VALUE;
    //stores previous node for inorder traversal
    TreeNode prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        inorder(root);
        
        return minDiff;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        //left call
        inorder(root.left);
        
        //inorder processing -> Node operation
        if(prev!=null){
            //if there is a value in prev then compare the diff of prev-root with our current best minDiff
            minDiff = Math.min(minDiff, Math.abs(prev.val - root.val));
        }
        //set prev = root
        prev = root;
        
        //right call
        inorder(root.right);
    }
}