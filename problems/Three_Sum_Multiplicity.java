package com.Data_Structures_byprayush.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.



Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Idea: Here, we have arr[i] + arr[j] + arr[k] = target
            now, -> target - arr[i] - arr[j] = arr[k]
            when we fix arr[i] and arr[j] values and get arr[k] and
            if it exists inside the list then we have a tuple i.e.
            i,j,k...
            To find it inside the list we can use a hashmap with a key and count...
            for e.g. we have 1 1 2 2 3 3 3 4 4 5 5 5 5
            here in this example, we have key : value
                                           1  :  2
                                           2  :  2
                                           3  :  3
                                           4  :  2
                                           5  :  4
       Now, to fix arr[i] and arr[j] we can use nested loops,


 */
public class Three_Sum_Multiplicity {
    public int threeSum(int[] arr, int target){
       /*
       The getOrDefault(Object key, V defaultValue) method of Map interface, implemented by HashMap class is used to get the value mapped with specified key.
       If no value is mapped with the provided key then the default value is returned.

       Syntax:
               default V getOrDefault(Object key, V defaultValue)

       Parameters: This method accepts two parameters:
     * key: which is the key of the element whose value has to be obtained.
     * defaultValue: which is the default value that has to be returned, if no value is mapped with the specified key.
     * Return Value: This method returns value mapped with the specified key, otherwise default value is returned.
        */
        Map<Integer, Long> frequency = new HashMap<>();
        //Iterating over each element
        //For integer element across all the elements in the array.
        for(int element : arr){
            long freq = frequency.getOrDefault(element, 0L);//Default value in the map.
            frequency.put(element, freq+1L);//Updating the frequency one higher than the previous one.
        }
        long ans = 0;//answer variable.
        //Iterating over each key in the map
        for(Integer element1 : frequency.keySet()){
            for(Integer element2 : frequency.keySet()){
                int element3 = target - element1 - element2;//Getting element 3
                //Checking if element 3 exists within the map, if not loop gets updated.
                if(frequency.containsKey(element3)){
                    long freq1 = frequency.get(element1);
                    long freq2 = frequency.get(element2);
                    long freq3 = frequency.get(element3);

                    if(element1.equals(element2) && element1.equals(element3)){
                        ans += (freq1) * (freq1-1)*(freq1-2)/6;//Case 3 Where all elements in tuple are same.
                    }else
                        if(element1.equals(element2)){
                            ans += (freq1)*(freq1-1)/2 * freq3;// Case 2 where 2 are same and the other is different.
                    }else
                        if(element1 < element2 && element2 < element3){
                            ans += (freq1*freq2*freq3);
                        }
                }
            }
        }
        return (int) (ans + ans % 1000000007);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the capacity of the array: ");
        int len = scan.nextInt();
        int[] arr = new int [len];
        System.out.println("Enter the target for the tuples: ");
        int target = scan.nextInt();
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        Three_Sum_Multiplicity obj1 = new Three_Sum_Multiplicity();
        System.out.println(obj1.threeSum(arr, target));
    }
}
