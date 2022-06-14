// Link: https://leetcode.com/problems/delete-operation-for-two-strings/

// Solution Time O(M*N), Space O(M*N)

// Without Longest Common Subsequence

class Solution {
    public int minDistance(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                //for 1 string is empty and other is non empty then you have to delete all the characters of non empty string
                if(i==0 || j==0){
                    dp[i][j] = i+j;
                }
                //for same characters in both strings, you don't have to delete anything, just take the previous result
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                //for different characters in both strings, delete 1 character from minimun of both the scenarios
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //result at last of the dp 
        return dp[text1.length()][text2.length()];
    }
}

// With Longest Common Subsequence

class Solution {
    public int minDistance(String word1, String word2) {
        //get longest common subsequence
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int common = longestCommonSubsequence(word1, word2, dp);
        
        //subtract common subsequence length from both string and what's left is the no. of chars to be removed
        return (word1.length() - common) + (word2.length() - common);
    }
    
    //TABULATE
    private int longestCommonSubsequence(String s1, String s2, int[][] dp) {
        for(int idx1=s1.length()-1; idx1>=0; idx1--) {
            for(int idx2=s2.length()-1; idx2>=0; idx2--) {
                //0 length cannot have any subsequence
                if(idx1==s1.length() || idx2==s2.length()) {
                    dp[idx1][idx2] = 0;
                    continue;
                }

                //found 1 common character, so increment the common subsequence length by 1
                if(s1.charAt(idx1) == s2.charAt(idx2)) {
                    //also go to next character of both strings
                    dp[idx1][idx2] = 1 + dp[idx1+1][idx2+1];
                    continue;
                }

                //no common character
                //2 scenarios possible

                //skip s1's current char
                int skip1 = dp[idx1+1][idx2];
                //skip s2's current char
                int skip2 = dp[idx1][idx2+1];

                //maximum of both the scenarios is returned
                dp[idx1][idx2] = Math.max(skip1, skip2);
            }
        }
        
        return dp[0][0];
    }
}