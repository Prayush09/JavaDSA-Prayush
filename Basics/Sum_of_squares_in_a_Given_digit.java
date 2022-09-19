package com.Data_Structures_byprayush.Basics;
/*
Algorithm :
1. Input a number from the user.
2. Pass the number to getValues() method.
3. Inside the method, Declare a variable 'a' and initialize it with the input number.
   Also, declare rem, and sum variable with 0.
4. Iterate over the number till it is not equal to 0.
   Retrieve each digit from the number and find its square and
   add them to store it into the sum variable.
5. Return/print the values.

 */
public class Sum_of_squares_in_a_Given_digit {
    static int sum = 0;
    static int rem = 0;
    public static int Sum_of_square(int n){
        while(n!=0)
        {
          rem =  n % 10;
          sum += rem*rem;
          n /= 10;
        }
        return sum;
    }
}
