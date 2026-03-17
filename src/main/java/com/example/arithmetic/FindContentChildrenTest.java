package com.echo.javademo.arithmetic;


import java.util.Arrays;

/**
 * 题目描述
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩
 * 子可以吃饱。
 * <p>
 * 输入输出样例
 * 输入两个数组，分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数量。
 * Input: [1,2], [1,2,3]
 * Output: 2
 */
public class FindContentChildrenTest {
    public static void main(String[] args) {
        int[] children = {1, 2};
        int[] cookies = {1, 2, 3};
        int childrenCount = findContentChildren(children, cookies);
        System.out.println(childrenCount);
    }

    // 时间复杂度n*n
    public static int findContentChildren(int[] children, int[] cookies) {
        // 入参是否正常效验
        if (children.length == 0 || cookies.length == 0) return 0;

        int child = 0;
        for (int i = 0; i < children.length; i++) {
            for (int j = 0; j < cookies.length; j++) {
                if (children[i] < cookies[j]) {
                    child++;
                }
            }
        }
        return child;
    }

//
//    public static int findContentChildren2(int[] children, int[] cookies) {
//        // 入参是否正常效验
//        if (children.length == 0 || cookies.length == 0) return 0;
//
//        Arrays.sort(children);
//        Arrays.sort(cookies);
//
//        int child = 0;
//        int cookie = 0;
//
////        while (cookie < cookies.length) {
////            if (children[child] < cookies[cookie]) child++; // 孩子可以吃饱
////            cookie++;
////        }
//        for (int i = 0; i < cookies.length; i++) {
//            if (children[child] < cookies[i]) child++; // 孩子可以吃饱
//        }
//        return child;
//    }
}
