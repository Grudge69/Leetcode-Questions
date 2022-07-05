// Link: https://leetcode.com/problems/longest-consecutive-sequence/

// Solution

// TC: O(N), SC: O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        //add all values in hashmap and consider each and every one as start points
        HashMap<Integer, Boolean> stPoints = new HashMap<>();
        for(int num: nums) {
            stPoints.put(num, true);
        }
        
        //whichever value's previous num exists in hashmap that is not the start point
        for(int num: nums) {
            if(stPoints.containsKey(num - 1)) {
                stPoints.put(num, false);
            }
        }
        
        //do work for starting points only
        int maxLength = 0;
        for(int num: nums) {
            if(stPoints.get(num) == true) {
                int length = 1;
                int startPt = num;
                while(stPoints.containsKey(startPt + length)) {
                    length++;
                }
                
                maxLength = Math.max(maxLength, length);
            }
        }
        
        return maxLength;
    }
}

// TC: O(NlogN), SC: O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        int n = nums.length;
        
        // Corner cases
        if(n==0 || n==1) return n;
        
        // All elements are added & maintained in priority queue in ascending order
        for(i=0;i<n;i++){
            pq.offer(nums[i]);
        }
        
        // Intialize the answer to 0
        int maxLength = 0;
        int num1 = pq.poll();
        
        // Intialize the current length of sequence to 1 since num1 already polled/considered above
        int len = 1;
        
        // Until queue is empty, keep checking difference between adjacent elements
        while(pq.isEmpty() == false){
            int num2 = pq.poll();
            int diff = num2 - num1;
            
            // If difference is more than 1, then update maxLength and reset len to 1
            if(diff > 1){
                if(len > maxLength){
                    maxLength = len;
                }
                len = 1;
            }
            else if(diff == 0){
                // Do nothing if diff = 0 i.e. adjacent elements are same that's okay 
                // For instance, if nums = [1,2,3,4,4,5,6,7,8,9,10,11]
                // Then answer is 11(1 to 11 even though 4 is twice) 
                // & answer is not 8 (from 4 to 11)
            }
            else{
                // If diff = 1, then increment the length of current sequence
                len++;
            }
            
            // Update num1 for next iteration
            num1 = num2;
        }
        
        // Don't forget this condition, in case the whole pq elements are in sequence
        // then this condition must be written else maxLength will remain 0
        if(len > maxLength){
            maxLength = len;
        }
        
        return maxLength;
    }
}