// Link:

// Solution

// Using Priority Queue

// Time O((n+k)logn), Space O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
        
        int ans=0;
        for(int i=0; i<k; i++) {
            ans = pq.remove();
        }
        
        return ans;
    }
}

// Optimisation => Time O(nlogk), Space O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        
        for(int i=k; i<nums.length; i++) {
            if(nums[i]>pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
}