class Solution {
    public int countElements(int[] nums) {
        // Find min and max
        int min = nums[0], max = nums[0];
        
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // count elements between max and min
        int count = 0;
        
        for(int num: nums){
            if(num>min && num<max) count++;
        }
        
        return count;
    }
}