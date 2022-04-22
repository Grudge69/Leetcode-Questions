// Link: https://leetcode.com/problems/continuous-subarray-sum/

// Solution: 

// Brute Force O(N*N) time, O(1) space

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = nums[nums.length-1];
        
        for (int i = nums.length-2 ; i>= 0 ; i--) {
            sum += nums[i];
            
            if (nums[i] == 0 && nums[i+1] == 0) 
                return true;
            
           if (sum >= k || sum == 0) {
               int internalSum = nums[i];
               
               for (int j = i+1 ; j < nums.length ; j++) {
                    internalSum += nums[j];
                   
                   if (internalSum%k == 0) {
                       return true;
                   }
               }
           }     
        }
        
        return false;
    }
}

//Using HASHMAP O(N) time, O(K) space => in map we are storing remainders and remainders range from 0,k

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // (remainder -> index) map
        // for k=0 and also if the first element is multiple of k then diff 0-(-1) is 1 and we don't take 1 element
        map.put(0, -1); 
        int remainder = 0;
        for(int i=0; i<nums.length; i++){
            remainder += nums[i];
            //divide by k only if k is not 0
            if(k!=0) remainder %= k;//get the remainder
            if(map.containsKey(remainder)){
                //if that remainder is already present meaning sum(0,i) = sum(0,j) 
                //therefore, sum(i, j) divisible by k
                if(i - map.get(remainder) > 1) return true; // more than 1 element
            }else{
                //remainder occurred for the first time, put it in map
                map.put(remainder, i);
            }
        }
        //no subarray with sum%k == 0 found
        return false;
    }
}

// Using HASHSET

 class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int last = 0; //previous subarr sum remainder
        for (int num : nums) {//iterate through entire array
            int cur = (last + num) % k;//current subarr sum remainder
            if (set.contains(cur)) return true;//if the rem already exists return true
            set.add(last); //add prev sub arr sum remainder
            last = cur; //change prev to curr for next iteration
        }
        //return false if nothing happens which means no such subarr found
        return false;
    }
}

