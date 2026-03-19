package com.example.arithmetic;


/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2026/3/19 15:30
 * <p>
 * 找出升序数组中的目标数字的索引的左右边界
 */
public class FindNumIndexTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10};
        int target = 6;
//        int index = findNumIndex(arr, target);
        int[] index = findNumIndex2(arr, target);
        System.out.println("目标数字" + target + "的索引为：" + index);
    }

    // 找出升序数组中的目标数字的索引的左右边界
    public static int[] findNumIndex2(int[] arr, int target) {
        int left = binarySearch(true, arr, target);
        int right = binarySearch(false, arr, target);
        return new int[]{left, right};
    }

    private static int binarySearch(boolean flag, int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (flag) {
                    // 向左查找
                    right = mid - 1;
                } else {
                    // 向右查找
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 找出升序数组中的目标数字的索引

    public static int findNumIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
