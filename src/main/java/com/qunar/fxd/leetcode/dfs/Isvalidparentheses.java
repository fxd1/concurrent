package com.qunar.fxd.leetcode.dfs;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 有多种括号的 ，不能用计数的方式，进行左括号加1  右括号减少1， 一旦小于0，则false。 或者最后不为0 也false
 *
 * 因为有多种括号 所有 {[}]  这种情况仍然会是 true  导致错误
 *
 * 用栈的方式 ，每一次拿 栈顶元素 和当前元素相比，如果是 一对 ，则进行pop。  否则将元素压入栈
 *
 */
public class Isvalidparentheses {

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack   = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()){
                stack.push(chars[i]);
            }else {
                char pop = stack.peek();
                if (pop == '{' && chars[i] =='}'){
                    stack.pop();
                }else if (pop == '(' && chars[i] ==')'){
                    stack.pop();
                }else if (pop == '[' && chars[i] ==']'){
                    stack.pop();
                }else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

}
