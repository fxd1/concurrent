package com.qunar.fxd.leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum2 {

    public static void main(String[] args) {

        int arr[] = new int[]{2, 3, 4};

        System.out.println(twoSum1(arr, 6));
    }

    public static int[] twoSum1(int[] numbers, int target) {


        int l=0;
        int r = numbers.length- 1;

        int sum = 0;
        while (l <r){

            sum = numbers[l] + numbers[r];
            if (sum  > target){
                --r;
            }else if (sum < target){
                ++l;
            }else {
                return new int[]{l+1, r+1};
            }

        }
        return null;


    }

    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i + 1);
            }
        }


        return null;
    }


}
