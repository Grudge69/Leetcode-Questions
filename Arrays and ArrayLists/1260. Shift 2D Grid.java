// Link: https://leetcode.com/problems/shift-2d-grid/

// Solution

// If the return ArrayList does not count space then its space complexity is O(1).
// The time complexity is O(n) where n is the count of all grid items.

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        // if shifting total(m*n) times, it shifts back to orignal state
        k = k % total;
        //stores our final result
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            //add an empty row to our 2d output list
            List<Integer> list = new ArrayList<>();
            result.add(list);
            for (int j = 0; j < n; j++) {  
                ////////////// 2D to 1D FLATTENNING /////////////////////
                // i * n + j original place index if we flatten our grid to 1D array
                // i*n is the no. of rows above our element
                // j is the no. of cols in our row
                // i*n + j is the total values shifted from 0,0 starting position which is also our idx in 1d arr
                // E.g. [1,3,4,5], 4 is shifted 2 times from starting 0 position which is also its idx in 1d arr
                int originalIdxFlatten1D = i * n + j;
                
                /////////////// 1D to 2D FOLDING //////////////////////
                // position of our element in 2D grid
                // i * n + j - k  is to get value k steps before                 
                int index = (originalIdxFlatten1D - k + total) % total;
                list.add(grid[index / n][index % n]);
            }
        }
        return result;
    }
}


// ALTERNATE SOLUTION

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rowCount = grid.length;                         // Number of rows in grid.
        int colCount = grid[0].length;                      // Number of columns in grid.
        int gridCount = rowCount * colCount;                // Number of cells (i.e. values) in grid.
        k = k % gridCount;                                  // Limit k to max number of cells in grid.                                                                Avoid negatives in next lines.
        int kCol = (gridCount - k) % colCount;              // Column to start copying from.
        int kRow = ((gridCount - k) % gridCount) / colCount;// Row to start copying from.
        int[] innRow = grid[kRow];                          // Array for the row to start copying from.
        int[][] result = new int[rowCount][colCount];       // Create result matrix, to hold shifted                                                                  values.
        for (int r = 0; r < rowCount; r++) {                // Loop through "to" rows.
            int[] outRow = result[r];                       // Get row array to copy into, so only                                                                    faster 1D reference in inner loop.
            for (int c = 0; c < colCount; c++) {            // Loop through "to" columns.
                outRow[c] = innRow[kCol];                   // Copy value from grid to result, shifting                                                                by copying.
                if (++kCol >= colCount) {                   // Next "from" column.  If at end of row...
                    kCol = 0;                               // Then start "from" columns at first                                                                      column.
                    if (++kRow >= rowCount)                 // When starting new column, next "from"                                                                  row.  If at end of grid...
                        kRow = 0;                           // Then start "from" rows at first row.
                    innRow = grid[kRow];                    // Get row array to copy from, so only                                                                    faster 1D reference when copying.
                }
            }
        }
        return (List)Arrays.asList(result);                 // Return result matrix, converting it to a                                                                List<List<Integer>>.
    }
}