package com.echo.javademo.arithmetic;


/**
 * 题目描述
 * 给定 n 节台阶，每次可以走一步或走两步，求一共有多少种方式可以走完这些台阶。
 * 输入输出样例
 * 输入是一个数字，表示台阶数量；输出是爬台阶的总方式。
 */
public class ClimbStairsTest {
    public static void main(String[] args) {
        int i = climbStairs(100);
        System.out.println(i);
    }

    /**
     * 斐波那契数列题
     * 可以通过归纳法总结出规律
     * @param n 台阶数
     * @return
     */
    public static int climbStairs(int n ){
        // 台阶数<=2
        if (n <=2) return n;

        int cur = 0,pre2=1,pre1=2;
        for (int i = 2; i < n; i++) {
            cur = pre1+pre2;
            pre2= pre1;
            pre1 = cur;
        }
        return cur;
    }
}
