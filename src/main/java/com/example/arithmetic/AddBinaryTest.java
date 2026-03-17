package com.example.arithmetic;


/*
67. 二进制求和
简单
相关标签
相关企业
给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

示例 1：
输入:a = "11", b = "1"
输出："100"

示例 2：
输入：a = "1010", b = "1011"
输出："10101"

 */
public class AddBinaryTest {
    public static void main(String[] args) {
        String a = "11", b = "1";
        String res = addBinary(a, b);
        System.out.println(res);
    }

    //最朴素的方法：先将 aaa 和 bbb 转化成十进制数，求和后再转化为二进制数。
    public static String addBinary(String a, String b) {
        int i = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        return Integer.toBinaryString(i);
    }
}
