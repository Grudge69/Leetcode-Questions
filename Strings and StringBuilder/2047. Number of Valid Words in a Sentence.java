         //QUESTION DESCRIPTION

// A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'), punctuation marks ('!', '.', and ','), and spaces (' ') only. Each sentence can be broken down into one or more tokens separated by one or more spaces ' '.

// A token is a valid word if all three of the following are true:

// It only contains lowercase letters, hyphens, and/or punctuation (no digits).
// There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters ("a-b" is valid, but "-ab" and "ab-" are not valid).
// There is at most one punctuation mark. If present, it must be at the end of the token ("ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
// Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".

// Given a string sentence, return the number of valid words in sentence.

 

// Example 1:

// Input: sentence = "cat and  dog"
// Output: 3
// Explanation: The valid words in the sentence are "cat", "and", and "dog".

// Example 2:

// Input: sentence = "!this  1-s b8d!"
// Output: 0
// Explanation: There are no valid words in the sentence.
// "!this" is invalid because it starts with a punctuation mark.
// "1-s" and "b8d" are invalid because they contain digits.

// Example 3:

// Input: sentence = "alice and  bob are playing stone-game10"
// Output: 5
// Explanation: The valid words in the sentence are "alice", "and", "bob", "are", and "playing".
// "stone-game10" is invalid because it contains digits.
 

// Constraints:

// 1 <= sentence.length <= 1000
// sentence only contains lowercase English letters, digits, ' ', '-', '!', '.', and ','.
// There will be at least 1 token.

            //SOLUTION

class Solution {
    
    public int countValidWords(String sentence) {
        //separating all the words and storing it in an array
        //something like, "this is a sentence" => {"this", "is", "a", "sentence"}
        String[] words = sentence.split(" ");
        
        //initially there are not valid words
        int validWords = 0;
        
        for(String word: words){
            //no word present
            if(word.equals("")) continue;
            
            //initially we assume the current word is valid and there is not hyphen condition violation
            boolean valid = true, hyphen = false;
            
            //traversing each character of word
            for(int i = 0; i < word.length();i++){
                char ch = word.charAt(i);
                
                //if ch is from a-z i.e. lowercase characters
                if(Character.isLowerCase(ch))
                    continue;
                //if ch is a digit then it is not valid character => valid=false
                if(ch >= '0' && ch <= '9'){
                    valid = false;
                    //no need to check for characters further
                    break;
                }
                //hyphen encountered
                if(ch == '-'){
                    //if hyphen is already true this means we encountered a hyphen before and count of hyphen should be less than 1
                    if(hyphen){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if hyphen is at beginning or end then it is not a valid character
                    if(i == 0 || i == word.length()-1){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if hyphen is not surrounded by lowercase character then also it is not a valid character
                    if(!(Character.isLowerCase(word.charAt(i-1)) && Character.isLowerCase(word.charAt(i+1)))){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if all of the above conditions is false it means first time hyphen is encountered and it is surrounded by lowercase characters
                    hyphen = true;
                }
                //punctuations encountered
                if(ch == '!' || ch == ',' || ch == '.'){
                    //if punctuations are not at the end of word it means word is invalid
                    if(i != word.length()-1){
                        valid = false;
                        break;
                    }
                }
            }
            //if all the above conditions are bypassed then it means the valid flag is unchanged meaning that our word is valid and has passed all the above checks
            if(valid){
                //count it as a valid word
                validWords++;
            }
            
        }
        
        return validWords;
    }
}