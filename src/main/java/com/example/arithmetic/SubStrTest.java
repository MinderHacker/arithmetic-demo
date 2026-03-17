package com.echo.javademo.arithmetic;

/**
 * 题目描述
 * 判断一个字符串是不是另一个字符串的子字符串，并返回其位置。
 * <p>
 * 输入输出样例
 * 输入一个母字符串和一个子字符串，输出一个整数，表示子字符串在母字符串的位置，若不存在则返回-1。
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 */
public class SubStrTest {

    public static void main(String[] args) {
        String haystack = "hell4334o";
        String needle = "l4l";
        Integer index = SubStr(haystack, needle);
        System.out.println(index);
    }

    //https://blog.csdn.net/qq_41773806/article/details/121078300

    public static Integer SubStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            char c1 = haystack.charAt(i);
            for (int j = 0; j < needle.length(); j++) {
                char c2 = needle.charAt(j);
                if (c1 == c2) {
                    if (haystack.substring(i, i + needle.length()).equals(needle)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
