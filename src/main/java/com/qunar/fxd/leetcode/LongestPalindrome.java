package com.qunar.fxd.leetcode;

import com.google.common.base.Strings;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (Strings.isNullOrEmpty(s)) {
            return s;
        }
        int len = s.length();
        String arr[] = new String[len];


        final char[] chars = s.toCharArray();
        arr[0] = "";
        for (int i = 1; i < len; i++) {
            String temp = arr[i - 1];
            if (i - temp.length() - 1 >= 0 && (chars[i - temp.length() - 1] == chars[i])) {
                arr[i] = chars[i - temp.length() - 1] + arr[i - 1] + chars[i];
            } else {
                arr[i] = "";
            }
        }
        return arr[len - 1];
    }

    // 暴力求解
    public static String longestPalindrome(String s) {

        String res = null;
        if (s.length() <= 1) {
            return s;
        }
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                strings.add(substring);
            }
        }

        System.out.println(strings);
        for (String ss : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = ss.length() - 1; i >= 0; i--) {
                stringBuilder.append(ss.charAt(i));
            }
            String s1 = stringBuilder.toString();
            if (s1.equals(ss)) {
                if (res == null || res.length() < ss.length()) {
                    res = ss;
                }
            }
        }

        return res;
    }


}
