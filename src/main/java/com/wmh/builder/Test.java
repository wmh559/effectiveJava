package com.wmh.builder;

import com.wmh.staticFactoryMethod.constant.Constant;

/**
 * @author wmh
 */
public class Test {
    public static void main(String[] args) {
        DataConnectionPool dataConnectionPool = new DataConnectionPool.Builder(Constant.FileDataConnection).max(1)
                .min(1).timeOut(1).build();
        System.out.println(dataConnectionPool);
    }
}
