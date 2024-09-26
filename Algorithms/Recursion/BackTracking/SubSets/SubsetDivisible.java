package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.SubSets;

import java.util.*;
import java.lang.*;

public class SubsetDivisible {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            subsetDivisible();
        }
    }

    public static void subsetDivisible() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n+1];

        //fill the array
        for(int i = 1; i <= n;i++){
            arr[i] = scan.nextInt();
        }

        arr[0] = 0;
        //now to fill the arr with its moduloValue => currentSum % n; also currentSum -> arr[i] + arr[i-1]//current + prev
        for(int i = 1; i <= n;i++){
            arr[i] += arr[i-1];//update the sum
            arr[i] %= n;//update the current sum with its modulo counterpart
        }
        //the arr contains modulo values
        //create a map
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 1; i <= n; i++){
            //check if arr[i] == 0
            if(arr[i] == 0){
                System.out.println(i);//print the size of the subset
                for(int idx = 1; idx <= i;idx++)
                    System.out.print(idx+" ");//print all the indices from 1 to i
                System.out.println();
                return;
            }
            if(mpp.containsKey(arr[i])){
                //find the length of the subset
                int length = i - mpp.get(arr[i]);
                System.out.println(length);//print the subset size
                //now to print all the indices of the elements
                for(int idx = mpp.get(arr[i])+1; idx <= i;idx++){
                    System.out.print(idx+" ");
                }
                System.out.println();
                return;
            }
            mpp.put(arr[i],i);//if none of the condition satisfy then put the current element and its index into the map.
        }
    }


}