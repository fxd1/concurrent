package com.qunar.fxd.leetcode.dp;

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

        int[] arr = new int[]{23, 2, 6, 4, 7};

        System.out.println(checkSubarraySum(arr, 12));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (k != 0 && sum % k == 0) {
                    if (j - i > 0) {
                        return true;
                    }
                }
                if (k == 0 && sum == k) {
                    if (j - i > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
