class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // first part
        reverse(nums, 0, nums.length - k - 1);

        // second part
        reverse(nums, nums.length - k, nums.length - 1);

        // entire array
        reverse(nums, 0, nums.length - 1);

    }

    public void reverse(int[] arr, int i, int j) {
        int start = i, end = j;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}