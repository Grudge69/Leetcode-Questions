// Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

//SOLUTION : 2 Pointer technique O(N) time

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //2 Pointer Approch USED
        //start and end pointer
        int left = 0, right = numbers.length-1;
        
        //traverse before the meet
        while(left<right){
            //sum of no. at start and end ptr
            int sum = numbers[left]+numbers[right];
            
            //return the indices(1-based indexing) of the pair, if found
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            //sum < target means we have to increase our sum to meet target
            if(sum<target){
                //left pointer is increased to go to a higher value as arr is sorted
                left++;
            }
            //sum > target means we have to deccrease our sum to meet target
            else{
                //right pointer is deccreased to go to a lower value as arr is sorted
                right--;
            }
        }
        
        //no pair found
        return null;
    }
}

// Binary search for each element's complement O(NlogN) time

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //id array is empty return not found [-1,-1]
        if(numbers.length == 0){
            return new int[]{-1, -1};
        }

        //traverse entire array and search complement of each value via binary search
        for(int i=0; i<numbers.length; i++){
            int val = numbers[i];
            int complement = target - val;

            //complement's index value except when it matches our curr value's idx as we should not take a element twice
            int compIdx = search(numbers, complement, i);
            //if an element is found then return the indices(1-based indexing)
            if(compIdx!=-1){
                return new int[]{i+1, compIdx+1};
            }
        }
        
        return new int[]{-1, -1};
    }
    
    //binary search with idx given which is our curr val's idx as we have to skip it to ensure not taking same element twice
    public int search(int[] nums, int target, int idx) {
        int start=0, end=nums.length-1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                //if target matches our element and mid == idx means we are taking the same element twice so skip it
                if(mid == idx) start = mid + 1;
                else return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        //no element found
        return -1;
    }
}