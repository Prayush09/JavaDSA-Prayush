package com.Data_Structures_byprayush.problems;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[] temp = new int[2];
        int index = 0;
        int[][] ans = new int[intervals.length][2];
        int firstElement = intervals[0][0];
        int secondElement = intervals[0][1];
        for(int i = 1 ; i < intervals.length;i++){
            //traverse and compare the secondElement with the first element of the next set
            if(intervals[i][0] < secondElement && secondElement < intervals[i][1]){
                secondElement = intervals[i][1];
            }else{
                //put the current subset in the answer and set the current range
                temp[0] = firstElement;
                temp[1] = secondElement;
                ans[index++] = temp;
                firstElement = intervals[i][0];
                secondElement = intervals[i][1];
            }
        }
        return ans;
    }
}
