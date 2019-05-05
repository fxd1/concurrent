package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 */
public class CountAndSay {


    public static void main(String[] args) {

        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {

        String res= "1";
        for (int i=1; i<n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String s = res;
            int cur = 0;
            while (cur < s.length()) {
                char c = s.charAt(cur);
                int temp = cur + 1;
                while (temp < s.length() && s.charAt(temp) == c) {
                    ++temp;
                }
                stringBuilder.append(temp - cur);
                stringBuilder.append(c);
                cur = temp;
            }
            res = stringBuilder.toString();
            System.out.println(res);
        }

        return res;
    }



}
