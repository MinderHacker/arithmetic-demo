package com.echo.javademo.arithmetic;


/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsertTest {

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,9};
        int target = 2;

        int index = searchInsert(nums, target);
        System.out.println("返回其索引为：" + index);
    }

//    private static int searchInsert(int[] nums, int target) {
//
//        // 看目标值是否在数组中
//        ArrayList<Integer> newList = new ArrayList<>();
//        if (nums[nums.length - 1] < target) {
//            // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
//            for (int i = 0; i < nums.length; i++) {
//                newList.add(nums[i]);
//            }
//            newList.add(target);
//            return newList.size() - 1;
//        }
//
//        //如果目标值存在于数组中
//        // 时间复杂度为n
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target){
//                return i;
//            }
//        }
//        return 0;
//    }

//    private static int searchInsert(int[] nums, int target) {
//        ArrayList<Integer> newList = new ArrayList<>();
//        // 看目标值是否在数组中,如果目标值不存在于数组中，返回它将会被按顺序插入的位置
//        // 标记位
//        int index = 0;
//        // 最大索引
//        int maxIndex = nums.length - 1;
//        // 最小索引
//        int minIndex = 0;
//        // 中间索引
//        int halfIndex = minIndex + (maxIndex - minIndex) / 2;
//
//        if (nums[nums.length - 1] < target) {
//            // 目标值大于数组中任何值
//            for (int i = 0; i < nums.length; i++) {
//                newList.add(nums[i]);
//            }
//            newList.add(target);
//            return newList.size() - 1;
//        } else if (nums[0] > target) {
//            // target小于数组中任何一个值
//            return 0;
//        } else {
//            // 目标值在数组中值的范围内
//
//            boolean flag = false;
//            for (int num : nums) {
//                if (num == target) {
//                    flag = true;
//                }
//            }
//            // 有这个值
//            if (flag) {
//                //如果目标值存在于数组中
//                // 时间复杂度为n
//                // 二分法
//                while (minIndex <= maxIndex) {
//                    // 找到时
//                    if (nums[halfIndex] == target) {
//                        return halfIndex;
//                    } else if (nums[halfIndex] < target) {
//                        minIndex = halfIndex + 1;
//                    } else {
//                        maxIndex = halfIndex - 1;
//                    }
//                    halfIndex = minIndex + (maxIndex - minIndex) / 2;
//                }
//            } else {
//
//                // 没有这个值
//                for (int i = 0; i <= nums.length - 1; i++) {
//                    if (nums[i] > target) {
//                        index = i;      //记录下标并退出循环
//                        break;
//                    }
//                }
//                //这个循环实现元素后移
//                //要从倒数的最后一个元素开始后移
//                for (int i = nums.length - 1; i > index; i--) {
//                    nums[i] = nums[i - 1];  //把前一个元素后移
//                }
//                nums[index] = target;
//                return index;
//            }
//        }
//        return 0;
//    }

//    private static int searchInsert(int[] nums, int target) {
//        int n = nums.length;
//        int left = 0, right = n - 1, ans = n;
//        while (left <= right) {
//            int mid = ((right - left) >> 1) + left;
//            if (target <= nums[mid]) {
//                ans = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//
//    }

    private static int searchInsert(int[] nums, int target) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            //找到插入位置 退出循环
            if(nums[i]>=target){
                index=i;
                break;
            }else{
                // 插在最后
                index = i+1;
            }
        }
        return index;
    }
}
