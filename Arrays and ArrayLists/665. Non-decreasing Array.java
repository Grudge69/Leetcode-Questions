// Link: https://leetcode.com/problems/non-decreasing-array/

// Solution: Iterate over array and find anomalies

// TIME: O(N), SPACE: O(1)
class Solution {
    public boolean checkPossibility(int[] nums) {
        int pos = -1;
        for(int i=0; i<nums.length-1; i++) {
            //finding anomaly i.e. curr>next
            if(nums[i]>nums[i+1]) {
                //if pos!=-1, this means pos changed because there was an anomaly before and now we have 2 anomalies which will violate the condition of changing just 1 value to make non-decreasing array
                if(pos != -1) {
                    return false;
                }
                pos = i;
            }
        }
        
        //if pos is unchanged => array is already increasing order and no anomaly found
        //if pos = 0 or pos = len-2 => we need to change only 1 value
        //we can change the pos value to make entire array non-decreasing only if nums[pos-1]<=nums[pos+1] || nums[pos]<=nums[pos+2]
        return pos == -1 || pos == 0 || pos == nums.length-2 || nums[pos-1]<=nums[pos+1] || nums[pos]<=nums[pos+2];
    }
}

// 2nd Method: Trying to make changes in array and checking anomalies

class Solution {
	public boolean checkPossibility(int[] arr) {
        //find idx where anomaly happens
		int index = findAnomaly(arr);
        //no anomaly found, array is already in increasing order
		if (index == -1) {
			return true;
		}
        //store curr idx value 
        //change curr value to value on next
		int temp = arr[index];
		arr[index] = arr[index + 1];
        //check for anomaly in updated array, if no anomaly found return true
		if (findAnomaly(arr) == -1) {
			return true;
		}

        //now, replacing by next value didn't work
        //try replacing with curr value
		arr[index] = temp;
		arr[index + 1] = temp;
        //check if anomalies are fixed
		if (findAnomaly(arr) == -1) {
			return true;
		}
		return false;
	}

	public int findAnomaly(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}
}