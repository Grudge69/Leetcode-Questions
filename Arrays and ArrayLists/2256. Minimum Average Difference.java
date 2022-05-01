// Link: https://leetcode.com/problems/minimum-average-difference/

// Solution

// Implementation - 1

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long rSum = 0;
        int lCtr = 0;
        int rCtr = nums.length;
        long lSum = 0;
        
        long lAvg, rAvg;
        long minAverage = 1_000_000;
        long diff;
        int minAvgIdx = 0;
        
        for (int num : nums)
            rSum += num;
        
        for (int i = 0; i < nums.length; ++i){
            ++lCtr;
            --rCtr;
            
            lSum += nums[i];
            rSum -= nums[i];
            
            lAvg = lSum/ lCtr;
            rAvg = rCtr == 0 ? 0 : rSum / rCtr;
            diff = Math.abs(lAvg - rAvg);
            
            if (diff < minAverage){
                minAverage = diff;
                minAvgIdx = i;
            }
        }
        
        return minAvgIdx;
    }
}

// Implementation - 2

class Solution {
    // Calculate the sum first and then minus the left sum in te for loop.

    public int minimumAverageDifference(int[] nums) {
        int len = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len -i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}

// Implementation - 3

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        long totalSum = 0;
        long min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        int avgIdx = -1;
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            long avg = sum/(i+1);
            
            totalSum -= nums[i];
            
            long avg2 = 0;
            if(i == n-1){
                avg2 = 0;
            }
            else {
                avg2 = totalSum/(n-i-1);
            }
            
            long absDiff = Math.abs(avg - avg2);
            if(absDiff < min){
                min = absDiff;
                avgIdx = i;
            }
            
        }
        
        return avgIdx;
    }
}