class Solution {
    public int countOperations(int a, int b) {
        // We can observe that if n1 is m times greater than n2, we will perform the subtraction m times, 
        // and after that n1 would be equal n1 % n2.

        // This is, pretty much, the Euclidean Algorithm. The complexity of this algorithm is O(log(min(a, b)).
        
        return a * b == 0 ? 0 : a > b ? countOperations(b, a) : b / a + countOperations(a, b % a);
    }
}