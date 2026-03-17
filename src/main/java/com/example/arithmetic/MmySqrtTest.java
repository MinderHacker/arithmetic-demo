package com.example.arithmetic;

/*
69. x 的平方根
简单
相关标签
相关企业
提示
给你一
由于返回类型是整数，结果只保个非负整数 x ，计算并返回 x 的 算术平方根 。留 整数部分 ，小数部分将被 舍去 。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

示例 1：
输入：x = 4
输出：2

示例 2：
输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

 */
public class MmySqrtTest {
    public static void main(String[] args) {
        int x =6;
        int res = mySqrt(x);
        System.out.println(res);
    }

    // 二分法
    public static int mySqrt(int x) {
        //特殊值判断
        if (x == 1 || x == 0) return x;

        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left ) / 2;
            if (mid > x / mid) {//m*m>x
                // 下次搜索范围(left ,mid-1)
                right = mid - 1;
            } else if (mid < x / mid) {
                // 下次搜索范围(mid +1,right)
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

//    public static long mySqrt2(long x) {
//        if (x == 1) return 1;
//        for (long i = x / 2; i >= 1; i--) {
//            if (i * i <= x) return i;
//        }
//        return (long) 0;
//    }

//    class Solution {
//        public int mySqrt(int x) {
//            if(x == 0 || x == 1){
//                return x;
//            }
//            int left = 1;
//            int right = x;
//            while(left <= right){
//                int mid = (left + right) >>> 1; //移位操作
//                if(x/mid < mid){
//                    right = mid - 1;
//                }else if(x/mid > mid){
//                    left = mid + 1;
//                }else{
//                    return mid;
//                }
//            }
//            return right;
//        }
//    }


}
