package com.Data_Structures_byprayush;

public class Time_Complexity {
    public void test(){
        int a = 1;
        a++;
    }
    public void test1(){
        int count =1;
        for (int i = 0; i < 100; i++) {

            count ++;
        }
    }
    public void test2(){
        int count = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                count++;
            }
        }
    }
    public void test3(){
        int count = 1;
        for (int o = 0; o < 7; o++) {


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Time_Complexity obj1 = new Time_Complexity();
        long start = System.currentTimeMillis();
        obj1.test();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: "+ (end-start));
        long start1 = System.nanoTime();
        obj1.test1();
        long end1 =  System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: "+ (end1-start1));
        long start2 =  System.nanoTime();
        obj1.test2();
        long end2 =  System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
        long start3 =  System.nanoTime();
        obj1.test3();
        long end3 =  System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: "+ (end3-start3));
    }
}
