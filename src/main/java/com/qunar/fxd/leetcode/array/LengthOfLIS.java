package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int arr[] = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // 当前下标的最大递增子序列 的个数
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] ==0){
                dp[i] =1;
            }
            for (int j = 0; j <i ; j++) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }


}
