package com.echo.javademo.arithmetic;

import junit.framework.Assert;
import org.python.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
示例 1：

输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true
 */
public class IsValidTest {
    public static void main(String[] args) {
        String s = "()[]{}";
//       String s = "(]";
//        String s = "{[]}";
        boolean isValid = isValid(s);
        Assert.assertTrue(isValid);
    }

    private static boolean isValid(String s) {
        Stack stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.empty() || c != stack.pop()) return false;
        }
        return stack.empty();
    }

//    private static boolean isValid(String s) {
//        Stack stack = new Stack<Character>();
//        for (Character c : s.toCharArray()) {
//            if (c == '{') stack.push('}');
//            else if (c == '[') stack.push(']');
//            else if (c == '(') stack.push(')');
//            else if (stack.isEmpty() || c != stack.pop()) return false;
//        }
//        return stack.isEmpty();
//    }
}
