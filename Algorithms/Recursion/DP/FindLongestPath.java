package com.Data_Structures_byprayush.Algorithms.Recursion.DP;

import java.util.*;

class FindLongestPath{

    private static int dfs(int[][] matrix, int i , int j, int[][] memo){
        if(memo[i][j]!= -1)
            return memo[i][j];
        int N = matrix.length;
        int M = matrix[0].length;

        int maxPath = 1;
        //going depth first
        if(i+1 < N && matrix[i+1][j]>matrix[i][j]){
            maxPath = Math.max(maxPath, 1 + dfs(matrix,i+1,j,memo));
        }

        if(j+1 < M && matrix[i][j+1] > matrix[i][j]){
            maxPath = Math.max(maxPath,1 + dfs(matrix,i,j+1,memo));
        }

        memo[i][j] = maxPath;
        return maxPath;
    }

    public static int longestPath(int[][] mat, int n, int m){
        int[][] memo = new int[n+1][m+1];

        for(int[] row : memo){
            Arrays.fill(row,-1);
        }

        return dfs(mat, 0, 0, memo);
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                mat[i][j] = scan.nextInt();
            }
        }

        int g = longestPath(mat,n,m);
        System.out.print(g);
    }
}