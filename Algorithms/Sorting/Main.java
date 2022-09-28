package com.Data_Structures_byprayush.Algorithms.Sorting;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        SelectionSort obj = new SelectionSort();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the capacity: ");
        int capacity = scan.nextInt();
        int[] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            System.out.println("Enter "+(i+1)+"th element into the array: ");
            arr[i]=scan.nextInt();
        }
        obj.selection_sort(arr);
        obj.print_arr(arr);
    }
}
