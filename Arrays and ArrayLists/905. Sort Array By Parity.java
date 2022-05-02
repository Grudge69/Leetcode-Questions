// Link: https://leetcode.com/problems/sort-array-by-parity/

// Solution

// Using partition of an array method
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = 0;
        
        while(right < nums.length) {
            if(nums[right] % 2 != 0) {
                right++;
            }else {
                //swap left and right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right++;
            }
        }
        
        return nums;
    }
}

// Using 2 pointer method
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left < right) {
            if(nums[left] % 2 != 0) {
                if(nums[right] % 2 == 0) {
                    //swap left and right
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    
                    left++;
                }
                right--;
            }else {
                left++;
            }
        }
        
        return nums;
    }
}