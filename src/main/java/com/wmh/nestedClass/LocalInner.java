package com.wmh.nestedClass;

/**
 * 局部内部类
 * 定义在外部类的局部位置。如代码块、方法中
 * @author wmh
 */
public class LocalInner {

    /**
     * 外部类的成员变量
     */
    private int localVar;

    /**
     * 声明一个局部内部类
     * @param incVar 局部内部类的成员变量
     */
    public void localMethod(int incVar) {
        int temp = incVar;
        /**
         * 2、不能添加访问修饰符，它的地位就是一个局部变量，但是可以使用final修饰
         */
        class LocalInnerClass {

            private  Integer i = 1;

            /**
             * 局部内部类的成员方法
             */
            public void someLocalMethod() {
                /**
                 * 1、局部内部类可以直接访问外部类的所有成员，包含私有的
                 */
               localVar = temp;
            }
        }
        /**
         * 3、作用范围在定义的方法或代码块中
         * 外部类访问内部类需要创建对象访问
         */
        LocalInnerClass innerClass = new LocalInnerClass();
        innerClass.someLocalMethod();
    }
}
