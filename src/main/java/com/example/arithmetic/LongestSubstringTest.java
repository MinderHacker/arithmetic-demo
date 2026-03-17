package com.echo.javademo.arithmetic;


import java.util.HashSet;

public class LongestSubstringTest {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("a1a2dfghsdaadd");
        System.out.println(i);
    }

    // 滑动窗口解法
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<=1){
            return s.length();
        }

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                // 未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            } else {
                // right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            // 每一次计算当前set子串的长度
            max = Math.max(set.size(), max);
        }
        return max;
    }
}
