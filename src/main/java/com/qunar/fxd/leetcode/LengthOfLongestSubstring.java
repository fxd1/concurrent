package com.qunar.fxd.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }

    /**
     * 滑动窗口内表示的是 无重复的子字符串
     * i 表示 子字符串的起始地址   j为 子字符串的末尾的相邻下标
     * 判断j加入 子字符串 是否还是无重复的
     * 如果不是，则 i向右移动，知道符合子字符串位置  在此基础上，设置max
     * 记录每一个符合的子字符串的 大小
     * 最终 j遍历到 末尾，就求出 子字符串长度最长的
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <=1){
            return s.length();
        }

        List<Character> slide = new LinkedList<>();
        int i=0;

        int j=1;
        char[] chars  =s.toCharArray();
        slide.add(chars[0]);
        int max =0;
        while (j < s.length()){
            while (slide.contains(chars[j])){
                i++;
                ((LinkedList<Character>) slide).poll();
            }
            slide.add(chars[j]);
            max  =Math.max(max, j-i +1);
            ++j;

        }

        return max;
    }


}
