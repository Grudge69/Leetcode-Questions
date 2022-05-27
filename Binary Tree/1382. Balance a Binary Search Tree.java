// Link: https://leetcode.com/problems/balance-a-binary-search-tree/

// Solution: Morris Inorder

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null || (root.left==null && root.right==null)) {
            return root;
        }
        //store values in arraylist - inorder - increasing order
        ArrayList<Integer> values = new ArrayList<>();
        traverse(root, values);
        //construct a balanced tree with those values
        return construct(0, values.size()-1, values);
    }
    
    private TreeNode construct(int start, int end, ArrayList<Integer> values) {
        if(start > end) return null;
        
        //mid as root
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(values.get(mid));
        //start to mid-1 is left subtree
        root.left = construct(start, mid-1, values);
        //mid+1 to end is left subtree
        root.right = construct(mid+1, end, values);
        
        return root;
    }
    
    //morris traversal - inorder
    private void traverse(TreeNode root, ArrayList<Integer> values) {
        
        while(root != null) {
            if(root.left == null) {
                //print 
                values.add(root.val);
                //go to right
                root = root.right;
            } else {
                //find inorder predecessor
                TreeNode iop = root.left;
                while(iop.right != null && iop.right != root) {
                    iop = iop.right;
                }
                //if left side is unprocessed
                if(iop.right == null) {
                    //make thread
                    iop.right = root;
                    //go to left
                    root = root.left;
                }
                //if left side is processed
                else {
                    //break thread
                    iop.right = null;
                    //print
                    values.add(root.val);
                    //go to right
                    root = root.right;
                }
            }
        }
    }
}

// Merge Sort

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        inOrder(root,list);
        return makeTree(list,0,list.size() - 1);
    }
    public TreeNode makeTree(ArrayList<Integer> list, int low, int high){
        if(low > high){
            return null;
        }   
        int middle = low + (high - low)/2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left= makeTree(list,low,middle - 1);
        node.right= makeTree(list,middle + 1,high);
        return node;
    }
    
    public void inOrder(TreeNode root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}