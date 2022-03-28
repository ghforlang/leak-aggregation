package com.edu.nbu.fan.sample.functions;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-4:29 下午
 * @since 1.0
 */
public class CharCounter implements Function<String,Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
