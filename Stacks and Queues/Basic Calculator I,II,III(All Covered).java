class Solution {
    private int performOp(int a, char op, int b){
        int output = 0;
        if(op=='*') output = a*b;
        
        else if(op=='/') output = a/b;
        
        else if(op=='+') output = a+b;
        
        else if(op=='-') output = a-b;
        
        return output;
        
    }
    
    private int precedence(char op){
        if(op=='+' || op=='-') return 1;
        else if(op=='*' || op=='/') return 2;
        else return 0;
    }
    
    private String refine(String s){
        StringBuilder str = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch==' ') continue; // ignore spaces
            
            if(ch=='+'){
                
                if(str.length()==0 || str.charAt(str.length()-1)=='('){
                    //unary +
                    str.append("0+");
                }else if(str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-'){
                    // ++ = + and -+ = -
                    continue;
                }else{
                    //normal + operator
                    str.append('+');
                }
            }else if(ch=='-'){
                if(str.length()==0 || str.charAt(str.length()-1)=='('){
                    //unary -
                    str.append("0-");
                }else if(str.charAt(str.length()-1)=='+'){
                    //+- = -
                    str.setCharAt(str.length()-1,'-');
                }else if(str.charAt(str.length()-1)=='-'){
                    // -- = +
                    str.setCharAt(str.length()-1,'+');
                }else{
                    //normal + operator
                    str.append('-');
                }
            }else{
                //operand encountered
                str.append(ch);
            }
        }
        
        return str.toString();
    }
    
    public int calculate(String s) {
        
        // refine it a little bit to handle unary operators -5,-2, +5,
        // handle double operators 5+-2
        // handle spaces
        s = refine(s);
        
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch>='0' && ch<='9'){
                //operand encountered
                //HANDLING multiple digit numbers
                int num = 0;
                while(i < s.length() && s.charAt(i)>='0' &&  s.charAt(i)<='9'){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                
                // operand -> push in operand wali stack
                operand.push(num);
                //when traversing string the pointer goes i forward so bring it back
                i--;
            }else if(ch=='('){
                operator.push(ch);
            }else if(ch==')'){
                while(operator.peek() != '('){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(performOp(a, op, b));
                }

                operator.pop(); // pop opening braces as well
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // operator -> + or - or * or /
                while(operator.size() > 0 && operator.peek() != '(' 
                    && precedence(operator.peek()) >= precedence(ch)){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(performOp(a, op, b));
                }

                operator.push(ch);
            }
        }
        
        while(operator.size() > 0){
            int b = operand.pop();
            int a = operand.pop();
            char op = operator.pop();
            operand.push(performOp(a, op, b));
        }

        return operand.peek();
    }
}