package com.qunar.fxd.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {


    public static void main(String[] args) {
        int arr[] = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arr));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i< nums.length-2; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int sum = 0 - nums[i];
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        --l;
                        ++l;
                        --r;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值

                        ++l;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        --l;
                    }
                }
            }
        }

        return res;
    }

        /**
         * 暴力 无法 去重
         * @param nums
         * @return
         */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = Lists.newArrayList();
        for (int k=0; k< nums.length-2; k++) {
            for (int j = k+1; j < nums.length - 1; j++) {
                for (int i = j + 1; i < nums.length; i++) {
                    if (nums[k] + nums[j] + nums[i] == 0) {
                        res.add(Lists.newArrayList(nums[k], nums[j], nums[i]));
                    }
                }
            }
        }

        return res;

    }


}
