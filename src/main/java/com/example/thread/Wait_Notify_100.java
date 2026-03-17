package com.example.thread;

class Wait_Notify_100 {

    private int num;
    private static final Object LOCK = new Object();
    private int maxnum = 100;

    private void printABC(int targetNum) {
        while (true) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    if (num >= maxnum) {
                        break;
                    }
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num >= maxnum) {
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName() + ": " + num);
                LOCK.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        Wait_Notify_100 wait_notify_100 = new Wait_Notify_100();
        new Thread(() -> {
            wait_notify_100.printABC(0);
        }, "thread1").start();
        new Thread(() -> {
            wait_notify_100.printABC(1);
        }, "thread2").start();
        new Thread(() -> {
            wait_notify_100.printABC(2);
        }, "thread3").start();
    }
}
