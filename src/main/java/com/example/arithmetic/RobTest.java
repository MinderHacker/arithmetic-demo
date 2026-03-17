package com.example.arithmetic;

/**
 * 打家劫舍
 * 中等
 * 2.8K
 * 相关企业
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class RobTest {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
//        int[] nums = {2, 7};
        int[] nums = {2, 1, 1, 2};// ???此情况不通过
//        int[] nums = {1, 3, 1};
//        int[] nums = {0};
        int result = rob5(nums);
        System.out.println(result);
    }


    /*
     1.只有一间房屋 ；num[0]
     2.只有两间房屋：Math.max(num[1],num[0])
     3.k间房屋：
      偷k：num[k]+num[k-2]
      不偷k： num[k-1]
      k间前的总金额：
      dp[0]=num[0]
      dp[1]=Math.max(num[1],num[0])
      dp[k]=Math.max(num[k]+num[k-2],num[k-1])

     最高能够偷到的金额：说明后面的金额依赖与前面的结果，所以是个动态规划问题
     */
    // 时间复杂度：n
    public static int rob5(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length-1];
    }

    /*
    这段代码是一个Java程序，定义了一个名为`Solution`的类，其中包含一个公开（public）方法`rob`。这个方法接收一个整数数组`nums`作为输入参数，
    其目的是解决“打劫房屋”问题的一个变种。在这个问题中，给定一系列房屋及其价值（nums数组），你需要决定在不相邻的情况下抢劫哪些房屋以获得最大总价值。
    方法的具体实现：
    1. 首先获取数组`nums`的长度`n`。
    2. 创建一个新的整数数组`f`，长度为`n + 2`。该数组用于存储到每个房屋的最大可获得价值（动态规划中的状态数组）。
    3. 使用一个for循环遍历输入数组`nums`：
       - 对于数组`nums`中的每个元素（对应房屋的价值），计算并更新`f[i + 2]`的值。这里的`f[i + 2]`表示考虑当前房屋时，所能获得的最大价值。
         - `f[i + 1]`表示跳过当前房屋（不抢它）时的最大价值。
         - `f[i] + nums[i]`表示抢当前房屋时的最大价值，即加上当前房屋的价值。
         - 利用`Math.max()`函数取上述两种情况的最大值作为`f[i + 2]`的值。
    4. 循环结束后，`f[n + 1]`将储存不抢最后一个房屋时的最大价值，因为题目要求不能连续抢劫房屋，所以不需要对最后一个房屋做特殊处理。
    5. 最后返回`f[n + 1]`作为最终答案，即在整个序列中按照规则抢劫房屋所能得到的最大总价值。
     */
    public static int rob4(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }


    public static int rob3(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int sum = 0;
            while (j < nums.length) {
                sum += nums[j];
                max = Math.max(max, sum);
                j += 2;
            }
        }
        return max;
    }


    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int max = 0;
        int index = 2;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (index < nums.length) {
                sum = sum + nums[i + index];
                index = index + 2;
            }
            max = Math.max(max, sum + nums[i]);
        }
        return max;
    }

    // 快慢指针法
    // 1.定义快慢指针，每次把快指针获得的值相加
    // 2.math.max()比较最大值
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int max = 0;
        for (int slow = 0; slow <= nums.length - 2; slow++) {
            int sum = 0;
            for (int fast = slow + 2; fast < nums.length; ) {
                sum = sum + nums[fast];
                fast = fast + 2;
            }
            max = Math.max(max, sum + nums[slow]);
        }
        return max;
    }


}
