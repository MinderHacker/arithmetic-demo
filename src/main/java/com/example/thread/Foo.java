package com.example.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Foo {
    private final CountDownLatch firstDone = new CountDownLatch(1);
    private final CountDownLatch secondDone = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(()-> {
            try {
                foo.first(()-> System.out.println("first----"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.submit(()-> {
            try {
                foo.second(()-> System.out.println("second----"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.submit(()-> {
            try {
                foo.third(()-> System.out.println("third----"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}