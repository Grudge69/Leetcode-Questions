                            //QUESTION DESCRIPTION

// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 

// Example 1:

// Input: columnNumber = 1
// Output: "A"
// Example 2:

// Input: columnNumber = 28
// Output: "AB"
// Example 3:

// Input: columnNumber = 701
// Output: "ZY"
 

// Constraints:

// 1 <= columnNumber <= 231 - 1


                           //SOLUTION 

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();
        
        while(columnNumber-- > 0){
            
            // columnNumber = 29
            // iteration 1 => columnNumber = 29 - 1 = 28, columnTitle = C (28%26=2, A+2 = C)
            //.               columnNumber = 28/26 = 1
            // iteration 2 => columnNumber = 1 - 1 = 0, columnTitle = AC (0%26=0, A+0 = A)
            columnTitle.insert(0, (char)((columnNumber%26) + 'A'));//add new char at beginning of prev result
            
            //reduce character by 26
            columnNumber/=26;
        }
        
        return columnTitle.toString();
    }
}