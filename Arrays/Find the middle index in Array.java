class Solution {
    public int findMiddleIndex(int[] nums) {
        int start = 0, end = nums.length - 1, totalSum = 0, startSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (startSum == totalSum - (startSum + nums[i])) {
                return i;
            }
            startSum += nums[i];
        }

        return -1;
    }
}