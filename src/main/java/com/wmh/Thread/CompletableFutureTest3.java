package com.wmh.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /**
         * 测试计算串行化
         * 打印结果：
         * 123
         * 出现异常了
         * true
         * 打断方法后得到的数据为：123
         */
        CompletableFuture<Integer> stringCompletableFuture = CompletableFuture.supplyAsync(() -> 1)
                //thenApply可以获取前面计算的结果继续执行
                .thenApply(i -> i + 2)
                .whenComplete((i, e) -> {
                    System.out.println(i);//3
                }).exceptionally(e -> {
                    System.out.println("出现异常了");
                    return 0;
                });

        CompletableFuture<Integer> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> 1)
                //handle可以获取前面计算的结果继续执行,区别在于thenApply发生异常后不会继续往下执行而handle会
                .handle((i,e) -> i + 2)
                .whenComplete((i, e) -> {
                    System.out.println(i);//3
                }).exceptionally(e -> {
                    System.out.println("出现异常了");
                    return 0;
                });

        CompletableFuture<Integer> stringCompletableFuture3 = CompletableFuture.supplyAsync(() -> 1)
                //thenApply可以获取前面计算的结果继续执行
                .thenApply(i -> i + 2)
                .thenApply(i -> {
                    int a = 10/0;
                    return i + 2;
                })
                .thenApply(i -> {
                    System.out.println("这句话不会打印");
                    return i + 2;
                })
                .whenComplete((i, e) -> {
                    System.out.println(i);//null
                }).exceptionally(e -> {
                    System.out.println("出现异常了");
                    return 0;
                });

        CompletableFuture<Integer> stringCompletableFuture4 = CompletableFuture.supplyAsync(() -> 1)
                //thenApply可以获取前面计算的结果继续执行
                .handle((i,e)-> i + 2)
                .handle((i,e) -> {
                    int a = 10/0;
                    return i + 2;
                })
                .handle((i,e) -> {
                    System.out.println("这句话会打印");
                    return i + 2;
                })
                .whenComplete((i, e) -> {
                    System.out.println(i);//null
                }).exceptionally(e -> {
                    System.out.println("出现异常了");
                    return 0;
                });
    }
}
