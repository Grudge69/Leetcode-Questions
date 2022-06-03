// Link: https://leetcode.com/problems/distribute-coins-in-binary-tree/

// Solution

// DFS - PostOrder

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
    //contains nodes and coins on that node and nodes below it
    class Pair {
        int nodes;
        int coins;
    }
    
    int minCoins = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return minCoins;
    }
    
    private Pair helper(TreeNode root) {
        if(root == null) {
            return new Pair();
        }
        
        //get answer from left and right children
        Pair lPair = helper(root.left);
        Pair rPair = helper(root.right);
        
        //current node's nodes and coins are calculated
        Pair currPair = new Pair();
        currPair.nodes = lPair.nodes + rPair.nodes + 1;
        currPair.coins = lPair.coins + rPair.coins + root.val;
        
        //mincoins is calculated as the different between nodes and coins on a particular node and all nodes below it
        minCoins += Math.abs(currPair.nodes - currPair.coins);
        
        return currPair;
    }
}