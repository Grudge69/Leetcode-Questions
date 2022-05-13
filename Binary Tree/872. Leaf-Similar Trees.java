// Link: https://leetcode.com/problems/leaf-similar-trees/

// Solution : Store leaf nodes in list and comparing

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
    // Time O(N) Space O(N)
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        getList(root1, list1);
        
        List<Integer> list2 = new ArrayList<>();
        getList(root2, list2);
        
        if(list1.size() == list2.size()) {
            for(int i=0; i<list1.size(); i++) {
                if(list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
    
    private void getList(TreeNode root, List<Integer> list) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        
        getList(root.left, list);
        getList(root.right, list);
    }
}

// Alternate Solution

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}