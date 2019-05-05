package com.qunar.fxd.leetcode.operation;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去
 * <p>
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {


    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        if (x == 0 || x == 1) return x;
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid == x / mid) return mid;
            if (x / mid > mid) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }


    /**
     * 牛顿迭代法
     */

    public int mySqrt1(int x) {
        if (x == 0 || x == 1) return x;
        long res = x;
        while (res > (x / res)) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

}
