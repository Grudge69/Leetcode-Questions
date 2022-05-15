// Link:

// Solution

// DFS - 2 Traversal

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        //find maximum height
        int maxHt = height(root);
        //add node values which have height = maxHt
        return sumHelper(root, maxHt);
    }
    
    //maxHeight
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHt = height(root.left);
        int rightHt = height(root.right);
        
        return 1 + Math.max(leftHt, rightHt);
    }
    
    //sum finder
    private int sumHelper(TreeNode root, int maxHt) {
        if(root == null) {
            return 0;
        }
        
        int sum = 0;
        if(root.left == null && root.right == null && maxHt == 1) {
            sum += root.val;
        }
        
        sum += sumHelper(root.left, maxHt-1);
        sum += sumHelper(root.right, maxHt-1);
        
        return sum;
    }
}

// DFS - 1 Traversal

class Solution {
    private int deepestSum = 0;
    private int deepestLevel = 0;

    public int deepestLeavesSum(TreeNode root) { 
        traverse(root, 0);
        return deepestSum;
    }

    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            //if leaf node reached and current level is the deepest
            if(deepestLevel == level) {
                deepestSum += root.val;
            }
            //finding deepest level
            else if(deepestLevel < level){
                deepestSum = root.val;
                deepestLevel = level;
            } 
        }
        
        //go to left and right subtree
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}