// Link: https://leetcode.com/problems/two-city-scheduling

// Solution : Sorting using comparator

class Solution {
    
    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        
        //sort array costs according to maximum profit when sending to city a which means a[0]-b[0]>a[1]-b[1]
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        //after sorting first half is with maximized profit for city a and second half is maximized profit for city b
        for(int i=0; i<costs.length; i++){
            int[] arr = costs[i];
            cost += i<costs.length/2? arr[0]: arr[1];
        }
        
        return cost;
    }
}

// Alternative Approach

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //half of costs array is taken
        int N = costs.length/2;
        //calculates our cost
        int minCost = 0;
        //iterator for calculating refund
        int idx = 0;
        //arr of size = costs
        int[] refund = new int[2*N];
        
        for(int[] cost : costs) {
            //for each val of costs get cityB - cityA
            refund[idx++] = cost[1] - cost[0];
            //initially think all of them are going to city A
            minCost += cost[0];
        }
        //refund array has the loss encountered when all go to city A
        Arrays.sort(refund);
        
        //add first half of this loss to minimize the cost
        for (int i = 0; i < N; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}

