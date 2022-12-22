package com.Data_Structures_byprayush.CPU_shifting_Algorithms;

import java.util.Scanner;

public class Segmentation {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int p = scan.nextInt();
        int[] arr1 = new int[p];
        int[] arr2 = new int[p];
        int[] arr3 = new int[p];
        System.out.println("Enter the value : ");
        for (int i = 0; i < p; i++) {
            System.out.println("Enter the Base Value of Process: "+ i);
            arr1[i] = scan.nextInt();
            System.out.println("Enter the limit value of Process : "+i);
            arr2[i]= scan.nextInt();
            arr3[i]= arr1[i]+arr2[i];
        }
        int res[] = new int[p];
        int res1[] = new int [p];
        for(int i = 0 ; i<arr1.length ; i++)
        {
            if(arrCheck(arr1,arr3,res[i])){
                res[i]=arr1[i];
                res1[i] = arr2[i];
            }
        }
        System.out.println("Base -> Limit");
        printArr(res,res1);
    }
    static boolean arrCheck(int[] arr1, int[] arr2, int n){
        boolean k = true;
        if(arr1.length != 0 || arr1.length!=1)
        {
            for (int i = 0; i < arr1.length; i++) {
                if(n>arr1[i]&&n<arr2[i])
                {
                    k = false;
                    break;
                }
            }
        }
        return k;
    }
    static void printArr(int[] arr, int[] arr1)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" -> "+arr1[i]);
        }
    }
}
