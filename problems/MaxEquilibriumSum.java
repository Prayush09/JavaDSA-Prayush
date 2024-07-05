package com.Data_Structures_byprayush.problems;
import java.util.*;
public class MaxEquilibriumSum {
    public static int maxEquilibriumSum(int arr[],int n){
        int totalsum = 0;
        int leftsum = 0;
        for(int i = 0 ; i < n; i++){
            totalsum += arr[i];
        }
        //crux of the problem
        for(int i = 0 ; i < n ;i++)
        {
            totalsum = totalsum - arr[i];
            if(totalsum == leftsum)
                    return i;
            leftsum += arr[i];
        }
        return -1;
    }

   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       int[] arr = new int[n];
       for(int i = 0 ; i < n ; i++)
       {
           arr[i] = scan.nextInt();
       }
       System.out.println(maxEquilibriumSum(arr,n));
   }
}
