// Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

// Solution

// Using DFS: TC: O(N), Space: O(ht of tree)

class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}

// Using Morris Traversal: TC: O(N), Space: O(1)

class Solution {
    
    public List<Integer> inorderTraversal(TreeNode curr) {
        List<Integer> ans = new ArrayList<>();
        if(curr == null)
            return ans;
        
        //work till curr exists
        while(curr != null) {
            //if left child doesn't exist
            if(curr.left==null) {
                //print curr and go to right
                ans.add(curr.val);
                curr = curr.right;
            } 
            //if left child exists
            else {
                //find inOrder predecessor -> left's rightMost
                TreeNode iop = curr.left;
                //till iop's right points to curr or null
                while(iop.right!=null && iop.right!=curr) {
                    iop = iop.right;
                }
                //left is unprocessed
                if(iop.right == null) {
                    //make thread and go to left
                    iop.right = curr;
                    curr = curr.left;
                } 
                //left is processed
                else {
                    //break thread, print and go to right
                    iop.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}