package com.echo.javademo.arithmetic;


import java.util.Arrays;

/**
 * 75. 颜色分类
 * 提示
 * 中等
 * 1.7K
 * 相关企业
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */
public class SortColorsTest {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        Arrays.sort(nums);
        int[] res = mpSort(nums);
        System.out.println(Arrays.toString(res));
    }

    /*
      冒泡排序：
      交换连个相邻的元素，升序的话，就把小的放在前面。
     */
    private static int[] mpSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
