package com.qunar.fxd.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class PlusOne {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {

        int[]res =new int[digits.length];
        int s = digits[digits.length-1] +1;
        int temp = s / 10;
        res[digits.length-1] = s%10;
        for(int i=digits.length-2; i>=0; i--) {
            res[i] = digits[i] + temp;
            temp = res[i]/10;
            res[i] = res[i]%10;
        }
        if (temp > 0){
            int[] ints = new int[digits.length+1];

            for (int i=1; i<ints.length;i++){
                ints[i] = res[i-1];
            }
            ints[0] = temp;
            return ints;
        }
        return res;
    }


}
