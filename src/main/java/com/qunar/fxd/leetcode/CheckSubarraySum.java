package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class CheckSubarraySum {

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

    public static void main(String[] args) {
        int arr[] = new int[]{23, 2, 0, 0, 7};
        System.out.println(checkSubarraySum(arr, 0));
    }


}
