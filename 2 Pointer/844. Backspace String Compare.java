// Link: https://leetcode.com/problems/backspace-string-compare/

// Solution

// Using Stack

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stkS = new Stack<>();
        Stack<Character> stkT = new Stack<>();
        
        //store characters of s in stack with popping characters on encountering #(backspace)
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if((i==0 && ch=='#') || (ch=='#' && stkS.isEmpty())) continue;
            if(ch=='#' && !stkS.isEmpty()){
                stkS.pop();
            }else{
                stkS.push(ch);
            }
        }
        
        //store characters of t in stack with popping characters on encountering #(backspace)
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if((i==0 && ch=='#') || (ch=='#' && stkT.isEmpty())) continue;
            if(ch=='#' && !stkT.isEmpty()){
                stkT.pop();
            }else{
                stkT.push(ch);
            }
        }
        
        //pop from both stacks and compare if the string is still the same after processing #(backspaces)
        while(!stkT.isEmpty() && !stkS.isEmpty()){
            if(stkS.peek()!=stkT.peek()) return false;
            
            stkT.pop();
            stkS.pop();
        }
        
        //if(after processing 1 string is empty and other is not) => both are not equal
        if((!stkS.isEmpty() && stkT.isEmpty()) || (stkS.isEmpty() && !stkT.isEmpty()))
            return false;
        
        return true;
    }
}

// 2 Pointer

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
        
        while (sPointer >= 0 || tPointer >= 0) {
            sPointer = getNextCharacterPosition(s, sPointer); // can be negative, empty string;
            tPointer = getNextCharacterPosition(t, tPointer); // can be negative, empty string;
            
            if ((sPointer < 0 && tPointer >= 0) ||
                (tPointer < 0 && sPointer >= 0) ||
                (sPointer >= 0 && tPointer >= 0) && (s.charAt(sPointer) != t.charAt(tPointer))
               ) {
                return false;
            }
            
            sPointer--;
            tPointer--;
        }
        
        return true;
    }
    // "ab##"
    //  "c#d#"

    public int getNextCharacterPosition(String s, int start) {
        if (start < 0) {
            return start;
        }
        
        char c = s.charAt(start);
        int count = c == '#' ? 2 : 0;
        
        while (count > 0) {
            start--;
            
            if (start < 0) {
                start -= count;
                break;
            }
            
            c = s.charAt(start);
            
            if (c == '#') {
                count++;
            } else {
                count--;
            }
        }
               
        return start;
    }
}