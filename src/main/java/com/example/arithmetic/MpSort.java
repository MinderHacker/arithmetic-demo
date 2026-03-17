package com.echo.javademo.arithmetic;


import java.util.Arrays;

public class MpSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 3, 6, 1};
        disply2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 冒泡排序:相邻的两个数字进行比较
    public static void disply2(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {// 确定比较多少轮
            for (int j = 0; j < arr.length -1-i; j++) {//相邻元素进行比较
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }

        // 选择排序：每次从待选择的数里选择最小的数
//        public static void disply ( int[] arr){
//            int min, temp;
//            for (int i = 0; i < arr.length - 1; i++) {
//                min = i;
//                for (int j = i; j < arr.length; j++) {
//                    if (arr[min] > arr[j]) {
//                        temp = arr[min];
//                        arr[min] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }

//        int min, temp;
//        for (int i = 0; i < arr.length-1; i++) {
//            min = i;// 每次假定拿到了最小值
//            for (int j = i; j < arr.length; j++) {
//                if (arr[min] > arr[j]) {
//                    temp = arr[min];
//                    arr[min] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

    }
}
