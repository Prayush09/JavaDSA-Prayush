package com.Data_Structures_byprayush.problems;
import java.util.*;
public class HackerRank_JumpGame5 {
        public static boolean isPossible(int[] arr){
            int maxReach = 0;
            for(int i = 0 ; i < arr.length;i++){
                if(i>maxReach)
                    return false;
                maxReach = Math.max(maxReach,i+arr[i]);
                if(maxReach >= arr.length-1)
                    return true;
            }
            return false;
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] arr= new int[n];
            for(int i = 0 ; i < arr.length;i++){
                arr[i] = scan.nextInt();
            }
            System.out.print(isPossible(arr));
        }
}
