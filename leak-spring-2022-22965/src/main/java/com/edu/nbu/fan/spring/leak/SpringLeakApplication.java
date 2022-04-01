package com.edu.nbu.fan.spring.leak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-4:56 PM
 * @since 1.0
 */
@SpringBootApplication
public class SpringLeakApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLeakApplication.class,args);
    }
}
