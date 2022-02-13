class Solution {
    public boolean isPowerOfTwo(int n) {
        int c=0;
        
        //take 2^3=8 as binary representation => 1 0 0 has only 1 set bit(1) 
        //any binary representation of power of two has only 1 set bit
        while(n>0){
            //count number of set bits
            if((n&1)==1) c++;

            //reduce number by removing last binary bit
            n=(n>>1); 
        }
          
        if(c==1) return true;
        return false;
    }
    
}