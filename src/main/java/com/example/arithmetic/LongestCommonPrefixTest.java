package com.echo.javademo.arithmetic;


/**
 * 最长公共前缀
 * 简单
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefixTest {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String commonPrefix = longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，先随便选一个
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
