package com.echo.javademo.arithmetic;

import java.util.Arrays;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2023/9/26 18:55
 */

/*
. 多数元素
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1：
输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2

提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 */
public class MajorityElementTest {
    public static void main(String[] args) {

        int[] nums={2, 2, 1, 1, 1, 2, 2,1,1};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);

    }

    // 方法1：先排序
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
