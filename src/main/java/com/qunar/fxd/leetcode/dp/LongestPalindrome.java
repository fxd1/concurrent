package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/comments/
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {


    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 初始化  长度为1和 长度为2且相邻的相等的字符 ，初始化为 子字符串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
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


}
