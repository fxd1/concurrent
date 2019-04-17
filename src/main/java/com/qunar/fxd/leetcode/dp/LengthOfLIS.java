package com.qunar.fxd.leetcode.dp;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {

    /**
     * dp[i] 表明的是i下标之前的元素中，最长的上升子序列。
     * dp[i]是 i之前的 元素的dp[j]+1 ，各个中的最大值作为dp[i]的值
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int dp[]=new int[len];
        for (int i=0; i< len; i++){
            if (dp[i] ==0){
                dp[i]=1;
            }
            for (int j=0; j<=i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        int res=0;
        for (int i=0; i< dp.length; i++){
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
