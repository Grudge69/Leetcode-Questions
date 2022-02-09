class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(stk.isEmpty() || stk.peek()!='('){
                    return false;
                }
                stk.pop();
            }else if(ch=='}'){
                if(stk.isEmpty() || stk.peek()!='{'){
                    return false;
                }
                stk.pop();
            }else if(ch==']'){
                if(stk.isEmpty() || stk.peek()!='['){
                    return false;
                }
                stk.pop();
            }else{
                // encountering opening brackets
                stk.push(ch);
            }
        }
        
        if(stk.size()!=0) return false;
        
        return true;
    }
}