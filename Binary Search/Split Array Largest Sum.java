class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            // Ans = Max element in array in case of 1 partition(min partitions possible)
            start = Math.max(start, nums[i]);

            // Ans = Sum of all elements in array in case of N(size of array) partitions(max
            // partitions possible)
            end += nums[i];
        }

        // Apply Binary search to search for ans in this range
        while (start < end) {
            int mid = start + (end - start) / 2;

            // try to find the no. of parts in which array can be divided such that the sum
            // of each subArray <= mid
            int sum = 0;
            int parts = 1;

            for (int num : nums) {

                if (sum + num > mid) {
                    // If the sum exceeds then divide it into next part
                    parts++;
                    // add first element of next subArray in sum to start calculating sum from
                    // scratch
                    sum = num;
                } else {
                    // Otherwise, just keep adding the numbers in array
                    sum += num;
                }
            }

            // If the parts we have divided < parts allowed(m)
            // This means sum of each subArray > the correct ANS
            // We need to decrease our sum(mid), OR, ANS < mid
            if (parts <= m) {
                end = mid;
            } else {
                // If the parts we have divided > parts allowed(m)
                // This means sum of each subArray < the correct ANS
                // We need to increase our sum(mid), OR, ANS > mid
                start = mid + 1;
            }
        }

        // After completion of while loop, start==end => return end; is also valid
        return start;
    }
}