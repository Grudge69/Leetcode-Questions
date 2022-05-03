// Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

// Solution: Using Binary Search

// Using binary search to find starting point. In worst case, the start - 1 is the target, every time we almost find O(lgn) time. So it's slower than previous solution in worst case scenario. In best case scenario, the starting point is always in the middle of [0, start], and it is faster than previous solution's O(2n).

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer start = null;
        Integer end = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                if (start == null) {
                    start = i - 1;
                    end = i;
                } else {
                    end = i;
                }
                if (start > 0 && nums[end] < nums[start - 1]) {
                    start = binarySearch(nums, -1, start, nums[end]);
                }                
            }
        }
        return start == null ? 0 : end - start + 1; 
    }
    private int binarySearch(int[] nums, int l, int r, int val) {
        while (l + 1 < r) {
            int m = (l + r) >> 1;
            if (nums[m] <= val) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }
}

// Using 2 pointers

// Iterate the nums array, find the first occurance that the nums[i] < max, then mark the starting index = i - 1 and end index = i. If nums[i] < max happens again, extend the end index. If nums[start -1] > nums[end], we need to decrease the starting index to find the real starting point. The starting point decreases at most n times. O(2n) is O(n).

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer start = null;
        Integer end = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                if (start == null) {
                    start = i - 1;
                    end = i;
                } else {
                    end = i;
                }
                while (start > 0 && nums[end] < nums[start - 1]) start--;
            }
        }
        return start == null ? 0 : end - start + 1; 
    }
}