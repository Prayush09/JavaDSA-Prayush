package com.Data_Structures_byprayush.problems;

public class removeTheBalls {
    static int countBalls(int n){
        int[] dp = new int[n+1];

        if(n < 0)
            return 0;

        dp[0] = 1;
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 1;
        if(n >= 3) dp[3] = 2;

        for(int i = 4; i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-3])%1000000007;
        }

        return dp[n];
    }


    public static void main(String[] args){
        int n = 76;
        System.out.print(countBalls(n));
    }
}



