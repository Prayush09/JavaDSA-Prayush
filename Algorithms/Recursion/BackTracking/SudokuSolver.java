package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(solve(board,0,0)){
            display(board);
        }else{
            System.out.println("Not solvable!");
        }
    }

    private static void display(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int d = 0; d < board[0].length; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static boolean solve(int[][] board, int row, int col){
        if(row == board.length){
            return true;
        }

        if(col == board[0].length){
            return solve(board,row+1,0);
        }

        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        for(int i = 1 ; i <= 9; i++){
            if(isSafe(board,row,col,i)){
                board[row][col] = i;
                if(solve(board,row,col+1)){
                    return true;
                }else{
                    //backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num){
        //check row
        for(int i = 0 ; i < board.length;i++){
            if(board[row][i] == num){
                return false;//number already exists
            }
        }

        //check column
        for(int[] nums : board){
            if(nums[col] == num) //checking all the elements in col
                return false;
        }

        //check the matrix
        //find the length of the smaller matrix using sqrt
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart+sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;
    }

}
