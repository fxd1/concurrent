package com.qunar.fxd.leetcode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 动态规划
     * @param s
     * @return
     */
//    public static String longestPalindrome1(String s) {
//
//
//    }
        // 暴力求解
    public static String longestPalindrome(String s) {

        String res =null;
        if (s.length() <=1){
            return s;
        }
         HashSet<String> strings = new HashSet<>();
        for (int i=0; i< s.length()-1; i++){
            for (int j=i+1; j<= s.length(); j++){
                String substring = s.substring(i, j);
                strings.add(substring);
            }
        }

        System.out.println(strings);
        for (String ss : strings){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = ss.length() -1 ; i>=0; i--){
                stringBuilder.append(ss.charAt(i));
            }
            String s1 = stringBuilder.toString();
            if (s1.equals(ss)){
                if (res ==null || res.length() < ss.length()){
                    res = ss;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s ="bb";
        System.out.println(longestPalindrome(s));
    }
}
