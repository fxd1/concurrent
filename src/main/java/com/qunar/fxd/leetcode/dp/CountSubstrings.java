package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 回文子字符串
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class CountSubstrings {

    public int countSubstrings(String s) {

        int res = 0;
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        //dp[i][j]表示 i-j之间的子字符串 是否是回文字符串
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    ++res;
                    dp[i][j] = true;
                }
            }
        }

        return res;
    }


}
