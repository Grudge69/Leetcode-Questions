        //QUESTION DESCRIPTIOJN

// Given a string s, find the length of the longest substring without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.


         //SOLUTION USING SET(SLIDING WINDOW TECHNIQUE)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a = 0;
        int b = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(b < s.length()) {
            //if character is allowed to add in set it means there is no duplicate
            if(set.add(s.charAt(b))) {
                b++;
                //add at end
                max = Math.max(max, set.size());
            } else {
                //if we are unable to add character this means there is a duplicate present
                //remove from beginning
                set.remove(s.charAt(a));
                a++;
            }
        }
        
        return max;
    }
}