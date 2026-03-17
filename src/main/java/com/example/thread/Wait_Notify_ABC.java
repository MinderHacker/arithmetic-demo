package com.example.thread;


/*
这段Java代码展示了使用wait()和notifyAll()方法实现三个线程之间循环打印ABC的同步操作。
print_ABC(int target)方法：该方法接收一个整数参数target，表示线程的目标打印字符（0对应A，1对应B，2对应C）。方法内部通过synchronized关键字锁定了一个静态对象Lock，确保了三个线程对共享资源num的访问是同步的。
在循环打印过程中，线程会根据num的值对target进行判断：
如果num % 3不等于target，表示当前线程需要等待，则调用Lock.wait()方法释放锁并进入等待状态，直到其他线程唤醒它。
如果num % 3等于target，表示当前线程可以进行打印操作，则执行打印、num自增和Lock.notifyAll()方法，其中notifyAll()方法会唤醒其他等待线程。
main()方法：在main()方法中创建了三个线程，分别调用print_ABC()方法并传入不同的target值。通过给线程命名，可以清楚地看到三个线程打印的顺序和内容。
总结：这段代码通过wait()和notifyAll()方法实现了三个线程之间的同步协调，使得它们能够按照一定的顺序循环打印ABC。
 */
class Wait_Notify_ABC {
    private int num;
    private static final Object Lock = new Object();
    private void print_ABC(int target) {
        synchronized (Lock) {
            //循环打印
            for (int i = 0; i < 10; i++) {
                while (num % 3 != target) {
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                Lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Wait_Notify_ABC wait_notify_abc = new Wait_Notify_ABC();
        new Thread(() -> {
            wait_notify_abc.print_ABC(0);
        }, "A").start();
        new Thread(() -> {
            wait_notify_abc.print_ABC(1);
        }, "B").start();
        new Thread(() -> {
            wait_notify_abc.print_ABC(2);
        }, "C").start();
    }
}
