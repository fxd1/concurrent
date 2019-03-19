package com.qunar.fxd.leetcode.array;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {


    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minPathSum(arr));
    }
    public static int minPathSum(int[][] grid) {

        if (grid.length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < m - 1; i++) {
            dp[i + 1][0] = dp[i][0] + grid[i + 1][0];
        }

        for (int i = 0; i < n - 1; i++) {
            dp[0][i + 1] = dp[0][i] + grid[0][i + 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }

}
