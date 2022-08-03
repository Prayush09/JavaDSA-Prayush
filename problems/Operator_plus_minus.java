package com.Data_Structures_byprayush.problems;
import java.util.Scanner;

public class Operator_plus_minus {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner (System.in);
        int a,b;
        System.out.println("Enter first number: ");
        a = scan.nextInt();
        System.out.println("Enter second number: ");
        b = scan.nextInt();
        System.out.println("Enter operator from '+','-','*','/' : ");
        String operations;
        operations = scan.next();
        switch (operations){
            case "+" -> System.out.println("Result: "+ (a+b));
            case "-" -> System.out.println("Result: "+ (a-b));
            case "*" -> System.out.println("Result: "+ (a*b));
            case "/" -> System.out.println("Result: "+ (a/b));
            default -> System.out.println("Please enter a valid operation");
        }
    }

}
