package com.qunar.fxd.leetcode.dp;

import java.util.Arrays;

/**
 * 回文子序列
 *
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        String s="aaa";

        System.out.println(longestPalindromeSubseq(s));
    }

    /**
     * 先初始化 i=j，一个字符串的时候 长度为1
     * dp[i][j]表示 j-i之前的最长回文子序列的长度
     * 当i和j的值相等的时候， 如果i-j的差值小于2，则表示要么是同一个，，要么是相邻的，则相邻的也进行初始化为2.
     *
     * 当大于2时， dp[i][j]=dp[i-1][j+1] +2
     * 如果i和j的值不相等的话， 则取相邻的值，中取得最大值
     * dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {

        int len =s.length();

        int dp[][] = new int[len][len];

        for (int i=0; i< len ;i++){
            dp[i][i] = 1;
        }
        for (int i=0; i<len; i++){
            for (int j=i;j >=0; j--){
                if (s.charAt(i) == s.charAt(j)){
                    if (i-j >=2) {
                        dp[i][j] = dp[i - 1][j + 1] +2;
                    }else if (i!=j){
                        dp[i][j]=2;
                    }
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
                }
            }
        }

        for (int[] d: dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[len-1][0];
    }



}
