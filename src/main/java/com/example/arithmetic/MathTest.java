package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 15/9/2023 下午4:06
 */

/*
# 在任意元素组成的数组里，找到 a+b+c=x*y 的组合，要求a、b、c、x、y不重复
# 如， 2，1，3，4，6，5，7  这些数字里，可以找到 1+4+7 = 2*6
 */
public class MathTest {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 6, 5, 7};
        int times = getTimes(114514);
        System.out.println(times);


    }

    //题目是一个数初始是0，只通过+1和*2两种操作，最少几次操作能让这个数变成114514？
    private static int getTimes(int x) {
        int index = 0;
        while (x != 0) {
            if (x % 2 == 0) x = x / 2;
            else x = x - 1;
            index++;

        }
        return index;
    }
}
