package com.cnjtg.javabase.thread;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 10:41
 */
public class TestThread {
    private int j;

    public TestThread(int j) {
        this.j = j;
    }

    //定义同步方法
    public synchronized void inc(){
        j++;
        System.out.println(j+"--inc--"+Thread.currentThread().getName());
    }
    public synchronized void dec(){
        j--;
        System.out.println(j + "--dsc--"+Thread.currentThread().getName());
    }
    //定义类
    class Inc extends Thread {
        @Override
        public void run(){
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

    //Run方法
    public void run(){
        (new Inc()).start();
        new Thread(new Dec()).start();
        (new Inc()).start();
        new Thread(new Dec()).start();
    }

    //Main
    public static void main(String[] args) {
        (new TestThread(0)).run();
    }
}
