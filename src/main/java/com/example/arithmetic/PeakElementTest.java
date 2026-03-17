package com.example.arithmetic;

/**
 *
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2025/12/17 18:24
 */
public class PeakElementTest {


    /*
    标题:寻找峰值
    题目描述
    峰值元素是指其值严格大于左右相邻值的元素。给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。你可以假设 nums [-1] = nums [n] = -∞。你必须实现时间复杂度为 O (log n) 的算法来解决此问题。
    示例 1：
    输入: nums = [1,2,3,1]输出: 2解释: 3 是峰值元素，你的函数应该返回其索引 2。
    示例 2：
    输入: nums = [1,2,1,3,5,6,4]输出: 1 或 5解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5，其峰值元素为 6。
    提示:
    1 <= nums.length <= 1000
    -2^31 <= nums[i] <= 2^31 - 1
    对于所有有效的 i 都有 nums [i] != nums [i + 1]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int peakIndex = findPeakElement(nums);
        System.out.println(peakIndex);
    }

    /*
    初始化指针：left 指向数组起始，right 指向数组末尾。
        二分循环：
        计算中间索引 mid，避免直接 (left + right) / 2 导致的整数溢出。
        若 nums[mid] > nums[mid + 1]，说明峰值在左半区间（包括 mid），将 right 设为 mid。
        否则，峰值在右半区间，将 left 设为 mid + 1。
        返回结果：循环结束时 left 和 right 重合，该位置即为峰值索引
     */
    private static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // 避免整数溢出
            if (nums[mid] > nums[mid + 1]) {
                // 峰值在左半区间（包含mid）
                right = mid;
            } else {
                // 峰值在右半区间（mid+1及以后）
                left = mid + 1;
            }
        }
        // 循环结束时left == right，即为峰值索引
        return left;
    }

}
