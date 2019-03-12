package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class romanToInt {

    public static int romanToInt(String s) {

        final char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i + 1 < chars.length) && chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                sum += toInt(chars[i + 1]) - toInt(chars[i]);
                ++i;
            } else if ((i + 1 < chars.length) && chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                sum += toInt(chars[i + 1]) - toInt(chars[i]);
                ++i;
            } else if ((i + 1 < chars.length) && chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                sum += toInt(chars[i + 1]) - toInt(chars[i]);
                ++i;
            } else {
                sum += toInt(chars[i]);
            }
        }
        return sum;
    }

    private static int toInt(char ch) {
        int res = 0;
        switch (ch) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

}
