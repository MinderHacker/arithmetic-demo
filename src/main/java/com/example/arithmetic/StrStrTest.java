package com.echo.javademo.arithmetic;


/*
 找出字符串中第一个匹配项的下标
中等
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
如果 needle 不是 haystack 的一部分，则返回  -1 。

示例 1：
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。

示例 2：
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class StrStrTest {
    public static void main(String[] args) {
        String haystack = "abscsadbutsad";
        String needle = "sad";
//        String haystack = "abscsdbutszad";
//        String haystack = "sad";
//        String needle = "d";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }

    /**
     * 思路：
     * 1.先找出haystack中与needle第一个字符相等的位置
     * 2.判断这个位置后面长度为needle.length的子字符串是否与needle相同
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        // 入参校验
        if (haystack.length() == 0
                || needle.length() == 0
                || haystack.length() < needle.length()
                || !haystack.contains(needle)
        ) return -1;

        char c = needle.charAt(0);
        for (int j = 0; j <= haystack.length() - needle.length(); j++) {
            if (haystack.charAt(j) == c) {
                String subHaystack = haystack.substring(j, j + needle.length());
                if (subHaystack.equals(needle)) return j;
            }
        }
        return 0;
    }


    public int strStr2(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if (nLength > hLength) return -1;

        // 这个解法相比方法一更简洁
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.substring(i, i + nLength).equals(needle)) return i;
        }
        return -1;
    }
}
