package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {

        int arr[][] = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 0){
            return 0;
        }
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];

        int m=obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i=0; i< m;i++){
            if (obstacleGrid[i][0] ==0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i=0; i< n;i++){
            if (obstacleGrid[0][i] ==0) {
                dp[0][i] = 1;
            }else {
                break;
            }
        }

        for (int i=0; i< m-1; i++ ){
            for (int j=0; j<n-1; j++){
                if (obstacleGrid[i+1][j+1] ==0){
                    dp[i+1][j+1] = dp[i][j+1] +dp[i+1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }


}
