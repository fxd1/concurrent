package com.qunar.fxd.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i=0; i< nums.length; i++){
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else {
                return true;
            }
        }

        return false;
    }


}
