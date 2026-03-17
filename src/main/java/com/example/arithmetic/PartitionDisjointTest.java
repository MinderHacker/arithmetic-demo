package com.echo.javademo.arithmetic;


/**
 * 分割数组
 * <p>
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。=========左边最大的元素值小于等于右边的元素=====》找到左边最大的元素，给最大元素设置临时值
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 */
public class PartitionDisjointTest {
    public static void main(String[] args) {
        /*
        需要定义三个变量：
        split：分割点
        max：左边数组目前的最大值
        tempMax：当前遇到的最大值
        想法：
        在遍历的过程中，如果遇到比max小的值，直接让split加一即可，因为比max小的值一定要在左边数组中。
        如果遇到大于等于max的值，需要记录在tempMax中临时存储
        如果再次遇到比max小的值，那么左边数组不得不包含它，此时之前记录的tempMax就应该作为max，因为此时左边数组的最大值已经变为了tempMax。
         */
        int[] nums = {5, 0, 3, 8, 6};
        int letftLength = partitionDisjoint(nums);
        System.out.println("left的长度为：" + letftLength);
    }

    private static int partitionDisjoint(int[] nums) {
        //split：分割点 max：左边数组的最大值 tempMax：遍历过程中遇到的最大值
        int split = 0;
        int max = nums[0];
        int tempMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                // tempMax理解为当前的最大值，所以需要比较之前存储的tempMax和nums[i]，选择最大的作为tempMax
                tempMax = Math.max(tempMax, nums[i]);
            } else {
                //如果当前遇到的值比左边数组最大值max要小，则左边数组应该包含该值，即split = i，同时，左边数组最大值max应该改变为目前数组中遇到的最大值
                split = i;
                max = tempMax;
            }
        }
        return split + 1;
    }
}
