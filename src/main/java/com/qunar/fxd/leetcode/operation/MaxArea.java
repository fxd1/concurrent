package com.qunar.fxd.leetcode.operation;

/***
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 两个指针， 首尾 两个，从中间进行遍历。
 *
 * 哪边小，则哪边往里进行遍历。。。
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2
 *
 *
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
