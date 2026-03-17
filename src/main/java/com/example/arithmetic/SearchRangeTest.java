package com.example.arithmetic;

import jnr.ffi.annotations.In;
import org.python.google.common.collect.Lists;

import java.util.*;

/**
 * 题目描述
 * 给定一个增序的整数数组和一个值，查找该值第一次和最后一次出现的位置。
 * 输入输出样例
 * 输入是一个数组和一个值，输出为该值第一次出现的位置和最后一次出现的位置（从 0 开
 * 始）；如果不存在该值，则两个返回值都设为-1。
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 数字 8 在第 3 位第一次出现，在第 4 位最后一次出现。
 */
public class SearchRangeTest {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 9, 10};
        int target = 8;
//        List<Integer> resultList = searchRange2(nums, target);
        int[] resultList = searchRange(nums, target);
        System.out.println(resultList);
    }


    public static int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();

        //输入：nums = [], target = 0
        //输出：[-1,-1]
        int[] ints = {-1, -1};
        if (nums.length == 0) {
            return ints;
        }

        // 输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]
        for (Integer num : nums) {
            list.add(num);
        }
        if (!list.contains(target)) {
            return ints;
        }

        list.clear();
        for (int i = 0; i < nums.length; i++) {//时间复杂度为n
            if (nums[i] == target) {
                list.add(i);
            }
        }
        if (list.size() == 0) return list.stream().filter(integer -> integer != null).mapToInt(i -> i).toArray();
        List<Integer> targetList = new ArrayList<>();
        targetList.add(list.get(0));
        targetList.add(list.get(list.size() - 1));

        int[] resultInt = targetList.stream().filter(integer -> integer != null).mapToInt(i -> i).toArray();
        return resultInt;
    }

    /**
     * nums = [5,7,7,8,8,8,9,10], target = 8
     *
     * @param nums   传入的数组
     * @param target 目标值
     * @return 返回与目标值相等的元素下标集合
     */
//    public static List<Integer> searchRange(int[] nums, int target) {
////        ArrayList<Integer> list = Lists.newArrayList();
//        ArrayList<Integer> list = new ArrayList<>();
//        if (nums.length <= 0) return list;
//        for (int i = 0; i < nums.length; i++) {//时间复杂度为n
//            if (nums[i] == target) {
//                list.add(i);
//            }
//        }
//
//        ArrayList<Integer> targetList = Lists.newArrayList();
//        targetList.add(list.get(0));
//        targetList.add(list.get(list.size() - 1));
////        targetList.toArray();
//        return targetList;
//    }


    /**
     * nums = [5,7,7,8,8,8,9,10], target = 8
     *
     * @param nums   传入的数组
     * @param target 目标值
     * @return 返回与目标值相等的元素下标集合
     */
    public static List<Integer> searchRange2(int[] nums, int target) {
        ArrayList<Integer> list = Lists.newArrayList();
        if (nums.length <= 0) return list;

        // 使用二分法找到找到与目标值相等的元素极其下标，然后取出下标进行排序，取第一个和最后一个
        // 时间复杂度log 2(n】)
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                list.add(mid);
                low++;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        ArrayList<Integer> targetList = Lists.newArrayList();
        Collections.sort(list);
        targetList.add(list.get(0));
        targetList.add(list.get(list.size() - 1));
        return targetList;
    }
}
