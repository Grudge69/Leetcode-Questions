// Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

// Solution

// Brute: Unoptimized -> 2 stacks

// TLE will come as we are doing too many operations
// Time O(N*K), Space O(N)

class Solution {
    public String removeDuplicates(String s, int k) {
        //to store resultant string
        Stack<Character> main = new Stack<>();
        //iterate over our string
        for(char c: s.toCharArray()){
            //temp stack which stores characters of same type
            Stack<Character> temp = new Stack<>();
            //push curr char in temp stack
            temp.push(c);
            
            //if top of main matches our temp stack top 
            //then remove from main and put it in temp
            while(!main.isEmpty() && main.peek()==c){
                temp.push(main.pop());
            }
            
            //if temp.size() matches then we have k adjacent and equal letters and they can be removed
            //otherwise, put back the characters from temp to main stack
            if(temp.size()!=k){
                while(!temp.isEmpty()){
                    main.push(temp.pop());
                }
            }
        }
        
        //convert the remaining characters in main stack to string using string builder
        StringBuilder sb= new StringBuilder();
        
        while(!main.isEmpty()){
            sb.append(main.pop());
        }
        
        //reverse the resulting string as stack is LIFO
        return sb.reverse().toString();
    }
}

// Better: Time Optimization: 1 stack only

// Time: O(N), Space: O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
        //in stack we store values like {char, count} and if the count matches k then we remove the value from stack
        Stack<int[]> main = new Stack<>();
        
        for(char c: s.toCharArray()){
            //main.peek()[0] -> character
            //main.peek()[1] -> count
            
            //if top char of stack matches our curr string char, then we increment the count
            if(!main.isEmpty() && main.peek()[0] == c){
                main.peek()[1]++;
            }
            //otherwise we just push the character with count = 1
            else{
                main.push(new int[]{c,1});
            }
            
            //if our count matches k then we pop it
            if(main.peek()[1]==k){
                main.pop();
            }
        }
        
        //convert resultant stack to string using stringbuilder
        StringBuilder sb= new StringBuilder();
        
        while(!main.isEmpty()){
            int[] top = main.pop();
            
            //append the char count no. of times
            while(top[1]-->0)
                sb.append((char) top[0]);
        }
        
        //reverse as stack is in LIFO
        return sb.reverse().toString();
    }
}

// Using Recursion: GIVING TLE
class Solution {
    public String removeDuplicates(String s, int k) {
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }
            
            if(count==k){
                String reduced = s.substring(0,i-k+1) + s.substring(i+1);
                return removeDuplicates(reduced,k);
            }
        }
        
        return s;
    }
}

// OPTIMIZED

// We need two stacks, one is to store arr characters, the other one is to store counts. Since stack peek index <= runner index, we can use string's char array as stack.

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] count = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            if (top == -1) {
                ++top;
                arr[top] = arr[i];
                count[top] = 1;
            } else {
                //if curr character matches stack top and stack top's count + 1(that of curr char)
                //matches k then we just need to remove k-1 chars in stack + 1(our curr char)
                if (top >= 0 && arr[top] == arr[i] && (count[top] + 1) == k) {
                    top -= k - 1;
                } 
                //otherwise push character in stack with incrementing top
                else {
                    top++;
                    //if stack top's char matches our current char then increment our count 
                    //otherwise put count=1 for new char encountered
                    count[top] = (arr[top - 1] == arr[i]) ? (count[top - 1] + 1) : 1;
                    arr[top] = arr[i];
                }
            }
        }
        //convert stack to string
        return new String(arr, 0, top + 1);
    }
}
