package com.example.arithmetic;

import cn.hutool.core.lang.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 问题：
 * 给你一个字符串和一个单词词典，问这个字符串是否能被划分成字典中的单词。
 * 比如如果词典是{"apple", "orange", "pie"},
 * “applepie”可以划分为apple/pie；applepieapple 可以划分为 "apple/pie/apple",
 * 但是“appie”就无法划分。
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2025/12/8 11:37
 */
public class WordTest {
    public static void main(String[] args) {
        Set<String> strs = new HashSet<>();
        strs.add("apple");
        strs.add("orange");
        strs.add("pie");
        String str = "applepie";
        boolean res = isDivided(str, strs);
        Assert.isTrue(res);
    }

    private static boolean isDivided(String str, Set<String> strs) {
        int len = str.length();
        Boolean[] dp =new Boolean[len+1];
        Arrays.fill(dp, false); // 初始化所有元素为 false，避免 NullPointerException
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // 若前j个字符可拆分，且j到i的子串在词典中，则前i个字符可拆分
                if (dp[j] && strs.contains(str.substring(j,i))){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
