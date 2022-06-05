// Link: https://leetcode.com/problems/replace-elements-in-an-array/

// Solution

// HashMap

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for(int[] op: operations) {
            if(!map.containsKey(op[0])) continue;
            int idx = map.get(op[0]);
            nums[idx] = op[1];
            map.remove(op[0]);
            map.put(nums[idx], idx);
        }
        
        return nums;
    }
}

// HashSet

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) 
            set.add(num);
        
        for (int[] op: operations) {
            set.remove(op[0]);
            set.add(op[1]);
        }
        
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        
        for (int num: set) {
            res[i++] = num;
        }
        
        
        return res;
    }
}