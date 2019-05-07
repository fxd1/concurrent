package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 *
 *
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 *
 */
public class MoveZeroes {


    public static void main(String[] args) {
        int arr[] =new int[]{0,1,0,3,12};

        moveZeroes1(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void moveZeroes1(int[] nums) {

        int i = 0;
        int j = 0;

        while (j < nums.length){

            if (nums[j] !=0){
                nums[i++] = nums[j];
            }
            j++;
        }

        while (i<nums.length){
            nums[i++] = 0;
        }
    }


    public static void moveZeroes(int[] nums) {

        int i = 0;
        int j = nums.length -1;

        while (i <j){

            while (j>0&& nums[j] ==0 ){
                --j;
            }

            while (i<nums.length && nums[i] != 0){
                ++i;
            }

            if (i <j){
                for (int k=i;k<j;k++){
                    nums[k] = nums[k+1];
                }
                nums[j] = 0;
            }
        }
    }


}
