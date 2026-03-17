package com.echo.javademo.arithmetic;

/**
 * 求数组中连续元素和的最大值
 */
public class GreedyAlgorithm {

    //使用贪婪策略，即当前子数组和为负数时，抛弃并从下一个数字重新开始计算子数组和。
    // 这种策略保证了局部最大的子数组和会累积到全局最大的子数组和中。
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
 
        for (int i = 1; i < nums.length; i++) {
            if (currentSum <= 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
 
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, 1};
        System.out.println("The maximum subarray sum is: " + maxSubArray(nums));
    }
}