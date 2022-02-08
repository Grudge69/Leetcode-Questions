class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        
        //if we take the contents of array and their indices all values as a list 
        //then there will be pair for all elements except the one that is missing
        //XOR will cancel out all the pairs leaving behind the one missing
        for(int i=0; i<nums.length; i++){
            ans = ans ^ i;
            ans = ans ^ nums[i];
        }
        
        ans = ans ^ nums.length;
        
        return ans;
    }
}