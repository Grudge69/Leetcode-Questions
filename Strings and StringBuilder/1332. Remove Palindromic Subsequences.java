// Link: https://leetcode.com/problems/remove-palindromic-subsequences/

// Solution

// Reverse and check equal to original string

class Solution {
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);  
        return sb.reverse().toString().equals(s)? 1: 2;
    }
}