package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfit {


    public static void main(String[] args) {
        int arr[]= new int[]{7,6,4,3,1};

        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {


        int min = Integer.MAX_VALUE; //保留 0-i中 最小的值

        int max=  0;// 表示 1-i之间的最大的差值
        for (int i=0; i< prices.length;i++){

            if (min > prices[i]){
                min = prices[i];
            }else {
                 max = Math.max(prices[i] - min, max);
            }
        }
        return max;

    }

}
