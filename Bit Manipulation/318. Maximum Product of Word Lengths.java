// Link: https://leetcode.com/problems/maximum-product-of-word-lengths/

// Solution

// Bit Manipulation Approach 
// Time: O(N*N), Space: O(N)

class Solution {
    // Integer bits allow us to store till 32 bits and english letters are only 26, so it will accomodate it easily
    // a = 0th bit, b = 1st bit, c = 2nd bit, ....... z = 25th bit
    // For word abc : state = 1 1 1 0 0 0 0 0 .... till 32 bits
    // For word abd : state = 1 1 0 1 0 0 0 0 .... till 32 bits
    // For word def : state = 0 0 0 1 1 1 0 0 .... till 32 bits
    // state(abc) & state(abd) != 0 as they have bits in common => letters in common
    // state(abc) & state(def) == 0 as they have no bits in common => no letters in common
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] states = new int[n];
        
        for(int i=0; i<n; i++) {
            String word = words[i]; 
            states[i] = getState(words[i]);
        }
        
        int maxPr = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if((states[i]&states[j])==0) {
                    maxPr = Math.max(maxPr, words[i].length()*words[j].length());
                }
            }
        }
        
        return maxPr;
    }
    
    private int getState(String word) {
        int state = 0;
        
        for(int i=0; i<word.length(); i++) {
            //take 1 char
            char c = word.charAt(i);
            //left shift till that chars position
            int currCharPosition = 1<<(c-'a');
            //OR it with previous chars state
            state = state | currCharPosition;
        }
        
        return state;
    }
}

// HASHSET SOLUTION

// Idea is to reduce the k^2 to k by puting all the characters of each string into a set.

// Time Complexity - O(n.k) + O(n^2.k) ~ O(n^2.k)
// where -
// n.k = to put all characters of each string into the set
// n^2 = to iterate over all the strings and compare it with every other string.
// k = for each string s1, we need to iterate over all the k characters and check if the s2 string's set contains the character of s1 in O(1) time

// Space Complexity - O(n.k), to store all characters of each string into the set.

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        List<Set<Character>> lst = new ArrayList(n);
        int max = 0;

        for(String word : words) {	
            Set<Character> set = new HashSet();
            lst.add(set);
            for(int i=0; i<word.length(); i++) {
                set.add( word.charAt(i) );
            }
        }

        for(int i=0; i<n; i++) {
            Set<Character> setI = lst.get(i);
            for(int j=i+1; j<n; j++) {
                boolean hasCommon = false;
                Set<Character> setJ = lst.get(j);
                for(Character c : setI) {
                    if( setJ.contains(c) ) {
                        hasCommon = true;
                        break;
                    }
                }

                if( !hasCommon ) 
                    max = Math.max(max, words[i].length()*words[j].length());	
            }
        }
        return max;
    }
}