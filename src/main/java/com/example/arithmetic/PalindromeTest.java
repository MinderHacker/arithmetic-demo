package com.echo.javademo.arithmetic;


/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class PalindromeTest {
    public static void main(String[] args) {
        int x = 101;
        boolean result = isPalindrome(x);
        System.out.println("x是回文数吗：" + result);

    }

    // 直接反转字符串比较
//    private static boolean isPalindrome(int x) {
//        // 小于零则不可能是回文数字
//        if (x<0){
//            return false;
//        }
//
//        String s1 = String.valueOf(x);
//        //字符串反转
//        String s2 = new StringBuilder(s1).reverse().toString();
//        if (s1.equals(s2)) {
//            return true;
//        }
//        return false;
//    }


    // 单个字符进行比较
    private static boolean isPalindrome(int x) {
        // 小于零则不可能是回文数字
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
           if (chars[i] == chars[chars.length-1-i]){
               return true;
           }else {
               return false;
           }
        }
        return false;
    }
}
