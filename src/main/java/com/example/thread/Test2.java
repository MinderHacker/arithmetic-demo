package com.example.thread;

/**
 * java循环顺序打印1,2,3,1,2,3
 */
public class Test2 {


    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pn.printA();
                }
            }, "线程A").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pn.printB();
                }
            }, "线程B").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pn.printA();
                }
            });
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pn.printC();
                }
            }, "线程C").start();
        }

    }


}

class PrintNumber {
    private static volatile int count = 1;

    void printA() {
        synchronized (this) {
            while (count != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "打印线程A---------");
        count = 2;
    }

    void printB() {
        synchronized (this) {
            while (count != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "打印线程B---------");
        count = 3;
    }

    void printC() {
        synchronized (this) {
            while (count != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "打印线程C---------");
        count = 1;
    }
}

