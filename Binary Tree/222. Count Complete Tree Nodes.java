// Link: https://leetcode.com/problems/count-complete-tree-nodes/

// Solution

//Approach 1

class Solution {
    int nodeCount = 0;
    public int countNodes(TreeNode root) {
        nodeCount = 0;
        countNodesUtils(root);
        return nodeCount;
    }
    private void countNodesUtils(TreeNode n){
        if(n == null) return;
        nodeCount++;
        countNodesUtils(n.left);
        countNodesUtils(n.right);
    }
}

//Approach 2

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}