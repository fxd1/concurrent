package com.qunar.fxd.leetcode;

/***
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 两个指针， 首尾 两个，从中间进行遍历。
 *
 * 哪边小，则哪边往里进行遍历。。。
 */
public class MaxArea {


    public static int maxArea1(int[] height) {

        int i=0;
        int j= height.length-1;
        int max= 0;
        while (i<j){
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i++]);
            }else {
                max = Math.max(max, (j - i) * height[j--]);
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {

            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[j], height[i]));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea1(arr));
    }


}
