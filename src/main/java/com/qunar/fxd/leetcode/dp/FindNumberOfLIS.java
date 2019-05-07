package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * <p>
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 */
public class FindNumberOfLIS {


    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (count[i] == 0) {
                count[i] = 1;
            }
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }


        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dp[i], max);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
