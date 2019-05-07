package com.qunar.fxd.leetcode;

import com.google.common.base.Strings;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 *
 *
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
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ;i < n; i++){
            for (int j=i; j>=0; j--){
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && i-j+1 > res.length() ){
                    res = s.substring(j, i+1);
                }
            }
        }
        return res;
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
