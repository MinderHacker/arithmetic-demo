package com.echo.javademo.arithmetic;

public class ThreadCqSecond {
    public static void main(String[] args) {
        new Thread(new Count()).start();
        new Thread(new Count()).start();
    }
}
 class Count implements Runnable {
     private static volatile int count = 0;
    @Override
    public void run() {
        while (count<30){
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "----" + count++);
            }
        }

    }
}