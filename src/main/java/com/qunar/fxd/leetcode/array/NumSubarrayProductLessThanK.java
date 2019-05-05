package com.qunar.fxd.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class NumSubarrayProductLessThanK {


    public static void main(String[] args) {
        int arr[] = new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(arr, 100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int i = 0, j = 0;
        int product = 1;
        int res = 0;
        while (j < nums.length) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                ++i;
            }
            res += (j - i + 1);
            ++j;
        }
        return res;
    }



}
