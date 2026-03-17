package com.example.arithmetic;

import jnr.ffi.annotations.In;
import sun.java2d.ScreenUpdateManager;

import java.util.*;
import java.util.stream.Stream;


/**
 * 组合总和
 * 中等
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target
 * 的所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class CombinationSumTest {

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println(combinationSum);
    }


    // 回溯+剪枝
    static List<List<Integer>> resultList = new ArrayList<>();
    static ArrayList<Integer> pathList = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length < 1 || candidates[0] > target) return resultList;
        dfs(candidates,0, target);
        return resultList;
    }

    private static void dfs(int[] candidates, int u,int target) {
        if (target<0) return;
        if (target == 0){
            resultList.add(new ArrayList<>(pathList));
            return;
        }
        for (int i = u; i < candidates.length; i++) {// u记录当前的位置
            if (candidates[i]<=target){
                pathList.add(candidates[i]);
                dfs(candidates,i,target-candidates[i]);
                pathList.remove(pathList.size()-1);
            }
        }
    }

    private static void backTrack2(int[] candidates, List<List<Integer>> resultList, int sum, int target,
                                   ArrayList<Integer> numList) {
        if (sum == target) {
            Collections.sort(numList);
            if (!resultList.contains(numList)) {
                resultList.add(new LinkedList<>(numList));
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            numList.add(candidates[i]);
            if (sum > target) {
                sum -= candidates[i]; // 在退出循环之前还原sum
                numList.remove(numList.size() - 1);
                continue;
            }
//            backTrack(candidates, resultList, sum, target, numList);
            numList.remove(numList.size() - 1);
            sum -= candidates[i]; // 移除元素后还原sum
        }
    }


    // 深度优先搜索
    static List<List<Integer>> res = new ArrayList<>(); //记录答案
    static List<Integer> path = new ArrayList<>();  //记录路径
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        dfs2(candidates, 0, target);
        return res;
    }
    public static void dfs2(int[] c, int u, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = u; i < c.length; i++) {
            if (c[i] <= target) {
                path.add(c[i]);
                dfs2(c, i, target - c[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size() - 1); //回溯，恢复现场
            }
        }
    }
}




