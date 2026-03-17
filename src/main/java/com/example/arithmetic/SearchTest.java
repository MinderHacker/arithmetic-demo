package com.example.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 中等
 * 相关标签
 * 相关企业
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class SearchTest {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1};
//        int destIndex = Binary_Search(nums, 0);
        int destIndex = search3(nums, 3);
        System.out.println(destIndex);

    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            }

            // 分治：以mid为界限，分开找
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    //二分查找的基本时间复杂度是 O(log n)，因为它每次都将搜索区间减半。
    public static int search3(int[] nums, int target) {
        int lo = 0, hi = nums.length, mid = 0;
        if (hi == 0) {
            return -1;
        }
        if (hi == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while (lo <= hi) {
//            mid = lo + ((hi - lo) >> 1);// 这里使用无符号右移操作 (hi - lo) >> 1 来确保不会发生整数溢出。
            mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    /*
       1.先还原数组:
          [ , , i-1,i, , ,]
         找旋转的位置：nums[i-1]>nums[i].
         list添加后面的元素
       2.查找是否包含该数字：
         不包含：-1
         包含：遍历，找到，返回下标
     */
    public static int search2(int[] nums, int target) {
        // 判断nums是否包含taget
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        if (!list.contains(target)) return -1;

        int index = 0;
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
            }
        }
        for (int i = index; i < nums.length; i++) {
            list2.add(nums[i]);
        }
        for (int i = 0; i < index; i++) {
            list2.add(nums[i]);
        }

        // 此时list2按顺序排列
        System.out.println(list2);

        return 0;
    }


    // 折半查找
    public static int search4(int[] arr, int x) {
        Arrays.sort(arr);
        int flag = -1;
        int low, hight, mid;
        low = 0;
        hight = arr.length - 1;
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (x < arr[mid]) {
                hight = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else {
                flag = mid;
                break;
            }
        }
        return flag;
    }
}
