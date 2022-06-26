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