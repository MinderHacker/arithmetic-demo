package com.example.thread;


import java.util.concurrent.atomic.AtomicInteger;

/*
1114. 按序打印
简单
相关标签
相关企业
给你一个类：

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
三个不同的线程 A、B、C 将会共用一个 Foo 实例。

线程 A 将会调用 first() 方法
线程 B 将会调用 second() 方法
线程 C 将会调用 third() 方法
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

提示：
尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
你看到的输入格式主要是为了确保测试的全面性。
 */
class Foo2 {
    public static void main(String[] args) throws InterruptedException {
        new Foo2().first(() -> System.out.println("first"));
        new Foo2().second(() -> System.out.println("second"));
        new Foo2().third(() -> System.out.println("third"));
    }

    // 分析：通过变量来控制打印顺序
    /*
    算法
    首先初始化共享变量 firstJobDone 和 secondJobDone，初始值表示所有方法未执行。
    方法 first() 没有依赖关系，可以直接执行。在方法最后更新变量 firstJobDone 表示该方法执行完成。
    方法 second() 中，检查 firstJobDone 的状态。如果未更新则进入等待状态，否则执行方法 second()。在方法末尾，更新变量 secondJobDone 表示方法 second() 执行完成。
    方法 third() 中，检查 secondJobDone 的状态。与方法 second() 类似，执行 third() 之前，需要先等待 secondJobDone 的状态。
     */

    /*
    这段代码定义了两个AtomicInteger类型的静态变量first和second，初始值都为0。AtomicInteger是Java提供的一个原子类，
    可以用于实现线程安全的整型变量。在多线程环境下，多个线程可以同时对first和second进行操作，而不会出现数据不一致的问题。
     */
    private static AtomicInteger first = new AtomicInteger(0);
    private static AtomicInteger second = new AtomicInteger(0);

    public Foo2() {}

    public static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // AtomicInteger 类实现的一个线程安全的自增操作。incrementAndGet() 方法会将当前原子整数加1并返回新的值。
        // 这个操作是原子的，意味着在多线程环境下也不会出现竞争条件，可以保证数据的一致性。
        first.incrementAndGet();
    }

    public static void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (first.get() != 1) {
            // waiting
        }
        printSecond.run();
        second.incrementAndGet();
    }

    public static void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (second.get() != 1) {
            // waiting
        }
        printThird.run();
    }
}