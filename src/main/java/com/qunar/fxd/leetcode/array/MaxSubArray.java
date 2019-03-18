package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {


    /**
     * 动态规划
     * 从头至尾遍历
     *
     * 当 sum小于0 时候，加下一个元素，不管下一个元素正负，肯定会更小。 反而不如下一个元素一个的和大
     * 所以 当sum小于0 的时候，就重新开始累计和
     * 若大于0，则加下一个。
     * sum表示的就是 所有的连续子数组的和
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {


        int sum = nums[0];
        int max = nums[0];
        for (int i=1; i< nums.length; i++){

           if(sum <0){
               sum = nums[i];
           }else {
               sum += nums[i];
           }
            max = Math.max(sum, max);

        }

        return max;
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i=0; i< nums.length-1; i++){

            int sum =0;
            for (int j=i; j<nums.length; j++){
                sum +=nums[j];
                max = Math.max(sum, max);

            }
        }

        return max;
    }


}
