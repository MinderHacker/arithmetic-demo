package com.echo.javademo.arithmetic;


import java.util.ArrayList;

/**
 * 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个
 * 元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k
 */
public class RemoveDuplicatesTest {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};// nums = [0,1,2,3,4]
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};// nums = [0,1,2,3,4]
//        int[] nums = {1, 1, 2};
        int newNumsCount = removeDuplicates(nums);
        System.out.println("新数组的个数为：" + newNumsCount);
    }


//    private static int removeDuplicates(int[] nums) {
//        ArrayList<Integer> numsList = new ArrayList<>();
//        for (int num : nums) {
//            if (!numsList.contains(num)) {
//                numsList.add(num);
//            }
//        }
//        return numsList.size();
//    }


//    private static int removeDuplicates(int[] nums) {
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[i] != nums[j]) {
//                nums[++i] = nums[j];
//            }
//        }
//
//        return i + 1;
//    }


    //  int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};// nums = [0,1,2,3,4]
    private static int removeDuplicates(int[] nums) {
        int index=0;
        //index指针指向替换位，i遍历，替换前后不同元素
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){//前后元素不相同，才添加到新数组里去。数组中的第一个元素不需要改变。
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}
