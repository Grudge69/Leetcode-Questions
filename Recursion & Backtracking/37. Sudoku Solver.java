// Link: https://leetcode.com/problems/sudoku-solver/

//SOLUTION : Recursion + BackTracking

class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board)) return;
    }
    
    boolean solve(char[][] board){
        int n = board.length;
        int row = -1, col = -1;
        
        boolean emptyLeft = true;
        
        
        // this is how we are replacing the r,c from arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some empty element in row, then break
            if (emptyLeft == false) {
                break;
            }
        }
        
        if(emptyLeft == true){
            //in previous loops no empty boxes were found which means the entire sudoku is filled and solved
            return true;//stop solving further
        }
        
        //check if we can put our num in the box or not
        for(int num=1; num<=9; num++){
            char number = (char)(num+'0');
            if(isSafe(board, row, col, num)){
                //it is safe to put our num, so put it
                board[row][col] = number;
                if(solve(board)){
                    //found the answer
                    return true;
                }else{
                    //backtrack
                    board[row][col] = '.';
                }   
            }
        }
        
        return false;
    }
    
    boolean isSafe(char[][] board, int row, int col, int num){
        char number = (char)(num+'0');
        //check the row
        for(int i=0; i<board.length; i++){
            //check if the num is in the row
            if(board[row][i]==number) return false;
        }
        
        //check the col
        for(char[] nums: board){
            //check if the num is in the col
            if(nums[col]==number) return false;
        }
        
        //check the 3X3 box 
        int sqrt = (int)(Math.sqrt(board.length));
        
        //find starting r,c of the box of which our current row,col is a part of
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        
        for(int r=rowStart; r<rowStart+sqrt; r++){
            for(int c=colStart; c<colStart+sqrt; c++){
                if(board[r][c]==number) return false;
            }
        }
        
        return true;
        
    }
}