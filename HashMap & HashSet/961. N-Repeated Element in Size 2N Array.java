// Link : https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

// SOLUTION : Using SET(Time & Space: O(N))

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        //since set only contains unique elements, so if any element is not being able to go in set, that means it is already present, so return it as it is duplicate
        for(int num: nums){
            if(!set.add(num)) return num;
        }
        
        return 0;
        
    }
}