package com.qunar.fxd.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/solution/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        back(0, 0, "", n, res);

        return res;
    }

    private void back(int open, int close, String cur, int n, List<String> res) {

        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (open < n) {
            back(open + 1, close, cur + "(", n, res);
        }
        if (open > close) {
            back(open, close + 1, cur + ")", n, res);
        }
    }


    public static void main(String[] args) {
        String s = "()";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch != trans(stack.pop())) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static char trans(char ch1) {

        if (ch1 == '(') {
            return ')';
        } else if (ch1 == '{') {
            return '}';
        } else if (ch1 == '[') {
            return ']';
        }
        return ch1;
    }
}
