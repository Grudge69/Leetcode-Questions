/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // THIS RECURSIVE SOLUTION CREATES ANS ARRAYLIST FOR EVERY RECURSIVE CALL WHICH JUST USES MORE SPACE IN HEAP
//     public List<Integer> preorder(Node root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root==null) return ans;
        
//         ans.add(root.val);
//         for(Node child: root.children){
//             List<Integer> childVal = preorder(child);
//             ans.addAll(childVal);
//         }
        
//         return ans;
//     }
    
    
    //The idea is to create 1 ArrayList for ans and pass its reference to helper function calls
    public List<Integer> preorder(Node root){
        List<Integer> ans = new ArrayList<>();
        
        //passing reference of ans in helper function ans getting the values in preorder
        preorderHelper(root, ans);
        
        //returning the final list with preorder traversal
        return ans;
    }
    
    private void preorderHelper(Node root, List<Integer> ans){
        if(root == null) return;
        
        //add our value to ans
        ans.add(root.val);
        
        //call for all the children of current node(root)
        for(Node child: root.children){
            preorderHelper(child, ans);
        }
    }
}