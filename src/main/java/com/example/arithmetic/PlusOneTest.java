package com.example.arithmetic;

import jnr.ffi.annotations.In;

import java.util.ArrayList;

/*
66. 加一
简单
相关标签
相关企业
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]
 */
public class PlusOneTest {
    public static void main(String[] args) {
//        int[] digits = {1, 2, 9};
        int[] digits = {9};
        int[] ints = plusOne(digits);
        System.out.println(ints);

    }

    /*
     1.换成数字，+1；
     2.拆分成int[]
     */
    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        // 123
        int num = 0;
        for (int i = 0; i < len; i++) {
            num = (int) (num + digits[i] * Math.pow(10, len - 1 - i));
        }
        int newNum = num + 1;//124

        String numStr = String.valueOf(newNum);
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numStr.length(); i++) {
            numList.add((int) numStr.charAt(i));
        }

        System.out.println(numList);
        return null;
    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;// 个位数不为9
        }
        digits = new int[digits.length + 1];// 一个数字，为9
        digits[0] = 1;
        return digits;
    }
}
