package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 22/09/2023 19:45
 */

/**
 * 最后一个单词的长度
 * 简单
 * 634
 * 相关企业
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 */
public class LengthOfLastWordTest {
    public static void main(String[] args) {
        //String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        int length = lengthOfLastWord(s);
        System.out.println(length);
    }

    private static int lengthOfLastWord(String s){
        String[] str =s.trim().split(" ");
        return str[str.length-1].length();
    }
}
