package com.echo.javademo.arithmetic;

import jnr.ffi.annotations.In;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 * 提示
 * 简单
 * 1.3K
 * 相关企业
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 */
public class FindDisappearedNumbersTest {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> numbers = findDisappearedNumbers(nums);
        System.out.println(numbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
