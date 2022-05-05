// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Solution: GREEDY

class Solution {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Algorithm: 
    // - Iterate through the array keeping track of minimum so far
    // - At each step check if we can maximise our profit
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE, maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++) {      
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            
        }
        
        return maxProfit;
    }
}

// Alternate Solution

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, minTillNow = prices[0];
        int n = prices.length;
        for(int i=1; i<n; i++) {
            if(prices[i] < minTillNow) {
                minTillNow = prices[i];
            }
            
            int profit = prices[i] - minTillNow;
            ans = Math.max(ans, profit);
        }
        return ans;
    }
}

// Alternate Solution 2

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell, profit = 0, varprofit = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(buy > prices[i]) buy = prices[i];
            else{
                sell = prices[i];
                varprofit = sell - buy;
            }
            if(varprofit > profit) profit = varprofit;
        }
        return profit;
    }
}
