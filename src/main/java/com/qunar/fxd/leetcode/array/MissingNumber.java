package com.qunar.fxd.leetcode.array;

/**
 *
 * https://leetcode-cn.com/problems/missing-number/
 */
public class MissingNumber {


    /**
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int sum = nums.length;
        for (int i=0; i< nums.length; i++){
            sum ^= nums[i];
            sum ^=i;
        }

        return sum;
    }


        /**
         * 所有元素 加和， 求差值 为 缺失的数字
         * @param nums
         * @return
         */
    public int missingNumber(int[] nums) {

        int sum = 0;
        for(int i=0; i< nums.length; i++){
            sum+=nums[i];
        }

        int s = 0;
        for(int i=1; i<=nums.length; i++){
            s+=i;
        }
        return s-sum;
    }

}
