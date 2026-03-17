package com.example.arithmetic;


/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 */
public class MyPowTest {
    public static void main(String[] args) {
        double x = 2;
        int n = 4;
        double result = myPow2(x, n);
        System.out.println(result);
    }

    public static double myPow3(double x, int n) {

        return Math.pow(x, n);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            result = result * x;
        }
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
//        return Math.pow(x, n);
    }


    public static double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * x;
        if (N % 2 == 0) {//n为偶数时
            return y * y;
        } else {
            return y * y * x;//n为奇数时，会
        }
    }

}
