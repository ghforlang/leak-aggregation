package com.edu.nbu.fan.sample.beans;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/29-3:52 PM
 * @since 1.0
 */
@EnableAutoConfiguration
@Configuration
public class BeanConfiguration {

    @Bean
    public Function<String,String> upperCase(){
        return value -> value.toUpperCase();
    }

    @Bean
    public Function<Message<String>,Integer> upperCaseMessage(){
        return value -> value.getPayload().toUpperCase().length();
    }

    @Bean
    public Function<Flux<String>,Flux<String>> lowerCase(){
        return flux -> flux.map(value -> value.toLowerCase(Locale.ROOT));
    }

    @Bean
    public Supplier<String> hello(){
        return () -> "hello!";
    }

    @Bean
    public Supplier<Flux<String>> infinite(){
        return () -> Flux.interval(Duration.ofSeconds(1))
                .log()
                .map(counter -> String.format("Counter: %s",counter));
    }
}
