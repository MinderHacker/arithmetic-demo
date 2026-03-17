package com.example.arithmetic;

public class SqrtTest {
    public static void main(String[] args) {
        int mySqrt = mySqrt(9);
        System.out.println(mySqrt);
    }

    /**
     * 求 f „x” = x2 − a = 0 的解(x>0)
     * <p>
     * 分析：
     * 1. x^2=a =》[0,a）.由于数值都是int，所以可在[1,a)范围内查找。
     * 可采用二分法接替
     *
     * @param a
     * @return
     */
    public static int mySqrt(int a) {
        if (a <= 0) return 0;

        int left = 1, right = a, mid, sqrt;
        while (left <= right) {
            // 很关键
            mid = (right - left) / 2 + left;
            sqrt = a / mid;

            if (mid == sqrt) {
                return sqrt;
            } else if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
