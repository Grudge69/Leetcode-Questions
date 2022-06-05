// Link: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/

// Solution

// GREEDY SOLUTION: Time O(NlogN) due to sorting, Space O(1)
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int i=0;
        while(i<nums.length) {
            int j=i;
            //find the longest possible subsequence with max-min<=k
            while(j<nums.length && nums[j]-nums[i]<=k) {
                j++;
            }
            ans++;//count 1 subsequence
            //starting of the next subsequence
            i=j;
        }
        return ans;
    }
}

// VISITED ARRAY APPROACH
class Solution {
    public int partitionArray(int[] nums, int k) {
        //Arrays.sort(nums);
        int result = 0;
        boolean [] visited = new boolean [100_001];
        int prev = - k - 1;
        
        for (int num : nums){
            visited[num] = true;
        }
        
        for (int i = 0; i < visited.length; ++i){
            if (!visited[i]) continue;
            
            if (i - prev > k){
                ++result;
                prev = i;
            }
        }
        
        return result;
    }
}