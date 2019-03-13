package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {


    public int strStr(String haystack, String needle) {

        if (needle == null || "".equals(needle)){
            return 0;
        }

        return haystack.indexOf(needle);
    }


}
