// Link: https://leetcode.com/problems/find-center-of-star-graph/

// Solution

// O(1) time, comparing 2 edges and finding common vtx

class Solution {
    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];
        
        // edges = [[1,2],[5,1],[1,3],[1,4]] => take any 2 edges and find the common vtx between the two 
        // like in [1,2],[5,1], 1 is common => 1 is the center 
        
        int center = -1;
        if(firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1]) {
            center = firstEdge[0];
        }
        
        if(firstEdge[1] == secondEdge[0] || firstEdge[1] == secondEdge[1]) {
            center = firstEdge[1];
        }
        
        if(secondEdge[0] == firstEdge[0] || secondEdge[0] == firstEdge[1]) {
            center = secondEdge[0];
        }
        
        if(secondEdge[1] == firstEdge[0] || secondEdge[1] == firstEdge[1]) {
            center = secondEdge[1];
        }
        
        return center;
    }
}

// Using inDegree or outDegree

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+2];
        int[] outDegree = new int[n+2];
        
        for(int[] e: edges) {
            inDegree[e[0]]++;
            outDegree[e[0]]++;
            
            inDegree[e[1]]++;
            outDegree[e[1]]++;
        }
        
        for(int i=1; i<=n+1; i++) {
            if(inDegree[i] == n) {
                return i;
            }
        }
        
        return -1;
    }
}