class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return nums[0];
        }

        // pivot is not actually pivot but pivot+1(0 based indexing)
        // and it is the minimum element
        return nums[pivot];
    }

    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here

            // CASES WHERE MID OR MID+1 IS PIVOT
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // instead of returning pivot = mid, we return the next element which is the
                // minimum
                return mid + 1;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                // instead of returning pivot = mid-1, we return the next element which is the
                // minimum
                return mid;
            }

            // CASES WHERE NEITHER MID NOR MID+1 IS PIVOT
            if (arr[mid] <= arr[start]) {
                // right part(increating)
                end = mid - 1;
            } else {
                // left part(increasing)
                start = mid + 1;
            }
        }
        return -1;
    }

}