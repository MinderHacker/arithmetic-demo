package com.example.arithmetic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 78. 子集
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class SubsetsTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    /*
      深度优先搜索
     */
    static List<List<Integer>> resultList = new ArrayList<>();
    static List<Integer> numsList = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);// cur 记录当前数量
//        backtrace(0, nums);// cur 记录当前数量
        return resultList;
    }


    public static void backtrace(int cur, int[] nums) {

        
    }
    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            resultList.add(new LinkedList<>(numsList));
            return;
        }
        numsList.add(nums[cur]);
        dfs(cur + 1, nums);
        numsList.remove(numsList.size() - 1);
        dfs(cur + 1, nums);
    }
}
