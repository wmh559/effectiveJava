package com.wmh.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /**
         * 测试CompletableFuture
         * 打印结果：
         * 123
         * 出现异常了
         * true
         * 打断方法后得到的数据为：123
         */
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        //get()方法:会阻塞直到获取到结果

        //getNow(T t)方法:不会阻塞,获取不到结果返回指定值
        System.out.println(stringCompletableFuture.getNow("123"));//123
        //get(long, TimeUnit)方法:会阻塞直到获取到结果,或者等待超时
        try {
            System.out.println(stringCompletableFuture.get(2,TimeUnit.SECONDS));//抛异常
        } catch (Exception e) {
            System.out.println("出现异常了");
        }
        //complete()方法:打断计算，返回指定数据
        System.out.println(stringCompletableFuture.complete("123"));//true
        //join()方法:会阻塞直到获取到结果
        System.out.println("打断方法后得到的数据为："+stringCompletableFuture.join());//123
    }
}
