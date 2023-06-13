package com.wmh.nestedClass;

/**
 * @author wmh
 * 匿名内部类
 */
public class AnnoInner {

    private Integer i;

    public void AnnoInnerClassMethod() {
        /**
         * 定义匿名内部类，与内部类相似在定义时就初始化
         */
        IAnnoInner inner = new IAnnoInner(){
            @Override
            public void annoInnerMethod() {
                /**
                 * 可以直接访问外部类的所有成员，包括私有
                 */
                i = 0;
            }
        };
        inner.annoInnerMethod();
    }
}
