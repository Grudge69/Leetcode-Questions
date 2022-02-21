                     //QUESTION DESCRIPTION

// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3

// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -231 <= nums[i] <= 231 - 1

                     //SOLUTION 

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int val = nums[0], count = 0;
        for(int num: nums){
            if(num == val){
                count++;
            }else{
                count = 1;
                val = num;
            }
            
            if(count>nums.length/2) return val;
            
        }
        
        return val;
    }
}



                 //SHORTER SOLUTION

// LOGIC IS THAT IF A MAJORITY ELEMENT EXIST THEN AFTER SORTING IT WILL BE PRESENT AT SIZE/2 POSITION AS IT OCCURS MORE THAN SIZE/2 TIMES 
// WHICH MEANS IT TAKES UP THE SIZE/2 INDEX.

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
