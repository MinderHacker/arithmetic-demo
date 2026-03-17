package com.example.arithmetic;

/**
 * 二分法找有序数组的数字下标
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2025/12/18 9:07
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target= 10;
        int index = binarySearch(nums, target);
        System.out.println( index);
    }
    private static int binarySearch(int[] nums,int target){
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}
