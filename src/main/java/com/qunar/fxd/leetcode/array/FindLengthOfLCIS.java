package com.qunar.fxd.leetcode.array;

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
