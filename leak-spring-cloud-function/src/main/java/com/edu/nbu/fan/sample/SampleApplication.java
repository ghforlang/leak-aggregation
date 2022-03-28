package com.edu.nbu.fan.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/28-4:14 下午
*/
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class,"--management.endpoints.web.exposure.include=functions");
    }

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
