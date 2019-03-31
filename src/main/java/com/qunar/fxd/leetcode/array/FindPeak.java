package com.qunar.fxd.leetcode.array;

public class FindPeak {

    /*

    遍历一遍, 找到第一个满足条件a[i]>a[i+1]的元素, 表明开始"下坡", 则i就是所找的最大值下标. 这种解法的时间复杂度为O(n). 当然, 这其中存在两种情况, 需要单独拿出来分析一下: 1, 数组单调递增. 因为题目要求数组"先递增后递减", 如果是"单调递增"的话, 那么最后一个元素, 肯定大于倒数第二个元素. 2, 数组单调递减. 同第一种情况的分析, "单调递减"的该数组, 肯定满足条件a[0]>a[1].
     */

    /**
     * 从头到尾遍历 ，发现有 arr[i]>arr[i+1]的，则表示i为当前峰值的下标
     *
     * @param arr
     * @return
     */
    public static int fingPeak(int arr[]) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        if (arr[arr.length - 2] < arr[arr.length - 1]) {
            return arr.length - 1;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,7,6,5,4,3,2,1};
        System.out.println(fingPeak1(arr));
    }
    public static int fingPeak1(int arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        if (arr[arr.length - 2] < arr[arr.length - 1]) {
            return arr.length - 1;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }

        int mid  =0;
        int i=0;
        int j = arr.length -1;

        while (i<j){
            mid = (i+j) >>1;
            if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }else if (arr[mid] > arr[mid+1]){
                j= mid-1;
            }else {
                i=mid+1;
            }
        }

        return -1;
    }

}
