package com.wmh.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       //测试CompletableFuture对结果进行消费
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> "hello world")
                //thenRun:任务A执行完毕后执行任务B，并且B不需要A的结果，且没有返回
                .thenRun(() -> {
                    System.out.println("任务B执行了");
                })
                //thenAccept:任务A执行完毕后，将结果传递给任务B，任务B无返回值
                .thenAccept(f -> {
                    System.out.println(f);
                    System.out.println("任务C执行了");
                });
    }
}
