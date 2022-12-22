package com.Data_Structures_byprayush.problems.Assignments;//package com.Data_Structures_byprayush.problems.Assignments;
//
//public class Optimal_Page_Replacement {
//    //To check whether a page exists in a frame or not
//    static boolean search(int key, int[] frame) {
//        for (int i : frame)
//            if (frame[i] == key)
//                return true;
//        return false;
//    }
//
//    //To find the frame that will not be used recently in future after given index in page[0 to p(n-1)]
//    static int predict(int[] page, int[] frame, int pageno, int index) {
//        //Store the index of pages which are going to be used recently in future.
//        int res = -1, farthest = index;
//        for (int i = 0; i < frame.length; i++) {
//            int j;
//            for (j = index; j < pageno; j++) {
//                if (frame[i] == page[j]) {
//                    if (j > farthest) {
//                        farthest = j;
//                        res = i;
//                    }
//                    break;
//                }
//            }
//            //If a page is never referenced in future, return it.
//            if (j == pageno)
//                return i;
//        }
//        //If all of the frames were not in future, return any of them, we return 0.
//        //Otherwise we return res.
//        //?-> it checks if there is any nullpointerexception. If there is then it will set res = 0;
//        return (res == -1) ? 0 : res;
//    }
//
//    static void OptimalPage(int[] page, int pageno, int frameno) {
//        //Create an array for given number of frames and initialize it as empty.
//        int[] frame = new int[frameno];
//
//        //Traverse through page reference array and check for miss and hit
//        int hit = 0;
//        int index = 0;
//        for (int i = 0; i < pageno; i++) {
//            //Page found in a frame : HIT
//            if (search(page[i], frame)) {
//                hit++;
//                continue;
//            }
//
//            //Page not found in a frame : MISS
//            //If there is space available in frames:
//            if (index < frameno)
//                frame[index++] = page[i];
//
//                //Find the page to be replaced.
//            else {
//                int j = predict(page, frame, pageno, i + 1);
//                frame[j] = page[i];
//            }
//        }
//        System.out.println("No. of hits = " + hit);
//        System.out.println("No. of misses = " + (pageno - hit));
//    }
//
//    //Main function
//    public static void main(String[] args) {
//        int[] page = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
//        int pageno = page.length;
//        int frameno = 3;
//        OptimalPage(page, pageno, frameno);
//    }
//}


//-----------------------------------------------------------------------------------
// Java program to demonstrate optimal page
// replacement algorithm.

import java.io.*;
import java.util.*;

class OptimalPageReplacement {

    // Function to check whether a page exists
    // in a frame or not
    static boolean search(int key, int[] fr)
    {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }

    // Function to find the frame that will not be used
    // recently in future after given index in pg[0..pn-1]
    static int predict(int pg[], int[] fr, int pn,
                       int index)
    {
        // Store the index of pages which are going
        // to be used recently in future
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pn; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            // If a page is never referenced in future,
            // return it.
            if (j == pn)
                return i;
        }

        // If all of the frames were not in future,
        // return any of them, we return 0. Otherwise
        // we return res.
        return (res == -1) ? 0 : res;
    }

    static void optimalPage(int pg[], int pn, int fn)
    {
        // Create an array for given number of
        // frames and initialize it as empty.
        int[] fr = new int[fn];

        // Traverse through page reference array
        // and check for miss and hit.
        int hit = 0;
        int index = 0;
        for (int i = 0; i < pn; i++) {

            // Page found in a frame : HIT
            if (search(pg[i], fr)) {
                hit++;
                continue;
            }

            // Page not found in a frame : MISS

            // If there is space available in frames.
            if (index < fn)
                fr[index++] = pg[i];

                // Find the page to be replaced.
            else {
                int j = predict(pg, fr, pn, i + 1);
                fr[j] = pg[i];
            }
        }
        System.out.println("No. of hits = " + hit);
        System.out.println("No. of misses = " + (pn - hit));
    }

    // driver function
    public static void main(String[] args)
    {

        int pg[]
                = { 2,1,7,8,6,4,9,0,7,9,4,3,2,1,0,1,1,1,0,9};
        int pn = pg.length;
        int fn = 4;
        optimalPage(pg, pn, fn);
    }
}
