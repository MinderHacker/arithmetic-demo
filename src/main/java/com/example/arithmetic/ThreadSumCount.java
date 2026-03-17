package com.echo.javademo.arithmetic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建5个线程，累加加数到50.打印的数字顺序执行
 */
public class ThreadSumCount {
    static CountDownLatch cdl = new CountDownLatch(10);;
    static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "----" + ai.getAndIncrement());
                    cdl.countDown();
                }
            });
        }
        //阻塞当前线程，将当前线程加入阻塞队列。
        cdl.await();
        System.out.println(ai.get());
        exec.shutdown();
    }
}

//    // 创建5个线程，累加加数到50.打印的数字顺序执行
//
//    // volatile保证变量修改后被线程可见
//    static volatile int count = 0;
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        // 创建任务
//        MyThread myThread = new MyThread();
//        // 创建5个线程
//        for (int i = 0; i < 5; i++) {
//            new Thread(myThread).start();
//        }
//    }
//
//static class MyThread implements Runnable {
//    @Override
//    public void run() {
//        while (true) {
//            // 锁住了当前类
//            synchronized (MyThread.class) {
//                try {
//                    Thread.sleep(10);
//                    if (count > 50) {
//                        break;
//                    }
//                    System.out.println(Thread.currentThread().getName() + "----" + count++);
//                    Thread.yield();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}


//    ExecutorService pool = Executors.newFixedThreadPool(5);
//    Future future=pool.submit(new Callable<Integer>() {
//        int result = 0;
//        @Override
//        public Integer call() throws Exception {
//            for (int i = 1; i <= 100; i++) {
//                result = result + i;
//            }
//            return result;
//        }
//    });
//        pool.shutdown();
//        System.out.println(future.get());


// 线程按顺序执行
//    Thread t1= new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("线程1执行");
//        }
//    });
//    Thread t2 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("线程2执行");
//        }
//    });
//    Thread t3 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("线程3执行");
//        }
//    });
//
//        t1.start();
//                t1.join();
//                t2.start();
//                t2.join();
//                t3.start();