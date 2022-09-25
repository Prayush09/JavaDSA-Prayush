package com.Data_Structures_byprayush.problems;
import java.util.*;
public class MinStack_Leetcode155 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cap = scan.nextInt();
        int[] a=new int[cap];
        a[6]=6;
        a[6]=0;
        a = new int[] {1,3,4,5,6,7,10,11};
        for (int j : a) {
            if (j == 6) {
                System.out.println("it's there go get it");
            }
        }

        System.out.println(Arrays.toString(a));
        //insertion one element to the front or to the back, or in the middle;
        //deleting any element.
        //searching for an element.
        //If the array isEmpty.


    }
}
