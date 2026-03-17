package com.example.arithmetic;

import java.util.Arrays;

public class XzSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 3, 6, 1};
        disply(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 选择排序：把未排序的数字里找出最大值或最小值放到已经排序的队列里去
    public static void disply(int[] arr) {
        int min, temp;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;// 每次假定拿到了最小值
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
