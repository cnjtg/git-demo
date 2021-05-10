package com.cnjtg.javabase.thread;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 10:35
 */
public class ThreadMain {
    public static void main(String[] args) {
        SleepThread thread = new SleepThread();
        thread.start();
    }
}
