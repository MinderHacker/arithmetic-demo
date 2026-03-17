package com.echo.javademo.arithmetic;

public class GiftTest {
    public static void main(String[] args) {
        int[] cakePrice = {10, 20, 5};
        int[] giftPrice = {5, 5, 2};
        int x = 15;
        int num = getNum(cakePrice, giftPrice, x);
        System.out.println(num);

    }

    /**
     * 解题思路：cakePrice + giftPrice<= x 进行组合
     *
     * @param cakePrice 蛋糕价格
     * @param giftPrice 礼物价格
     * @param x         预算
     * @return 购买方案总数
     */
    public static int getNum(int[] cakePrice, int[] giftPrice, int x) {
        // 参数校验
        if (x <= 0) return 0;
        if (cakePrice.length == 0 || giftPrice.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < cakePrice.length; i++) {
            for (int j = 0; j < giftPrice.length; j++) {
                if (cakePrice[i] + giftPrice[j] <= x) {
                    count++;
                }
            }
        }
        return count;
    }
}
