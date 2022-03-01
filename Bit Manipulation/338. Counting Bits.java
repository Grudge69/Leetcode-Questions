//Link: https://leetcode.com/problems/counting-bits/

//SOLUTION

//USING n & (n-1), faster

class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n+1];
        //DP Used in a way that
        //for i=5, i&(i-1)= 5&4 = 4(100 binary representation), answer for i=4 is already present in our array so we just add 1 to it
        for(int i=1;i<=n;i++)
            count[i] = 1 + count[i&(i-1)];
        return count;
    }
}

//USING >> operation

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; i++){
            int num = i;
            int count = 0;
            while(num>0){
                if((num&1)!=0){
                    count++;
                }
                num=(num>>1);
            }
            ans[i] = count;
        }
        
        return ans;
    }
}