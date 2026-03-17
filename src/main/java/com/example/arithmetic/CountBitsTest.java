package com.example.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2023/9/30 17:36
 */

/*
比特位计数
提示
简单
1.3K
相关企业
给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。



示例 1：

输入：n = 2
输出：[0,1,1]
解释：
0 --> 0
1 --> 1
2 --> 10
示例 2：

输入：n = 5
输出：[0,1,1,2,1,2]
解释：
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 */
public class CountBitsTest {
    public static void main(String[] args) {
        int[] ints = countBits(5);
        System.out.println(ints);

    }

    // Java中有现成的API，哈哈，没想到吧 Integer.bitCount 返回指定的int值的二进制补码二进制表示中的 int数
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]= Integer.bitCount(i);
        }
        return ans;
    }
}
