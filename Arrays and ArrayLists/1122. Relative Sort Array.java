                // QUESTION DESCRIPTION

// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 

// Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

// Example 1:

// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]


// Example 2:

// Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
// Output: [22,28,8,6,17,44]




                 // SOLUTION USING FREQ ARRAY


class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //range of 0<=arr1[i]<=1000 => all elements of arr1 exists int indices of freq array
        int[] freqOfArr1 = new int[1001];
        int start = 0;
        
        //add frequencies of all elements in arr1
        for(int val: arr1){
            freqOfArr1[val]++;
        }
        
        //take individual arr elements from arr2
        for(int val: arr2){
            //check freq of those elements and push that number of times in arr1
            while(freqOfArr1[val]-- > 0){
                arr1[start++] = val;
            }
        }
        
        //add remaining elements to arr1 according to their frequencies
        for(int i=0; i<freqOfArr1.length; i++){
            while(freqOfArr1[i]-- > 0){
                arr1[start++] = i;
            }
        }
        
        return arr1;
    }
}
