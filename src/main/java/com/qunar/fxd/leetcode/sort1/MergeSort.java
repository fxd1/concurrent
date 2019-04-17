package com.qunar.fxd.leetcode.sort1;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13, 2, 4, 7, 9, 12};
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int arr[], int start, int end) {

        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int a[], int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }

    }
}
