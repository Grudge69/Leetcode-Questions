// LINK: https://leetcode.com/problems/add-strings/

// SOLUTION: traverse both strings from backwards and add with carry

class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1, j=num2.length()-1, carry = 0;
        StringBuilder str = new StringBuilder();
        
        while(i>=0 || j>=0 || carry>0){
            int d1 = (i>=0) ? num1.charAt(i) - '0': 0;
            int d2 = (j>=0) ? num2.charAt(j) - '0': 0;
            
            int val = (d1+d2+carry)%10;
            char ch = (char)(val + '0');
            carry = (d1+d2+carry)/10;
            
            str.append(ch);
            
            if(i>=0) i--;
            if(j>=0) j--;
        }
        
        return str.reverse().toString();
        
        
    }
}