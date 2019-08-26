package com.mdq.simpletest.demo.utils;

import java.util.Arrays;

public class sortTest {

    public static void main(String[] args) {

        int arr[] = {0,10,-11,-12,1,-13,-14,-15,-16,-1,-2,7,8,-9,-7,0,11,-3,12,13,14,15,16,-10};
//10 16 15 14 13 12 11 8 7 -2 -9 -7 -16 -3 -15 -14 -13 -12 -11 -10
        Arrays.sort(arr);
//        for(int i=0;i<=arr.length-1;i++){
//            for(int j=0;j<i;j++){
//                System.out.println("i="+i+","+"j="+j);
//               // if(arr[i]>=0){continue;}
//                if(arr[i]>arr[j]){
//                    int start = arr[i];
//                    //j = jb(i,j,arr);
//                    arr[i] = arr[j];
//                    arr[j] = start;
//                // j--;
//                //}
//                }
//            }
//        }
        for(int n=0;n<arr.length;n++){
            System.out.print(arr[n]+" ");
        }
    }
    public static int jb(int i, int j, int arr[]){
        if(i<j){
                if(arr[j] >=0){
                    if(arr[j]==0){
                        System.out.println("arr[j]:"+arr[j]+",j:"+j+",i:"+i);
                    }
                    return j;
                }else{
                    j--;
                    return jb(i,j,arr);
                }
            }else{
                return j;
        }
    }
}
