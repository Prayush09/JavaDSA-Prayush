package com.Data_Structures_byprayush.problems;
import java.util.Scanner;

public class subtractproductandsum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number : ");
        int n = scan.nextInt();
        int product = 1;
        int sum = 0;
        while(n>0)
        {
            int rem = n % 10;//extracting last digit
            product = product * rem;//multiplying for product
            sum = sum + rem;//adding for sum
            n /= 10;//removing the last digit.
        }
        System.out.println("Product: "+ product );
        System.out.println("Sum: " + sum );
        System.out.println("Difference: "+ (product-sum));
    }
}
