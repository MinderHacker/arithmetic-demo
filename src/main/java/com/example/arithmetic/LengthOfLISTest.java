package com.echo.javademo.arithmetic;

import java.util.List;

public class LengthOfLISTest {
    public static void main(String[] args) {
        int[] nums ={10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        int maxLength = 0, n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
