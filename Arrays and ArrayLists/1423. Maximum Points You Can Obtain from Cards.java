// Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

// Solution: Find minimum sum subarray and subtract from totalSum

// LOGIC:
// This question is a good example where simply finding a way to reword it would make your life a lot easier. The question is asking us to find the maximum sum of values at the left and right edges of the array. More specifically, it's asking us to find the max sum of k values at the edges. If we were to reword the question, we're essentially asked to find the minimum subarray sum of length n - k. Once we find this, we simply subtract this from the total sum and this would be our answer.
    
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0, minSubarray = 0;

        int currSum = 0;
        
        for (int i=0; i<n; i++) {
            totalSum += cardPoints[i];
            currSum += cardPoints[i];
            if (i < n-k) minSubarray += cardPoints[i];
            else {
                currSum -= cardPoints[i-(n-k)];
                minSubarray = Math.min(minSubarray, currSum);
            }
        }

        return totalSum - minSubarray;
    }
}

// Alternate method: sliding window, min subarr

// Approach: Find contiguous subarr of length n-k with least sum and subtract it from total sum of all the elements

// Time: O(N), Space: O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        //get the total sum
        int totalSum = 0;
        for(int val: cardPoints) {
            totalSum += val;
        }
        
        //picking up all the cards
        if(n == k) {
            return totalSum;
        }
        
        //pick up first n-k-1 values to go towards forming a window of n-k
        int window = 0;
        for(int i=0; i<n-k-1; i++) {
            window += cardPoints[i];
        }
        
        //add 1 value to this window from n-k-1 to n, to make the window of size n-k
        //check totalSum - window, max value from all windows
        //subtract leftmost value from window and add next value to the right in window to make the window of size n-k again
        int ans = 0;
        for(int i=n-k-1; i<n; i++) {
            window += cardPoints[i];
            
            ans = Math.max(ans, totalSum - window);
            
            window -= cardPoints[i-(n-k-1)];//left most value of window
        }
        
        return ans;
    }
}