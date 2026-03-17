package com.example.arithmetic;


import java.util.concurrent.*;

/**
 * 线程池实现顺序+1到100
 */
public class MultiThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        Future future = poolExecutor.submit(new Callable<Integer>() {
            int max = 0;
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    max = max + i;
                }
                return max;
            }
        });
        poolExecutor.shutdown();
        // 打印
        System.out.println(future.get());
    }
}
