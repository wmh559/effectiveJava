package com.wmh.builder.abstractBuild.impl;

import cn.hutool.core.util.ObjectUtil;
import com.wmh.builder.abstractBuild.Pizza;

/**
 * @author wmh
 */
public class NyPizza extends Pizza {

    public enum Size{SMALL, MEDIUM, LARGE,DEFAULT}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{

        private final Size size;

        public Builder(Size size){
            this.size = ObjectUtil.defaultIfNull(size,Size.DEFAULT);
        }

        @Override
        public Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                '}' + super.toString();
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
