package com.example.arithmetic;


import org.python.google.common.collect.Maps;

import java.util.HashMap;

/**
 * 题目描述
 * 判断两个字符串包含的字符是否完全相同。
 *
 * 输入输出样例
 * 输入两个字符串，输出一个布尔值，表示两个字符串是否满足条件。
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class StrCompareTest {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Boolean flag = strCompare2(s, t);
        System.out.println(flag);

    }

    /**
     * 由于自包含26个字母，所以用数组进行统计，遍历s时++，遍历t时–，如果数组中存在不等于0的数则返回false，否则返回true。
     *
     * @param s 输入的第一个字符串
     * @param t 输入的第二个字符串
     * @return
     */
    public static Boolean strCompare(String s, String t) {
        // 入参校验
        if (s.length() != t.length()) return false;

        int[] array = new int[26];
        for (char c : s.toCharArray()) {  // 时间复杂度：n
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) { // 时间复杂度：n
            array[c - 'a']--;
        }
        for (int num : array) {
            if (num != 0) return false;
        }
        return true;
    }


    /**
     * 将s中所有字符存入HashMap并计数，然后遍历t中每一个字符，如果在HashMap中找不到或者比HashMap中的数量多则返回false，如果遍历结束则返回true。
     *
     * @param s 输入的第一个字符串
     * @param t 输入的第二个字符串
     * @return
     */
    public static Boolean strCompare2(String s, String t) {
        // 入参校验
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = Maps.newHashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) return false;
            else {
                if (map.get(c) == 0) return false;
                map.put(c, map.get(c) - 1); // 遇见一个，就减少一个相同字符的数量
            }
        }

        return true;
    }
}
