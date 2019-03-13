package com.qunar.fxd.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i=0; i< nums.length; i++){
            if (nums[i] != val){
                nums[slow ++] = nums[i];
            }
        }
        return slow;
    }

    public static void main(String[] args) {

        int [] arr = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }


}
