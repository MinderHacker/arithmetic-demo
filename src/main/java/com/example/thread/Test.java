package com.example.thread;

/**
 * 按顺序打印abc
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        // 方法2：
        PrintNum printNum = new PrintNum();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printNum.printA();
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printNum.printB();
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printNum.printC();
            }
        },"线程C").start();

    }


}

class PrintNum {
    private volatile int index= 1;
    void printA(){
        synchronized (this){
            while (index !=1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"打印线程A---------");
        index =2;
    }
    void printB(){
        synchronized (this){
            while (index !=2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"打印线程B---------");
        index =3;
    }
    void printC(){
        synchronized (this){
            while (index !=3){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"打印线程C---------");
        index =1;
    }
}