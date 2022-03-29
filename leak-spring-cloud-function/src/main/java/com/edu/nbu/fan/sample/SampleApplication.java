package com.edu.nbu.fan.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
