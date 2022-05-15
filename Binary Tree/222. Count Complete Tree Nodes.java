// Link: https://leetcode.com/problems/count-complete-tree-nodes/

// Solution

// BRUTE APPROACHES
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

// Optimized Approach

class Solution {
    public int countNodes(TreeNode root) {
       return helper(root);
    }

    public int helper(TreeNode root) {
        if(root==null) return 0;
        
        int l=0;
        int r=0;
        
        //find lowest level on left side
        TreeNode current=root;
        while(current!=null) {
            l++;
            current=current.left;
        }
        
        //find lowest level on right side
        current=root;
        while(current!=null) {
            r++;
            current=current.right;
        }
        
        //if a complete binary tree(then left and right ends are on same level) exists then nodes = 2^L-1
        if(l==r) return (int)Math.pow(2,l)-1;
        //otherwise traverse on left and right side
        else return 1+helper(root.left)+helper(root.right);
    }
}
