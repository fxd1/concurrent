package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *
 * 最大乘积
 * 需要有两个dp
 * 一个保存子数组中 当前的最小值  ，一个保存最大值
 * 因为最小值 乘以负数，很有可能变成了最大值
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int maxDp[] = new int[nums.length];
        int minDp[] = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxDp[i - 1] * nums[i];
            int min = minDp[i - 1] * nums[i];
            maxDp[i] = Math.max(Math.max(max, min), nums[i]);
            minDp[i] = Math.min(Math.min(max, min), nums[i]);
            res = Math.max(res,  maxDp[i]);
        }
        return res;
    }


}
