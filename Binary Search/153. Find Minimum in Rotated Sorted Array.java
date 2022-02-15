class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return nums[0];
        }

        // pivot is not actually pivot but pivot+1 as it is the minimum element
        return nums[pivot];
    }
    
    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // instead of returning pivot = mid, we return the next element which is the minimum
                return mid+1;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                // instead of returning pivot = mid-1, we return the next element which is the minimum
                return mid;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}