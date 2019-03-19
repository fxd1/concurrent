package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 * 解题思路 ：
 * 动态规划
 * 将过程中的结果都保存下来
 * 当前的位置 等于 上边 的位置 与 左边位置的和
 *
 * 注意 边缘情况 ，提前将边缘 初始化
 */
public class UniquePaths {


    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {

        int arr[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n - 1; j++) {
                arr[i + 1][j + 1] = arr[i][j + 1] + arr[i + 1][j];
            }
        }
        return arr[m - 1][n - 1];
    }


}
