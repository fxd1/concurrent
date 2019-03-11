package com.qunar.fxd.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
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
