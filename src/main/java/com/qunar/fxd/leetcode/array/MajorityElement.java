package com.qunar.fxd.leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 */
public class MajorityElement {


    /**
     * 摩尔投票fa
     * 先假设result是第一个数，然后从第二个数开始遍历，遇见相同的就+1，不同的就-1，如果count==0，就result赋值为下一个数，接着遍历，最后result的值 就是结果。该方法的思想是众数一定比其他所有的数加起来的数量要多，就算是众数与其他每一个数相抵消，最后剩下来的也是众数。况且还有其他数之间的抵消，所以剩下来的一定是众数。
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {

        int count = 0;
        int res = 0;
        for (int i=0; i<nums.length; i++){

            if (count ==0){
                res = nums[i];
                ++count;
            }else {
                if (res == nums[i]){
                    ++count;
                }else {
                    --count;
                }
            }
        }

        return res;
    }


        public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (maxCount < map.get(nums[i])){
                maxValue = nums[i];
                maxCount = map.get(nums[i]);
            }
        }

        return maxValue;

    }


}
