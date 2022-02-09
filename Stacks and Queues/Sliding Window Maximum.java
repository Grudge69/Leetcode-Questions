class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int idx = 0;
        
        for(int i=0; i<nums.length; i++){
            //removeFirst -> when front element is excluded from current window
            if(q.size()>0 && q.getFirst()<=i-k){
                q.removeFirst();
            }
            
            //removeLast -> smaller than our element
            while(q.size()>0 && nums[q.getLast()]<nums[i]){
                q.removeLast();
            }
            
            //addLast -> we may be answer of our current window
            q.addLast(i);
            
            if(i>=k-1){
                //current window's maximum is at front of Deque
                res[idx++] = nums[q.getFirst()];
            }
        }
        
        return res;
    }
}