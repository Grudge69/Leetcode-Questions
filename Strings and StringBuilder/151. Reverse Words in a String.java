                //QUESTION DESCRIPTION

// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

// Constraints:

// 1 <= s.length <= 104
// s contains English letters (upper-case and lower-case), digits, and spaces ' '.
// There is at least one word in s.
 

// Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?


                         //SOLUTION(USING String and stringbuilder functions)

class Solution {
    public String reverseWords(String s) {
        // remove spaces from beginning and ending
        s=s.trim();
        // if no spaces in between this means there is 1 single word
        if(s.indexOf(" ")<0)
            return s;
        
        // get all the words and store in an array
        // (in case of multiple spaces between words some spaces might not get filtered and will be present in words[] array)
        String[] words=s.split(" ");
        
        //result StringBuilder
        StringBuilder ans = new StringBuilder();
        
        //traverse words array in opposite to reverse according to the question
        for(int i=words.length-1;i>=0;--i)
        {
            //remove any spaces which might not be filtered before
            words[i]=words[i].trim();
            //if any word is empty("") this means this was unfiltered space and has been removed by trim() method now
            if(words[i].equals(""))
                continue;
            
            //append in StringBuilder with a space
            ans.append(words[i]+" ");
        }
        
        //just remove last space that might be added in appending
        return ans.toString().trim();
        
    }
}