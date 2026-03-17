package com.echo.javademo.arithmetic;

import junit.framework.Assert;


/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。

示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

 */
public class IsPalindrome {
    public static void main(String[] args) {
        Boolean flage = isPalindrome(121);
        Assert.assertTrue(flage);

    }

    public static boolean isPalindrome(int x) {
        // 负数判断
        if (Math.abs(x) != x) {
            return false;
        }

        // 转换成字符串，倒序
        String s = String.valueOf(x);
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            buffer.append(s.charAt(i));
        }
        return buffer.toString().equals(s);
    }
}
