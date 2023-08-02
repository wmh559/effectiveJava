package com.wmh.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       //测试CompletableFuture对结果进行选用，谁快用谁
        CompletableFuture<String> a_come_in = CompletableFuture.supplyAsync(() -> {
            System.out.println("A come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "A";
        });
        CompletableFuture<String> b_come_in = CompletableFuture.supplyAsync(() -> {
            System.out.println("B come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B";
        });
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { 当这段代码放开最后结果为A，否则为B
            e.printStackTrace();
        }*/
        CompletableFuture<Object> objectCompletableFuture = a_come_in.applyToEither(b_come_in, (s) -> {
            return s;
        });

        System.out.println("最后结果为:"+objectCompletableFuture.join());
    }
}
