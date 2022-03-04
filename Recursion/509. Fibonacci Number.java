// Link: https://leetcode.com/problems/fibonacci-number/

// SOLUTION

// Recursive

class Solution {
    public int fib(int n) {
        if(n==1 || n==0) return n;
        return fib(n-1) + fib(n-2);
    }
}

// Iterative 100% faster

class Solution {
    public int fib(int n) {
        int a=0, b=1, c=0;
        if(n==0 || n==1) return n;
        
        for(int i=0; i<n-1; i++){
            c = a+b;
            a = b;
            b = c;
        }
        
        return c;
    }
}