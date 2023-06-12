package com.wmh.builder.abstractBuild;

import cn.hutool.core.util.ObjectUtil;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author wmh
 */
public abstract class Pizza {
    //定义枚举类
    public enum Topping {HAM,MUSHROOM,ONION,PEPPER,SAUSAGE,EMPTY}

    final Set<Topping> toppings;

    protected abstract static class Builder<T extends Builder<T>> {
        //EnumSet:枚举集合类 EnumSet.noneOf创建一个元素类型为指定枚举类型的集合
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(ObjectUtil.defaultIfNull(topping,Topping.EMPTY));
            return self();
        }

        protected abstract Pizza build();

        protected abstract T self();
    }
    protected Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                '}';
    }
}
