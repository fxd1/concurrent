package com.qunar.fxd.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int maxdp[] = new int[nums.length];
        int mindp[] = new int[nums.length];
         mindp[0] = nums[0];
         maxdp[0] = nums[0];
        int res = nums[0];
        for (int i=1; i< nums.length; i++){
            int min = mindp[i-1] * nums[i];
            int max = maxdp[i-1] * nums[i];
            maxdp[i] = Math.max(Math.max(max, min), nums[i]);
            mindp[i] = Math.min(Math.min(max, min), nums[i]);

            res = Math.max(maxdp[i], res);
        }

        return res;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}
