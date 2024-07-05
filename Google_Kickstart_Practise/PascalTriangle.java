package com.Data_Structures_byprayush.Google_Kickstart_Practise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();
        scanner.close();



        for (int i = 0; i < numRows; i++) {
            int number = 1;
//            for (int j = 0; j < numRows - i; j++) {
//                System.out.print("   "); // Print spaces for formatting
//            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%6d", number); // Adjust formatting for spacing
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}

