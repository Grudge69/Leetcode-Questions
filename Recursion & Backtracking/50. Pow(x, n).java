class Solution {
    public double myPow(double x, int n) {
      
        //negative power inverts the number
        if(n<0){
          
            x=1/x;
        }
        //helper function to calculate answer
       return helper(x,n);
    
    }
    
    //Helper function
    public double helper(double x, int n){
        //base condition power = 0 returns 1
        if(n==0){
            return 1;
        }
        
        //taking smaller answer-> dividing problem in half( O(logN) )
       double ans = helper(x,n/2);
        
        //for odd powers multiply with x again
        return (n%2==0 ? ans*ans : x*ans*ans);
    } 
}