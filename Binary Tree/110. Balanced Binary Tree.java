// Link: https://leetcode.com/problems/balanced-binary-tree/

// Solution

// Using Height function

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            // no node means tree is balanced
            return true;
        }

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            // if abs(ht. left subtree - ht. right subtree)>1 => tree is not balanced
            return false;
        }

        // check for other nodes if they are balanced or not
        // && is used because even if 1 of the node isn't balanced it means entire tree
        // is not balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // function to get height of the tree in terms of nodes
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

// using pair class(height, balanced)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // pair class with height and balanced
    class Pair {
        int height;
        boolean balanced;

        Pair() {
            this.height = 0;
            this.balanced = false;
        }

        Pair(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        // return answer's balanced member
        return heightBalancedChecker(root).balanced;
    }

    // this function return pair(height, balanced)
    Pair heightBalancedChecker(TreeNode node) {
        if (node == null) {
            // for no node ht=0, it is balanced
            return new Pair(0, true);
        }

        // get ans for left subtree
        Pair leftPair = heightBalancedChecker(node.left);
        // if left is not balanced return it as answer as the entire tree won't be
        // balanced
        if (!leftPair.balanced) {
            return leftPair;
        }

        // get ans for right subtree
        Pair rightPair = heightBalancedChecker(node.right);
        // if right is not balanced return it as answer as the entire tree won't be
        // balanced
        if (!rightPair.balanced) {
            return rightPair;
        }

        // get height difference for both left and right subtree
        int htDiff = Math.abs(leftPair.height - rightPair.height);
        Pair ans = new Pair();
        // set final result's height
        ans.height = 1 + Math.max(leftPair.height, rightPair.height);
        // for height difference <= 1 set ans.balanced = true and false otherwise
        ans.balanced = (htDiff <= 1) ? true : false;

        // return that ans
        return ans;
    }
}

// Manipulating Height() function

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {// for 0 no. of nodes tree is balanced
            return true;
        }

        // a function which returns height ans -1 if the tree is unbalanced
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            // height 0 for no nodes, ht is in terms of nodes
            return 0;
        }
        // get height for left or right subtree
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // if anyone returns -1 it means that they are unbalanced i.e. difference of
        // left & right child's ht > 1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // if difference of left & right child's ht > 1 => tree is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // return height of root node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}