package com.Data_Structures_byprayush.Basics;
import java.util.Scanner;
public class Math_class {
    /*
Math class methods:
  1. Math.max(); tells you the greater of the two values.
  2. Math.abs(); only a single value passes, Its shows the absolute value.
  3. Math.sqrt(); square root of the value.
  4. Math.round(); round off value.
     * Math.ceil(); //only round off to the higher side of the value.
     * Math.floor(); //only round off to the lower side of the value.
 */
    public static void main(String[] args){
        //Pythagoras Theorem.
        // H = P^2 + B^2
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the base and the perpendicular of the right angle triangle: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double z = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        scan.close();
        System.out.println("The hypotenuse of the right angle triangle for the sides "+a+", "+b+" is : "+ z);
    }
}
