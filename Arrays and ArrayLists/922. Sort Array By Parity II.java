// Link: https://leetcode.com/problems/sort-array-by-parity-ii/

// Solution: 2 array for odd and even

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //even odd store separately in arrays
        int[] even = new int[nums.length/2];
        int[] odd = new int[nums.length/2];
        //even ptr and odd ptr 
        int e=0, o=0;
        for(int num: nums) {
            if(num%2 == 0) {
                even[e] = num;
                e++;
            }else {
                odd[o] = num;
                o++;
            }
        }
        //reset even and odd ptr
        e=0;
        o=0;
        //traverse the arr
        for(int i=0; i<nums.length; i++) {
            //if element is even then add value from even arr
            if(i%2 == 0) {
                nums[i] = even[e];
                e++;
            }
            //if element is odd then add value from odd arr
            else {
                nums[i] = odd[o];
                o++;
            }
        }
        
        return nums;
    }
}

// IN-PLACE, Using 2 ptrs

// We use two pointer approach to keep track of the swapping of elements at correct positions . We traverse our array from the end while we maintain our two pointers from the beginning index i.e 0 and 1 for even and odd respectively .
// We only move our i'th pointer when we know that the current position is infact fulfulling our requirements .

class Solution {
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;   //even pointer
        int odd = 1;    // odd pointer
        int i = nums.length-1;   // we traverse from end of list
        while(i >= 0){
            if(nums[i] % 2 == i % 2)    //only move our pointer if cur placement is satisfied
                i--;
            else{
                if(nums[i] % 2 == 0){
                    swap(nums,even,i);
                    even+=2;
                }
                else{
                    swap(nums,odd,i);
                    odd+=2;
                }
            }
        }
        return nums;
    }
}