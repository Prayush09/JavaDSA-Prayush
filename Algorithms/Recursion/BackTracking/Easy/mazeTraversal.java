package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking.Easy;
import java.util.ArrayList;
public class mazeTraversal {
    public static void main(String[] args) {
        String s = "";
        boolean[][] arr = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathWithObstacle(arr,arr.length-1,arr[0].length-1,s);
    }

    private static void pathWithObstacle(boolean[][] mat, int r, int c, String s){
        if(r == 0 && c == 0){
            System.out.println(s);
            return;
        }
        if(r>0){
            if(mat[r][c])
            {
                pathWithObstacle(mat,r-1,c,s+"V");
            }
        }
        if(c>0){
            if(mat[r][c]){
                pathWithObstacle(mat,r,c-1,s+"H");
            }
        }
        if(r > 0 && c > 0){
            if(mat[r][c])
                pathWithObstacle(mat,r-1,c-1,s+"D");
        }
    }


    static ArrayList<String> count(String s, int r, int c){
        if(r == 1 && c == 1) {
            //found one answer
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        ArrayList<String> paths = new ArrayList<>();
        if(r>1){
            paths.addAll(count(s+"D ",r-1,c));
        }
        if(c>1){
            paths.addAll(count(s+"R ",r,c-1));
        }
        if(r > 1 && c > 1){
            //diagonally
            paths.addAll(count(s+"DG ",r-1,c-1));
            //this only take into consideration that you start at n,m
        }
        return paths;
    }
}
