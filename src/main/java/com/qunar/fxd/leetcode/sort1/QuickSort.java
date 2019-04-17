package com.qunar.fxd.leetcode.sort1;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int arr[] = new int[]{13, 2, 4, 7, 9, 12};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    private static void sort(int arr[], int low, int high){
        if (arr.length <=0){
            return;
        }

        if (low >high){
            return;
        }
        int base = arr[low];
        int i=low;
        int j = high;

        while (i<j &&arr[j] > base){
            --j;
        }

        if (i<j){
            arr[i] =arr[j];
        }
        while (i< j &&arr[i] <=base){
            i++;
        }
        if (i<j){
            arr[j] = arr[i];
        }
        arr[i]= base;
        sort(arr,low, i-1);
        sort(arr,i+1, high);
    }
}
