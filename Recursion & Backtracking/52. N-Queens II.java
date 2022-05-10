// Link: https://leetcode.com/problems/n-queens-ii/

// Solution

class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }

    public int queens(boolean[][] board, int row) {
        if (row == board.length) {
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

    public boolean isQueenSafe(boolean[][] board, int row, int col) {
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
}


//OPTIMISATION(HASHING)

class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1]; 
        int lowerDiagonal[] = new int[2*n-1]; 
        return solve(0, board, leftRow, lowerDiagonal, upperDiagonal);
    }
    
    private int solve(int col, char[][] board, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if(col == board.length) {
            return 1;
        }
        
        int count = 0;
        
        for(int row = 0; row < board.length; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length -1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1 + col - row] = 1;
                count+=solve(col+1, board, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
        
        return count;
    }
}