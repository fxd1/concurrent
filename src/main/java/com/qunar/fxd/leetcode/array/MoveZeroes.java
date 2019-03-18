package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
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
