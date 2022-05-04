// Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/

// Solution

// 2 pointers

class Solution {
    public int maxOperations(int[] nums, int k) {
        //sort array
        Arrays.sort(nums);
        //start and end pointers
        int i=0, j=nums.length-1;
        int count = 0; // count no. of steps
        //till start and end ptrs meet or cross each other
        while(i<j) {
            //if we get a sum of k then count a step and move start and end ptrs
            if(nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            }
            //if sum > k, move the end ptr as we need a smaller value
            else if(nums[i] + nums[j] > k) {
                j--;
            }
            //if sum < k, move the start ptr as we need a bigger value
            else {
                i++;
            } 
        }
        
        return count;
    }
}

// Hashmap

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int count=0;
        
        for(int i=0; i<nums.length ;i++){
            //to check if that k-nums[i] present and had some value left or already paired
            if(map.containsKey(k-nums[i]) && map.get(k-nums[i]) > 0){
                count++;
                map.put(k-nums[i], map.get(k-nums[i]) - 1);
            }else{
                //getOrDefault is easy way it directly checks if value is 0 returns 0 where I added 1
                //and if some value is present then it return that value "similar to map.get(i)" and I added 1 on it 
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        return count;
    }
}

// binary search to find boundary + the first solution

class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.parallelSort(nums);
        int l = -1;
        int r = n;
        // binary search to find right boundary
        while (l + 1 < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < k) {
                l = m;
            } else {
                r = m;
            } 
        } 
        r = l;
        l = 0;
        int total = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            } else {
                total++;
                l++;
                r--;
            }
        }
        return total;
    }
}