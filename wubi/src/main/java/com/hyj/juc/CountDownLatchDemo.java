package com.hyj.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);//只允许out3个,留下2个

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println("out");
                countDownLatch.countDown();//-1
            }).start();
        }

        countDownLatch.await();//一直等到count为0
        System.out.println("close door");
    }
}
