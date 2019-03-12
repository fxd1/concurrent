package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class reverseInt {

    public static int reverse(int x) {

        int res = 0;

        while (x !=0){
            int pop = x % 10;
            //Integer.MAX_VALUE - res*10 >m    res * 10就会溢出，导致数据不准确，仍然条件为true ，继续加。  所以应该在 inter 最大值 除以10
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop > -8)) return 0;
            res = res * 10 + pop;

            x= x/10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

}
