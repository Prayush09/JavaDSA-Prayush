package com.Data_Structures_byprayush.Data_Structures.Linear.Heaps;
import java.io.*;
import java.util.*;
public class KthLargestElement {
        public static int kthLargest(int[] arr, int k){
            PriorityQueue<Integer> pq = new PriorityQueue<>(); //min-heap
            //add the first k elements
            for(int i = 0; i < k;i++){
                pq.add(arr[i]);
            }
            //now iterate from k, to end of array, note: the size of PriorityQueue should not be greater than k.
            //if it is then remove the top element and then add
            for(int i = k; i < arr.length;i++){
                if(arr[i]>pq.peek() && pq.size() <= k){
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
            return pq.peek();
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ;i < n;i++){
                arr[i] = scan.nextInt();
            }
            int k = scan.nextInt();
            System.out.print(kthLargest(arr, k));
        }
}