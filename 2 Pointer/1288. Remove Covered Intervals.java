        //QUESTION DESCRIPTION

// Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

// The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

// Return the number of remaining intervals.

 

// Example 1:

// Input: intervals = [[1,4],[3,6],[2,8]]
// Output: 2
// Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

// Example 2:

// Input: intervals = [[1,4],[2,3]]
// Output: 1
 

// Constraints:

// 1 <= intervals.length <= 1000
// intervals[i].length == 2
// 0 <= li <= ri <= 105
// All the given intervals are unique. 


          //SOLUTION

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int size = intervals.length;
        int countOfCovered = 0;
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                //if both i and j are are pointing to same interval skip it
                if(i==j) continue;
                
                if(intervals[i][0]>=intervals[j][0] && intervals[i][1]<=intervals[j][1]){
                    countOfCovered++;
                    break;//no need to check ahead
                }
            }
        }
        
        return size-countOfCovered;
    }
}