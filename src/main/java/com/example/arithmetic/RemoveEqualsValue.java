package com.echo.javademo.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 移除元素:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveEqualsValue {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 45, 5, 7, 6, 4};
        int value = 4;
        int newNumsSize = removeElement(nums, value);
        System.out.println("移除元素后的新数组的长度为：" + newNumsSize);
    }

    private static int removeElement(int[] nums, int value) {
        List arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (value != nums[i]) {
                arrayList.add(nums[i]);
            }
        }

//        int count = 0;
//        for (int num : nums) {
//            if (value != num) {
//                nums[count] = num;
//                count++;
//            }
//        }
//        return count;
        
        return arrayList.size();
    }
}
