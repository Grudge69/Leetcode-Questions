                     //QUESTION DESCRIPTION

// Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

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

// Input: columnTitle = "A"
// Output: 1

// Example 2:

// Input: columnTitle = "AB"
// Output: 28

// Example 3:

// Input: columnTitle = "ZY"
// Output: 701
 

// Constraints:

// 1 <= columnTitle.length <= 7
// columnTitle consists only of uppercase English letters.
// columnTitle is in the range ["A", "FXSHRXW"].


                   //SOLUTION

class Solution {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0, size = columnTitle.length();
        for(int i = 0; i<size; i++){
            char c = columnTitle.charAt(i);
            // Visualize it like 123 = ((1*10 + 2) * 10) + 3
            // digit = 1, num = 0 * 10 + 1 = 1
            // digit = 2, num = 1 * 10 + 2 = 12
            // digit = 3, num = 12 * 10 + 3 = 123
            
            int digit = c - 'A' + 1;
            columnNumber = columnNumber * 26 + digit; 
        }
        
        return columnNumber;
    }
}