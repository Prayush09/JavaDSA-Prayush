package com.Data_Structures_byprayush.problems.Assignments;
/*
Assignment - II - Module IV
Due November 26, 2022 11:59 PM
Name : Prayush Giri
Reg: 21BCE7864
Which sorting technique you would prefer when the given numbers are already sorted?
Bubble Sort
Which sorting technique you would prefer for sorting the products in flipkart and amazon? Explain it
Heap sort would be efficient as the multilevel hierarchical model can easily sort through big databases.

 */

public class Sorting {
    //Name : Prayush Giri
    //Registration Number : 21BCE7864
    //Aadhar number : 6195 0296 7595

    // 1. Bubble Sort
    public static void BubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swapping
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
    }

    // 2. Selection Sort
    public static void SelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index])
                    index = j;//Finding and storing the index value;
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // 3. Insertion Sort
    public static void InsertionSort(int[] array) {
        int i, j, temp;
        int n = array.length;
        for (i = 0; i < n; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && temp <= array[j]) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
    }

    // 4. Merge Sort (2-way)
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void mergeSort3Way(Integer[] gArray)
    {
        // if array of size is zero returns null
        if (gArray == null)
            return;

        // creating duplicate of given array
        Integer[] fArray = new Integer[gArray.length];

        // copying elements of given array into
        // duplicate array
        for (int i = 0; i < fArray.length; i++)
            fArray[i] = gArray[i];

        // sort function
        mergeSort3WayRec(fArray, 0, gArray.length, gArray);

        // copy back elements of duplicate array
        // to given array
        for (int i = 0; i < fArray.length; i++)
            gArray[i] = fArray[i];
    }

    /* Performing the merge sort algorithm on the
       given array of values in the rangeof indices
       [low, high).  low is minimum index, high is
       maximum index (exclusive) */
    public static void mergeSort3WayRec(Integer[] gArray,
                                        int low, int high, Integer[] destArray)
    {
        // If array size is 1 then do nothing
        if (high - low < 2)
            return;

        // Splitting array into 3 parts
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        // Sorting 3 arrays recursively
        mergeSort3WayRec(destArray, low, mid1, gArray);
        mergeSort3WayRec(destArray, mid1, mid2, gArray);
        mergeSort3WayRec(destArray, mid2, high, gArray);

        // Merging the sorted arrays
        merge(destArray, low, mid1, mid2, high, gArray);
    }
    public static void merge(Integer[] gArray, int low,
                             int mid1, int mid2, int high,
                             Integer[] destArray)
    {
        int i = low, j = mid1, k = mid2, l = low;

        // choose smaller of the smallest in the three ranges
        while ((i < mid1) && (j < mid2) && (k < high))
        {
            if (gArray[i].compareTo(gArray[j]) < 0)
            {
                if (gArray[i].compareTo(gArray[k]) < 0)
                    destArray[l++] = gArray[i++];

                else
                    destArray[l++] = gArray[k++];
            }
            else
            {
                if (gArray[j].compareTo(gArray[k]) < 0)
                    destArray[l++] = gArray[j++];
                else
                    destArray[l++] = gArray[k++];
            }
        }

        // case where first and second ranges have
        // remaining values
        while ((i < mid1) && (j < mid2))
        {
            if (gArray[i].compareTo(gArray[j]) < 0)
                destArray[l++] = gArray[i++];
            else
                destArray[l++] = gArray[j++];
        }

        // case where second and third ranges have
        // remaining values
        while ((j < mid2) && (k < high))
        {
            if (gArray[j].compareTo(gArray[k]) < 0)
                destArray[l++] = gArray[j++];

            else
                destArray[l++] = gArray[k++];
        }

        // case where first and third ranges have
        // remaining values
        while ((i < mid1) && (k < high))
        {
            if (gArray[i].compareTo(gArray[k]) < 0)
                destArray[l++] = gArray[i++];
            else
                destArray[l++] = gArray[k++];
        }

        // copy remaining values from the first range
        while (i < mid1)
            destArray[l++] = gArray[i++];

        // copy remaining values from the second range
        while (j < mid2)
            destArray[l++] = gArray[j++];

        // copy remaining values from the third range
        while (k < high)
            destArray[l++] = gArray[k++];
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public void Heapsort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }




    //Main program to run sorting
    public static void main(String[] args) {
        int arr[] ={6,1,9,5,0,2,9,6,7,5,9,5};

        System.out.println("Array Before Bubble Sort");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();
        long startBubble = System.nanoTime();
        BubbleSort(arr);//sorting array elements using bubble sort
        long endBubble = System.nanoTime();
        System.out.println("Array After Bubble Sort");
        System.out.println("Total elapsed time in Bubble: "+(endBubble-startBubble));
        for (int j : arr) {
            System.out.print(j + " ");
        }
        int arr1[] ={6,1,9,5,0,2,9,6,7,5,9,5};
        System.out.println("\nBefore Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();
        long startSelection = System.nanoTime();
        SelectionSort(arr1);//sorting array using selection sort
        long endSelection = System.nanoTime();
        System.out.println("Total time Taken in Selection: "+(endSelection-startSelection));
        System.out.println("After Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        int arr2[] ={6,1,9,5,0,2,9,6,7,5,9,5};
        System.out.println("\nBefore sorting array elements are - ");
        for (int i : arr2)
            System.out.print(i+" ");
        long startInsertion = System.nanoTime();
        InsertionSort(arr2);
        long endInsertion = System.nanoTime();
        System.out.println("\nTotal Elapsed Time in Insertion: "+(endInsertion-startInsertion));
        System.out.println("\nAfter sorting array elements are - ");
        for (int i : arr2)
            System.out.print(i+" ");


        int arr3[] = {6,1,9,5,0,2,9,6,7,5,9,5};
        Sorting S = new Sorting();
        System.out.println("\nArray Before Sorting in Merge: ");
        printArray(arr3);
        long MergeSortTime = System.nanoTime();
        S.sort(arr, 0, arr.length - 1);
        long MergeSortTimeEnd = System.nanoTime();
        System.out.println("\nTotal time taken: "+(MergeSortTimeEnd-MergeSortTime));
        System.out.println("\nMerge 2 way Sort: ");
        printArray(arr);
        System.out.println();
        Integer arr4[] ={6,1,9,5,0,2,9,6,7,5,9,5};
        System.out.println("Before 3 way Merge sort: ");
        for(int i: arr4)
            System.out.print(i+" ");
        long MergeTime1 = System.nanoTime();
        mergeSort3Way(arr4);
        long MergeendTime1 = System.nanoTime();
        System.out.println("\nTotal Time Taken in Merge : "+ (MergeendTime1 - MergeTime1));
        System.out.println("\nAfter 3 way merge sort: ");
        for (int i = 0; i < arr4.length; i++)
            System.out.print(arr4[i] + " ");
        int[] arr5 = {6,1,9,5,0,2,9,6,7,5,9,5};
        System.out.println("Before quick sort: ");
        printArray(arr5);
        int length = arr5.length;
        long quickstart = System.nanoTime();
        quickSort(arr5,0,length-1);
        long quickend = System.nanoTime();
        System.out.println("Total time taken in quick sort: "+(quickend-quickstart));
        System.out.println("After quick sort: ");
        printArray(arr5);

        int[] arr6 = {6,1,9,5,0,2,9,6,7,5,9,5};
        System.out.println("Before heap sort: ");
        printArray(arr6);
        Sorting ob = new Sorting();
        long StartHeap = System.nanoTime();
        ob.Heapsort(arr6);
        long EndHeap = System.nanoTime();
        System.out.println("Total time taken in Heap Sort: "+(EndHeap-StartHeap));
        System.out.println("Sorted array in Heap");
        printArray(arr6);
    }

}

























