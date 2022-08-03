//package com.KunalDSACourse;
//import java.util.Scanner;
//// To Comment out the selected code, use 'ctrl+/'
//public class basic {
//    public static void main(String[] args) {
//        int a  =  10;
//        //Here 'a' is an identifier and '10' is a literal. Commonly used in primitive data types.'
//
//        //Now if you are dealing with big values then, please use an underscore which can tidy it up.
//        int million = 234_000_000;
//        System.out.print(million);
//
//        //Remember that in using floats the values are rounded off which directly means that they are not that accurate.
//        Scanner scan = new Scanner(System.in);
//        float marks = scan.nextFloat();
//        System.out.println("Your marks is : "+marks);
//
//        //Type Casting and conversion.
//        //Conditions for Type Casting:
//        /*
//        1. The two types should be compatible like float and int.
//        2. The destination type should be greater than the source type. That is if the number is first and int and then we are adding it into a float then that will work.
//           But if we do the reverse then that will not happen and one error will occur.| float > int |
//        3.To fit big value inside a type which has a smaller maximum value we use narrowing conversion OR MORE FAMOUSLY KNOWN AS TYPE CASTING   .
//         */
//        //Narrowing conversion OR TYPE CASTING:
//        int z = (int)(83792.392f);//We have an integer but we are storing a value of float inside it using a (int) -> NARROW CONVERSION or TYPE CASTING
//
//        //Automatic Promotion in expression:
//        int i = 257; // A byte can only handle upto 256 bits but we are explicitly type casting 257 into byte f.
//        byte f = (byte)(i); //At this stage what the byte does is that it will take modulus of the given value and maximum value. => 257 % 256 = 1.
//        System.out.println(f); //The output we get will be 1.
//
//        //In the code snippet below q * p will give 20,000 which easily surpass the maximum threshold value of byte but still the code works.
//        //This happens due to something in java called Automatic Promotion, where all the byte values stored in the expression for int d have
//        // been converted to integer for the expression to work.
//        byte q = 40;
//        byte p = 50;
//        byte c = 100;
//        int d = q * p / c;
//        System.out.println(d); //This only work if the type in which the expression is stored in is larger then the type which is being automatically promoted to.
//        //The opposite of this will not work.
//
//        //LOOPS
//        //FOR LOOPS - YOU KNOW HOW MANY TIMES THE LOOP IS GOING TO RUN THEN USE THIS.
//        //WHILE LOOPS - YOU DO NOT KNOW HOW MANY TIMES THE LOOP IS GOING TO RUN THEN USE THIS.
//    }
//}
