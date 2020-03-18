package com.hyj.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //void的包装类,大写
//        CompletableFuture<Void> voidCompletableFuture = new CompletableFuture<>();
        //runAsync没有返回值,
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("模拟异步执行请求,");
        });
        System.out.println(voidCompletableFuture.get());

        //supplyAsync
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            return 666;
        });
        System.out.println(completableFuture.get());
    }
}
