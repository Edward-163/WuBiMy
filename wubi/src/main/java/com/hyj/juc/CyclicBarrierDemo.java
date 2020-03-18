package com.hyj.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("4444444444444444");
        });

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(temp);
                try {
                    cyclicBarrier.await();//注意位置,
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        cyclicBarrier.await();
    }
}
