class Solution {
    public String removeOuterParentheses(String s) {
        String str="";
        int count=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(st.size()==0){
                    st.push('(');
                }
                else if(st.size()>=1){
                    st.push('(');
                    str+='(';
                }
            }
            else{
                if(st.size()==1){
                st.pop();
                }
                else if(st.size()>=1){
                    st.pop();
                    str+=')';
                }
            }
        }
        return str;
    }
}