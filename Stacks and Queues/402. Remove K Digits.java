                //QUESTION DESCRIPTION

// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

//  Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

// Example 3:

// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

// Constraints:

// 1 <= k <= num.length <= 105
// num consists of only digits.
// num does not have any leading zeros except for the zero itself.              
                
                //SOLUTING USING STACK

class Solution {
    public String removeKdigits(String num, int k) {
        //Stack
        Stack<Character> stk = new Stack<>();
        
        //push characters of num,
        // the below popping should happen only k times
        //pop if(stk.top > curr char to be pushed), CHECK THIS FIRST
        for(char ch: num.toCharArray()){
            while(!stk.isEmpty() && k>0 && stk.peek()>ch){
                stk.pop();
                k--;
            }
            
            stk.push(ch);
        }
        
        //for string of length 1 and k=1, e.g. "9", 1
        //9 is pushed in stack first, but is not popped as for loop ends
        //so we need to pop remaining characters if k has some value left
        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }
        
        //form a string with remaining char in stack
        StringBuilder remNum = new StringBuilder();
        while(stk.size()>0){
            remNum.append(stk.pop());
        }
        
        //have to reverse this string because it was pushed in reverse in stack
        remNum.reverse();
        
        //remove 0s at the beginning
        while(remNum.length()>1 && remNum.charAt(0)=='0'){
            remNum.deleteCharAt(0);
        }
        
        //if there is no number left return "0";
        return remNum.length()>0 ? remNum.toString() : "0";
    }
}