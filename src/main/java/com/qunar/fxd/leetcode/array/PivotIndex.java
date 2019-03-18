package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class PivotIndex {



    public int pivotIndex1(int[] nums) {


        int sum = 0;
        for(int i=0; i< nums.length; i++){
            sum+= nums[i];
        }

        int leftSum = 0;
        int rightSum = sum;

        for (int i=0; i<nums.length; i++){
            rightSum -= nums[i];

            if (leftSum == rightSum){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }


        /**
         * 暴力算法
         * @param nums
         * @return
         */
    public int pivotIndex(int[] nums) {

        for (int i=0; i< nums.length; i++){

            int left = 0;
            int right =0;
            int l = 0;
            while (l<i){
                left +=nums[l++];
            }
            int r = i+1;
            while (r < nums.length){
                right +=nums[r++];
            }
            if (left == right){
                return i;
            }
        }

        return -1;
    }


}
