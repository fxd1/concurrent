package com.qunar.fxd.leetcode.operation;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                resBuilder.append(reps[i]);
            }
        }
        return resBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

}
