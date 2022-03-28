package com.edu.nbu.fan.sample.functions;


import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-4:31 下午
 * @since 1.0
 */
public class Greeter implements Function<String,String> {
    @Override
    public String apply(String name) {
        return "hello " + name;
    }
}
