// Link: https://leetcode.com/problems/divide-two-integers/

// Solution

class Solution {
    public int divide(int dividend, int divisor) {
        //for divide by 0, and -infinite/-1, return infinity
        if(divisor==0 || dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
           
        //contains result
        int res = 0;
        //if both sign same then +ve else -ve
        int sign = (dividend<0)^(divisor<0)? -1: 1;
        
        //get the absolute values for dividend and divisor
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        
        //do this till divisor <= divident
        while(dvs<=dvd){
            
            long temp=dvs;
            long mul=1;
            
            while(dvd>=temp<<1){
                temp<<=1;
                mul<<=1;
            }
            
            dvd-=temp;
            res+=mul;
        }
        
        return sign==1?res:-res;
    }
}

// Alternate Approach

class Solution {
    //Algorithm
//1. while we can subtract divisor from dividend
//if yes, then we double the divisor
//increment the count
//check again
//2. Add the count into result
//3. Subtract the temporary variable from dividend

public int divide(int dividend, int divisor) {
//if the ans overflows
if(dividend == 1<<31 && divisor == -1)
return Integer.MAX_VALUE;

//check if the signs are the same => +ve, else -ve
boolean sign = (dividend>=0) == (divisor>=0) ? true : false;

//convert both values to positive
dividend = Math.abs(dividend);
divisor = Math.abs(divisor);

int result = 0;
//till we can subtract
while(dividend-divisor>=0) {
//how many no. of times we can subtract
int count=0;
//everytime we are doubling the divisor 
//i.e. we are doing divisor<<1 count no. of times
while(dividend - (divisor<<1<<count)>=0) {
count++;
}

//actual count is the no. of times we have doubled i.e. 1<<count
result += 1<<count;
//reduce dividend by that no. of times
dividend -= divisor<<count;
}

return sign==true? result: -result;
}
}