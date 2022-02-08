class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> indices = new ArrayList<>();
        // check for first occurrence if target first
        int start = search(nums, target, true);
        if (start == -1) {
            return indices;
        }
        int end = search(nums, target, false);
        
        for(int i = start; i<=end; i++){
            indices.add(i);
        }
        
        return indices;
        
    }
    
    // this function just returns the index value of target
    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential ans found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}