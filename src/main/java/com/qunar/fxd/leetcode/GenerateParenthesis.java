package com.qunar.fxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {


    /**
     * 解题思路：根据题意，我们需要找出满足()形式的组合，第一想法是遍历出所有情况，然后再一个个验证，也就是有2^2n种可能
     * <p>
     * 但是明显这样效率太低，我们可以想想哪些才是符合条件的，比如第一个肯定得是'('，第二个可以是）,也可以是'('
     * <p>
     * 如果第二个是）,那么第三个只能是'(',因为"())"明显错误
     * <p>
     * 所以我们可以总结出，当'('和')'出现次数相同时，下一个只能是(,当'('多于')'时，下一个可以是'(',也可以是')'
     * <p>
     * 因此我们在写递归的时候，就把这两个条件加进去就可以
     */
    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        backList(res, "", 0, 0, n);
        return res;
    }


    private static void backList(List<String> res, String cur, int open, int close, int max) {

        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backList(res, cur + "(", open + 1, close, max);
        }
        if (open > close) {
            backList(res, cur + ")", open, close + 1, max);
        }
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
