        // QUESTION WITH DESCRIPTION

// You are given an array target and an integer n.

// In each iteration, you will read a number from list = [1, 2, 3, ..., n].

// Build the target array using the following operations:

// "Push": Reads a new element from the beginning list, and pushes it in the array.
// "Pop": Deletes the last element of the array.
// If the target array is already built, stop reading more elements.
// Return a list of the operations needed to build target. The test cases are generated so that the answer is unique.


// Example 1:

// Input: target = [1,3], n = 3
// Output: ["Push","Push","Pop","Push"]
// Explanation: 
// Read number 1 and automatically push in the array -> [1]
// Read number 2 and automatically push in the array then Pop it -> [1]
// Read number 3 and automatically push in the array -> [1,3]


// Example 2:

// Input: target = [1,2,3], n = 3
// Output: ["Push","Push","Push"]


// Example 3:

// Input: target = [1,2], n = 4
// Output: ["Push","Push"]
// Explanation: You only need to read the first 2 numbers and stop.
 

// Constraints:

// 1 <= target.length <= 100
// 1 <= n <= 100
// 1 <= target[i] <= n
// target is strictly increasing.

        // SOLUTION USING ARRAYLIST(NOT STACK, BUT IMPLEMENTED STACK IN A WAY)

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>(); //stores ans i.e. operations performed
        
        // index to keep track of no. of elements in target arr
        int targetIdx=0;
        
        // taking list elements from 1-n, stop when either list is finished or all target[] elements are compared
        for(int listCounter=1; listCounter<=n && targetIdx<target.length; listCounter++){
            //on encountering new element PUSH it
            ans.add("Push");
            
            //if the element from list[] doesn't match target[] element, POP it
            if(listCounter!=target[targetIdx]){
                ans.add("Pop");
            }else{
                //if the element from list[] matches target[] element, check next element in target[]
                targetIdx++;
            }
        }
        
        return ans;
    }
}