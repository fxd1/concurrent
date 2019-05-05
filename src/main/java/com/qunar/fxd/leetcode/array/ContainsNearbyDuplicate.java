package com.qunar.fxd.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 */
public class ContainsNearbyDuplicate {

    /**
     * 滑动窗口
     * <p>
     * 利用hash表作为滑动窗口   ， 窗口的大小为k
     * 遍历数组，
     * 当滑动窗口中包含下一个元素而的时候  说明在k范围之内有重复元素
     * 当滑动窗口小于k时  直接add
     * 如果等于k，则先remove掉 i-k元素，然后再加上i元素
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        if (k <= 0) {
            return false;
        }
        Set<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (hash.contains(nums[i])) {
                return true;
            } else {
                if (hash.size() < k) {
                    hash.add(nums[i]);
                } else {
                    hash.remove(nums[i - k]);
                    hash.add(nums[i]);
                }
            }
        }

        return false;

    }

    /**
     * 暴力算法
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {


        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j < nums.length && nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }

        return false;
    }



}
