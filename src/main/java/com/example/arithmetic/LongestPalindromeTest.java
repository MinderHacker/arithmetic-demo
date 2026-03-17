package com.example.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 18/9/2023 5:03 pm
 */

/**
 * 5. 最长回文子串
 * 提示
 * 中等
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindromeTest {
    public static void main(String[] args) {
//        String s = "baacabad";
//        String s = "bb";
        String s ="babad";
        String longestPalindrome = longestPalindrome2(s);
        System.out.println(longestPalindrome);
    }


    /*
    1.判断是否是回文字符串
    2.取最长的。 max = Math.max(max,str.length)
     */

    // 暴力破解：
    // 1.列举所有的子字符串，判断是否是回文字符串，保存最长的回文字符串
    private static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int max = 0;
        String ans = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length() > max) {
                    max = Math.max(substring.length(), max);
                    ans = substring;
                }
            }
        }
        return ans;
    }

    // 判断是否是回文字符串 abccba
    private static Boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    // 时间复杂度 n*n*n
    private static String longestPalindrome2(String s) {
        if (s.length() <= 1) return s;
        // 获取所有字符串  abcBC
        int max = 0;
        String maxLengthStr = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                Boolean ispPalindrome = isPalindrome2(substring);
                if (ispPalindrome && substring.length() > max) {
                    maxLengthStr = substring;
                    max = Math.max(max, substring.length());
                }
            }
        }
        return maxLengthStr;
    }

    private static Boolean isPalindrome2(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
