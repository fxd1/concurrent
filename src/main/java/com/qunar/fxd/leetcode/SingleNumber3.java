package com.qunar.fxd.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 */
public class SingleNumber3 {


    public static int[] singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet();
        int res[] = new int[2];
        for (int n: nums){
            if (!set.contains(n)){
                set.add(n);
            }else {
                set.remove(n);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        int index =0;
        while (iterator.hasNext()){
            Integer next = iterator.next();
            res[index ++] =next;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));

    }


}
