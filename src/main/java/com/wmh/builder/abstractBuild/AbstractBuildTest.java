package com.wmh.builder.abstractBuild;

import com.wmh.builder.abstractBuild.impl.NyPizza;

/**
 * @author wmh
 */
public class AbstractBuildTest {
    public static void main(String[] args) {
        Pizza build = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();
        System.out.println(build);
    }
}
