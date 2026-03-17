package com.example.arithmetic;

/*
461. 汉明距离
简单

两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

示例 1：
输入：x = 1, y = 4

输出：2
解释：
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
上面的箭头指出了对应二进制位不同的位置。
示例 2：

输入：x = 3, y = 1
输出：1

汉明距离广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异。
两个整数之间的汉明距离是对应位置上数字不同的位数。
 */
public class HammingDistanceTest {
    public static void main(String[] args) {
        int hammingDistance = hammingDistance(1, 4);
        System.out.println(hammingDistance);

    }

    // 计算 xxx 和 yyy 之间的汉明距离，可以先计算 x⊕yx \oplus yx⊕y，然后统计结果中等于 111 的位数。
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
