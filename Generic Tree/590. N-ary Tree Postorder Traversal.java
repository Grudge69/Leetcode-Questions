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
    
    //The idea is to create 1 ArrayList for ans and pass its reference to helper function calls
    public List<Integer> postorder(Node root){
        List<Integer> ans = new ArrayList<>();
        
        //passing reference of ans in helper function ans getting the values in preorder
        postorderHelper(root, ans);
        
        //returning the final list with preorder traversal
        return ans;
    }
    
    private void postorderHelper(Node root, List<Integer> ans){
        if(root == null) return;
        
        //call for all the children of current node(root)
        for(Node child: root.children){
            postorderHelper(child, ans);
        }
        
        //add our value to ans(In POSTORDER=>After recursive call)
        ans.add(root.val);
    }
}