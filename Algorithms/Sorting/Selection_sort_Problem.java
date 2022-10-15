package com.Data_Structures_byprayush.Algorithms.Sorting;
import java.util.Scanner;
public class Selection_sort_Problem {
    public static int[] selection_sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)//Traversing through whole array
        {
            //assigning the minimum index value of i.
            int min_index = i;
            //Starting second loop from i+1 position till last position,
            // here j = 1 for first iteration
            // therefore we need to go till j<n and not j<n-1.
            for(int j=i+1;j<n;j++)
                //If any index that is greater than i has a smaller value,
                // we assign that j index to min_index;
                //We repeat this for loop until we get
                if(arr[j]<arr[min_index])
                    min_index=j;
            //Reversing the numbers using indexes.
            int temp = arr[min_index];
            arr[min_index]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    public static void display(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String [] args)
    {
        System.out.println("Enter the number of students: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] name = new String[n];
        int[] rollno = new int[n];
        String[] address = new String[n];
        int[] CGPA = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            System.out.println("Student name: ");
            name[i] = scan.next();
            System.out.println("Enter RollNo: ");
            rollno[i] = scan.nextInt();
            System.out.println("Enter Address: ");
            scan.nextLine();
            address[i]= scan.nextLine();
            System.out.println("Enter CGPA: ");
            CGPA[i]=scan.nextInt();
        }
        selection_sort(CGPA);
        display(CGPA);
    }
}
