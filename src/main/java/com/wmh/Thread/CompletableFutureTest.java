package com.wmh.Thread;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        /**
         * 静态方法创建CompletableFuture
         * CompletableFuture.supplyAsync():创建一个异步任务，有返回值
         * CompletableFuture.runAsync():创建一个异步任务，没有返回值
         * 可以创建线程池来指定执行异步任务的线程，不指定的话使用默认ForkJoin线程池
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<String> test = CompletableFuture.supplyAsync(() -> {
                System.out.println("hello");
                return "world";
            },executorService).whenComplete((a,e)->{
                System.out.println("任务执行完成了："+a);
                System.out.println("异常结果为："+e);
            }).exceptionally(e-> {
                System.out.println("出现异常了："+e);
                return null;
            });
        } finally {
            executorService.shutdown();
        }
        Test test = new Test();
        test.setId("").setName("");
    }
}

@Data
@Accessors(chain = true)
class Test {

    private String id;
    private String name;

}
