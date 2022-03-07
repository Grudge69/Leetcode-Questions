// Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/

// Solution: BFS

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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        
        //Stores children at all levels
        List<List<Integer>> ans = new ArrayList<>();
        
        //Helps in BFS
        Queue<Node> q = new ArrayDeque<>();
        
        //add root from back
        q.add(root);
        
        //work till queue is empty
        while(!q.isEmpty()){
            //count the no. of children at that level because queue has all children stored in it
            int count = q.size();
            //we take this size before because size of queue changes when we remove a child
            
            //stores children at a particular level
            List<Integer> levels = new ArrayList<>();
            
            //remove only the no. of children at that particular level
            for(int i=0; i<count; i++){
                //remove 1 node from front
                Node curr = q.remove();
                //store it's value
                levels.add(curr.val);
                
                //add all its children in queue(from backwards)
                for(Node child: curr.children){
                    q.add(child);
                }
            }
            
            //we have got all the children of a particular level and add this level to our ans
            ans.add(levels);
        }
        
        //return the final ans
        return ans;
        
    }
}