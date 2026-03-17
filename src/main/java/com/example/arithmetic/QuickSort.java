package com.example.arithmetic;

import java.util.Arrays;

/**
 * 题目一：快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));

    }
    private static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }

            //如果满足条件就进行交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }

        // 将基准位与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用右半数组
        quickSort(arr, j + 1, high);
        //递归调用左半数组
        quickSort(arr, low, j - 1);
    }

}