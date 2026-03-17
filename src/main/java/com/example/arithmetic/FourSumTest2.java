package com.echo.javademo.arithmetic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class FourSumTest2 {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;

//        int[] nums = {2, 2, 2, 2, 2};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-5, 5, 4, -3, 0, 0, 4, -2};
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }


    // 两层for循环遍历+双指针（移动）
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        //元素不足四个，返回为为空
        if (nums.length < 4) {
            return resultList;
        }

        // 元素为4个
        List<Integer> arrayList = null;
        if (nums.length == 4) {
            arrayList = new ArrayList<>();
            for (int num : nums) {
                arrayList.add(num);
            }
            long sum = arrayList.get(0) + arrayList.get(1) + arrayList.get(2) + arrayList.get(3);
            if (sum == target) {
                resultList.add(arrayList);
                return resultList;
            } else {
                return resultList;
            }
        }

        // 1.对数组排序
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length;

        //2.双层循环+双指针移动
        for (int i = 0; i < len - 3; i++) {
            // 去重：相邻的元素相等
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;//去重
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        //左右指针去重
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return resultList;
    }
}
