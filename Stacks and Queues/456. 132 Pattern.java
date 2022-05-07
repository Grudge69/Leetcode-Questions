// Link:

// Solution

// BRUTE FORCE : Time O(N*N) Space O(1), GIVES TLE
class Solution {
    public boolean find132pattern(int[] nums) {
        int min = nums[0], n = nums.length;
        for(int j=1; j<n-1; j++) {
            for(int k=j+1; k<n; k++) {
                if(nums[k] > min && nums[k] < nums[j]) {
                    return true;
                }
                
                min = Math.min(min, nums[j]);
            }
        }
        
        return false;
    }
}

//BETTER: Using Stack
//Space: O(n) Time O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        
        min[0] = nums[0];
        
        //filling min arr with Minimum(prev min[i-1], curr nums[i])
        for(int i=1; i<n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int j=n-1; j>=0; j--) {
            //min[j] signifies ith element
            //only if jth element > ith element
            if(nums[j] > min[j]) {
                //st.peek() signifies kth element
                //remove all kth elements from stack which are less than or equal to ith element
                while(!st.isEmpty() && st.peek()<=min[j]) {
                    st.pop();
                }
                
                //if the stack is not empty and there is a kth element < jth element, we have found 132 sequence
                if(!st.isEmpty() && st.peek()<nums[j]) {
                    return true;
                }
                
                //if not 132 sequence has been found yet, try for other j keeping this nums[j] as kth element
                st.push(nums[j]); 
            }
        }
        //no such 132 sequence found
        return false;
    }
}

// Using Array Traversal

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums==null||nums.length<3) 
            return false;
        
        //prev min and max arr
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        
        min[0]=nums[0];
        max[0]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            //if curr >= prev max, set curr max = curr and curr min = prev min
            if(nums[i]>=max[i-1]){
                max[i]=nums[i];
                min[i]=min[i-1];
            }
            //else if curr <= prev min, set curr min = curr and curr max = prev max
            else if(nums[i]<=min[i-1]){
                min[i]=nums[i];
                max[i]=max[i-1];
            }
            
            else{
                int j=0;
                //find a j where nums[j] > nums[i] (nums[i] signifies kth element)
                for( j=i-1;j>=1;j--){
                    if(nums[j]>nums[i]) break;
                }
                
                //if such a jth element is found, also the prev min to that j(which is ith element) is found
                //you have found 132 pattern
                if(j>=1&&min[j-1]<nums[i]) return true;
                
                //set curr max = prev max and curr min = prev min
                max[i]=max[i-1];
                min[i]=min[i-1];
            }
        }
        //no such 132 pattern found
        return false;
    }
}

// Using the given array itself as stack (bottom on the right end)
class Solution {
    public boolean find132pattern(int[] nums) {
        int kThElement = Integer.MIN_VALUE;
        int top = nums.length;
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j]<kThElement) return true;
            
            else{
                while(top<nums.length && nums[j]>nums[top]) 
                    kThElement = nums[top++];
            }
            //push in stack
            nums[--top] = nums[j];
        }
        return false;
    }
}