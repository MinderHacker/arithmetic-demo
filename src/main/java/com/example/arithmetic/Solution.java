package com.echo.javademo.arithmetic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findCombination(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 存储结果的列表
        Set<Integer> set = new HashSet<>(); // 用于判断是否重复的集合

        // 遍历数组的每个元素
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    // 跳过重复的数字
                    if (i == j || i == k || j == k) continue;

                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];

                    int x = a + b + c;
                    int y = a * b * c;

                    // 判断是否满足条件且不重复
                    if (x == y && !set.contains(a) && !set.contains(b) && !set.contains(c)) {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(a);
                        combination.add(b);
                        combination.add(c);
                        result.add(combination);

                        // 将已添加的数加入集合，防止重复
                        set.add(a);
                        set.add(b);
                        set.add(c);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.findCombination(nums);

        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
