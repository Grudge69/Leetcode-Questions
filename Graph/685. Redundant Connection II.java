// Link: https://leetcode.com/problems/redundant-connection-ii/

// Solution: UNION & FIND

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        Arrays.fill(parent, -1);
        
        boolean twoParents = false;
        int[] e1 = null, e2 = null; //2 edges which are connected to same node, e1 comes before e2
        
        //finding which vtx have 2 parents
        for(int i=0; i<edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            //first parent
            if(parent[to] == -1) {
                parent[to] = from;
            } else {
                twoParents = true;
                e2 = edges[i];
                e1 = new int[]{parent[to], to};
                break;
            }
        }
        
        dsu = new int[edges.length+1];//vtx are from 1-n
        for(int i=0; i<=edges.length; i++) {
            dsu[i] = i;
        }
        
        //case where no vtx has 2 parents
        if(twoParents == false) {
            //Edge creating cycle is the answer
            int[] res = null;
            for(int i=0; i<edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];

                int fromLead = find(from);
                if(to == fromLead) {
                    //cycle detected
                    res = edges[i];
                    break;
                } else {
                    dsu[to] = fromLead;
                }
            }
            
            return res;
        } else {
            //EXCLUDE e2 => find cycle
            boolean noCycleFlag = true;
            for(int i=0; i<edges.length; i++) {
                if(edges[i] == e2) {
                    continue;
                }
                
                int from = edges[i][0];
                int to = edges[i][1];

                int fromLead = find(from); 
                if(to == fromLead) {
                    //cycle detected
                    noCycleFlag = false;
                } else {
                    dsu[to] = fromLead;
                }
            }  
            
            //If removing e2 is not causing cycle then e2 is the cause of cycle. Otherwise e1 is cause of cycle.
            return (noCycleFlag == true)? e2: e1;
        }
    }
    
    int[] dsu;//parent set for UNION & FIND
    
    int find(int x) {
        if(dsu[x] == x) {
            return x;
        } else {
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
    
}