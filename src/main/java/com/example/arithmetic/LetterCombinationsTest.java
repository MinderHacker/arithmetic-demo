package com.echo.javademo.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 电话号码的字母组合
 * 中等
 * 2.7K
 * 相关企业
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LetterCombinationsTest {
    public static void main(String[] args) {
        String str = "23";
        List<String> results = letterCombinations(str);
        System.out.println(results);
    }

    /* 时间复杂度：
       空间复杂度：
     */

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    // 回溯算法
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits,
                                 int index, StringBuffer combination) {
        if (index == digits.length()) {//回溯出口：字符组合数量验证
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));//添加组合字符
                backtrack(combinations, phoneMap, digits, index + 1, combination);//递归

                // 撤销选择：每次删除最后一个字符，再添加新的组合
                combination.deleteCharAt(index);
            }
        }
    }

}


