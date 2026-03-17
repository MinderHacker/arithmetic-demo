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
public class FourSumTest {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        //        int target = 0;

        int[] nums = {2,2,2,2,2};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-5, 5, 4, -3, 0, 0, 4, -2};
        int target = 8;
        List<List<Integer>> result = fourSum2(nums, target);
        System.out.println(result);
    }


    // 两层for循环遍历+双指针（移动）
    private static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        //元素不足四个，返回为为空
        if (nums.length < 4) return resultList;

        // 元素>=4个
        int len = nums.length;
        int sum = 0;
        Arrays.sort(nums);//数组排序

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;//去重
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // left,right位置的数去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    // 4层for循环
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> arrayList = null;
        List resultList = new ArrayList<>();

        //元素不足四个，返回为为空
        if (nums.length < 4) {
            return resultList;
        }

        // 元素为4个
        if (nums.length == 4) {
            arrayList = new ArrayList<>();
            for (int num : nums) {
                arrayList.add(num);
            }
            if (arrayList.get(0) + arrayList.get(1) + arrayList.get(2) + arrayList.get(3) != target) {
                return resultList;
            } else {
                resultList.add(arrayList);
                return resultList;
            }
        }

        // 元素大于4个
        for (int i = 0; i < nums.length - 4; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            arrayList = new ArrayList<>();
                            arrayList.add(nums[i]);
                            arrayList.add(nums[j]);
                            arrayList.add(nums[k]);
                            arrayList.add(nums[l]);

                            // 若两个四元组元素一一对应，则认为两个四元组重复
                            if (!resultList.contains(arrayList)) {
                                resultList.add(arrayList);
                            }
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
