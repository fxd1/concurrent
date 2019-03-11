package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mulit = 1;
            int left = 0;
            int right = nums.length - 1;
            while (left < i) {
                mulit *= nums[left++];
            }
            while (right > i) {
                mulit *= nums[right--];
            }
            res[i] = mulit;
        }
        return res;
    }



}
