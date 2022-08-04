package com.Data_Structures_byprayush.Basics;
import java.util.Scanner;

// 1. To find the minimum and maximum values in an array.
//    to do that we take the first value, start comparing it to other
//    elements, if it's the smallest we store it var.
//    Repeat the same for maximum.
//    If it's not the maximum or minimum we can store it in another array.

public class Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {

//TO THE POINT SOLUTION.
    public double avgsalary(int[] salary){
        int total = salary[0] , max = salary [0] , min = salary [0];//Setting each value to the first salary element.
        int len = salary.length;//Making a len variable that stores the value of the length of array.
        for(int i = 1 ; i < len ; i++){
            total += salary[i];//Adding all the elements in salary array to total.
            if(max<salary[i])//If method to store the max value from the array.
                max = salary[i];
            if(min>salary[i])//If method to store the min value from the array.
                min = salary[i];
        }
        return (total - max - min)/(len - 2);
        //Returning the avg value which excludes max and min values,
        //1. by subtracting max and min from the total.
        //2. dividing by number of elements remaining excluding max and min
        // i.e. total elements remaining - 2.
        //  ============or==================
        // salary.length - 2 /  len - 2.

    }
//--------------------Very slow solution.------------------------
//       public double avgsalary(int [] salary){
//           DecimalFormat d1 = new DecimalFormat("0.00000");
//           double avg=0;
//           int max=0;
//           int min=salary[0];
//           Arrays.sort(salary);
//           for (int i : salary) {
//                   if(i > max){
//                       max = i;
//                   }
//                   if(min > i)
//                       min = i;
//           }
//           for(int j : salary){
//               if(j != min && j != max )
//                   avg += j;
//           }
//           d1.format(avg);
//           return avg/(salary.length-2);
//       }
//----------------------------------------------------------------
    public static void main(String[] args) {
           Scanner scan = new Scanner(System.in);
        System.out.println("How many salary do you want in the array? : ");
           int index = scan.nextInt();
           int[] salary = new int[index];
        System.out.println("Please enter the salaries one by one : ");
        for (int i = 0; i < index; i++) {
            salary[i] = scan.nextInt();
        }
        Average_Salary_Excluding_the_Minimum_and_Maximum_Salary q1 = new Average_Salary_Excluding_the_Minimum_and_Maximum_Salary();
        System.out.println(q1.avgsalary(salary));

    }
}
