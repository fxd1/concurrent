package com.qunar.fxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * 全排列
 * dfs
 * 回溯算法
 *
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        System.out.println(permute(nums));

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        permute(nums,0,lists);
        return lists;
    }

    public static void permute(int[] nums,int start,List<List<Integer>> lists) {
        if(start==nums.length-1){
            List<Integer> list=new ArrayList<>();
            for(int i = 0 ; i < nums.length;i++){
                list.add(nums[i]);
            }
            lists.add(list);
        }
        for(int i =start ; i < nums.length;i++){
            swap(nums,i,start);
            permute(nums,start+1,lists);
            swap(nums,i,start);
        }

    }

    private static void swap(int [] nums,int num, int num1) {
        int temp=nums[num];
        nums[num]=nums[num1];
        nums[num1]=temp;
    }
}
