package com.qunar.fxd.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 定义一个 map  ，map来key表示 nums中连续累加的数组的和sum
 * value表示出现的次数
 *
 * sum-k 若在map中可以get到，那么表示 sum-k的此元素与 sum当前的元素 之间存在
 * 和为k的连续子数组。
 */
public class SubarraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }




    public static void main(String[] args) {
        int nums[] = new int[]{-1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }


}
