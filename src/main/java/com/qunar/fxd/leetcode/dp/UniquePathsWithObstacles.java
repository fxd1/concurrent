package com.qunar.fxd.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][]= new int[m][n];
        for (int i=0; i<m;i++){
            if (obstacleGrid[i][0] ==0){
                dp[i][0]= 1;
            }else {
                break;
            }
        }
        for (int i=0; i<n;i++){
            if (obstacleGrid[0][i] ==0){
                dp[0][i]= 1;
            }else {
                break;
            }
        }
        for (int i=1; i<m;i++){
            for (int j=1; j< n; j++){
                if (obstacleGrid[i][j] == 0){
                    if (obstacleGrid[i-1][j] !=0  && obstacleGrid[i][j-1] ==0){
                        dp[i][j] =dp[i][j-1];
                    }else if (obstacleGrid[i-1][j] ==0  && obstacleGrid[i][j-1] !=0){
                        dp[i][j] =dp[i-1][j];
                    }else {
                        dp[i][j] =dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }



}
