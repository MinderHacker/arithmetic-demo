package com.example.arithmetic;


import jnr.ffi.annotations.In;

/**
 * 62. 不同路径
 * 中等
 * 相关标签
 * 相关企业
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class UniquePathsTest {
    public static void main(String[] args) {
        int m = 7, n = 3;
        int paths = uniquePaths(m, n);
        System.out.println(paths);
    }

    /*
    ：动态规划

    我们令 dp[i][j] 是到达 i, j 最多路径
    动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
    注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1

    时间复杂度分析： 代码中有三层嵌套循环，其中外层两层循环的次数分别为m和n，因此循环体总的执行次数为 O(m * n)。
    尽管内部循环有依赖于外部循环变量的情况，但每个格子只被计算一次，所以总的时间复杂度依然是 O(m * n)。
    空间复杂度分析： 代码中定义了一个m行n列的二维数组dp用于存储中间结果，因此空间复杂度为 O(m * n)。
    这里的空间复杂度主要取决于输入参数m和n的大小，即网格的维度。

    总结：
    时间复杂度：O(m * n)  mxn+m+n
    空间复杂度：O(m * n)
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
