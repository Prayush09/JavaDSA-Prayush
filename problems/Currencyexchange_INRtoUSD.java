package com.Data_Structures_byprayush.problems;
import java.util.Scanner;
public class Currencyexchange_INRtoUSD {
     public static void main(String [] args){
         Scanner scan = new Scanner (System.in);
         System.out.println("Please enter a value in INR: ");
         float value = scan.nextFloat();
         float converted_Rate = value * 0.013f;
         System.out.println("The converted value is: "+converted_Rate);

     }
}
