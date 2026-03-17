package com.echo.javademo.arithmetic;


import java.util.Arrays;



public class MaxTimeTest {
    public static void main(String[] args) {
        int m = 5;
        int n = 10;
        int[] time = {8, 4, 3, 2, 10};
        int workTime = getWorkTime(m, n, time);
        System.out.println(workTime);

    }


    /**
     * @param m    流水线个数
     * @param n    作业数
     * @param time 每个作业处理时长
     * @return 完成所有作业总时长
     */
    public static int getWorkTime(int m, int n, int[] time) {
        Arrays.sort(time);

        // 当流水线个数大于等于作业数，所有作业可并行工作，完成所有作业的时间取决于处理时间最长的那个作业
        if (m >= n) {
            return time[time.length - 1];
        }

        // 当流水线个数小于等于作业数

        return 0;
    }
}