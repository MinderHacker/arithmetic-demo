package com.example.test;

/**
 *
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2025/12/9 11:45
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 6};
        findNum(arr);
    }

    /*
     * 给定一个无序的正整数数组，数组中的元素互不相同，需要找出所有满足以下条件的元素：
     * - 在该元素之前的所有元素都严格小于它
     * - 在该元素之后的所有元素都严格大于它
     * 换句话说，对于数组中的某个元素 arr[i]，需要满足：
     * - 对于所有 j < i，有 arr[j] < arr[i]
     * - 对于所有 j > i，有 arr[i] < arr[j]
     */
    public static void findNum(int[] arr) {
        // 边界条件判断
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        // 从索引0到i-1的最大值
        int[] lMax = new int[n];
        // 从索引i+1到n-1的最小值
        int[] rMin = new int[n];

        // 构建leftMax数组
        lMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1], arr[i-1]);
        }

        // 构建rightMin数组
        rMin[n-1] = Integer.MAX_VALUE;
        for (int i = n-2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i+1], arr[i+1]);
        }

        // 检查每个元素是否满足条件
        for (int i = 0; i < n; i++) {
            if (arr[i] > lMax[i] && arr[i] < rMin[i]) {
                System.out.println("满足条件的元素: " + arr[i] + " 索引: " + i);
            }
        }
    }
}
