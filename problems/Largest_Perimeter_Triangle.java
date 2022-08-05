package com.Data_Structures_byprayush.problems;
import java.util.Arrays;
import java.util.Scanner;
//The Trianle inequality states that the sum of the lengths of any two sides
//of a trinalge is greater than the length of the remaining side. It follows from the fact that a straight line is the shortest path between two points.
//The inequality is strict fi teh triangle is non-degenerate(meaning it has a non-zero area).
public class Largest_Perimeter_Triangle {
    public int Largest_perimeter(int[] nums){

        Arrays.sort(nums);
        //We only want the for loop to run once if the array has only three elements, twice if the elements are four, otherwise it will throw array out of bounds exception.
        for (int i = nums.length-3; i >= 0; i--) {
            if((nums[i]+nums[i+1])>nums[i+2]){//If logic was correct only needed to optimize the for-loop according to the if statement.
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the capacity of the array: ");
        int capacity = scan.nextInt();
        int[] nums = new int[capacity];
        System.out.println("Enter all the elements in the array: ");
        for (int i = 0; i < capacity; i++) {
            nums[i] = scan.nextInt();
        }
        Largest_Perimeter_Triangle l1 = new Largest_Perimeter_Triangle();
        System.out.println("Result: "+l1.Largest_perimeter(nums));
    }
}
