// Link: https://leetcode.com/problems/wiggle-subsequence/

// Solution: Time O(N)

// Approach 1

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1;
        int prevDiff = 0;
        
        for(int i=0; i<nums.length-1; i++){
            int diff = nums[i+1] - nums[i];
            if( (diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >=0) ) {
                ans++;
                prevDiff = diff;
            }
        }
        
        return ans;
    }
}

// Approach 2

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1) {
            return nums.length;
        }
        
        int up = 1, down = 1;
        
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] < nums[i+1]) { // uphill case
                up = down + 1;
            } else if(nums[i] > nums[i+1]) {
                down = up + 1;
            }
        }
        
        return Math.max(up, down);
    }
}