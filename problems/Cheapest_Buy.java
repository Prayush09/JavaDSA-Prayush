package com.Data_Structures_byprayush.problems;

import java.util.*;
public class Cheapest_Buy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[][] P = new long[n][m];
            long ans = 0;
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++){
                long max = Integer.MIN_VALUE, maxI = -1;
                for(int j=0;j<m;j++){
                    P[i][j] = sc.nextLong();
                    if(P[i][j]> max){
                        max = P[i][j];
                        maxI = j;
                    }
                    ans+=P[i][j];
                }
                ans -= max;
                for(int j=0;j<m;j++){
                    if(j!=maxI) set.add(j);
                }
            }
            if(n==1 || m==1){
                System.out.println(-1);
                continue;
            }
            boolean flag = true;
            int itemNotBoughtIndex = -1;
            for(int i=0;i<m;i++){
                if(!set.contains(i)){
                    flag = false;
                    itemNotBoughtIndex = i;
                    break;
                }
            }
            if(flag){
                System.out.println(ans);
                continue;
            }
            long[] itemNotB = new long[n];
            for(int i=0;i<n;i++){
                itemNotB[i] = P[i][itemNotBoughtIndex];
                P[i][itemNotBoughtIndex] = 0;
            }
            long lastItem = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                long max = Integer.MIN_VALUE;
                for(int j=0;j<m;j++){
                    if(max<P[i][j]){
                        max = P[i][j];
                    }
                }
                lastItem = Math.min(lastItem, (itemNotB[i] - max) );
            }
            System.out.println(ans + lastItem);
        }
        sc.close();
    }
}