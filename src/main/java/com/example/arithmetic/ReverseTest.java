package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 19/09/2023 13:35
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 7. 整数反转
 * 中等
 * 3.9K
 * 相关企业
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围  ，就返回 0。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 */
public class ReverseTest {
    public static void main(String[] args) {
        //Integer x = 123;
        Integer x = -123;
        //Integer x = 0;
        int result = reverse(x);
        System.out.println(result);
    }

    private static int reverse(int x) {
//        long n = 0;
//        while (x != 0) {
//            n = n * 10 + x % 10;
//            x = x / 10;
//        }
//        return (int) n == n ? (int) n : 0;

        int result = 0;
        while (x != 0) {
            int tmp = result; // 保存计算之前的结果
            result = (result * 10) + (x % 10);
            x /= 10;
            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
            if (result / 10 != tmp) return 0;
        }


        return result;
    }

    // 使用栈
//    private static int reverse(int x) {
//        if (x == 0) return 0;
//        int x2 = x < 0 ? Math.abs(x) : x;
//        Stack<Character> stack = new Stack<>();
//        StringBuffer buffer = new StringBuffer();
//        for (Character c : String.valueOf(x2).toCharArray()) {
//            stack.push(c);
//        }
//        for (int i = stack.size(); i > 0; i--) {
//            Character c = (Character) stack.pop();
//            buffer.append(c);
//        }
//        Integer result;
//        if (x < 0) {
//            result = -Integer.valueOf(String.valueOf(buffer));
//        } else {
//            result = Integer.valueOf(String.valueOf(buffer));
//        }
////        if (result < -214748364 || (result == -214748364)) {
////            return 0;
////        }
//
//        return result;
//    }

}
