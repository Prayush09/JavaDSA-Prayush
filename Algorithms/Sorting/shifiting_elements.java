package com.Data_Structures_byprayush;
import java.util.Scanner;

public class shifiting_elements {

    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many elements in the array: ");
        int len = scan.nextInt();
        int [] arr = new int[len];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < len; i++) {
            arr[i]=scan.nextInt();
        }
        System.out.println("Original Array: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
        //Shifting array:
            int temp = arr[arr.length-1];//storing last element
        //shifting
        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0]=temp;
        System.out.println();
        System.out.println("Rotated array to the right: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
