// Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

// Solution

// HashSet for unique substrings

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet();
        
        int st=0;
        //check unique substrings of length k == pow(2,k)
        //i.e. no. of values with k size binary representation
        while(st+k<=s.length()) {
            String num = s.substring(st, st+k);
            set.add(num);
            st++;
        }
        
        return set.size() == 1<<k;
    }
}