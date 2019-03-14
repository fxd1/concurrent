package com.qunar.fxd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        combinationSum(arr, 7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates, 0, 0, target, list, res);

        System.out.println(res);
        return null;
    }



    private static void back(int arr[], int index, int num, int target, List<Integer> list, List<List<Integer>> result) {

        if (num > target) {
            return;
        }
        if (num == target) {
            result.add(list);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(arr[i]);
            back(arr, i, num + arr[i], target, temp, result);
        }
    }
}
