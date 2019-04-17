package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 *输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {

        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            if (prices[i] - minPrice >maxPrice){
                maxPrice = prices[i] -minPrice;
            }
        }
        return maxPrice;
    }


}
