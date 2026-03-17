package com.example.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。你可以 按任意顺序 返回答案。
 * 示例1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class NoRepeatNumTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> noRepeatNums = noRepeatNum(nums);
        System.out.println(noRepeatNums);
    }

    static List<List<Integer>> resultList = new ArrayList<>();

    private static List<List<Integer>> noRepeatNum(int[] nums) {
        List<Integer> path = new ArrayList<>();
        // 回溯
        backTrace(nums, path, resultList);
        return resultList;
    }


    /*
    这段代码实现了一个回溯算法来生成一个整数数组中所有不重复元素的子序列。我们可以分析其时间复杂度和空间复杂度：
    1. **时间复杂度**：
       - 回溯算法的时间复杂度通常与问题规模以及可能产生的解的数量有关。
       - 在这个例子中，问题规模是输入数组`nums`的长度，记为n。
       - 每个元素都有被选或不选两种可能（假设没有额外剪枝操作），因此在最坏情况下（每个元素都被考虑过一次且都加入到路径中），对于每一个元素，都需要进行一次遍历并递归调用自身，因此总的递归次数可以达到 `2^n` 的量级。
       - 但由于存在剪枝操作（如果元素已经在路径中则跳过），实际的递归次数会少于 `2^n`。
       - 然而即使有剪枝，考虑到所有可能的子集组合，该算法仍然是指数级别的复杂度，可以认为其时间复杂度为 `O(2^n)`。

    2. **空间复杂度**：
       - **递归栈空间**：由于这是一个递归算法，每层递归都会增加一定的栈空间开销。在最坏情况下，即递归深度达到n层（每个元素都被依次加入到路径中），空间复杂度为 `O(n)`。
       - **存储结果的空间**：结果列表`resultList`用于保存所有不重复子序列，理论上最多会有 `2^n` 个不同的子序列（当允许空序列时），但实际上因为要求是不重复子序列，所以数量会小于 `2^n`，但还是与输入大小成指数关系。然而，由于我们关注的是所需额外空间而不是输出大小，所以这部分并不计入空间复杂度的计算。
       - **路径空间**：`path`列表用于记录当前递归路径中的元素，其最大长度不会超过`n`，因此这部分的空间复杂度也为 `O(n)`。

    综合上述分析，主要关注的额外空间消耗是递归栈和路径空间，所以总体空间复杂度为 `O(n)`。
     */
    private static void backTrace(int[] nums, List<Integer> path, List<List<Integer>> resultList) {
        if (path.size() == nums.length) {
            resultList.add(new LinkedList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;// 剪枝
            path.add(nums[i]);
            // 递归
            backTrace(nums, path, resultList);
            path.remove(path.size() - 1);// 回退  ？移除的时候，为什么i的值会变化
        }
    }
}
