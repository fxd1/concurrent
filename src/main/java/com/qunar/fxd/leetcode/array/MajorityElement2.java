package com.qunar.fxd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 *
 *
 */
public class MajorityElement2 {


    public static void main(String[] args) {
        int arr[] = new int[]{3,2,3};
        System.out.println(majorityElement(arr));
    }

    /**
     * 由于题目限制了运行时间和运行空间，导致这道题非常有技巧性，由题目中给出的答案需要大于数组长度的1/3所以可以推断结果集的长度必定小于3。由此可以联想到多数投票算法，将两个数字设为候选数，遍历一遍数组确定这两个候选数，再遍历一遍数组确定这两个候选数是否是满足题目要求的
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {


        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == r1){
                c1++;
            }else if(nums[i] == r2){
                c2++;
            }else if(c1 == 0){
                r1 = nums[i];
                c1++;
            }else if(c2 == 0){
                r2 = nums[i];
                c2++;
            }else{
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == r1){
                c1++;
            }else if(nums[i] == r2){
                c2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(c1 > nums.length/3){
            res.add(r1);
        }

        if(c2 > nums.length/3){
            res.add(r2);
        }

        return res;

    }


}
