package com.example.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 全排列
 * 中等
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermuteTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
//    static List<List<Integer>> resultList = new ArrayList<>();


    /**
     * 思路：回溯算法
     * @param nums
     * @return
     */
    /*
    **时间复杂度分析**：
    回溯算法实现全排列的时间复杂度为 O(n!)，其中 n 为数组 nums 的长度。因为对于每一个元素，都有 n-1 种可能的插入位置（除了已经在路径中的元素），所以总共有 n*(n-1)*(n-2)*...*1 种排列方式，即 n! 种。
    **空间复杂度分析**：
    1. **递归栈空间**：由于回溯过程中使用了递归调用，最坏情况下递归深度为 n，因此递归栈的空间复杂度是 O(n)。
    2. **结果存储空间**：每个排列需要一个新的 LinkedList 存储，共产生 n! 个列表。但由于 Java 中 List 对象存储的是对元素的引用而非复制整个列表，故最终结果列表中所有子列表共享原数组 nums 的元素，故不计入空间复杂度。
    3. **局部变量 path**：在每次递归调用时都会创建一个 ArrayList 来保存当前路径，但该空间随着递归返回会被释放，因此考虑递归树的所有节点，其最大空间消耗也是 O(n)，与递归栈空间相同。

    综上所述，空间复杂度主要取决于递归栈和局部变量 `path`，所以整体空间复杂度为 O(n)。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backTrack(nums, resultList, path);
        return resultList;
    }

    private static void backTrack(int[] nums, List<List<Integer>> resultList, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            resultList.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;// 剪枝
            path.add(nums[i]);
            backTrack(nums, resultList, path);
            path.remove(path.size() - 1);
        }
    }
}
