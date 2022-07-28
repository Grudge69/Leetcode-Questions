// Link: https://leetcode.com/problems/valid-anagram/

// Solution

// Using HashMap

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }
        
        for(char c: t.toCharArray()) {
            if(!sMap.containsKey(c)) {
                return false;
            }
            
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c)-1);
            }
        }
        
        for(char c: sMap.keySet()) {
            if(sMap.get(c) != 0) {
                return false;
            }
        }
        
        return true;
    }
}

// Using Freq Arr

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for(int i=0; i<26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}