// Link: https://leetcode.com/problems/rotate-image/

// Solution

// Brute Force : Time O(N*N) Space O(N*N)

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempMatrix = new int[n][n];
        
        int row = 0, col = n-1;
        
        //take first row of original matrix and put it in last col of temp matrix;
        //row++; col--;
        //keep doing above 2 steps till row<n || col>=0
        while(row<n || col>=0) {
            for(int i=0; i<n; i++) {
                tempMatrix[i][col] = matrix[row][i];
            }
            
            row++;
            col--;
        }
        
        //copy contents of temp matrix into original matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
}

// Optimized

// Time: O(N*N), Space: O(1)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //transpose of matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reverse each row
        for(int[] row: matrix) {
            int start = 0, end = n-1;
            while(start<end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                
                start++;
                end--;
            }
        }
    }
}