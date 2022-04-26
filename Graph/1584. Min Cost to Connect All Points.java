// Link: https://leetcode.com/problems/min-cost-to-connect-all-points/

// Solution: MST-Prim's

/////////////////////////// MINIMUM SPANNING TREE - PRIM'S ALGORITHM //////////////////////////////////

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        // array that keep track of the shortest distance from mst to each node
        int[] disArr = new int[len];
        for (int i = 1; i < len; ++i) {
            disArr[i] = Integer.MAX_VALUE;
        }
        // visited[node] == true if node in mst
        boolean[] visited = new boolean[len];
        visited[0] = true;//start from 0 node
        
        int numEdge = 0;
        // current node, used to update the disArr
        int cur = 0;
        // result
        int res = 0;
        
        while (numEdge++ < len - 1) {
            int minEdge = Integer.MAX_VALUE;
            int next = -1;
            for (int i = 0; i < len; ++i) {
                // if the node i is not in mst
                if (!visited[i]) {
                    // find the distance between cur and i
                    int xDist = Math.abs(points[cur][0] - points[i][0]);
                    int yDist = Math.abs(points[cur][1] - points[i][1]);
                    int dis = xDist + yDist;
                    // update distance array
                    disArr[i] = Math.min(dis, disArr[i]);
                    // find the shortest edge
                    if (disArr[i] < minEdge) {
                        minEdge = disArr[i];
                        next = i;
                    }
                }
            }
            cur = next;
            visited[cur] = true;
            res += minEdge;
        }
        
        return res;
    }
}


/////////////////////////////////// DIJKSTRA'S ALGORITHM /////////////////////////////////////

// 1. Initialize distance to point at index 0 to 0 and distance to all other points to +inf.

/* 2. While !(all points are covered):
      Pick the index which has the lowest distance value
      Mark this node as visited
      Add the distance to the answer variable
      Update the distance to other points from this point */

// 3. Return ans

class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited=new boolean[points.length];
        
        Node[] nodes=new Node[points.length];
        
        int ans=0;
        
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            nodes[i]=new Node(point[0], point[1], Integer.MAX_VALUE);
        }
        
        nodes[0].dist=0;

        int numNodes=points.length;
        
        while(numNodes>0){
            numNodes--;
            int minIndex = findNextNode(nodes, visited);
            ans += nodes[minIndex].dist;
            visited[minIndex] = true;
            updateDistToAllNodes(nodes, minIndex, visited);
        }
        
        return ans;
    }

    public void updateDistToAllNodes(Node[] nodes, int index, boolean[] visited){
        int x = nodes[index].x;
        int y = nodes[index].y;
        
        for(int i=0;i<nodes.length;i++){
            if(!visited[i]){
                int newDist=Math.abs(nodes[i].x-x)+Math.abs(nodes[i].y-y);
                nodes[i].dist=Math.min(nodes[i].dist, newDist);
            }
        }
    }

    public int findNextNode(Node[] nodes, boolean[] visited){
        int min=Integer.MAX_VALUE;
        int ans=-1;
        
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].dist<min && !visited[i]){
                min=nodes[i].dist;
                ans=i;
            }
        }
        
        return ans;
    }

    class Node{
        int x, y;
        int dist;
        
        Node(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}