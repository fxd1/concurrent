package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortLIst {


    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m-- + n-- - 1;
        while (m >=0 && n >=0) {
            nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }

    }
}
