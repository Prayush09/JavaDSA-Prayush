package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.Easy;

public class print2DArray {
    public static void print2D(int[][] arr, int row, int col, int count){
        if(row == arr.length){
            System.out.print("No. of elements: "+count);
            return;
        }
        if(col == arr[0].length){
            print2D(arr,row+1,0,count);
            return;
        }
        System.out.println(arr[row][col]);
        count++;
        print2D(arr,row,col+1,count);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {2,4,5,6}
        };
        print2D(arr,0,0,0);
    }
}
