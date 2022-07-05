// Link: https://leetcode.com/problems/evaluate-division/

// Solution: 

// Using DFS

class Solution {
    //helper class with dest->value(weights) pair
    class Node {
        String key;
        double val;

        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build a graph with (src, {dest, value})
        //we use map because graph is dynamic as there is diff wt associated to diff directions
        Map<String, List<Node>> g = buildGraph(equations, values);
        
        //contains the result for each query
        double[] result = new double[queries.size()];
        //call dfs for each query
        for (int i = 0; i < queries.size(); i++)
            //dfs returns the result of each query via traversing graph from query[0] to query[1] and multiplying the values(wt.)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g);
        
        //return the calcualted result for each query
        return result;
    }

    //dfs implementation
    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        //if src or dest variables are not present in the graphs then there is no way to calculate the result
        if (!(g.containsKey(s) && g.containsKey(d)))
            return -1.0;
        //src/dest = 1 if src == dest
        if (s.equals(d))
            return 1.0;
        
        //add current node in visited
        visited.add(s);
        //traverse all nodes from the src
        for (Node ng : g.get(s)) {
            //go to the node only if not visited already
            if (!visited.contains(ng.key)) {
                //find the ans from the neighbour node
                double ans = dfs(ng.key, d, visited, g);
                //multiply the ans with our node's answer only if it isn't -1 and return it
                if (ans != -1.0)
                    return ans * ng.val;
            }
        }
        //return -1 if you can't find the result
        return -1.0;
    }

    // build graph
    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            //in equations list, get src = variable1 and dest = variable2
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            //if src or dest is not available then initialize it
            g.putIfAbsent(src, new ArrayList());
            g.putIfAbsent(des, new ArrayList());
            //find the variable src/dest and ad the corresponding values to it like
            // src->dest = val , dest->src = 1/val
            // add those as nodes in graph
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1 / values[i]));
        }
        //return the graph built
        return g;
    }
}






// Using DSU

class Solution {
    //storing parent of set and multiplier from value to their parents
    HashMap<String, String> parent;
    HashMap<String, Double> mult;
    
    //initialize parent of all operands to themselves and their multipliers as 1.0
    private void initializerDSU(String x) {
        if(parent.containsKey(x) == false) {
            parent.put(x, x);
            mult.put(x, 1.0);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> eq: equations) {
            initializerDSU(eq.get(0));
            initializerDSU(eq.get(1));
        }
        
        //Build DSU
        int i=0; //iterator
        for(List<String> eq: equations) {
            //get leaders and multipliers
            String l0 = find(eq.get(0));
            String l1 = find(eq.get(1));
            
            Double m0 = mult.get(eq.get(0));
            Double m1 = mult.get(eq.get(1));
            
            //perform union(without considering ranks)
            parent.put(l0, l1);
            mult.put(l0, m1*values[i]/m0);
            
            i++;
        }
        
        //iterate queries to check in DSU and find a possible path to go from operand a to operand b
        double[] res = new double[queries.size()];//store results corresponding to each query
        i=0;//reset iterator
        
        for(List<String> query: queries) {
            if(!parent.containsKey(query.get(0)) || !parent.containsKey(query.get(1))) {
               res[i] = -1.0;
               i++;
               continue;
            }
            
            //find leaders of set of both operands of query
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(!l0.equals(l1)) {
               res[i] = -1.0;
               i++;
               continue;
            }
            
            //get the multipliers of both operands and divide them to get the ans
            Double m0 = mult.get(query.get(0));
            Double m1 = mult.get(query.get(1));
            
            res[i] = m0/m1;
            
            i++;
        }
        
        return res;
    }
    
    String find(String x) {
        if(parent.get(x).equals(x)) {
            return x;
        } else {
            String currParent = parent.get(x);
            String leader = find(currParent);
            
            parent.put(x, leader);
            mult.put(x, mult.get(currParent) * mult.get(x));
            
            return leader;
        }
    }
}