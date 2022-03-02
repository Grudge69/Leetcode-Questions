// Link: https://leetcode.com/problems/is-subsequence/

// SOLUTION

class Solution {
    public boolean isSubsequence(String s, String t) {
        int smallItr = 0;
        
        for(int bigItr=0; bigItr<t.length() && smallItr<s.length(); bigItr++){
            if(s.charAt(smallItr) == t.charAt(bigItr)){
                smallItr++;
            }
        }
        
        return smallItr == s.length();
    }
}

//RECURSIVE CAUSES TIME LIMIT EXCEEDED

class Solution {
    public boolean isSubsequence(String s, String t) {
        return helper("", t, s);
    }
    
    private boolean helper(String p, String up, String check){
        if(up.isEmpty()){
            return p.equals(check);
        }
        
        char ch = up.charAt(0);
        
        //take ch
        boolean leftAns = helper(p+ch, up.substring(1), check);
        
        //don't take ch
        boolean rightAns = helper(p, up.substring(1), check);
        
        return leftAns || rightAns;
    }
}