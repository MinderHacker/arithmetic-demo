package com.echo.javademo.arithmetic;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 中等
 * 1.5K
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 */
public class ThreeSumClosestTest {
    public static void main(String[] args) {
        // int[] nums = {-1, 2, 1, -4};
        // int[] nums = {0, 0, 0};
        //int[] nums = {0, 1, 2};
        //int[] nums = {1, 1, 1, 0};
        int[] nums = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }

    // 三个整数，使它们的和与 target 最接近=> |sum-target| =0  Math.min();
    /*
    双指针法:
        先让数组有序，也就是需要先对数组进行排序
        然后每次固定一个元素，再去寻找另外两个元素，也就是双指针
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = 0, len = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            left = i + 1;
            right = len - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                int res = Math.abs(sum - target);
                if (res < Math.abs(result - target)) {
                    result = sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
