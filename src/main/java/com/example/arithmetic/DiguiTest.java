package com.echo.javademo.arithmetic;

public class DiguiTest {
    public static void main(String[] args) {
        int result = Calculate(3);
        System.out.println(result);

    }

    private static int Calculate(int num){
        if (num==0){
            return 1;
        }else {
            return num *Calculate(num-1);
        }
    }
}
