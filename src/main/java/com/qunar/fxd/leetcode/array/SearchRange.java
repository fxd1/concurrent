package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {

        int []arr = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }
    public static int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length -1;
        int mid =-1;
        int left =-1;
        int right = -1;
        while (low <= high){
            mid = low + ((high -low) >>1);
            if (nums[mid] > target){
                high = mid-1;
            }else if (nums[mid] < target){
                low = mid+1;
            }else {
                left = mid;
                right = mid;
                while (left>0 && nums[left-1] == target){
                    --left;
                }
                while (right<nums.length-1 && nums[right+1] == target){
                    ++right;
                }
                return new int[]{left, right};
            }
        }
        return new int[]{left, right};
    }



}
