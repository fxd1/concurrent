package com.qunar.fxd.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/comments/
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int fast = 0;
        int slow = 0;
        for (fast =1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,1};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

    }
}
