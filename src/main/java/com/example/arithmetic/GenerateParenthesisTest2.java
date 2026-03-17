package com.example.arithmetic;

import java.util.ArrayList;
import java.util.List;


/**
 * 括号生成
 * 中等
 * 3.4K
 * 相关企业
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesisTest2 {
    public static void main(String[] args) {
        List<String> stringList = generateParenthesis(1);
        System.out.println(stringList);
    }

    /*
       左括号left，有括号right
       1.left=0 && right=0  list.add();
       2.left<right  添加右边；
       3.left>right  添加左边；

     */
    static ArrayList<String> resultList = new ArrayList<>();
    // 思路：递归调用
    private static List<String> generateParenthesis(int n) {
        if (n < 0) return resultList;
        generateParent("", n, n);
        return resultList;
    }

    private static void generateParent(String str, int left, int right) {
        if (left == 0 && right == 0) {
            resultList.add(str);
            return;
        }
        if (left == right) {
            generateParent(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generateParent(str + "(", left - 1, right);//(((
            }
            generateParent(str + ")", left, right - 1);
        }
    }
}
