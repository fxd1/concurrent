package com.qunar.fxd.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13, 2, 4, 7, 9, 12};

        sort1(arr);

        System.out.println(Arrays.toString(arr));

    }

    //直接插入 交换次数比较少
    public static void sort1(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    //直接插入  交换次数比较多
    public static void sort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    public static void swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
