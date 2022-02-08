class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;

        // ptr at first row and last column
        while (r < rows && c >= 0) {
            int currVal = matrix[r][c];
            // if target found then return true result or the row, col indices
            if (currVal == target) {
                return true;
                // return new int[]{r, c};
            }
            
            if (currVal < target) {
                // target lies on the right side
                // discard this col and all others on left of it
                r++;
            } else {
                // target lies on down side
                // discard this row and all others above it
                c--;
            }
        }
        return false;
        // return new int[]{-1, -1};
    }
}