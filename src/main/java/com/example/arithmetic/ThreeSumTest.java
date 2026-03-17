package com.echo.javademo.arithmetic;

import org.python.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSumTest {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /*
      思路：
      1，先给数组排序
      2.三个元素分别为i，left,right.分别移动左右指针来找值

            输入：nums = [-1,0,1,2,-1,-4]
            输出：[[-1,-1,2],[-1,0,1]]
            解释：
            nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
            nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
            nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
            不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
      */
    public static List<List<Integer>> threeSum(int[] nums) {
        // List<List<Integer>> resultList = Lists.newArrayList();
        List<List<Integer>> resultList = new ArrayList();

        // 入参校验
        if (nums == null || nums.length < 3) return resultList;
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //当 sumsumsum == 000 时，nums[L]nums[L]nums[L] == nums[L+1]nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++L++
                    // 当 sumsumsum == 000 时，nums[R]nums[R]nums[R] == nums[R−1]nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R−−R--R−−
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return resultList;
    }
}
