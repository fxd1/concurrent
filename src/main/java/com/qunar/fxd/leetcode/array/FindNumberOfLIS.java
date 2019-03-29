package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * <p>
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,1,2,3,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 */
public class FindNumberOfLIS {


    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(arr));
    }

    public static int findNumberOfLIS(int[] nums) {

        int dp[] = new int[nums.length];//  当前0-i 的序列中的最大递增子序列的元素个数
        int count[] = new int[nums.length]; // 当前i序列中最大递增子序列的个数
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (count[i] == 0) {
                count[i] = 1;
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {

                        count[i] += count[j];
                    }
                }
            }

        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        int res = 0;
        for (int i = 0; i < count.length; i++) {

            if (dp[i] == max) {
                res += count[i];
            }


        }
        return res;
    }


}
