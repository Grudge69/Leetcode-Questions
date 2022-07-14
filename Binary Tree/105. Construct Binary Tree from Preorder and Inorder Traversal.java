// Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Solution: 

// Un Optimized using Loop for searching

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
        return root;
    }
    
    private TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, int[] in) {
        //base case
        if(pre_lo > pre_hi) {
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        node.val = pre[pre_lo];
        
        int idx = in_lo;
        while(in[idx]!=pre[pre_lo] && idx<=in_hi) {
            idx++;
        }
        
        int lhs = idx - in_lo;
        
        node.left = construct(pre_lo+1, pre_lo+lhs, in_lo, idx-1, pre, in);
        node.right = construct(pre_lo+lhs+1, pre_hi, idx+1, in_hi, pre, in);
        
        return node;
    }
}

//Optimized Using HashMap

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        //inorder map: elem -> idx
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(0, preorder.length-1, 0, inorder.length-1, preorder, inMap);
    }
    
    private TreeNode helper(int preLo, int preHi, int inLo, int inHi, int[] pre, HashMap<Integer, Integer> inMap) {
        //out of bounds
        if(preLo > preHi) {
            return null;
        }
        
        //preorder's left most is the root
        TreeNode root = new TreeNode(pre[preLo]);
        
        //get position of curr root in inorder
        int inPos = inMap.get(pre[preLo]);
        
        //get no. of elements in the left subtree which will be told by the inorder array as => Left Node Right
        int elemToLeft = inPos - inLo;
        
        //get the left and right subtree of root built by the helper()
        root.left = helper(preLo+1, preLo+elemToLeft, inLo, inPos-1, pre, inMap);
        root.right = helper(preLo+elemToLeft+1, preHi, inPos+1, inHi, pre, inMap);
        
        return root;
    }
}