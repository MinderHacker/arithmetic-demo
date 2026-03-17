package com.echo.javademo.arithmetic;

/**
 * . 最大子数组和
 * 中等
 * 6.4K
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArrayTest {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray2(nums);
        System.out.println(result);
    }

    /*
    动态规划解析：
    num[i]=nums[i]+math.max(nums[i-1],0)
初始状态： dp[0]==nums[0]，即以 nums[0]结尾的连续子数组最大和为 nums[0] 。
返回值： 返回 dp列表中的最大值，代表全局最大值。
     */
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //nums[i] += Math.max(nums[i - 1], 0);
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);//和零比较，决定是否
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    //使用贪婪策略，即当前子数组和为负数时，抛弃并从下一个数字重新开始计算子数组和。
    // 这种策略保证了局部最大的子数组和会累积到全局最大的子数组和中。
    public static int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            if (currentSum <= 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }
            maxSum= Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
