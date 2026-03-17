package com.example.arithmetic;

import java.util.Arrays;

public class MaxSubArrayTest2 {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {5,4,-1,7,8};
//        int[] nums = {4,-1,2,1};
//        int[] nums = {1};
        int[] nums = {-2, 1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }


    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);// 两个数相加得到一个新值
            max = Math.max(nums[i], max);
        }
        return max;

    }

    // 具有最大和的 max = math.max(max,sum)      连续子数组 nums[i-1]<nums[i]
    private static int maxSubArray2(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                sum = nums[i];
            }
        }
        return max;

    }
}
