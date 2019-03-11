package com.qunar.fxd.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = k; j < sum; j =  k * k) {
                int temp = sum - j;
                if (temp == 0) {
                    return true;
                }
                if (temp > 0) {
                    if (map.containsKey(temp)){
                        return true;
                    }
                }

            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return false;
    }


}
