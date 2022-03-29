package com.edu.nbu.fan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/29-5:56 PM
 * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/echo")
    public String echo(){
        return "echo";
    }
}
