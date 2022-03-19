//QUESTION DESCRIPTION

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

//SOLUTION USING HASHMAP

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIdxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // if target-curr val exists in map
            // then return the index for map element, curr element
            if (valIdxMap.containsKey(target - nums[i])) {
                return new int[] { valIdxMap.get(target - nums[i]), i };
            }

            valIdxMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}

//different hashmap solution
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // stores value->idx pair
        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            //getting target - nums[i] and checking if it is present in hashmap which means that a pair is present with sum = target
            Integer requiredNum = (Integer)(target - numbers[i]);
            if(indexMap.containsKey(requiredNum)){
                //getting idx of (target - curr no., our curr no. )
                int toReturn[] = {indexMap.get(requiredNum), i};
                //store these idx in arr and return it
                return toReturn;
            }
            //store val->idx pair in map
            indexMap.put(numbers[i], i);
        }
        //if no pair is found then return null
        return null;
    }
}


//2 pointer approach BEST

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int forwardCounter =1;
        while(forwardCounter < nums.length)
        {
            for(int i=0 ; (i + forwardCounter) < nums.length; i++)
            {
                if((nums[i] + nums[(i+forwardCounter)]) == target)
                    return new int[]{i,(i+forwardCounter)};
            }
            forwardCounter++;
        }
      return null;  
    }
}