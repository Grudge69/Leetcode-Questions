// Link: https://leetcode.com/problems/valid-perfect-square/

// Solution : using binary search from 1 to N

class Solution {
    public boolean isPerfectSquare(int x) {
        if(x==1) return true;
        long start = 1, end = x;
        
        while(start<=end){
            long mid = start + (end - start)/2;
            if(mid*mid==x) return true;
            else if(mid*mid>x){
                //mid is greater than answer
                //so check for values less than this mid
                end = mid - 1;
            }else{
                //this mid can be the ans as mid*mid <= x
                //so check for values bigger than this mid
                start = mid + 1;
            }
        }
        
        return false;
    }
}