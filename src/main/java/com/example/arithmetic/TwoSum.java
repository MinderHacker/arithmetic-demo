package com.echo.javademo.arithmetic;

import jnr.ffi.annotations.In;
import org.python.google.common.collect.Maps;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 4, 5};
        int target = 9;
        //遍历每一个数字求和
        //Map<Integer, Integer> index = getIndex(nums, target);
        List<List<Integer>> index = getIndex(nums, target);
        //算法复杂度n平方
        System.out.println(index);
    }

    // 双指针解法：时间复杂度
    /*
    这段代码的时间复杂度为O(nlogn)，其中n为数组nums的长度。
    主要是因为在函数中使用了Arrays.sort()方法对数组进行排序，其时间复杂度为O(nlogn)，
    而后面的while循环的时间复杂度为O(n)。因此，总的时间复杂度为O(nlogn)。
     */
    private static List<List<Integer>> getIndex(int[] nums, int target) {
        // HashMap<Integer, Integer> map = Maps.newHashMap();
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                resultList.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return resultList;
    }


    /**
     * 使用双指针分别从数组最左边和最右边向中间移动
     *
     * @param nums   传入的数组
     * @param target 目标值
     * @return map的键值对分别为数组元素的下标
     */
    private static Map<Integer, Integer> getIndex3(int[] nums, int target) {
        // HashMap<Integer, Integer> map = Maps.newHashMap();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    map.put(i, j);
                }
            }
        }
        return map;
    }

    private static Map<Integer, Integer> getIndex2(int[] nums, int target) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    map.put(i, j);
                }
            }
        }
        return map;
    }
}
