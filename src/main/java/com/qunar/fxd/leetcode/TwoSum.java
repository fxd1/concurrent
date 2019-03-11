package com.qunar.fxd.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>(nums.length);


        for (int i = 0; i < nums.length; i++) {
            int subtract = target - nums[i];
            if (map.containsKey(subtract)){
                return new int[]{map.get(subtract), i};
            }
            map.put(nums[i], i);
        }

        return nums;
    }



    public static void main(String[] args) {


    }
}
