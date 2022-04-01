// Link: https://leetcode.com/problems/reverse-string/

// Solution: 2 ptr technique

class Solution {
    public void reverseString(char[] s) {
        //2 ptr from beginning and end, just swap values at those 2 ptrs
        int i=0, j=s.length-1;
        
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            i++;
            j--;
        }
        
    }
}