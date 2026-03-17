package com.example.arithmetic;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class MinPathSumTest {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minPathSum = minPathSum2(grid);
        System.out.println(minPathSum);
    }

    /*
       每个元素对应的最小路径和即为对应的路径上的数字总和。

       时间复杂度：mxn+m+n
       空间复杂度：mxn
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];//前面路径的和加上当前坐标的值，为当前坐标的新值
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }


    //https://leetcode.cn/problems/minimum-path-sum/

    private static int M;
    private static int N;
    private static int[][] memo;

    //dfs + 记忆
    public static int minPathSum2(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(grid, 0, 0);
    }

    private static int dfs(int[][] grid, int r, int c) {
        //若越界，则认为不可达，距离为无穷大
        if (r < 0 || r >= M || c < 0 || c >= N) return Integer.MAX_VALUE;
        if (memo[r][c] > -1) return memo[r][c];
        //若到达终点，终点的贡献值是其本身
        if (r == M - 1 && c == N - 1) return grid[M - 1][N - 1];
        //右边的点到终点最短的路径
        int right = dfs(grid, r, c + 1);
        //下面的点到终点的最短路径
        int down = dfs(grid, r + 1, c);
        //取两者的较小值，计算出当前点的最小路径值
        int ans = Math.min(right, down) + grid[r][c];
        memo[r][c] = ans;
        return ans;
    }
}
