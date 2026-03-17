package com.echo.javademo.arithmetic;


/**
 * 11. 盛最多水的容器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 */
public class MaxAreaTest {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(nums);
        System.out.println(maxArea);
    }

    // 双指针+动态规划
    // 时间复杂度：nxn
    private static int maxArea2(int[] height) {
        int max = 0;
        for (int left = 0; left < height.length - 1; left++) {
            for (int right = height.length - 1; right > left; right--) {
                int s = (right - left) * Math.min(height[left], height[right]);
                max = Math.max(s, max);
            }
        }
        return max;
    }

    // 双指针
    // 时间复杂度： n
    private static int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = height[left] < height[right] ?
                    Math.max((right - left) * height[left++], max)
                    : Math.max((right - left) * height[right--], max);
        }
        return max;
    }
}
