package com.hyj.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoraDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//获取不到许可就blocked等待,
                    System.out.println(Thread.currentThread().getName()+"in");
                    TimeUnit.SECONDS.sleep(2);//模拟长时间占位,突显剩下2个线程没in
                    System.out.println(Thread.currentThread().getName()+"out");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();

        }
    }
}
