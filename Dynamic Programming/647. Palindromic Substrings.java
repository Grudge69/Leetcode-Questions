// Link: https://leetcode.com/problems/palindromic-substrings/

// Solution: Brute Force + 2d - DP

// Brute Force: Time O(N^3), Space O(1)
class Solution {
    public int countSubstrings(String s) {
        int count=0;
        
        for(int i=0; i<s.length(); i++) {
           for(int j=i+1; j<=s.length(); j++) {
               String ss = s.substring(i,j);
               
               if(isPalindrome(ss)) count++;
           }
        }
        
        return count;
    }
    
    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        
        while(i<j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            
            if(ch1!=ch2) return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}

// 2d-DP
// Time O(N^2), Space O(N^2)
class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        
        for(int gap=0; gap<s.length(); gap++) {
            for(int i=0, j=gap; j<dp[0].length; i++, j++) {
                if(gap == 0) {
                    //startIdx == endIdx
                    //1 length is always palindrome
                    dp[i][j] = true;
                } else if(gap == 1) {
                    //startIdx+1 == endIdx
                    //2 length str is palindrome ONLY if both chars are same
                    if(s.charAt(i)==s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    //endIdx-startIdx>1
                    //3 or more length str is palindrome ONLY if startChar = endChar AND (start+1 to end-1) substring is palindrome
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                
                //if current substring from (i to j) is palindrome then count it
                if(dp[i][j] == true) count++;
            }
        }
        
        return count;
    }
}