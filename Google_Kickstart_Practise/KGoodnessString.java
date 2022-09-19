package com.Data_Structures_byprayush.Google_Kickstart_Practise;

import java.util.Scanner;
//goodness score of a string as the number of indices i.
// Si !=  S(N-i+1), where 1<= i <= N/2 (1-indexed).
//Convert the given string S of length N, into a string with a goodness score of K.
//In one operation, Ada can change any character in the string to any uppercase letter
//Coding the first part of the problem
    /*
    Analysis
As per the given definition of operation,
Ada can only change the goodness score by one in a single move.
 Therefore to get a string with the required goodness score in the
 minimum number of operations Ada can either increase or decrease the goodness score
 by one in each step. Let us assume there are X indices(≤N/2 (1-indexed)) i in the given
 string S such that Si≠SN−i+1. We have 3 cases now.

Case 1: X=K,
In this case, Ada already has the string which has a goodness score of K.
Therefore number of operations required is 0.
Case 2: X>K,
In this case, Ada can change (X−K) letters at indices i (1≤i≤N/2 (1-indexed))
that satisfy Si≠SN−i+1 to the letter at SN−i+1.
 Then she will have a string with a goodness score of K.
 Therefore the minimum number of operations is (X−K).
Case 3: X<K,
In this case, Ada can change (K−X) letters at indices i (1≤i≤N/2 (1-indexed)) that satisfy
Si=SN−i+1 to any other uppercase letter other than the one at SN−i+1.
As a result, she will have a string with a goodness score of K.
Therefore the minimum number of operations is (K−X).
     */


class  KGoodnessString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            String S = scan.next();
            System.out.println("Case #"+i+": "+solve(S,K));
        }
    }



    public static int solve(String s, int k) {
        int minimumOperations;
        int x = 0;
        int length = s.length();
        char[] arr;
        arr = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if(arr[i]!=arr[length-i-1]){
                x++;
            }
        }
        if(x == k){
            minimumOperations = 0;
        }
        else if(x>k){
            minimumOperations = x-k;
        }
        else{
            minimumOperations = k-x;
        }
        return minimumOperations;
    }
}