class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(nums1.length > nums2.length){
            // traverse through num2 and search each element in num1
            // sort nums1 for binary search
            Arrays.sort(nums1);
            for(int val: nums2){
                if(binarySearch(nums1, val)==true){
                    if(ans.contains(val) == false)
                        ans.add(val);
                }
            }
        }else{
            // traverse through num1 and search each element in num2
            // sort nums2 for binary search
            Arrays.sort(nums2);
            for(int val: nums1){
                if(binarySearch(nums2, val)==true){
                    if(ans.contains(val) == false)
                        ans.add(val);
                }
            }
        }
        
        int[] result = new int[ans.size()];
        int k = 0;
        for(int val: ans){
            result[k++] = val;
        }
        
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return false;
    }
}