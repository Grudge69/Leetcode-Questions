// Link: https://leetcode.com/problems/is-graph-bipartite/

// Solution : DFS and BFS

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int v=0; v<graph.length; v++) {
            if(visited[v] == 0) {
                // boolean isBip = traverseBFS(graph, visited, v);
                boolean isBip = traverseDFS(graph, visited, v, 1);
                if(isBip == false) {
                    return false;
                }
            }
        } 
        
        return true;
    }
    
    class Pair {
        int v;
        int color;
        
        Pair(int v, int color) {
            this.v = v;
            this.color = color;
        }
    }
    
    //0 = uncolored
    //1 = green 
    //-1 = red
    private boolean traverseBFS(int[][] graph, int[] visited, int v) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        queue.add(new Pair(v, 1));
        while(queue.size() > 0) {
            //remove
            Pair rem = queue.remove();
            
            //mark*
            if(visited[rem.v] != 0) {
                //check cycle 
                int origCol = visited[rem.v];
                int newCol = rem.color;
                
                if(origCol == newCol) {
                    continue;
                } else {
                    return false;
                }
            }
            
            visited[rem.v] = rem.color;
            for(int nbr: graph[rem.v]) {
                if(visited[nbr] == 0) {
                    queue.add(new Pair(nbr, -rem.color));
                }
            }
        }
        
        return true;
    }
    
    private boolean traverseDFS(int[][] graph, int[] visited, int v, int color) {
        visited[v] = color;
        
        for(int nbr: graph[v]) {
            if(visited[nbr] == 0) {
                boolean isBip = traverseDFS(graph, visited, nbr, -color);
                if(isBip == false) {
                    return false;
                }
            } else {
                int origCol = visited[nbr];
                int newCol = -color;
                
                if(origCol != newCol) {
                    return false;
                }
            }
        }
        
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