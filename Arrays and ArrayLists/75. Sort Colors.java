// Link: https://leetcode.com/problems/sort-colors/

// Solution

// count no. of zeroes, ones and twos and replace that no. of times in order

class Solution {
    public void sortColors(int[] nums) {
        int one = 0, zero = 0, two = 0;
        for(int num: nums) {
            if(num == 0) {
                zero++;
            }
            
            if(num == 1) {
                one++;
            }
            
            if(num == 2){
                two++;
            }
        }
        int i=0;
        for(int j=0; j<zero; j++) {
            nums[i] = 0;
            i++;
        }
        
        for(int j=0; j<one; j++) {
            nums[i] = 1;
            i++;
        }
        
        for(int j=0; j<two; j++) {
            nums[i] = 2;
            i++;
        }
    }
}

//1 traversal, stable

class Solution {
    //i -> 0's region
    //j -> 1's region
    //k -> 2's region
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        while(j<=k) {
            int num = nums[j];
            if(num == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }
            else if(num == 1) {
                j++;
            }
            else {
                swap(nums, j, k);
                //j++ is not done here as the no's ahead are not known to us so we don't know for sure which no. came at j's position after swapping
                k--;
            }
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}