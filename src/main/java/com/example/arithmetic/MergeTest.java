package com.example.arithmetic;

import org.python.antlr.op.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 中等
 * 相关标签
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为
 * intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
 * 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeTest {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
//        int[][] intervals = {{1, 4}, {2,3}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /*
    排序+双指针
       int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
      1.每个数组按照第一个数组，升序排列；
      2.判断相邻的数组有没有交集，有交集，则合并；没有则添加

      复杂度分析
时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。

     */

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        // 只有一个元素
        if (intervals.length <= 1) return intervals;
        // 数组排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0], right = intervals[i][1];//左右指针表示一个数组中的两个元素
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
