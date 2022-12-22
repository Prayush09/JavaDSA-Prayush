package com.Data_Structures_byprayush.problems.Assignments;

class doublehashing {
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void doublehashing(int table[], int tsize, int arr[],
                              int N)
    {
        for (int i = 0; i < N; i++) {
            int hv = (3*arr[i]+3) % tsize;
            int hv1=arr[i];
            if (table[hv] == 0)
                table[hv] = arr[i];
            else {
                for (int j = 1; j < tsize; j++) {
                    int t = (hv + j * hv1) % tsize;
                    if (table[t] == 0) {
                        table[t] = arr[i];
                        break;
                    }
                }
            }
        }

        printArray(table);
    }
    public static void main(String args[])
    {
        int arr[] = { 6,1,9,5,0,2,9,6,7,5,9,5 };
        int N = 12;
        int L = 20;
        int hash_table[] = new int[L];
        for (int i = 0; i < L; i++) {
            hash_table[i] = 0;
        }
        doublehashing(hash_table, L, arr, N);
    }
}



