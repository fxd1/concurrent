package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 *
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
