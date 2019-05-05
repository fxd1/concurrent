package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 */
public class FindLengthOfLCIS {


    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(arr));
    }


    public static int findLengthOfLCISDp2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int max = 0;
        int k=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                ++k;
                max = Math.max(max, k);
            }else{
                k=1;
            }
        }
        return max;


    }

    public static int findLengthOfLCISDp1(int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] += dp[i - 1];
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < nums.length) {
            while (j < nums.length - 1 && nums[j] < nums[j + 1]) {
                ++j;
            }
            max = Math.max(max, j - i + 1);
            i = j + 1;
            j = i;
        }
        return max;
    }

}
