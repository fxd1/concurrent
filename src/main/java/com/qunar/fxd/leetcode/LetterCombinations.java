package com.qunar.fxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

 */
public class LetterCombinations {
    /**
     * 回溯算法    dfs
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if ("".equals(digits)){
            return list ;
        }
        String[] patterns = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
                "wxyz"};

        getCombinations(digits, 0, "", list, patterns);
        return list;
    }


    private static void getCombinations(String digits, int index, String form, List<String> res, String[] patterns) {
        if (index == digits.length()) {
            res.add(form);
            return;
        }
        String s = patterns[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            getCombinations(digits, index + 1, form + s.charAt(i), res,patterns);
        }
    }
}

