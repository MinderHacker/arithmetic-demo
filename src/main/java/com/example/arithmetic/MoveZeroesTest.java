package com.example.arithmetic;

import java.util.Arrays;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2023/9/30 11:40
 */
/*
 移动零
提示
简单
2.2K
相关企业
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:
输入: nums = [0]
输出: [0]

 */
public class MoveZeroesTest {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
//        char[] ints = moveZeroes(nums);
        System.out.println(nums);
    }

    // 1.遍历每一个元素，遇见零，记录下出现零的次数，非零元素直接添加
    // 2.把零直接添加到后面，数量为出现的次数
//    public static char[] moveZeroes(int[] nums) {
//        StringBuffer buffer = new StringBuffer();
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                count++;
//                continue;
//            }
//            buffer.append(nums[i]);
//        }
//        for (int i = 0; i < count; i++) {
//            buffer.append(0);
//        }
//        return buffer.toString().toCharArray();
//    }


    // 把所有的非零值往前搬，然后从搬运结束点开始，把后面的值赋值为0
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    // 快慢指针
    public static void moveZeroes3(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                if (slow++ != fast) {
                    nums[fast] = 0;
                }
            }
            fast++;
        }
    }
}
