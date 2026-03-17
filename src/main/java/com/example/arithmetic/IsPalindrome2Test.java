package com.example.arithmetic;


import junit.framework.Assert;

/**
 * 125. 验证回文串
 * 简单
 * 相关标签
 * 相关企业
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class IsPalindrome2Test {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
//        String s = "race a car";
        boolean palindrome = isPalindrome(s);
        Assert.assertTrue(palindrome);
    }

    /*
    1.将所有大写字符转换为小写字符
    2.判断这个字符串是否是回文字符串
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();// a man, a plan, a canal: panama
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 97 && chars[i] <= 122 || chars[i] >= 48 && chars[i] <= 57) {
                buffer.append(chars[i]);
            }
        }
        // buffer :amanaplanacanalpanama
        boolean res = isPal(buffer.toString());
        return res == true ? true : false;
    }

    public static boolean isPal(String s) {
        int len = s.length();
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
