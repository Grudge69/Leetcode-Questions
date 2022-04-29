// Link:

// Solution

//Graph Coloring - DFS
// 0 = uncolored
// 1 = blue
// -1 = red

// TIME: O(V+E), SPACE: O(V)
class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];//color for each node in graph
        for (int i = 0; i < g.length; i++)
            //if a node is uncoloured(not connected to any other node => no way to get to that)
            //and, we are not able to colour it
            if (colors[i] == 0 && !validColor(g, colors, 1, i)) // initially we are coloring the node blue
                return false;
        //return true as no conflict in colouring found
        return true;
    }

    //check if we can color the graph with the color we want
    boolean validColor(int[][] g, int[] colors, int color, int node) {
        //if it is already coloured then check if our color is same as the color of the node which means there is no conflict, otherwise there is a conflict and the graph is not bipartite
        if (colors[node] != 0) 
            return colors[node] == color;
        
        //if it is not colored, the color it with our color
        colors[node] = color;
        //check all adjacent nodes and color it with the other color than our color
        for (int adjacent : g[node])
            //return false if coloring is not possible
            if (!validColor(g, colors, -color, adjacent))
                return false;
        return true;
    }
}

//Graph Coloring - BFS
// 0 = uncolored
// 1 = blue
// -1 = red

// TIME: O(V+E), SPACE: O(V)

class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            //do the work if the node is not colored
            if (colors[i] == 0) {
                //Queue for each node's children
                Queue<Integer> q = new LinkedList<>();
                q.add(i);//add our node to it
                colors[i] = 1;//color our node blue
                //work while queue is empty
                while (!q.isEmpty()) {
                    //get our node from queue
                    Integer node = q.poll();
                    //get all it's children/adjacent nodes
                    for (int adjacent : g[node])
                        //if adjacent nodes have the same color as our node => our graph is not bipartite
                        if (colors[adjacent] == colors[node])
                            return false;
                        //if adjacent nodes are not colored
                        else if (colors[adjacent] == 0) {
                            // add it in queue
                            q.add(adjacent);
                            // color it opposite to that of our node
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        
        //return true if no violation is found and entire graph is traversed
        return true;
    }
}

//Union Find 
// TIME: O(ElogV), SPACE: O(V)
class Solution {
    int[] parent; 
    public boolean isBipartite(int[][] graph) {
        parent = new int[graph.length];
        for(int i = 0; i < parent.length; i++) parent[i]  = i;
        for (int i=0; i<graph.length; i++) {
            int[] adjs = graph[i];
            for (int j=0; j<adjs.length; j++) {
                if (find(i) ==find(adjs[j])) return false;
                union(adjs[0], adjs[j]);
            }
        }
        return true;
    }
    
     int find(int i) {
            if (parent[i] == i) {
                return parent[i];
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }
        
        void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ) {
                parent[parentI] = parentJ;
            }
        }
}