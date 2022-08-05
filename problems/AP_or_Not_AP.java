package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
import java.util.Arrays;


public class AP_or_Not_AP {
    public boolean Arithmetic_Progression(int [] arr) {
        Arrays.sort(arr);
//-------------------------------------------------------------------
        //My Approach:
//        int i = 0;
//        int temp2 = 0;
//        while(i != arr.length-1){
//            if(arr.length == 2){
//                return true;
//            }
//            int temp = arr[i]-arr[i+1];
//            i++;
//            if(temp2 == temp)
//                return true;
//            temp2 = temp;
//        }
//        return false;
// ----------Correct Solution: ------------------------------------------
        long differece = arr[0] - arr[1];
        for (int i = 0; i < arr.length-1; i++) { //arr.length - 1 because we want to check i+1 also, but array ends at arr.length - 1 so, we need to go till arr.length - 2 so, we use arr.length - 1.
            long current_difference = (arr[i] - arr[i + 1]);
            if (current_difference != differece) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the capacity of the array: ");
        int capacity = scan.nextInt();
        int [] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = scan.nextInt();
        }
        AP_or_Not_AP obj1 = new AP_or_Not_AP();
        System.out.println(obj1.Arithmetic_Progression(arr));
    }
}
