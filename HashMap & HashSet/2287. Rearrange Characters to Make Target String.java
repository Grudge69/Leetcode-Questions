// Link: https://leetcode.com/problems/rearrange-characters-to-make-target-string/

// Solution

// Hashmap

class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> Smap = new HashMap();
        HashMap<Character, Integer> Tmap = new HashMap();
        
        for(char c: s.toCharArray()) {
            if(!Smap.containsKey(c)) {
                Smap.put(c, 1);
            } else {
                Smap.put(c, Smap.get(c)+1);
            }
        }
        
        for(char c: target.toCharArray()) {
            if(!Tmap.containsKey(c)) {
                Tmap.put(c, 1);
            } else {
                Tmap.put(c, Tmap.get(c)+1);
            }
        }
        
        
        int ans = Integer.MAX_VALUE;
        for(char c: target.toCharArray()) {
            if(!Smap.containsKey(c))
                ans = 0;
            else
                ans = Math.min(ans, Smap.get(c)/Tmap.get(c));
        }
        
        return ans==Integer.MAX_VALUE? 0: ans;
    }
}

// Frequency Array

class Solution
{
    public int rearrangeCharacters(String s, String target)
    {
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        for(char ch : target.toCharArray())
            freq2[ch-'a']++;

        int min = Integer.MAX_VALUE;
        for(char ch : target.toCharArray())
            min = Math.min(min,freq[ch-'a']/freq2[ch-'a']);
        
        return min;
    }
}