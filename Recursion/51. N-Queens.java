// Link: https://leetcode.com/problems/n-queens/

//SOLUTION
// 1(My Solution)
class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        int count = queens(board, 0);
        return ans;
    }

    private int queens(boolean[][] board, int row) {
        if (row == board.length) {
            addInArrayList(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                // backtracking
                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isQueenSafe(boolean[][] board, int row, int col) {
        // vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;

    }

    private void addInArrayList(boolean[][] board) {
        List<String> rowList = new ArrayList<>();
        for (boolean[] row : board) {
            String rowVal = "";
            for (boolean element : row) {
                if (element) {
                    rowVal += 'Q';
                } else {
                    rowVal += '.';
                }
            }
            rowList.add(rowVal);
        }
        ans.add(rowList);
    }

}

// 2(Referred from discuss section)
class Solution {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] grid = new int[n][n];
        check(grid, 0);// zero indexed
        return list;
    }

    public boolean check(int[][] grid, int row) {
        if (row == grid.length) {// we reached last row,append into list
            List lis = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    // System.out.print(grid[i][j]+" ");
                    sb.append((grid[i][j] == 1) ? "Q" : ".");
                }
                lis.add(sb.toString());
                // System.out.println();
            }
            list.add(lis);
            return true;
        }
        for (int j = 0; j < grid.length; j++) {
            if (safe(grid, row, j)) {// safe so insert queen
                // System.out.println(row+" "+j);
                grid[row][j] = 1;
                check(grid, row + 1);// go to next row
                grid[row][j] = 0;// we are making it to zero because we need to get to past situation,we need
                                 // every possible answer
            }
        }
        return false;
    }

    public boolean safe(int[][] grid, int row, int col) {
        // checks columns and cross matched or not
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    if (j == col || (Math.abs(i - row) == Math.abs(j - col))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}