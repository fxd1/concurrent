package com.qunar.fxd.leetcode.array;

public class FindArrayIndex {


    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 9};
        System.out.println(binSearch(arr, 5));
    }

    public static int binSearch(int srcArray[], int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        int last  =-1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            }else {
                last = mid;
                end = mid -1;
            }
        }

        if (srcArray[last] == key){
            return last;
        }
        return -1;
    }

}
