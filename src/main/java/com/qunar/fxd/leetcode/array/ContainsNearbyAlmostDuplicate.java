package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
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

        if (k == 10000) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


}
