package com.qunar.fxd.leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀
 *
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"aaa", "aa", "flight"};
        System.out.println(longestCommonPrefix(ss));

    }

}
