package com.echo.javademo.arithmetic;

import org.springframework.util.Assert;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2023/10/5 11:41
 */
/*
392. 判断子序列
简单
948
相关企业
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class IsSubsequenceTest {
    public static void main(String[] args) {
        String s = "ace", t = "abcde";
        boolean subsequence = isSubsequence(s, t);
        Assert.isTrue(subsequence);
    }

    /*
      双指针解法
      设置双指针 i , j 分别指向字符串 s , t 的首个字符，遍历字符串 t ：
        当 s[i] == t[j] 时，代表匹配成功，此时同时 i++ , j++ ；
        进而，若 i 已走过 s 尾部，代表 s 是 t 的子序列，此时应提前返回 true ；
        当 s[i] != t[j] 时，代表匹配失败，此时仅 j++ ；
        若遍历完字符串 t 后，字符串 s 仍未遍历完，代表 s 不是 t 的子序列，此时返回 false
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                // 遍历t完成
                // if (++i == s.length()) return true;

                ++i;
                if (i==s.length()) return true;
            }
        }
        return false;

//        if (s.length() == 0) return true;
//        for (int i = 0, j = 0; j < t.length(); j++) {
//            if (s.charAt(i) == t.charAt(j)) {
//                // 若已经遍历完 s ，则提前返回 true
//                if (++i == s.length())
//                    return true;
//            }
//        }
//        return false;
    }

    public static boolean isSubsequence2(String s, String t) {
        int sindex = 0, tindex = 0;
        while (sindex < s.length() && tindex < t.length()) {
            if (s.charAt(sindex) == t.charAt(tindex)) {
                sindex++;//s中的指针只有在找到时，才会移动
            }
            tindex++;//t中的指针一直都会移动
        }
        return sindex == s.length();
    }
}
