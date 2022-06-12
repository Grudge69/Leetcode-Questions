// Link:

// Solution

// Using HashSet

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(set.add(nums[second])) {
                //unique element
                sum += nums[second];
                second++;
            } else {
                //non unique
                set.remove(nums[first]);
                sum -= nums[first];
                first++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

// FASTER HashSet Approach

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] visited = new boolean[10001];
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(!visited[nums[second]]) {
                //unique element
                visited[nums[second]] = true;
                sum += nums[second];
                second++;
            } else {
                //non unique
                
                while(nums[first]!=nums[second]) {
                    visited[nums[first]] = false;//discard first value
                    sum -= nums[first];
                    first++;
                }
                
                first++;
                second++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

// Using Visited Array

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] visited = new boolean[10001];
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(!visited[nums[second]]) {
                //unique element
                visited[nums[second]] = true;
                sum += nums[second];
                second++;
            } else {
                //non unique
                visited[nums[first]] = false;//discard first value
                sum -= nums[first];
                first++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

// FASTER Visited Array Approach

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] visited = new boolean[10001];
        int first=0, second=0;
        int sum = 0, maxSum = 0;
        while(second<nums.length) {
            if(!visited[nums[second]]) {
                //unique element
                visited[nums[second]] = true;
                sum += nums[second];
                second++;
            } else {
                //non unique
                
                //discard values before duplicate value
                while(nums[first]!=nums[second]) {
                    visited[nums[first]] = false;//discard first value
                    sum -= nums[first];
                    first++;
                }
                first++;
                second++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}