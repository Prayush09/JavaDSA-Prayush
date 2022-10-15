package com.Data_Structures_byprayush.Algorithms.Sorting;


public class Quick_sort {
    //Display function for the array
    public static void display(int[] arr, int size)
    {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //A function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    //A partitioning function
    static int partition (int[]arr,int low, int high)
    {
        //Pivot element selected as right most element in array each time.
        int pivot = arr[high];
        int swapIndex = (low-1); //swapping index

        for (int i = low; i <= high - 1; i++) {
            if(arr[i]<pivot)
            {
                swapIndex++;//incrementing swapping index
                swap(arr,swapIndex,i);
            }
        }
        //swap swapIndex+1 and pivot index
        swap(arr,swapIndex+1,high);
        return (swapIndex+1);
    }
    //Quicksort function using recursion
    static void quicksort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int indexPI = partition(arr,low,high);

            quicksort(arr,low,indexPI-1);//left partition
            quicksort(arr,indexPI+1,high);//right partition
        }
    }

    public static void main(String[]args)
    {
        int [] Prayush = {400,200,100,7864,21};
         int size = Prayush.length;
        display(Prayush,size);

        quicksort(Prayush,0,size-1);
        display(Prayush,size);
    }
}
