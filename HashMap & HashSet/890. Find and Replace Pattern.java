// Link:

// Solution:

// Example 1
    // word: m e e, pattern: a b b 
    
    // patternToWord: 
    // a --> m
    // b --> e
    // b is already present and is mapped to e only there for you can go forward
    
    // wordToPattern: 
    // m --> a
    // e --> b
    // e is already present and is mapped to b only there for you can go forward
    

// Example 2
    // word: d e q, pattern: a b b 
    
    // patternToWord: 
    // a --> d 
    // b --> e
    // 'b' is already present and is mapped to 'e' which is not the same as 'q' => return false
    
    // wordToPattern: 
    // d --> a
    // e --> b
    // 'q' is to be mapped to 'b' but in patternToWord 'b' is already mapped to 'e' => return false;


// Using HashMap   

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word: words) {
            if(isMatching(word, pattern)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean isMatching(String word, String pattern) {
        HashMap<Character, Character> patternToWord = new HashMap<>();
        HashMap<Character, Character> wordToPattern = new HashMap<>();
        
        for(int i=0; i<word.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            
            if(!patternToWord.containsKey(patternChar)) {
                patternToWord.put(patternChar, wordChar);
            }
            
            if(!wordToPattern.containsKey(wordChar)) {
                wordToPattern.put(wordChar, patternChar);
            }
            
            if(patternToWord.get(patternChar) != wordChar || wordToPattern.get(wordChar) != patternChar) {
                return false;
            }
        }
        
        return true;
    }
}

// Using Character Freq Array

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word: words) {
            if(isMatching(word, pattern)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean isMatching(String word, String pattern) {
        char[] patternToWord = new char[26];
        char[] wordToPattern = new char[26];
        
        for(int i=0; i<word.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            
            if(patternToWord[patternChar - 'a'] == 0) {
                patternToWord[patternChar - 'a'] = wordChar;
            }
            
            if(wordToPattern[wordChar - 'a'] == 0) {
                wordToPattern[wordChar - 'a'] = patternChar;
            }
            
            if(patternToWord[patternChar - 'a'] != wordChar || wordToPattern[wordChar - 'a'] != patternChar) {
                return false;
            }
        }
        
        return true;
    }
}