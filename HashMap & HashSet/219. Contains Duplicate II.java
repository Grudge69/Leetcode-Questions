//QUESTION DESCRIPTION

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

//SOLUTION(using SET)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                // when pointer travels beyond k distance start removing elements from set that
                // lie k dist behind i
                // this is because we have to maintain absolute k distance
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {
                // set.add() adds a particular element only if it doesn't already exist in it
                // we check if set is not allowing to add nums[i], this means it is duplicate
                return true;
            }
        }

        return false;
    }
}

// using HASHMAP
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> valIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if the element already exists in HashMap and absolute distance between that
            // element's index and index(latest before current element) stored in map <= K,
            // this means duplicate exists within K distance of current element
            if (valIdxMap.containsKey(nums[i]) && Math.abs((i - valIdxMap.get(nums[i]))) <= k) {
                return true;
            }

            // store index(value) at current element(key)
            // this updates index to latest and ignores previous indices
            valIdxMap.put(nums[i], i);
        }
        return false;
    }
}