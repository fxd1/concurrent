package com.qunar.fxd.leetcode.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit2 {


    /**
     * 峰谷法
     * 不要跳过一个峰 ，因为是不可能可以 去获得更多的利润，
     * <p>
     * 如果我们分析图表，那么我们的兴趣点是连续的峰和谷。
     * <p>
     * 用数学语言描述为： Total Profit= \sum_{i}(height(peak_i)-height(valley_i)) TotalProfit=∑
     * i
     * ​
     * (height(peak
     * i
     * ​
     * )−height(valley
     * i
     * ​
     * ))
     * <p>
     * 关键是我们需要考虑到紧跟谷的每一个峰值以最大化利润。如果我们试图跳过其中一个峰值来获取更多利润，那么我们最终将失去其中一笔交易中获得的利润，从而导致总利润的降低。
     * <p>
     * 例如，在上述情况下，如果我们跳过 peak_ipeak
     * i
     * ​
     * 和 valley_jvalley
     * j
     * ​
     * 试图通过考虑差异较大的点以获取更多的利润，获得的净利润总是会小与包含它们而获得的静利润，因为 CC 总是小于 A+BA+B。
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int peek = 0;
        int min = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i + 1 < prices.length && prices[i] > prices[i + 1]) {
                i++;
            }
            min = prices[i];
            while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                i++;
            }
            peek = prices[i];
            sum += peek - min;
        }
        return sum;
    }

    /**
     * 方法三：简单的一次遍历
     * 算法
     * <p>
     * 该解决方案遵循 方法二 的本身使用的逻辑，但有一些轻微的变化。在这种情况下，我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值。最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。这种方法将简化解决方案。 这个例子可以更清楚地展现上述情况：
     * <p>
     * 从上图中，我们可以观察到 A+B+CA+B+C 的和等于差值 DD 所对应的连续峰和谷的高度之差     * @param prices
     */
    public int maxProfit1(int[] prices) {

        int max = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }


}
