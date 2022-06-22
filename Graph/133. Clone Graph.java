// Link: https://leetcode.com/problems/clone-graph/

// Solution

// DFS

// With HashMap for visited

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        HashMap<Integer, Node> visited = new HashMap<>();
        return helper(node, visited);
    }
    
    private Node helper(Node node, HashMap<Integer, Node> visited) {
        Node nodeClone = new Node(node.val);
        visited.put(node.val, nodeClone);
        
        for(Node nbr: node.neighbors) {
            if(visited.containsKey(nbr.val) == false) {
                Node nbrClone = helper(nbr, visited);
                nodeClone.neighbors.add(nbrClone);
            } else {
                Node nbrClone = visited.get(nbr.val);
                nodeClone.neighbors.add(nbrClone);
            }
        }
        
        return nodeClone;
    }
}

// With Frequency Array for visited

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Node[] visited = new Node[101];
        return helper(node, visited);
    }
    
    private Node helper(Node node, Node[] visited) {
        Node nodeClone = new Node(node.val);
        visited[node.val] = nodeClone;
        
        for(Node nbr: node.neighbors) {
            if(visited[nbr.val] == null) {
                Node nbrClone = helper(nbr, visited);
                nodeClone.neighbors.add(nbrClone);
            } else {
                Node nbrClone = visited[nbr.val];
                nodeClone.neighbors.add(nbrClone);
            }
        }
        
        return nodeClone;
    }
}