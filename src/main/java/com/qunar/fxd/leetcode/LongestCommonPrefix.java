package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
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
