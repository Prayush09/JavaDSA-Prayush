package com.Data_Structures_byprayush;
import java.util.ArrayList;
import java.util.Scanner;
public class Subtract_the_Product_and_sum_of_digits_of_an_integer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();

//---------------Below is a slow solution.---------------------------
//        int sum=0;
//        int mult=1;
//        ArrayList<Integer> ar = new ArrayList<Integer>();
//        do{
//            ar.add(n%10);
//            n /= 10;
//        }while(n > 0);
//        //sum
//        for (int i = 0; i < ar.size(); i++) {
//            sum+=ar.get(i);
//        }
//        //multiply
//        for (int j = 0; j < ar.size(); j++) {
//            mult *= ar.get(j);
//        }
//        System.out.println("Result: "+ (mult - sum));
//--------------------------------------------------------------
        //Faster Solution:
        int product = 1;
        int sum = 0;
        while(n>0)
        {
            int rem = n % 10; //Getting the last digit.
            product *= rem; //Multiply
            sum += rem; //Sum
            n /= 10; //removing the last digit.
        }
        int difference = product - sum;
        System.out.println(difference);


    }
}
