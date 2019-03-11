package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {

        int res = 0;
        for (int i=0; i< nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,2,2,3,3,4};
        System.out.println(singleNumber(arr));
    }





}
