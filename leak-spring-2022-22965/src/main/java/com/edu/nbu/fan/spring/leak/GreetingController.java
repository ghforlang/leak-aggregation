package com.edu.nbu.fan.spring.leak;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-5:01 PM
 * @since 1.0
 */
@RestController
public class GreetingController {

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "hello";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        return "hello";
    }
}
