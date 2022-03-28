package com.edu.nbu.fan.sample.functions;

import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/28-4:30 下午
 * @since 1.0
 */
public class Exclaimer implements Function<Flux<String>,Flux<String>> {
    @Override
    public Flux<String> apply(Flux<String> stringFlux) {
        return stringFlux.map(word -> word + "!!!");
    }
}
