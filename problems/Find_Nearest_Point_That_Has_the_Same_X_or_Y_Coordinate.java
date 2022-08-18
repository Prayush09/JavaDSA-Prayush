package com.Data_Structures_byprayush.problems;

public class Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate {
    public int nearestValidPoint(int x, int y, int [][] points){
        int smallestDistance = Integer.MAX_VALUE; /*Maximum value stored so that we can use it to compare the first element in the array*/
        int result = -1;//If we don't find any valid points then we return -1.
        for (int i = 0; i < points.length; i++) {
            //Checking if at the indexes in the array are equal to the x and/or y.
            if(points[i][0]==x || points[i][1]==y) {
                int currentDistance = Math.abs(x - points[i][0] + Math.abs(y - points[i][1]));//storing the manhattan distance...
                if (currentDistance < smallestDistance) {
                    smallestDistance = currentDistance;//If current is smaller, it becomes the smaller distance
                    result = i;//since we need to return the 0th index we are only iterating i in the 0th index of the points 2D array.

                }
            }
        }
        return result;
    }
}
