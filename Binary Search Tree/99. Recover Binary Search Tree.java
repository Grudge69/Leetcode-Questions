// Link: https://leetcode.com/problems/recover-binary-search-tree/

// Solution : Inorder traversal, 2 pointer => O(N) time, O(logN) space(recursion stack)

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
    //2 pointers containing the nodes that need to be swapped in order to recover BST
    TreeNode first = null;
    TreeNode second = null;
    //keep prev as low as possible from the range mentioned in constraints
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        //swap values of first and second pointer
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
    
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        //processing
        
        //            root   3
        //                 /   \
        //                /     \
        // prev(first)   1       4  prev
        //                      /
        //                     /
        //                   2  root(second)
        
        //first node not found & the pair with anomaly found(prev.val>root.val)
        if(first==null && prev.val>root.val){
            //set first pointer as prev
            first = prev;
        }
        
        //first node found now finding second & the pair with anomaly found(prev.val>root.val)
        if(first!=null && prev.val>root.val){
            //set second pointer as root
            second = root;
        }
        
        //after every processing prev is updated as root
        prev = root;
        
        inorder(root.right);
    }
    
    
}

// MORRIS TRAVERSAL O(1) space O(N) time

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
    public void recoverTree(TreeNode root) {
        
        /// USING MORRIS INORDER TRAVERSAL
        
        if(root == null) return;
        
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        
        while(root!=null){
            if(root.left == null){
                // PROCESSING NODE
                if(prev!=null && prev.val>root.val){
                    //first not found
                    if(first==null){
                        first = prev;
                    }
                    
                    second = root;
                }
                
                prev = root;
                
                root = root.right;
            }else{
                //get a ptr to right most of left node
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                
                //join temp to root to create threaded binary tree
                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }else{
                    temp.right = null;
                    
                    // PROCESSING NODE
                    if(prev!=null && prev.val>root.val){
                        //first not found
                        if(first==null){
                            first = prev;
                        }

                        second = root;
                    }

                    prev = root;
                    
                    root = root.right;
                }
            }
        }
        
        //Swap first and second ptr values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}