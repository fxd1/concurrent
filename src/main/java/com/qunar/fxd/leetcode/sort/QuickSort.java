package com.qunar.fxd.leetcode.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13, 2, 4, 7, 9, 12};

        quickSort(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int arr[], int low, int high) {

        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];   //挖坑1：保存基准的值
        while (left < right){
            while(left < right && arr[right] >= temp){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;   //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }

}
