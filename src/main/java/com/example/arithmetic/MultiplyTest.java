package com.echo.javademo.arithmetic;


import java.math.BigInteger;

/**
 * 字符串相乘
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class MultiplyTest {
    public static void main(String[] args) {
        String num1 = "2", num2 = "3";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }

    public static String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();

    }
}
