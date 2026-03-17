package com.echo.javademo.arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 中等
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstringTest {
    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println("无重复字符的最长子串的长度是：" + length);
    }


    /*
    解题思路
    从左到右遍历，max变量记录最大长度，startIndex记录当前子串的起始坐标
    startIndex ~ endIndex 之前的子串，是当前正在进行计算长度的子串
    每取到一个新的字符，校验 startIndex ~ endIndex 之间是否存在
    如果存在，则变更 startIndex 的值
    每次循环，更新max的值
    时间复杂度：nXn
     */
//    private static int lengthOfLongestSubstring(String s) {
//        int max = 0;
//        int startIndex = 0;
//        char c;
//        int index;// pwwkew
//        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
//            c = s.charAt(endIndex);
//
//            index = -1;
//            for (int i = startIndex; i < endIndex; i++) {
//                if (s.charAt(i) == c) {
//                    index = i;
//                    break;
//                }
//            }
//            if (index >= 0) { // 存在
//                startIndex = index + 1;
//            }
//            max = Math.max(max, endIndex - startIndex + 1);
//        }
//        return max;
//    }

    // 遍历每个字符，与前面的字符进行比较
//    private static int lengthOfLongestSubstring(String s) {
//        int index = 1;
//        String newString = String.valueOf(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            if (newString.contains(String.valueOf(s.charAt(i)))) {
//                return index;
//            }
//            newString = newString + s.charAt(i);
//            index++;
//        }
//        return index;
//    }


    /**
     * 滑动窗口解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            }else{
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            //每一次计算当前set子串的长度
            max = Math.max(max, set.size());
        }
        return max;
    }
}
