package com.echo.javademo.arithmetic;

import java.util.HashMap;
import java.util.Stack;

/**
 * 问题：
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 算法原理
 * 栈先入后出特点恰好与本题括号排序特点一致，即若遇到左括号入栈，
 * 遇到右括号时将对应栈顶左括号出栈，则遍历完所有括号后 stack 仍然为空；
 *
 */
public class StackTest {
    public static void main(String[] args) {
        String s = "{}[](]";
        boolean res = isValid(s);
        System.out.println(res);

    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
                if (map.get(chars[i]) == chars[i + 1]) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) return true;

        return false;
    }
}
