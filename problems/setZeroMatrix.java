package com.Data_Structures_byprayush.problems;

import java.util.Scanner;

public class setZeroMatrix {

    public static void setZero(int[][] arr, int m, int n){
        //m -> row and n -> col
        int col0=1;
        //traverse and mark the matrix in the 0th row and col if a zero exist in the row or col
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n ;j++){
                if(arr[i][j] == 0){
                    //mark ith row == 0
                    arr[i][0] = 0;
                    //for col we need to check if its not the first col
                    if(j!=0){
                        //mark jth col if its not the first one
                        arr[0][j] = 0;
                    }
                    else{
                        //mark the first col as 0
                        col0 = 0;
                    }
                }
            }
        }
        //fill the elements == 1 from (1,1)->(m-1,n-1)
        for(int i = 1; i < m;i++){
            for(int j = 1; j < n;j++) {
                if (arr[i][j] != 0) {
                    if (arr[0][j] == 0 || arr[i][0] == 0){
                        arr[i][j] = 0;//if the element is non zero but its 0th col or 0th row is 0 => zero.
                    }
                }
            }
        }

        //check if the 0th row contains a zero
        if(arr[0][0]==0){
            for(int j = 0; j < n;j++){
                arr[0][j] = 0;//mark the whole zeroth row => zero
            }
        }

        //check if the 0th col contains a zero
        if(col0 == 0){
            for(int i = 0 ;i < m;i++){
                arr[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m;j++){
                arr[i][j] = scan.nextInt();
            }
        }
        setZero(arr, n, m);
        for(int i = 0 ;i < n;i++){
            for(int j = 0 ; j < m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
