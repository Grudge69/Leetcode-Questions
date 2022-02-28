// Link: https://leetcode.com/problems/summary-ranges/

// SOLUTION

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        //if string is empty return empty list
        if (nums.length == 0) {
            return result;
        }
        
        //contains individual ranges
        StringBuilder sb = new StringBuilder();
        
        //traversing the array
        for (int i=0; i< nums.length; i++) {
            //take current number(starting of range)
            int currentNumber = nums[i];
            
            //reset StringBuilder for new ranges
            sb.setLength(0);
            
            //traverse till next = curr + 1 && till second last index
            while (i < nums.length - 1 && nums[i+1] == nums[i] + 1) {
                i++;
            }
            
            //if i has travelled because of the previous loop then we have got a ending value of range
            if(currentNumber != nums[i]) {
                sb.append(currentNumber);
                sb.append("->");
                sb.append(nums[i]);
            } else {
                //the previous while loop didn't word and we didn't get a different ending value
                //so add this number only
                sb.append(currentNumber);
            }
            
            //add the range to list
            result.add(sb.toString());
        }
        
        //return final list
        return result;
    }
}