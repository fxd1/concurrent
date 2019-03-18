package com.qunar.fxd.leetcode.array;

import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {

        int arr[]=new int[]{0,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 2147483647));
    }

    /**
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length == 0 || k < 1) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling((long)nums[i] - (long)t) != null && set.ceiling((long)nums[i] -(long) t) <= ((long)nums[i] + (long)t))
                return true;
            if (set.size() >= k ) {
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);

        }
        return false;
    }


}
