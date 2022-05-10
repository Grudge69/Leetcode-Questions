class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    
    private int helper(int num, int count){
        if(num==0) return count;
        
        if(num%2==0){
            //even number divide by 2
            return helper(num/2, count+1);
        }else{
            //odd number subtract 1
            return helper(num-1, count+1);
        }
    }
}