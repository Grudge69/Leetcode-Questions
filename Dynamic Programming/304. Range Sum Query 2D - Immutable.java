// Link: https://leetcode.com/problems/range-sum-query-2d-immutable/

// Solution

// Brute Force

class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        this.matrix = new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++) {
            for(int j=col1; j<=col2; j++) {
                sum += this.matrix[i][j];
            }
        }
        
        return sum;
    }
}

 // USING PREFIX SUM ON COLUMNS AND ROWS

 class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        this.matrix = new int[rows][cols];
        
        //making the matrix such that the element NEW_matrix[i][j] contains sum from ORIG_matrix[0][0] to ORIG_matrix[i][j]
        
        //prefix sum -> column wise
        for(int i=0; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        //prefix sum -> row wise
        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        
        this.matrix = matrix;
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        //from ORIG_matrix[0][0] to ORIG_matrix[row2][col2]
        int total = this.matrix[r2][c2];
        
        int extra = (r1!=0? this.matrix[r1-1][c2]: 0) + (c1!=0? this.matrix[r2][c1-1]: 0) - (r1!=0 && c1!=0? this.matrix[r1-1][c1-1]: 0);
        
        return total - extra;
    }
}