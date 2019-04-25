package com.qunar.fxd.leetcode.dp;

import java.util.Arrays;

/**
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <p>
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * <p>
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 */
public class CheckSubarraySum {


    public static void main(String[] args) {

        int []arr = new int[]{23,2,6,4,7};

        System.out.println(checkSubarraySum(arr, 12));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] % k ==0 || (dp[i - 1] + nums[i]) % k ==0) {
                return true;
            }
            if ((dp[i - 1] + nums[i]) % k ==0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
        }

        System.out.println(Arrays.toString(dp));
        return false;
    }


}
